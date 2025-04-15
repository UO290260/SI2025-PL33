package giis.demo.generarrecibos;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;
import giis.demo.util.SwingUtil;
import giis.demo.util.Util;

/**
 * Controlador para la funcionalidad de visualizacion de las tablas para enviar recibos
 * -instancia con la vista y el modelo
 * -ejecutando initController que instalara los manejadores de los eventos
 */
public class GenerarrecibosController {
	private GenerarrecibosModel modelo;
	private GenerarrecibosView vista;
	private boolean enviado;

	public GenerarrecibosController(GenerarrecibosModel model, GenerarrecibosView view) {
		this.modelo = model;
		this.vista = view;
		this.initView();
	}

	/**
	 * Inicialización del controlador.
	 */
	public void initController() {
		//Invoco el metodo que responde al listener para que se encargue de generar las exceciones
		vista.getBtnEnviar().addActionListener(e -> SwingUtil.exceptionWrapper(() -> enviarSeleccionados()));
		vista.getBtnCargar().addActionListener(e -> SwingUtil.exceptionWrapper(() -> cargarCSV()));

	}

	/**
	 * Inicializacion del controlador
	 */
	public void initView() {
		//Abre la ventana
		vista.getFrame().setVisible(true);
		//Inicia los datos de la vista
		cargarListaColegiados();
		cargarListaRecibos();
	}

	/**
	 * Método que maneja y envia a los colegiados con estado de recibos no emitidos a la tabla de recibos con estado emitido 
	 */
	private void enviarSeleccionados() {
		int totalFilas = vista.getTablaColegiados().getRowCount();

		if (totalFilas == 0) {
			JOptionPane.showMessageDialog(null, "No hay colegiados en la tabla.");
			return;
		}

		List<String[]> datosSeleccionados = new ArrayList<>();
		String fechaSolicitud = Util.dateToIsoString(new Date());

		for (int fila = 0; fila < totalFilas; fila++) {
			ColegiadosRecibosDTO colegiado = new ColegiadosRecibosDTO();
			colegiado.setId_recibo(Integer.parseInt(vista.getTablaColegiados().getValueAt(fila, 0).toString()));
			colegiado.setNombre(vista.getTablaColegiados().getValueAt(fila, 1).toString());
			colegiado.setApellidos(vista.getTablaColegiados().getValueAt(fila, 2).toString());
			colegiado.setDNI(vista.getTablaColegiados().getValueAt(fila, 3).toString());
			colegiado.setCuota_pagar(Integer.parseInt(vista.getTablaColegiados().getValueAt(fila, 4).toString()));
			colegiado.setFecha_recibo(fechaSolicitud); 
			colegiado.setCuenta_bancaria(vista.getTablaColegiados().getValueAt(fila, 5).toString());
			colegiado.setEstado("Emitido");
			modelo.actualizarEstadoRecibo(colegiado.getDNI(), "Emitido");

			datosSeleccionados.add(new String[] {
					String.valueOf(colegiado.getId_recibo()),
					colegiado.getNombre(),
					colegiado.getApellidos(),
					colegiado.getDNI(),
					String.valueOf(colegiado.getCuota_pagar()),
					colegiado.getFecha_recibo(),
					colegiado.getCuenta_bancaria(),
					colegiado.getEstado()
			});
		}

		//Si se envian los datos , se genera el csv
		if (!datosSeleccionados.isEmpty()) {
			boolean archivoGenerado = generarCSV(datosSeleccionados);
			if (archivoGenerado) {
				cargarListaColegiados(); 
				cargarListaRecibos();   
				JOptionPane.showMessageDialog(null, "Todos los colegiados han sido enviados y exportados a CSV.");

				//Deshabilito el boton de enviar durante 10 seg , simulando una vez al año
				vista.getBtnEnviar().setEnabled(false);
				new javax.swing.Timer(10_000, e -> SwingUtil.exceptionWrapper(() -> vista.getBtnEnviar().setEnabled(true))).start();
				enviado = true; 
			} else {
				JOptionPane.showMessageDialog(null, "Hubo un error al generar el archivo CSV.");
			}
		}
	}

	/**
	 * Obtencion de la lista de los colegiados con estado de inscripcion Aprobada y estado de recibo No Emitido 
	 */
	private void cargarListaColegiados() {
		List<ColegiadosRecibosDTO> colegiadosPendientes = modelo.getListaColegiados();
		TableModel tmodelColegiados = SwingUtil.getTableModelFromPojos(colegiadosPendientes, new String[]{
				"id_colegiado", "nombre", "apellidos", "DNI", "cuota_pagar", "cuenta_bancaria", "estado"  
		});
		vista.getTablaColegiados().setModel(tmodelColegiados);
		SwingUtil.autoAdjustColumns(vista.getTablaColegiados());
	}

	/**
	 * Obtencion de la lista de los recibos con estado Emitido y No Cobrado/Cobrado
	 */
	private void cargarListaRecibos() {
		List<ColegiadosRecibosDTO> recibos = modelo.getListaRecibos();
		TableModel tmodelRecibos = SwingUtil.getTableModelFromPojos(recibos, new String[]{
				"id_recibo", "nombre", "apellidos", "DNI", "cuota_pagar", "fecha_recibo", "cuenta_bancaria", "estado"
		});
		vista.getTablaRecibos().setModel(tmodelRecibos);
		SwingUtil.autoAdjustColumns(vista.getTablaRecibos());
	}

