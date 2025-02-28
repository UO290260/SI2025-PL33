package giis.demo.inscripcioncursos;

import java.awt.Dimension;


import java.awt.SystemColor;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;

import net.miginfocom.swing.MigLayout;

public class Inscripcion_cursosView {
	
	private JFrame frame;
	private JTextField  JTnumero;
	private JButton btnNumero;
	private JButton btnInscripcion;
	private JTable TabCurso;
	private JLabel DatosPersonales;
	private JTable tabDatos;
	
	public Inscripcion_cursosView() {
		iniciate();
	}
	
     private void iniciate() {
    	 //Diseñamos una ventana de tamaño 492x422
	    	frame = new JFrame();
			frame.setTitle("Inscripción de curso");
			frame.setName("Inscripción");
			frame.setBounds(0, 0, 792, 380);
			frame.setResizable(false); // para que la ventana no pueda cambiar de tamaño 
			frame.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
			frame.getContentPane().setLayout(new MigLayout("", "[grow]", "[][][grow][][][][][][][][]")); //Es el layout que usaremos dividiendolo en filas y columnas
			
			final JLabel lblinscripción;
			final JLabel lblistacursos;
			lblinscripción= new JLabel("Inscripción para un nuevo curso");
			frame.getContentPane().add(lblinscripción, "cell 0 0 3 1, center"); // texto explicativo de la ventana
			
			final JLabel IntroducirNúmero;
			IntroducirNúmero= new JLabel("Introduzca su número de colegiado o precolegiado:");
			frame.getContentPane().add(IntroducirNúmero, "flowx,cell 0 2");
			
			JTnumero = new JTextField ();
			JTnumero.setName("JTnumero");
			frame.getContentPane().add(JTnumero, "cell 0 2");
			JTnumero.setColumns(15); //Campo de texto que ocupa 15 columnas 
			
			
		btnNumero = new JButton("Comprobar datos"); //Boton de comparar datos que mas adelante cargará los datos del colegiado
		IntroducirNúmero.setLabelFor(btnNumero);
		frame.getContentPane().add(btnNumero, "cell 1 2");
		
		lblistacursos = new JLabel("Lista de los cursos disponibles:");
		frame.getContentPane().add(lblistacursos, "cell 0 3");
		//Lista desplegable de cursos disponibles
		TabCurso = new JTable();
		TabCurso.setName("tabDetalle");
		TabCurso.setRowSelectionAllowed(true);
		TabCurso.setDefaultEditor(Object.class, null); //readonly
		TabCurso.setBackground(SystemColor.control);
		JScrollPane tableDetallePanelCursos = new JScrollPane(TabCurso);
		tableDetallePanelCursos.setMinimumSize(new Dimension(200,65));
		tableDetallePanelCursos.setPreferredSize(new Dimension(1000,100));
		frame.getContentPane().add(tableDetallePanelCursos, "cell 0 4 2 1");
		
		JLabel lblDatoscolegiado = new JLabel("Datos personales del colegiado:");
		frame.getContentPane().add(lblDatoscolegiado, "cell 0 5");
		
		//Tabla donde más adelante se cargarán los datos del coelgiado a partir de su identificador
		tabDatos = new JTable();
		tabDatos.setName("tabDetalle");
		tabDatos.setRowSelectionAllowed(false);
		tabDatos.setDefaultEditor(Object.class, null); //readonly
		tabDatos.setBackground(SystemColor.control);
		JScrollPane tableDetallePanel = new JScrollPane(tabDatos);
		tableDetallePanel.setMinimumSize(new Dimension(200,65));
		tableDetallePanel.setPreferredSize(new Dimension(1000,65));
		frame.getContentPane().add(tableDetallePanel, "cell 0 6 2 1");
		//Boton para inscribir a un colegiado al curso 
		btnInscripcion = new JButton("Inscribirse");
		IntroducirNúmero.setLabelFor(btnInscripcion);
		frame.getContentPane().add(btnInscripcion, "cell 1 7,alignx right");
			
	    }
     
     //los getters y setters de los campos de los atributos
     public JFrame getFrame() {return frame;}
     public void setFrame(JFrame frame) {this.frame = frame;}
     public JTextField getJTnumero() {return JTnumero;}
     public void setJTnumero(JTextField jTnumero) {JTnumero = jTnumero;}
     public JButton getBtnNumero() {return btnNumero;}
     public void setBtnNumero(JButton btnNumero) {this.btnNumero = btnNumero;}
     public JButton getBtnInscripcion() {return btnInscripcion;}
     public void setBtnInscripcion(JButton btnInscripcion) {this.btnInscripcion = btnInscripcion;}
     public JTable getTabCurso() {return TabCurso;}
     public void setTabCurso(JTable tabCurso) {TabCurso = tabCurso;}
     public JLabel getDatosPersonales() {return DatosPersonales;}
     public void setDatosPersonales(JLabel datosPersonales) {DatosPersonales = datosPersonales;}
     public JTable getTabDatos() {return tabDatos;}
     public void setTabDatos(JTable tabDatos) {this.tabDatos = tabDatos;}
     

}
