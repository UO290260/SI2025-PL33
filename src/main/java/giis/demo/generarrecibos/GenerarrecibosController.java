package giis.demo.generarrecibos;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;

import giis.demo.util.SwingUtil;

public class GenerarrecibosController {
	private GenerarrecibosModel modelo;
	private GenerarrecibosView vista;

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

	private void enviarSeleccionados() {
		int totalFilas = vista.getTablaColegiados().getRowCount();

		if (totalFilas == 0) {
			JOptionPane.showMessageDialog(null, "No hay colegiados en la tabla.");
			return;
		}

		List<String[]> datosSeleccionados = new ArrayList<>();

		for (int fila = 0; fila < totalFilas; fila++) {
			ColegiadosRecibosDTO colegiado = new ColegiadosRecibosDTO();
			colegiado.setId_colegiado(Integer.parseInt(vista.getTablaColegiados().getValueAt(fila, 0).toString()));
			colegiado.setNombre(vista.getTablaColegiados().getValueAt(fila, 1).toString());
			colegiado.setApellidos(vista.getTablaColegiados().getValueAt(fila, 2).toString());
			colegiado.setDNI(vista.getTablaColegiados().getValueAt(fila, 3).toString());
			colegiado.setTitulacion(vista.getTablaColegiados().getValueAt(fila, 4).toString());
			colegiado.setEstado("Enviado");

			// Actualiza estado del colegiado y del recibo
			modelo.actualizarEstadoColegiadoReal(colegiado, "Enviado");
			modelo.actualizarEstadoRecibo(colegiado.getDNI(), "Emitido");

			datosSeleccionados.add(new String[] {
				String.valueOf(colegiado.getId_colegiado()),
				colegiado.getNombre(),
				colegiado.getApellidos(),
				colegiado.getDNI(),
				colegiado.getTitulacion(),
				colegiado.getEstado()
			});
		}

		if (!datosSeleccionados.isEmpty()) {
			boolean archivoGenerado = generarCSV(datosSeleccionados);
			if (archivoGenerado) {
				cargarListaColegiados(); // Actualiza la tabla con los nuevos estados
				cargarListaRecibos();
				JOptionPane.showMessageDialog(null, "Todos los colegiados han sido enviados y exportados a CSV.");
			} else {
				JOptionPane.showMessageDialog(null, "Hubo un error al generar el archivo CSV.");
			}
		}
	}
	
	/**
	 * 
	 */
	private void cargarListaColegiados() {
		List<ColegiadosRecibosDTO> colegiadosPendientes = modelo.getListaColegiados();
		TableModel tmodelPendientes = SwingUtil.getTableModelFromPojos(colegiadosPendientes, new String[]{
				"id_colegiado", "nombre", "apellidos", "DNI", "titulacion", "estado"
		});
		vista.getTablaColegiados().setModel(tmodelPendientes);
		SwingUtil.autoAdjustColumns(vista.getTablaColegiados());
	}
	
	/**
	 * 
	 */
	private void cargarListaRecibos() {
	    List<RecibosDTO> recibos = modelo.getListaRecibos();
	 	TableModel tmodelEnviados = SwingUtil.getTableModelFromPojos(recibos, new String[]{
	            "id_recibo", "DNI", "cuota_pagar", "fecha_recibo", "estado"
	    });
	    vista.getTablaRecibos().setModel(tmodelEnviados);
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

}

