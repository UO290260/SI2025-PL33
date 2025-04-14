package giis.demo.visualizarinscritos;
	
import java.util.List;
import javax.swing.table.TableModel;
import giis.demo.util.SwingUtil;

public class VisualizarInscritosController {
	VisualizarInscritosModel model;
	VisualizarInscritosView view;
	
	public VisualizarInscritosController(VisualizarInscritosModel m, VisualizarInscritosView v) {
		this.model = m;
		this.view = v;
		
		this.initView();
		mostrarCursos();
		mostrarInscritos();
	}
	
	/**
	 * Metodo que inicializa la ventana principal
	 */
	public void initView() {
		view.getFrame().setVisible(true);
	}
	/**
	 * Metodo que obtiene los cursos de la base de datos para cargarlos en la tabla de la interfaz
	 */
	public void mostrarCursos () {
		List<CursoDTO> cursos = model.getListaCursos();
		
		TableModel modelCursos = SwingUtil.getTableModelFromPojos(cursos, new String[]{
				"id_curso", "titulo", "descripcion", "estado"}
		);
		
		view.getTablaCursos().setModel(modelCursos);
		SwingUtil.autoAdjustColumns(view.getTablaCursos());
	}
	/**
	 * Método que obtiene la lista de inscritos de un curso 
	 * a partir del id del curso seleccionado
	 */
	public void getListaInscritos() {
		List<InscripcionDTO> inscripciones = model.getListaInscritos((int) view.getTablaCursos().getValueAt(view.getTablaCursos().getSelectedRow(), 0));
		
		TableModel modelInscriciones = SwingUtil.getTableModelFromPojos(inscripciones, new String[]{
				"id_inscripcion", "nombre", "apellidos", "dni", "estado"}
		);
		
		view.getLblNumero().setText("Numero de inscritos en el curso: " + inscripciones.size());
		
		view.getTablaInscritos().setModel(modelInscriciones);
		SwingUtil.autoAdjustColumns(view.getTablaInscritos());
	}
	
	/**
	 * Método que obtiene la lista de espera de un curso 
	 * a partir del id del curso seleccionado
	 */
	public void getListaEspera() {
		List<InscripcionDTO> inscripcionesEspera = model.getListaEspera((int) view.getTablaCursos().getValueAt(view.getTablaCursos().getSelectedRow(), 0));
		
		TableModel modelInscricionesEspera = SwingUtil.getTableModelFromPojos(inscripcionesEspera, new String[]{
				"id_inscripcion", "nombre", "apellidos", "dni", "posicion", "estado"}
		);
		
		view.getLblesperaNumero().setText("Numero de Lista de espera en el curso: " + inscripcionesEspera.size());
		
		view.getTablaEspera().setModel(modelInscricionesEspera);
		SwingUtil.autoAdjustColumns(view.getTablaEspera());
	}
	
	/**
	 * Método que carga los inscritos en la tabla de la interfaz
	 */
	public void mostrarInscritos() {
		 view.getTablaCursos().getSelectionModel().addListSelectionListener(e -> {
	            if (!e.getValueIsAdjusting()) {
	                getListaInscritos();
	                getListaEspera();
	            }
	        });
	}
}
