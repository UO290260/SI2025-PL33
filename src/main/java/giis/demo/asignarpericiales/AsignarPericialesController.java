package giis.demo.asignarpericiales;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
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
	
	/**
	 * Función para, una vez escogida pericial y perito, se realice la asignacion
	 */
	public void asignarPericial() {
		if (view.getTablaPericiales().getSelectedRow() == -1) {
			JOptionPane.showMessageDialog(null, "Se debe seleccionar una pericial");
            return;
		}
		
		if (!((String)view.getTablaPericiales().getValueAt(view.getTablaPericiales().getSelectedRow(), 4)).equals("Pendiente")) {
			JOptionPane.showMessageDialog(null, "Solo se pueden asignar periciales en estado Pendiente");
            return;
		}
		
		Date fechaHoy = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String fechaStr = sdf.format(fechaHoy);
		
		model.añadirAsignacion((int) view.getTablaPeritos().getValueAt(view.getTablaPeritos().getSelectedRow(), 1),
				(int) view.getTablaPericiales().getValueAt(view.getTablaPericiales().getSelectedRow(), 0), fechaStr);
		
		model.actualizarTablas((int) view.getTablaPeritos().getValueAt(view.getTablaPeritos().getSelectedRow(), 1),
				(int) view.getTablaPericiales().getValueAt(view.getTablaPericiales().getSelectedRow(), 0));
		
		JOptionPane.showMessageDialog(null, "Se ha realizado correctamente la asignacion");
		cargarTablas();
	}
	
	/**
	 * Función para cargar las tablas en la interfaz
	 */
	public void cargarTablas() {
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
		
		view.getTablaPeritos().setRowSelectionInterval(0, 0);
	}
	
	/**
	 * Funcion para inicializar la ventana principal y habilitar las funcionalidades
	 */
	public void initView() {
		view.getFrame().setVisible(true);
		
		cargarTablas();
		
		//Acción ejecutada al pulsar el boton
		this.view.getBoton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
					asignarPericial();
			}
		});
	}
}
