package giis.demo.visualizarcursos;

import java.awt.event.ItemEvent;
import java.util.List;

import javax.swing.table.TableModel;

import giis.demo.util.SwingUtil;

public class VisualizarCursosController {
	
	VisualizarCursosModel model;
	VisualizarCursosView view;
	
	public VisualizarCursosController(VisualizarCursosModel m, VisualizarCursosView v) {
		this.model = m;
		this.view = v;
		
		this.initView();
		this.agregarCursos();
	}
	
	/**
	 * Acciones que se van a ejecutar al iniciar el programa
	 */
	public void initView() {
		view.getFrame().setVisible(true);
	}
	
	//Cargamos la lista del colectivo solicitado
	public void elegirListaCursos() {		
		String opcion = view.getOpcion().getItemAt(view.getOpcion().getSelectedIndex());
		List<VisualizarCursosDTO> colegiados;
		if (opcion == "Todos") 
			colegiados = model.getTodosCursos();
		
		else if (opcion == "Precolegiados")
			colegiados = model.getListaCursos("cuota_precolegiado");
		
		else if (opcion == "Colegiados")
			colegiados = model.getListaCursos("cuota_colegiado");
		
		else
			colegiados = model.getListaCursos("cuota_otros");
		
		TableModel tmodel = SwingUtil.getTableModelFromPojos(colegiados, new String[]{
				"id_curso", "titulo", "descripcion", "fecha_inicio", "fecha_fin", "duracion",
				"plazas", "cuota_precolegiado", "cuota_colegiado", "cuota_otros", "apertura_inscripcion", "cierre_inscripcion", "estado"}
		);
		
		view.getTabla().setModel(tmodel);
		SwingUtil.autoAdjustColumns(view.getTabla());
	}
	
	public void agregarCursos() {
		 view.getOpcion().addItemListener(e -> {
	            if (e.getStateChange() == ItemEvent.SELECTED) {
	                elegirListaCursos();  // Llamamos al método que aplica el filtro.
	            }
	        });
	}
	
}
	
