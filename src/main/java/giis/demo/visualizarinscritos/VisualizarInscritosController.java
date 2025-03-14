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
	}
	
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
	
	public void mostrarInscripciones() {
		List<InscripcionDTO> inscripciones = model.getListaInscritos((int) view.getTablaCursos().getValueAt(view.getTablaCursos().getSelectedRow(), 0));
		
		TableModel modelInscriciones = SwingUtil.getTableModelFromPojos(inscripciones, new String[]{
				"id_inscripcion", "nombre", "apellidos", "dni", "estado"}
		);
		
		view.getTablaInscritos().setModel(modelInscriciones);
		SwingUtil.autoAdjustColumns(view.getTablaInscritos());
	}
}
