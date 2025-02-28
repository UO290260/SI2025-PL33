package giis.demo.util;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import giis.demo.historicocursos.HistoricocursosController;
import giis.demo.historicocursos.HistoricocursosModel;
import giis.demo.historicocursos.HistoricocursosView;
import giis.demo.inscripcion_colegiados.Inscripcion_colegiadosController;
import giis.demo.inscripcion_colegiados.Inscripcion_colegiadosModel;
import giis.demo.inscripcion_colegiados.Inscripcion_colegiadosView;
import giis.demo.ofertar_cursos.*;
import giis.demo.inscripcioncursos.Inscripcion_cursosController;
import giis.demo.inscripcioncursos.Inscripcion_cursosModel;
import giis.demo.inscripcioncursos.Inscripcion_cursosView;

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
		frame.setBounds(0, 0, 300, 200);
		frame.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);

		//Boton de la historia Ofertar Cursos
		JButton btnEjecutarTkrun = new JButton("1. Ejecutar ofertar_curso");
		btnEjecutarTkrun.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {
				OfertarCursosController controller=new OfertarCursosController(new OfertarCursosModel(), new OfertarCursosView());
			}
		});
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
		frame.getContentPane().add(btnEjecutarTkrun);
		
		//Historia inscripcion_colegiados
		JButton btnEjecutarTkrun2 = new JButton("2. Ejecutar de inscripcion_colegiados");
		btnEjecutarTkrun2.addActionListener(new ActionListener() { //NOSONAR codigo autogenerado
			public void actionPerformed(ActionEvent e) {
				Inscripcion_colegiadosController controller2=new Inscripcion_colegiadosController(new Inscripcion_colegiadosModel(), new Inscripcion_colegiadosView());
				controller2.initController();
			}
		});
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
		frame.getContentPane().add(btnEjecutarTkrun2);
		
		JButton btnIncripcióncurso = new JButton("Inscripción de curso"); //Botón que llama a la ventana de inscripción de curso
		btnIncripcióncurso.addActionListener(new ActionListener() { //NOSONAR codigo autogenerado
			public void actionPerformed(ActionEvent e) {
				Inscripcion_cursosController controller=new Inscripcion_cursosController(new Inscripcion_cursosModel(), new Inscripcion_cursosView());
			}
		});
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
		frame.getContentPane().add(btnIncripcióncurso);
		
		//Apertura de cursos
		/*
		JButton btnAbrirCurso = new JButton("Apertura Curso"); //Botón que llama a la ventana de inscripción de curso
		btnIncripcióncurso.addActionListener(new ActionListener() { //NOSONAR codigo autogenerado
			public void actionPerformed(ActionEvent e) {
				Inscripcion_cursosController controller=new Inscripcion_cursosController(new Inscripcion_cursosModel(), new Inscripcion_cursosView());
			}
		});
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
		frame.getContentPane().add(btnAbrirCurso);
		*/
		
		//Historia historico_cursos
		JButton btnEjecutarTkrun3 = new JButton("3. Ejecutar de historico_cursos");
		btnEjecutarTkrun3.addActionListener(new ActionListener() { //NOSONAR codigo autogenerado
			public void actionPerformed(ActionEvent e) {
				HistoricocursosController controller=new HistoricocursosController(new HistoricocursosModel(), new HistoricocursosView());
				controller.initController();
			}
		});
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
		frame.getContentPane().add(btnEjecutarTkrun3);
		
		
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