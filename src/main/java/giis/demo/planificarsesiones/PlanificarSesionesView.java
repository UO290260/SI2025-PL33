package giis.demo.planificarsesiones;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.SystemColor;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

public class PlanificarSesionesView {
	JFrame frame;
	JPanel panelSesiones;
	JTable tablaCursos;
	JTextField txtHora, txtDuracion;
	JDateChooser fecha;
	
	public PlanificarSesionesView() {
		initialize();
	}
	
	private void initialize() {
		
		JLabel lblCurso;
		JLabel lblFecha, lblHora, lblDuracion;
		
		frame = new JFrame();
		frame.setBounds(0, 0, 701, 450);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);
		frame.setTitle("Planificar Sesiones");
		frame.setName("Planificar Sesiones");
		
		lblCurso = new JLabel("Selecciona un curso:");
		lblCurso.setBounds(7, 7, 400, 14);
		frame.getContentPane().add(lblCurso);
		
		tablaCursos = new JTable();
		tablaCursos.setName("tablaInscritos");
		tablaCursos.setRowSelectionAllowed(true);
		tablaCursos.setDefaultEditor(Object.class, null); 
		tablaCursos.setBackground(SystemColor.control);
		JScrollPane panelCursos = new JScrollPane(tablaCursos);
		panelCursos.setBounds(7, 32, 668, 150);
		frame.getContentPane().add(panelCursos);
		
		panelSesiones = new JPanel();
		panelSesiones.setLayout(new GridLayout(3, 2, 50, 10));
		panelSesiones.setBounds(7, 232, 400, 150);
		
		lblFecha = new JLabel("Fecha de la sesión: ");
		panelSesiones.add(lblFecha);
		fecha = new JDateChooser();
        fecha.setPreferredSize(new Dimension(100,24));
        panelSesiones.add(fecha);
		
		lblHora = new JLabel("Hora de inicio: ");
		panelSesiones.add(lblHora);
		txtHora = new JTextField();
		txtHora.setName("txtHora");
		panelSesiones.add(txtHora);
		
		lblDuracion = new JLabel("Duración: ");
		panelSesiones.add(lblDuracion);
		txtDuracion = new JTextField();
		txtDuracion.setName("txtDuracion");
		panelSesiones.add(txtDuracion);
		
		frame.getContentPane().add(panelSesiones, "wrap");
	}
	
	public JFrame getFrame() { return frame; }
	public JTable getTablaCursos() { return tablaCursos; }
	public JTextField getDuracion() {return txtDuracion; }
	public Date getFecha() { return fecha.getDate(); }
}
