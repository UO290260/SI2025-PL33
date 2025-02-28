package giis.demo.aperturacursos;
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

import com.toedter.calendar.JDateChooser;

import net.miginfocom.swing.MigLayout;

public class apertura_cursosView {
	private JFrame frame;
	private JDateChooser DateApertura;
	private JDateChooser DateCierrea;
	private JButton btnapertura;
	private JTable TabCurso;
	
	public apertura_cursosView() {
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
			
			final JLabel lblapertura;
			final JLabel lblistacursos;
			lblapertura= new JLabel("Apertura para un nuevo curso");
			frame.getContentPane().add(lblapertura, "cell 0 0 3 1, center"); // texto explicativo de la ventana
			
			final JLabel fecha_apertura;
			fecha_apertura= new JLabel("Fecha de apertura:");
			frame.getContentPane().add(fecha_apertura, "flowx,cell 0 2");
			
			DateApertura = new JDateChooser();
			DateApertura.setName("FechaApetura");
			frame.getContentPane().add(DateApertura, "cell 0 2");
			 
			
			final JLabel fecha_cierre;
			fecha_cierre= new JLabel("Fecha de cierre:");
			frame.getContentPane().add(fecha_apertura, "flowx,cell 1 2");
			
			DateCierrea = new JDateChooser();
			DateCierrea.setName("FechaCierre");
			frame.getContentPane().add(DateCierrea, "cell 1 2");
		
		
		lblistacursos = new JLabel("Lista de los cursos planificados:");
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
		
		//Boton para inscribir a un colegiado al curso 
		btnapertura = new JButton("Abrir Curso");
		fecha_apertura.setLabelFor(btnapertura);
		frame.getContentPane().add(btnapertura, "cell 1 7,alignx right");
	    }
	

}
