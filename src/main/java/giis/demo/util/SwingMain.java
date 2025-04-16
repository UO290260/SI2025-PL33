package giis.demo.util;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.BorderFactory;
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
import giis.demo.memoriaAnualPericiales.MemoriaAnualesPericialesController;
import giis.demo.memoriaAnualPericiales.MemoriaAnualesPericialesModel;
import giis.demo.memoriaAnualPericiales.MemoriaAnualesPericialesView;
import giis.demo.aperturacursos.apertura_cursosController;
import giis.demo.aperturacursos.apertura_cursosModel;
import giis.demo.aperturacursos.apertura_cursosView;
import giis.demo.generarrecibos.GenerarrecibosController;
import giis.demo.generarrecibos.GenerarrecibosModel;
import giis.demo.generarrecibos.GenerarrecibosView;
import giis.demo.asignarpericiales.AsignarPericialesController;
import giis.demo.asignarpericiales.AsignarPericialesModel;
import giis.demo.asignarpericiales.AsignarPericialesView;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

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
		try {
		    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
		    e.printStackTrace();
		}
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setTitle("Main");
		frame.setBounds(0, 0, 692, 387);
		frame.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 10, 10);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel panelCursos = new JPanel();
		panelCursos.setBounds(10, 11, 179, 204);
		panelCursos.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Acciones de Cursos", TitledBorder.LEFT, TitledBorder.TOP));
		panel.add(panelCursos);
		
		JButton btnOfertarCurso = new JButton("Ofertar curso");
		btnOfertarCurso.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {
			OfertarCursosController controllerOfertarCursos=new OfertarCursosController(new OfertarCursosModel(), new OfertarCursosView());
			}
			});
		panelCursos.add(btnOfertarCurso);
		
		JButton btnInscricpcionACursos = new JButton(" Inscricpcion a cursos");
		btnInscricpcionACursos.addActionListener(new ActionListener() { //NOSONAR codigo autogenerado
			public void actionPerformed(ActionEvent e) {
			InscripcionCursosController controller3=new InscripcionCursosController(new InscripcionCursosModel(), new InscripcionCursosView());
			}
			});
		panelCursos.add(btnInscricpcionACursos);
		
		JButton btnAperturaCurso = new JButton("Apertura Curso");
		btnAperturaCurso.addActionListener(new ActionListener() { //NOSONAR codigo autogenerado
			public void actionPerformed(ActionEvent e) {
			apertura_cursosController controller4=new apertura_cursosController(new apertura_cursosModel(), new apertura_cursosView());
			}
			});
		panelCursos.add(btnAperturaCurso);
		
		JButton btnVisualizarCursos = new JButton("Visualizar Cursos");
		btnVisualizarCursos.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {
			VisualizarCursosController controllerVisualizarCursos=new VisualizarCursosController(new VisualizarCursosModel(), new VisualizarCursosView());
			}
			});
		panelCursos.add(btnVisualizarCursos);
		
		JButton btnHistoricocursos = new JButton("Historico cursos");
		btnHistoricocursos.addActionListener(new ActionListener() { //NOSONAR codigo autogenerado
			public void actionPerformed(ActionEvent e) {
			HistoricocursosController controller6=new HistoricocursosController(new HistoricocursosModel(), new HistoricocursosView());
			controller6.initController();
			}
			});
		panelCursos.add(btnHistoricocursos);
		
		JButton btnPlanificarSesiones = new JButton("Planificar Sesiones");
		btnPlanificarSesiones.addActionListener(new ActionListener() { //NOSONAR codigo autogenerado
			public void actionPerformed(ActionEvent e) {
			PlanificarSesionesController controllerPlanificarSesiones=new PlanificarSesionesController(new PlanificarSesionesModel(), new PlanificarSesionesView());
			}
			});
		panelCursos.add(btnPlanificarSesiones);
		
		
		JPanel PanelBases = new JPanel();
		PanelBases.setBounds(10, 250, 656, 79);
		PanelBases.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Base de datos", TitledBorder.LEFT, TitledBorder.TOP));
		panel.add(PanelBases);
		PanelBases.setLayout(null);
		
		JButton btnCargarDatosIniciales = new JButton("Cargar Datos Iniciales para Pruebas");
		btnCargarDatosIniciales.setBounds(10, 33, 263, 23);
		btnCargarDatosIniciales.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {
				Database db=new Database();
				db.createDatabase(false);
				db.loadDatabase();
			}
		});
		PanelBases.add(btnCargarDatosIniciales);
		
		JButton btnInicializarBaseDeDatos = new JButton("Inicializar Base de Datos en Blanco");
		btnInicializarBaseDeDatos.setBounds(361, 33, 254, 23);
		btnInicializarBaseDeDatos.addActionListener(new ActionListener() { //NOSONAR codigo autogenerado
			public void actionPerformed(ActionEvent e) {
				Database db=new Database();
				db.createDatabase(false);
			}
		});
		PanelBases.add(btnInicializarBaseDeDatos);
		
		JPanel PanelColegiados = new JPanel();
		PanelColegiados.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Colegiados y externos", TitledBorder.LEFT, TitledBorder.TOP));
		PanelColegiados.setBounds(214, 11, 179, 114);
		panel.add(PanelColegiados);
		
		JButton btnInscripcion_colegiados = new JButton("Inscripcion colegiados");
		btnInscripcion_colegiados.addActionListener(new ActionListener() { //NOSONAR codigo autogenerado
			public void actionPerformed(ActionEvent e) {
			InscripcioncolegiadosController InscripcionColegiadoscontroller=new InscripcioncolegiadosController(new InscripcioncolegiadosModel(), new InscripcioncolegiadosView());
			InscripcionColegiadoscontroller.initController();
			}
			});
		PanelColegiados.add(btnInscripcion_colegiados);
		
		JButton btnVisualizarInscritos = new JButton("Visualizar Inscritos");
		btnVisualizarInscritos.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {
			VisualizarInscritosController controllerVisualizarCursos=new VisualizarInscritosController(new VisualizarInscritosModel(), new VisualizarInscritosView());
			}
			});
		PanelColegiados.add(btnVisualizarInscritos);
		
		JButton btnSolicitudColegiado = new JButton(" Solicitud colegiado");
		btnSolicitudColegiado.addActionListener(new ActionListener() { //NOSONAR codigo autogenerado
			public void actionPerformed(ActionEvent e) {
				SolicitudColegiadoController controller10=new SolicitudColegiadoController(new SolicitudColegiadoModel(), new SolicitudColegiadoView());
				controller10.initController();
			}
		});
		PanelColegiados.add(btnSolicitudColegiado);
		
		JPanel panelPeritos = new JPanel();
		panelPeritos.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Peritos", TitledBorder.LEFT, TitledBorder.TOP));
		panelPeritos.setBounds(429, 11, 179, 114);
		panel.add(panelPeritos);
		
		JButton btnInscripcionListaTap = new JButton("Inscripcion lista TAP");
		btnInscripcionListaTap.addActionListener(new ActionListener() { //NOSONAR codigo autogenerado
			public void actionPerformed(ActionEvent e) {
			InscripcionlistaTAPController controller8=new InscripcionlistaTAPController(new InscripcionlistaTAPModel(), new InscripcionlistaTAPView());
			controller8.initController();
			}
			});
		panelPeritos.add(btnInscripcionListaTap);
		
		JButton btnAsignarPericiales = new JButton("Asignar Periciales");
		btnAsignarPericiales.addActionListener(new ActionListener() { //NOSONAR codigo autogenerado
			public void actionPerformed(ActionEvent e) {
				AsignarPericialesController controllerAsignarPericial=new AsignarPericialesController(new AsignarPericialesModel(), new AsignarPericialesView());
			}
		});
		panelPeritos.add(btnAsignarPericiales);
		
		JButton btnMostrarPericialesAnuales = new JButton("Periciales anuales");
		btnMostrarPericialesAnuales.addActionListener(new ActionListener() { //NOSONAR codigo autogenerado
			public void actionPerformed(ActionEvent e) {
				MemoriaAnualesPericialesController controllerAsignarPericial=new MemoriaAnualesPericialesController(new MemoriaAnualesPericialesView(), new MemoriaAnualesPericialesModel());
			}
		});
		panelPeritos.add(btnMostrarPericialesAnuales);
		
		JPanel panelOtros = new JPanel();
		panelOtros.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Otros", TitledBorder.LEFT, TitledBorder.TOP));
		panelOtros.setLayout(null);
		panelOtros.setBounds(216, 136, 392, 79);
		panel.add(panelOtros);
		
		JButton btnEjecutarGenerarRecibos = new JButton("Generar recibos");
		btnEjecutarGenerarRecibos.setBounds(10, 28, 173, 23);
		btnEjecutarGenerarRecibos.addActionListener(new ActionListener() { //NOSONAR codigo autogenerado
            public void actionPerformed(ActionEvent e) {
                GenerarrecibosController controller12=new GenerarrecibosController(new GenerarrecibosModel(), new GenerarrecibosView());
                controller12.initController();
            }
        });
		panelOtros.add(btnEjecutarGenerarRecibos);
	}

	public JFrame getFrame() { return this.frame;}
}