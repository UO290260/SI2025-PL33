package giis.demo.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;

import giis.demo.dto.CursosDTO;
import giis.demo.dto.InscripcionesDTO;
import giis.demo.models.VisualizarCursosModel;
import giis.demo.util.SwingUtil;
import giis.demo.views.VisualizarCursosView;

public class VisualizarCursosController {
	
	VisualizarCursosModel model;
	VisualizarCursosView view;
	
	public VisualizarCursosController(VisualizarCursosModel m, VisualizarCursosView v) {
		this.model = m;
		this.view = v;
		
		this.initView();
		this.agregarCursos();
		this.mostrarInscritos();
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
		List<CursosDTO> colegiados;
		if (opcion == "Todos") 
			colegiados = model.getTodosCursos();
		
		else if (opcion == "Precolegiados")
			colegiados = model.getListaCursos("cuota_precolegiado");
		
		else if (opcion == "Colegiados")
			colegiados = model.getListaCursos("cuota_colegiado");
		
		else if (opcion == "Minusválidos")
			colegiados = model.getListaCursos("cuota_minusvalido");
		
		else if (opcion == "Desempleados")
			colegiados = model.getListaCursos("cuota_desempleado");
		
		else if (opcion == "Empleados")
			colegiados = model.getListaCursos("cuota_empleado");
		
		else if (opcion == "Alumnos")
			colegiados = model.getListaCursos("cuota_alumno");
		
		else if (opcion == "Empresas")
			colegiados = model.getListaCursos("cuota_empresa");
		
		else
			colegiados = model.getListaCursos("cuota_otros");
		
		TableModel tmodel = SwingUtil.getTableModelFromPojos(colegiados, new String[]{
				"id_curso", "titulo", "descripcion", "fecha_inicio", "fecha_fin", "duracion",
				"plazas", "cuota_precolegiado", "cuota_colegiado", "cuota_minusvalido", "cuota_desempleado", "cuota_empleado", "cuota_alumno", "cuota_empresa",
				"cuota_otros", "apertura_inscripcion", "cierre_inscripcion", "estado"}
		);
		
		view.getTablaCursos().setModel(tmodel);
		SwingUtil.autoAdjustColumns(view.getTablaCursos());
		
		ActionListener accionBoton = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (view.getTablaCursos().getSelectedRow()==-1) {
					JOptionPane.showMessageDialog(null, "Debe seleccionar un curso para cancelar");
		            return;
				}
				if (view.getTablaCursos().getValueAt(view.getTablaCursos().getSelectedRow(), 17).equals("En Curso")) {
					JOptionPane.showMessageDialog(null, "El curso no puede haber iniciado");
		            return;
				}
				
				if (view.getTablaCursos().getValueAt(view.getTablaCursos().getSelectedRow(), 17).equals("Cancelado")) {
					JOptionPane.showMessageDialog(null, "No se puede cancelar un curso ya cancelado");
		            return;
				}
				cancelarCurso();
				elegirListaCursos();
			}
		};

		for (ActionListener al : view.getBoton().getActionListeners()) {
			view.getBoton().removeActionListener(al);
		}

		view.getBoton().addActionListener(accionBoton);
	}
	
	public void agregarCursos() {
		 view.getOpcion().addItemListener(e -> {
	            if (e.getStateChange() == ItemEvent.SELECTED) {
	                elegirListaCursos();  // Llamamos al método que aplica el filtro.
	            }
	        });
	}
	
	public void cancelarCurso () {
		model.cancelarCurso((int) view.getTablaCursos().getValueAt(view.getTablaCursos().getSelectedRow(), 0));
		model.actualizarInscritos((int) view.getTablaCursos().getValueAt(view.getTablaCursos().getSelectedRow(), 0));
		JOptionPane.showMessageDialog(null, "El curso ha sido cancelado correctamente");
	}
	
	public void mostrarInscritos () {
		view.getTablaCursos().getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
            	if ((int) view.getTablaCursos().getSelectedRow() != -1) {
            		List<InscripcionesDTO> inscripciones = model.getListaInscritos((int) view.getTablaCursos().getValueAt(view.getTablaCursos().getSelectedRow(), 0));
                	TableModel modelInscriciones = SwingUtil.getTableModelFromPojos(inscripciones, new String[]{
            				"id_inscripcion", "nombre", "apellidos", "dni", "cantidad_devolver", "estado"}
            		);
            		
            		view.getTablaInscritos().setModel(modelInscriciones);
            		SwingUtil.autoAdjustColumns(view.getTablaInscritos());
                }
            	} 	
        });
	}
}
	
