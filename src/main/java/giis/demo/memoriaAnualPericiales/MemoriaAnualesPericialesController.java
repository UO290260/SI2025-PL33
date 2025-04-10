package giis.demo.memoriaAnualPericiales;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.table.TableModel;

import giis.demo.util.SwingUtil;


public class MemoriaAnualesPericialesController {

	MemoriaAnualesPericialesView v;
	MemoriaAnualesPericialesModel model;
	
	public MemoriaAnualesPericialesController(MemoriaAnualesPericialesView view,MemoriaAnualesPericialesModel model)
	{
		this.v=view;
		this.model=model;
		this.initView();
	}
	
	public void initView()
	{
		v.getFrmIncidenciasPericiales().setVisible(true);
		
		v.getComboAño().addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	mostrarPericiales();
		    }
		});
		
		v.getComboEstado().addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	mostrarPericiales();
		    }
		});
	}
	
	public void mostrarPericiales() {
		String anio=(String) v.getComboAño().getSelectedItem();
		String estado=(String) v.getComboEstado().getSelectedItem();
		List<PericialesDTO> pericial = model.cargarPericiales(anio,estado);
		
		TableModel modelpericial = SwingUtil.getTableModelFromPojos(pericial, new String[]{
				"id_pericial","id_perito","nombre","solicitante","fecha","urgencia","estado"}
		);
		
		v.getTablaPericiales().setModel(modelpericial);
		SwingUtil.autoAdjustColumns(v.getTablaPericiales());
	}
}
