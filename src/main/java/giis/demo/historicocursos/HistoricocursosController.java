package giis.demo.historicocursos;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.TableModel;
import giis.demo.util.SwingUtil;

/**
 * Controlador para la funcionalidad de visualizacion de los cursos de un colegiado
 * -instancia el controlador con la vista y el modelo
 * -ejecutando initController que instalara los manejadores de eventos
 */
public class HistoricocursosController {
	private HistoricocursosModel modelo; 
	private HistoricocursosView vista;

	public HistoricocursosController(HistoricocursosModel model, HistoricocursosView view) {
		this.modelo = model;
		this.vista = view;
		this.initView();
	}

	/**
	 * Inicializacion del controlador 
	 */
	public void initController() {
		//Invoco el metodo que responde al listener para que se encargue de generar las excepciones
		vista.getBtnBuscar().addActionListener(e -> SwingUtil.exceptionWrapper(() -> cargarListaCursos()));

	}

	public void initView() {	
		//Abre la ventana
		vista.getFrame().setVisible(true);
		//Inicia los datos de la vista 
		cargarListaCursos();
	}

	/**
	 * Obtencion de la lista de cursos que necesita la lista de objetos del modelo y muestra tambien los resumenes.
	 */
	public void cargarListaCursos() {
		String numeroColegiadovista = vista.getNumerocolegiadotxt().getText();
		if (numeroColegiadovista.isEmpty()) { 
			JOptionPane.showMessageDialog(null, "Introduzca un número de colegiado");
			return;
		}

		int idColegiado = Integer.parseInt(numeroColegiadovista);
		List<HistoricocursosDTO> cursos = modelo.getListaCursos(idColegiado);
		if (cursos.isEmpty()) {
			JOptionPane.showMessageDialog(null, "El colegiado numero " + idColegiado + " no está inscrito en ningún curso.");
			return;
		}

		TableModel tmodel = SwingUtil.getTableModelFromPojos(cursos, new String[]{
				"id_colegiado" ,"id_curso", "titulo", "fecha_inicio", "fecha_fin", "duracion", "estado"
		});

		vista.getTabla().setModel(tmodel);
		SwingUtil.autoAdjustColumns(vista.getTabla());

		int totalCursos = modelo.getTotalCursos(idColegiado);
		int totalHoras = modelo.getTotalHoras(idColegiado);
		vista.getTotalcursos().setText(String.valueOf(totalCursos));
		vista.getTotalhoras().setText(String.valueOf(totalHoras));
	}

	/**
	 * Método para que solo puedas introducir números 
	 * @param letra
	 */
	public static void soloNumeros(JTextField numero) {
		numero.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				char c = evt.getKeyChar();
				if (!Character.isDigit(c) && c != KeyEvent.VK_BACK_SPACE) {
					evt.consume(); 
				}
			}
		});
	}
}