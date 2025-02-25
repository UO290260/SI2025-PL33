package giis.demo.util;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import giis.demo.*;
import giis.demo.inscripcion_colegiados.Inscripcion_colegiadosController;
import giis.demo.inscripcion_colegiados.Inscripcion_colegiadosModel;
import giis.demo.inscripcion_colegiados.Inscripcion_colegiadosView;
import giis.demo.ofertar_cursos.*;

/**
 * Punto de entrada principal que incluye botones para la ejecucion de las pantallas 
 * de las aplicaciones de ejemplo
 * y acciones de inicializacion de la base de datos.
 * No sigue MVC pues es solamente temporal para que durante el desarrollo se tenga posibilidad
 * de realizar acciones de inicializacion
 */
public class SwingMain {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() { //NOSONAR codigo autogenerado
			public void run() {
				try {
					SwingMain window = new SwingMain();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace(); //NOSONAR codigo autogenerado
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SwingMain() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Main");
		frame.setBounds(0, 0, 287, 185);
		frame.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);

		//Boton de la historia Ofertar Cursos
		JButton btnEjecutarTkrun = new JButton("Ejecutar ofertar_curso");
		btnEjecutarTkrun.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {
				OfertarCursosController controller=new OfertarCursosController(new OfertarCursosModel(), new OfertarCursosView());
			}
		});
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
		frame.getContentPane().add(btnEjecutarTkrun);
		
		//Historia inscripcion_colegiados
		JButton btnEjecutarTkrun2 = new JButton("Ejecuccion de Inscripcion_colegiados (Alejandro Piñeiro)");
		btnEjecutarTkrun2.addActionListener(new ActionListener() { //NOSONAR codigo autogenerado
			public void actionPerformed(ActionEvent e) {
				Inscripcion_colegiadosController controller2=new Inscripcion_colegiadosController(new Inscripcion_colegiadosModel(), new Inscripcion_colegiadosView());
				controller2.initController();
			}
		});
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
		frame.getContentPane().add(btnEjecutarTkrun2);
		
		
		//Historia visualizacion_cursos
		/**
		 * 
		JButton btnEjecutarTkrun2 = new JButton("Ejecuccion de  Visualizacion_cursos(Alejandro Piñeiro)");
		btnEjecutarTkrun.addActionListener(new ActionListener() { //NOSONAR codigo autogenerado
			public void actionPerformed(ActionEvent e) {
				Visualizacion_cursosController controller=new Visualizar_cursosController(new Visualizacion_cursosModel(), new Visualizacion_cursosView());
				controller.initController();
			}
		});
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
		frame.getContentPane().add(btnEjecutarTkrun2);
		
		*/
		/**
		 * Cargar la base de datos en blanco 
		 */
		JButton btnInicializarBaseDeDatos = new JButton("Inicializar Base de Datos en Blanco");
		btnInicializarBaseDeDatos.addActionListener(new ActionListener() { //NOSONAR codigo autogenerado
			public void actionPerformed(ActionEvent e) {
				Database db=new Database();
				db.createDatabase(false);
			}
		});
		frame.getContentPane().add(btnInicializarBaseDeDatos);
		
		/**
		 * Cargar la base de datos del proyecto	
		 */
		JButton btnCargarDatosIniciales = new JButton("Cargar Datos Iniciales para Pruebas");
		btnCargarDatosIniciales.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {
				Database db=new Database();
				db.createDatabase(false);
				db.loadDatabase();
			}
		});
		frame.getContentPane().add(btnCargarDatosIniciales);
		
	}

	public JFrame getFrame() { return this.frame;}
	
}