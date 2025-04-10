package giis.demo.solicitudcolegiado;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;
import giis.demo.util.SwingUtil;

/**
 * Controlador para la funcionalidad de solicitudes de colegiados
 * -instancia con la vista y el modelo
 * -ejecutando initController que instalara los manejadores de los eventos
 */
public class SolicitudColegiadoController {
	private SolicitudColegiadoModel modelo;
	private SolicitudColegiadoView vista;

	public SolicitudColegiadoController(SolicitudColegiadoModel model, SolicitudColegiadoView view) {
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
		vista.getBtnComprobar().addActionListener(e -> SwingUtil.exceptionWrapper(() -> comprobar()));
	}

	/**
	 * Inicializacion del controlador
	 */
	public void initView() {
		//Abre la ventana
		vista.getFrame().setVisible(true);
		//Inicia los datos de la vista
		cargarListaPendientes();
		cargarListaAprobadosYCancelados();
	}

	/**
	 * Método que maneja y envia a los colegiados pendientes a la tabla colegiados enviados 
	 */
	private void enviarSeleccionados() {
		int[] filasSeleccionadas = vista.getTabla().getSelectedRows();

		if (filasSeleccionadas.length == 0) {
			JOptionPane.showMessageDialog(null, "Selecciona una fila para enviar.");
			return;
		}

		List<String[]> datosSeleccionados = new ArrayList<>();
		for (int i = 0; i < filasSeleccionadas.length; i++) {
			int fila = filasSeleccionadas[i];
			if (fila < vista.getTabla().getRowCount()) {
				ColegiadoDTO colegiado = new ColegiadoDTO();
				colegiado.setId_colegiado(Integer.parseInt(vista.getTabla().getValueAt(fila, 0).toString()));
				colegiado.setNombre(vista.getTabla().getValueAt(fila, 1).toString());
				colegiado.setApellidos(vista.getTabla().getValueAt(fila, 2).toString());
				colegiado.setDNI(vista.getTabla().getValueAt(fila, 3).toString());
				colegiado.setTitulacion(vista.getTabla().getValueAt(fila, 4).toString());
				colegiado.setEstado("Enviado");
				modelo.actualizarEstadoColegiado(colegiado, "Enviado");

				datosSeleccionados.add(new String[]{
						String.valueOf(colegiado.getId_colegiado()),
						colegiado.getNombre(),
						colegiado.getApellidos(),
						colegiado.getDNI(),
						colegiado.getTitulacion(),
						colegiado.getEstado()
				});
			}
		}

		//Si los datos estan correctos,los envio 
		if (!datosSeleccionados.isEmpty()) {
			boolean archivoGenerado = generarCSV(datosSeleccionados);
			if (archivoGenerado) {
				//Si se envia el archivo,se actualizan las tablas
				cargarListaPendientes();
				JOptionPane.showMessageDialog(null, "Los colegiados seleccionados han sido enviados.");
			} else {
				//Si el archivo no se generó , se cancela
				JOptionPane.showMessageDialog(null, "Los colegiados no se actualizaron.");
			}
		}
	}

	/**
	 * Tabla de los Colegiados con estado Pendiente
	 */
	private void cargarListaPendientes() {
		List<ColegiadoDTO> colegiadosPendientes = modelo.getListaPendientes();
		TableModel tmodelPendientes = SwingUtil.getTableModelFromPojos(colegiadosPendientes, new String[]{
				"id_colegiado", "nombre", "apellidos", "DNI", "titulacion", "estado"
		});
		vista.getTabla().setModel(tmodelPendientes);
		SwingUtil.autoAdjustColumns(vista.getTabla());
	}

