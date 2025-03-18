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
	
	public void mostrarCursos () {
		List<CursoDTO> cursos = model.getListaCursos();
		
		TableModel modelCursos = SwingUtil.getTableModelFromPojos(cursos, new String[]{
				"id_curso", "titulo", "descripcion", "estado"}
		);
		
		view.getTablaCursos().setModel(modelCursos);
		SwingUtil.autoAdjustColumns(view.getTablaCursos());
	}
	
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
	 * Método que obtiene la lista de inscritos de un curso 
	 * a partir del id del curso seleccionado
	 */
	public void mostrarInscritos() {
		 view.getTablaCursos().getSelectionModel().addListSelectionListener(e -> {
	            if (!e.getValueIsAdjusting()) {
	                getListaInscritos(); 
	            }
	        });
	}
}
