package giis.demo.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.table.TableModel;

import giis.demo.dto.CursosDTO;
import giis.demo.models.apertura_cursosModel;
import giis.demo.util.ApplicationException;
import giis.demo.util.SwingUtil;
import giis.demo.util.Util;
import giis.demo.views.apertura_cursosView;

public class apertura_cursosController {
	private apertura_cursosModel model;
	private apertura_cursosView view;
	private List<CursosDTO> ListaCursos;
	
	public apertura_cursosController(apertura_cursosModel m, apertura_cursosView v) {
		this.model = m;
		this.view = v;
		//no hay inicializacion especifica del modelo, solo de la vista
		this.initView();
	}
	
	public void initView() {
		view.getFrame().setVisible(true);
		this.getListaCursos();
		view.getBtnapertura().addActionListener(new ActionListener() { //NOSONAR codigo autogenerado
			public void actionPerformed(ActionEvent e) {
				if(view.getDateApertura().getDate()==null || view.getDateCierre().getDate()==null)
				{
					throw new ApplicationException("Se debe introducir fecha de cierre y apertura ");
				}
				if(view.getTabCurso().getSelectedRow()==-1)
				{
					throw new ApplicationException("Debes seleccionar un curso que quieras abrir plazo de inscripción ");
				}
				if(view.getDateCierre().getDate().before(view.getDateApertura().getDate())) {
					throw new ApplicationException("La fecha de apertura debe ser antes que la fecha del cierre");
				}
				else
				{
					int idCurso=ListaCursos.get(view.getTabCurso().getSelectedRow()).getId_curso();
					String apertura=Util.dateToIsoString(view.getDateApertura().getDate());
					String cierre=Util.dateToIsoString(view.getDateCierre().getDate());
					if(apertura.equals(cierre)) {
						throw new ApplicationException("La fecha de apertura debe ser distinta de fecha del cierre");
					}
					else {
						model.AbrirCurso(idCurso, apertura, cierre);
						apertura_cursosController.this.getListaCursos(); //Actualiza la lista de los cursos
					}	
				}
			}
		});	
	}
	/**
	 * 	Obtiene la lista de cursos disponibles y los carga en el una tabla 
	 */
	public void getListaCursos() {
				ListaCursos=model.getListacursos();
				TableModel tmodel=SwingUtil.getTableModelFromPojos(ListaCursos, new String[] {"id_curso","titulo","descripcion","fecha_inicio","fecha_fin","duracion","plazas","cuota_precolegiado", "cuota_colegiado", "cuota_otros","apertura_inscripcion","cierre_inscripcion","estado"});
				view.getTabCurso().setModel(tmodel);
				SwingUtil.autoAdjustColumns(view.getTabCurso());			
	}
}