	/**
	 * Tabla de los Colegiados con estado de solicitud Aprobada y Cancelado
	 */
	private void cargarListaAprobadosYCancelados() {
		List<ColegiadoDTO> colegiadosAprobadosCancelados = modelo.getListaColegiadosAprobadosCancelados();
		TableModel tmodelEnviados = SwingUtil.getTableModelFromPojos(colegiadosAprobadosCancelados, new String[]{
				"id_colegiado", "nombre", "apellidos", "DNI", "titulacion", "estado"
		});
		vista.getTablaEnviados().setModel(tmodelEnviados);
		SwingUtil.autoAdjustColumns(vista.getTablaEnviados());
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

			//Si el nombre del archivo existe, lo aumento en uno
			while (archivo.exists()) {
				contador++;
				fileName = "archivo" + contador + ".csv";
				archivo = new File(rutaCarpeta + File.separator + fileName);
			}

			//Escribir en el archivo generado
			try (FileWriter writer = new FileWriter(archivo)) {
				writer.append("id colegiado,nombre,apellidos,dni,titulacion,estado\n");

				for (int i = 0; i < datosSeleccionados.size(); i++) {
					writer.append(String.join(",", datosSeleccionados.get(i))).append("\n");
				}
				JOptionPane.showMessageDialog(null, "Archivo CSV creado en: " + archivo.getAbsolutePath());
				return true; 
			} catch (IOException e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "Error al generar el archivo.");
				return false; 
			}
		} else {
			//Cancelo la seleccion del directorio
			JOptionPane.showMessageDialog(null, "No se seleccionó una ruta.");
			return false; 
		}
	}

	/**
	 * Checkbox de la vista que seleccionar y deselecciona todos las filas de la tabla
	 * @param seleccionar
	 * @param tabla
	 */
	public static void seleccionarDeselectarTodos(boolean seleccionar, JTable tabla) {
		int totalFilas = tabla.getRowCount();

		if (seleccionar && totalFilas > 0) {
			tabla.setRowSelectionInterval(0, totalFilas - 1); 
		} else {
			tabla.clearSelection(); 
		}
	}

	/**
	 * Metodo para cargar en la tabla un archivo csv
	 */
	private void cargarCSV() {
		JFileChooser chooser = new JFileChooser();
		chooser.setDialogTitle("Seleccionar archivo CSV");
		chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

		int resultado = chooser.showOpenDialog(null);

		if (resultado == JFileChooser.APPROVE_OPTION) {
			File archivo = chooser.getSelectedFile();
			List<ColegiadoDTO> colegiados = leerCSV(archivo);

			if (colegiados != null && !colegiados.isEmpty()) {
				TableModel tmodel = SwingUtil.getTableModelFromPojos(colegiados, new String[] {
						"id_colegiado", "nombre", "apellidos", "DNI", "titulacion", "estado"
				});

				vista.getTablaEnviados().setModel(tmodel);
				SwingUtil.autoAdjustColumns(vista.getTablaEnviados());
				JOptionPane.showMessageDialog(null, "Archivo CSV cargado correctamente.");
				JOptionPane.showMessageDialog(null, "Comprueba los datos con el boton comprobar.");

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
	private List<ColegiadoDTO> leerCSV(File archivo) {
		List<ColegiadoDTO> colegiados = new ArrayList<>();

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
				if (campos.length == 6) {
					try {
						for (int i = 0; i < campos.length; i++) {
							campos[i] = campos[i].trim();
						}

						String dni = campos[3];

						//Compruebo si el dni existe y si su estado es distino a enviado
						if (modelo.dniEstado(dni)) {
							JOptionPane.showMessageDialog(null, "Carga cancelada. El DNI " + dni + " ya existe en el sistema.");
							return new ArrayList<>();
						}

						ColegiadoDTO colegiado = new ColegiadoDTO();
						colegiado.setId_colegiado(Integer.parseInt(campos[0]));
						colegiado.setNombre(campos[1]);
						colegiado.setApellidos(campos[2]);
						colegiado.setDNI(campos[3]);
						colegiado.setTitulacion(campos[4]);
						colegiado.setEstado(campos[5]);
						colegiados.add(colegiado);

					} catch (NumberFormatException e) {
						JOptionPane.showMessageDialog(null, "Error en el formato del archivo CSV. Verifique los datos.");
						e.printStackTrace();
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error al leer el archivo CSV.");
		}

		return colegiados;
	}

	/**
	 * Metodo que comprueba las titulaciones de los colegiados
	 */
	private void comprobar() {
		int lineasTabla= vista.getTablaEnviados().getRowCount();
		if (lineasTabla == 0) {
			JOptionPane.showMessageDialog(null, "No hay datos que comprobar , carga un archivo.");
			return;
		}

		boolean enviados = false;
		for (int linea_actual = 0; linea_actual < lineasTabla; linea_actual++) {
			String estado = (String) vista.getTablaEnviados().getValueAt(linea_actual, 5);
			if (estado.equals("Enviado")) {
				enviados = true;
				break;
			}
		}

		if (!enviados) {
			JOptionPane.showMessageDialog(null, "No hay colegiados con estado 'Enviado' para comprobar.");
			return;
		}

		List<ColegiadoDTO> colegiadosEnviados = modelo.getListaColegiadosEnviados();
		for (int linea_actual = 0; linea_actual < lineasTabla; linea_actual++) {
			String estado = (String) vista.getTablaEnviados().getValueAt(linea_actual, 5);
			if (!"Enviado".equals(estado)) {
				continue;
			}

			String dni = (String) vista.getTablaEnviados().getValueAt(linea_actual, 3);
			String titulacion = (String) vista.getTablaEnviados().getValueAt(linea_actual, 4);

			ColegiadoDTO colegiado = null;
			for (int i = 0; i < colegiadosEnviados.size(); i++) {
				if (colegiadosEnviados.get(i).getDNI().equals(dni)) {
					colegiado = colegiadosEnviados.get(i);
					break;
				}
			}

			if (colegiado != null) {
				String titulacion_aux = titulacion;

				if (titulacion_aux.equals("Licenciatura Informatica") ||
						titulacion_aux.equals("Ingenieria Informatica") ||
						titulacion_aux.equals("Master Ingenieria Informatica")) {
					colegiado.setEstado("Aprobada");
				} else {
					colegiado.setEstado("Cancelado");
				}

				modelo.actualizarEstadoColegiado(colegiado, colegiado.getEstado());
			}
		}

		//Actualizo los datos de la tabla
		cargarListaAprobadosYCancelados();
		JOptionPane.showMessageDialog(null, "Los estados de todos los colegiados han sido actualizados.");
	}
}