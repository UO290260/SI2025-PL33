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
import giis.demo.inscripcioncolegiados.InscripcioncolegiadosController;
import giis.demo.inscripcioncolegiados.InscripcioncolegiadosModel;
import giis.demo.inscripcioncolegiados.InscripcioncolegiadosView;
import giis.demo.ofertarcursos.OfertarCursosController;
import giis.demo.ofertarcursos.OfertarCursosModel;
import giis.demo.ofertarcursos.OfertarCursosView;
import giis.demo.planificarsesiones.PlanificarSesionesController;
import giis.demo.planificarsesiones.PlanificarSesionesModel;
import giis.demo.planificarsesiones.PlanificarSesionesView;
import giis.demo.solicitudcolegiado.SolicitudColegiadoController;
import giis.demo.solicitudcolegiado.SolicitudColegiadoModel;
import giis.demo.solicitudcolegiado.SolicitudColegiadoView;
import giis.demo.visualizarcursos.VisualizarCursosController;
import giis.demo.visualizarcursos.VisualizarCursosModel;
import giis.demo.visualizarcursos.VisualizarCursosView;
import giis.demo.visualizarinscritos.VisualizarInscritosController;
import giis.demo.visualizarinscritos.VisualizarInscritosModel;
import giis.demo.visualizarinscritos.VisualizarInscritosView;
import giis.demo.inscripcioncursos.InscripcionCursosController;
import giis.demo.inscripcioncursos.InscripcionCursosModel;
import giis.demo.inscripcioncursos.InscripcionCursosView;
import giis.demo.inscripcionlistaTAP.InscripcionlistaTAPController;
import giis.demo.inscripcionlistaTAP.InscripcionlistaTAPModel;
import giis.demo.inscripcionlistaTAP.InscripcionlistaTAPView;
import giis.demo.aperturacursos.apertura_cursosController;
import giis.demo.aperturacursos.apertura_cursosModel;
import giis.demo.aperturacursos.apertura_cursosView;

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
		frame.setBounds(0, 0, 500, 500);
		frame.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);

		//Boton de la historia Ofertar Cursos
		JButton btnOfertarCursos = new JButton("1. Ejecutar ofertar_curso");
		btnOfertarCursos.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {
				OfertarCursosController controllerOfertarCursos=new OfertarCursosController(new OfertarCursosModel(), new OfertarCursosView());
			}
		});
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
		frame.getContentPane().add(btnOfertarCursos);

		//Boton de la historia inscripcion_colegiados
		JButton btnInscripcion_colegiados = new JButton("2. Ejecutar de inscripcion_colegiados");
		btnInscripcion_colegiados.addActionListener(new ActionListener() { //NOSONAR codigo autogenerado
			public void actionPerformed(ActionEvent e) {
				InscripcioncolegiadosController controller2=new InscripcioncolegiadosController(new InscripcioncolegiadosModel(), new InscripcioncolegiadosView());
				controller2.initController();
			}
		});
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
		frame.getContentPane().add(btnInscripcion_colegiados);

		//Boton de la historia inscripcion_curso
		JButton btnIncripcióncurso = new JButton("3. Ejecutar inscricpcion_cursos"); //Botón que llama a la ventana de inscripción de curso
		btnIncripcióncurso.addActionListener(new ActionListener() { //NOSONAR codigo autogenerado
			public void actionPerformed(ActionEvent e) {
				InscripcionCursosController controller3=new InscripcionCursosController(new InscripcionCursosModel(), new InscripcionCursosView());
			}
		});
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
		frame.getContentPane().add(btnIncripcióncurso);

		//Boton de la historia apertura_curso
		JButton btnAbrirCurso = new JButton("4. Apertura Curso"); //Botón que llama a la ventana de inscripción de curso
		btnAbrirCurso.addActionListener(new ActionListener() { //NOSONAR codigo autogenerado
			public void actionPerformed(ActionEvent e) {
				apertura_cursosController controller4=new apertura_cursosController(new apertura_cursosModel(), new apertura_cursosView());
			}
		});
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
		frame.getContentPane().add(btnAbrirCurso);

		//Boton de la historia Visualizar Cursos
		JButton btnVisualizarrCursos = new JButton("5. Ejecutar Visualizar Cursos");
		btnVisualizarrCursos.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {
				VisualizarCursosController controllerVisualizarCursos=new VisualizarCursosController(new VisualizarCursosModel(), new VisualizarCursosView());

			}
		});
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
		frame.getContentPane().add(btnVisualizarrCursos);

		//Boton de la historia historico_cursos
		JButton btnHistoricocurso = new JButton("6. Ejecutar de historico_cursos");
		btnHistoricocurso.addActionListener(new ActionListener() { //NOSONAR codigo autogenerado
			public void actionPerformed(ActionEvent e) {
				HistoricocursosController controller6=new HistoricocursosController(new HistoricocursosModel(), new HistoricocursosView());
				controller6.initController();
			}
		});
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
		frame.getContentPane().add(btnHistoricocurso);

		//Boton de la historia Visualizar Inscritos
		JButton btnVisualizarInscritos = new JButton("7. Visualizar Inscritos");
		btnVisualizarInscritos.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {
				VisualizarInscritosController controllerVisualizarCursos=new VisualizarInscritosController(new VisualizarInscritosModel(), new VisualizarInscritosView());
			}
		});
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
		frame.getContentPane().add(btnVisualizarInscritos);

		//Boton de la historia inscripcion_lista_TAP
		JButton prueba = new JButton("8. Ejecutar de inscripcion_lista_TAP");
		prueba.addActionListener(new ActionListener() { //NOSONAR codigo autogenerado
			public void actionPerformed(ActionEvent e) {
				InscripcionlistaTAPController controller8=new InscripcionlistaTAPController(new InscripcionlistaTAPModel(), new InscripcionlistaTAPView());
				controller8.initController();
			}
		});
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
		frame.getContentPane().add(prueba);


		//Boton de la historia Planificar sesiones
		JButton btnPlanificarSesiones = new JButton("9. Planificar Sesiones");
		btnPlanificarSesiones.addActionListener(new ActionListener() { //NOSONAR codigo autogenerado
			public void actionPerformed(ActionEvent e) {
				PlanificarSesionesController controllerPlanificarSesiones=new PlanificarSesionesController(new PlanificarSesionesModel(), new PlanificarSesionesView());
			}
		});
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
		frame.getContentPane().add(btnPlanificarSesiones);
		

		//Boton de la historia inscripcion_lista_TAP
		JButton btnSolicitud = new JButton("10. Ejecutar solicitud_colegiado");
		btnSolicitud.addActionListener(new ActionListener() { //NOSONAR codigo autogenerado
			public void actionPerformed(ActionEvent e) {
				SolicitudColegiadoController controller10=new SolicitudColegiadoController(new SolicitudColegiadoModel(), new SolicitudColegiadoView());
				controller10.initController();
			}
		});
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
		frame.getContentPane().add(btnSolicitud);


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