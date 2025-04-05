package giis.demo.asignarpericiales;

import java.util.List;
import javax.swing.table.TableModel;
import giis.demo.util.SwingUtil;

public class AsignarPericialesController {
	
	AsignarPericialesView view;
	AsignarPericialesModel model;
	
	public AsignarPericialesController(AsignarPericialesModel m, AsignarPericialesView v) {
		model = m; 
		view = v;
		
		initView();
	}
	public void initView() {
		view.getFrame().setVisible(true);
		
		List<PericialDTO> periciales = model.getListaPericiales();
		
		TableModel modelPericiales = SwingUtil.getTableModelFromPojos(periciales, new String[]{
				"id_pericial", "solicitante", "fecha", "urgencia", "estado"}
		);
		
		view.getTablaPericiales().setModel(modelPericiales);
		SwingUtil.autoAdjustColumns(view.getTablaPericiales());
		
		List<PeritoDTO> peritos = model.getListaPeritos();
		
		TableModel modelPeritos = SwingUtil.getTableModelFromPojos(peritos, new String[]{
				"tap", "id_colegiado", "correo", "telefono", "estado"}
		);
		
		view.getTablaPeritos().setModel(modelPeritos);
		SwingUtil.autoAdjustColumns(view.getTablaPeritos());
	}
}
