package giis.demo.solicitudcolegiado;
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
	}
	
	/**
	 * Inicializacion del controlador
	 */
	public void initView() {
		//Abre la ventana
		vista.getFrame().setVisible(true);
		//Inicia los datos de la vista
		cargarListaPendientes();
		cargarListaEnviados();
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
				cargarListaEnviados();
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
	 * Tabla de los Colegiados con estado Enviado
	 */
	private void cargarListaEnviados() {
		List<ColegiadoDTO> colegiadosEnviados = modelo.getListaColegiadosEnviados();
		TableModel tmodelEnviados = SwingUtil.getTableModelFromPojos(colegiadosEnviados, new String[]{
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
}