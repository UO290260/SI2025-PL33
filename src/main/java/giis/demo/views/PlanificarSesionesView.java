package giis.demo.views;

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
import javax.swing.JButton;

public class PlanificarSesionesView {
	JFrame frame;
	JPanel panelSesiones;
	JTable tablaCursos, tablaSesiones;
	JTextField txtHora, txtDuracion;
	JDateChooser fecha;
	JButton boton;
	
	public PlanificarSesionesView() {
		initialize();
	}
	
	private void initialize() {
		
		JLabel lblCurso;
		JLabel lblFecha, lblHora, lblDuracion, lblSesiones;
		
		frame = new JFrame();
		frame.setBounds(0, 0, 701, 565);
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
		panelSesiones.setLayout(new GridLayout(2,3,50,10));
		panelSesiones.setBounds(7, 183, 668, 95);
		
		lblFecha = new JLabel("Fecha de la sesión: ");
		panelSesiones.add(lblFecha);
		lblHora = new JLabel("Hora de inicio: ");
		panelSesiones.add(lblHora);
		lblDuracion = new JLabel("Duración: ");
		panelSesiones.add(lblDuracion);
		
		fecha = new JDateChooser();
        panelSesiones.add(fecha);
		txtHora = new JTextField();
		txtHora.setName("txtHora");
		panelSesiones.add(txtHora);
		txtDuracion = new JTextField();
		txtDuracion.setName("txtDuracion");
		panelSesiones.add(txtDuracion);
		
		frame.getContentPane().add(panelSesiones, "wrap");
		
		lblSesiones = new JLabel("Sesiones del curso seleccionado");
		lblSesiones.setBounds(7, 289, 668, 24);
		frame.getContentPane().add(lblSesiones);
		
		tablaSesiones = new JTable();
		tablaSesiones.setName("tablaSesiones");
		tablaSesiones.setDefaultEditor(Object.class, null); 
		tablaSesiones.setBackground(SystemColor.control);
		JScrollPane panelSesiones = new JScrollPane(tablaSesiones);
		panelSesiones.setBounds(7, 315, 668, 150);
		frame.getContentPane().add(panelSesiones);
		
		boton = new JButton("Planificar sesion");
		boton.setBounds(278, 487, 129, 23);
		frame.getContentPane().add(boton);
	}
	
	public JFrame getFrame() { return frame; }
	public JTable getTablaCursos() { return tablaCursos; }
	public JTable getTablaSesiones() { return tablaSesiones; }
	public JTextField getDuracion() {return txtDuracion; }
	public JTextField getHoraInicio() {return txtHora; }
	public JDateChooser getCalendario() { return fecha; }
	public Date getFecha() { return fecha.getDate(); }
	public JButton getBoton() { return boton; }
}