	/**
	 * Metodo que genera un csv
	 * @param datosSeleccionados
	 */
	private boolean generarCSV(List<String[]> datosSeleccionados) {
		//Seleccionar el directorio
		JFileChooser chooser = new JFileChooser();
		chooser.setDialogTitle("Seleccionar ubicación para guardar el archivo");
		chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

		int resultado = chooser.showSaveDialog(null);

		if (resultado == JFileChooser.APPROVE_OPTION) {
			String rutaCarpeta = chooser.getSelectedFile().getAbsolutePath();

			//Si la carpeta no existe la creo
			File carpeta = new File(rutaCarpeta);
			if (!carpeta.exists()) {
				carpeta.mkdirs();
			}

			//Creo el nombre del archivo
			int contador = 1;
			String fileName = "archivo" + contador + ".csv";
			File archivo = new File(rutaCarpeta + File.separator + fileName);
			//Creo el archivo que simulo que me llega del banco
			File archivo_banco = new File(rutaCarpeta + File.separator + "archivo_banco.csv");

			//Si el nombre del archivo existe, lo aumento en uno
			while (archivo.exists()) {
				contador++;
				fileName = "archivo" + contador + ".csv";
				archivo = new File(rutaCarpeta + File.separator + fileName);
			}

			try {
				//Escribir en el archivo generado
				FileWriter writer = new FileWriter(archivo);
				writer.append("id_recibo,nombre,apellidos,DNI,cuota_pagar,fecha_recibo,cuenta_bancaria,estado\r\n");

				for (int i = 0; i < datosSeleccionados.size(); i++) {
					writer.append(String.join(",", datosSeleccionados.get(i))).append("\n");				
				}
				//Cierro
				writer.close();

				//Escribo en el archivo del banco
				FileWriter writerBanco = new FileWriter(archivo_banco);
				writerBanco.append("id_recibo,DNI,cuota_pagar,fecha_recibo,estado\r\n");

				for (int i = 0; i < datosSeleccionados.size(); i++) {
					String[] datos = datosSeleccionados.get(i);

					String id_recibo = datos[0]; 
					String dni = datos[3]; 
					String cuota_pagar = datos[4];
					String fecha_recibo = datos[5]; 
					//Estado del recibo generado de manera aleatoria
					String estado_random;
					double random = Math.random() * 100;
					if (random < 50) {
						estado_random = "No Cobrado";
					} else {
						estado_random = "Cobrado";
					}
					writerBanco.append(id_recibo).append(",").append(dni).append(",").append(cuota_pagar).append(",").append(fecha_recibo).append(",").append(estado_random).append("\n");
				}
				writerBanco.close();

				JOptionPane.showMessageDialog(null, "Archivo CSV creado en: " + archivo.getAbsolutePath());
				JOptionPane.showMessageDialog(null, "Archivo banco CSV creado en: " + archivo_banco.getAbsolutePath());
				return true;

			} catch (IOException e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "Error al generar los archivos.");
				return false;
			}
		} else {
			//Cancelo la seleccion del directorio
			JOptionPane.showMessageDialog(null, "No se seleccionó una ruta.");
			return false;
		}
	}

	/**
	 * Metodo para cargar en la tabla un archivo csv
	 */
	private void cargarCSV() {
		if (!enviado) {
			JOptionPane.showMessageDialog(null, "Debes de pulsar el boton enviar primero antes de cargar.");
			return;
		}
		JFileChooser chooser = new JFileChooser();
		chooser.setDialogTitle("Seleccionar archivo del banco CSV");
		chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

		int resultado = chooser.showOpenDialog(null);

		if (resultado == JFileChooser.APPROVE_OPTION) {
			File archivo = chooser.getSelectedFile();
			List<ColegiadosRecibosDTO> recibos = leerCSV(archivo);

			if (recibos != null && !recibos.isEmpty()) {
				TableModel tmodel = SwingUtil.getTableModelFromPojos(recibos, new String[] {
						"id_recibo" , "DNI", "cuota_pagar", "fecha_recibo", "estado"
				});

				vista.getTablaRecibos().setModel(tmodel);
				SwingUtil.autoAdjustColumns(vista.getTablaRecibos());
				JOptionPane.showMessageDialog(null, "Archivo CSV cargado correctamente.");
			} else {
				JOptionPane.showMessageDialog(null, "El archivo CSV no contiene datos válidos.");
			}
		} else {
			JOptionPane.showMessageDialog(null, "Se cancelo la carga del archivo");
		}
	}

	/**
	 * Metodo para leer los archivos csv
	 * @param archivo
	 * @return
	 */
	private List<ColegiadosRecibosDTO> leerCSV(File archivo) {
		List<ColegiadosRecibosDTO> recibos = new ArrayList<>();

		try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
			String linea;
			boolean primera = true;

			while ((linea = br.readLine()) != null) {
				//Me salto la primera linea del fichero que quiero leer
				if (primera) {
					primera = false;
					continue;
				}

				String[] campos = linea.split(",");
				if (campos.length == 5) {
					try {
						for (int i = 0; i < campos.length; i++) {
							campos[i] = campos[i].trim();
						}

						ColegiadosRecibosDTO recibo = new ColegiadosRecibosDTO();
						recibo.setId_recibo(Integer.parseInt(campos[0]));
						recibo.setDNI(campos[1]);
						recibo.setCuota_pagar(Integer.parseInt(campos[2]));
						recibo.setFecha_recibo(campos[3]);
						recibo.setEstado(campos[4]);

						modelo.actualizarRecibo(recibo);
						recibos.add(recibo);

					} catch (NumberFormatException e) {
						JOptionPane.showMessageDialog(null, "Error en el formato de datos del archivo banco CSV.");
						e.printStackTrace();
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error al leer el archivo banco CSV.");
		}
		return recibos;
	}
}