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
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PlanificarSesionesView {
	JFrame frame;
	JPanel panelSesiones;
	JTable tablaCursos;
	JTextField txtHora, txtDuracion;
	JDateChooser fecha;
	JButton boton;
	
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
		panelSesiones.setLayout(new GridLayout(2,3,50,10));
		panelSesiones.setBounds(7, 210, 668, 95);
		
		lblFecha = new JLabel("Fecha de la sesión: ");
		panelSesiones.add(lblFecha);
		lblHora = new JLabel("Hora de inicio: ");
		panelSesiones.add(lblHora);
		lblDuracion = new JLabel("Duración: ");
		panelSesiones.add(lblDuracion);
		
		fecha = new JDateChooser();
        fecha.setPreferredSize(new Dimension(100,24));
        panelSesiones.add(fecha);
		txtHora = new JTextField();
		txtHora.setName("txtHora");
		txtHora.setPreferredSize(new Dimension(100,24));
		panelSesiones.add(txtHora);
		txtDuracion = new JTextField();
		txtDuracion.setName("txtDuracion");
		txtDuracion.setPreferredSize(new Dimension(100,24));
		panelSesiones.add(txtDuracion);
		
		frame.getContentPane().add(panelSesiones, "wrap");
		
		boton = new JButton("Planificar sesion");
		boton.setBounds(278, 350, 129, 23);
		frame.getContentPane().add(boton);
	}
	
	public JFrame getFrame() { return frame; }
	public JTable getTablaCursos() { return tablaCursos; }
	public JTextField getDuracion() {return txtDuracion; }
	public JTextField getHoraInicio() {return txtHora; }
	public JDateChooser getCalendario() { return fecha; }
	public Date getFecha() { return fecha.getDate(); }
	public JButton getBoton() { return boton; }
}
