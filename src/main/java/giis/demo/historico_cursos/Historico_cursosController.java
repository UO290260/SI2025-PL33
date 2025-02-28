package giis.demo.historico_cursos;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.TableModel;
import giis.demo.util.SwingUtil;

public class Historico_cursosController {

	private Historico_cursosModel modelo; 
	private Historico_cursosView vista;

	/**
	 * Constructor
	 * @param model
	 * @param view
	 */
	public Historico_cursosController(Historico_cursosModel model, Historico_cursosView view) {
		this.modelo = model;
		this.vista = view;
		this.initView();
	}

	/**
	 * Inicializo la interfaz
	 */
	public void initView() {	
		vista.getFrame().setVisible(true);
		cargarListaCursos();
	}

	/**
	 * Boton de buscar colegiado , que si tiene una excecpion la genera
	 */
	public void initController() {
		vista.getBtnBuscar().addActionListener(e -> SwingUtil.exceptionWrapper(() -> cargarListaCursos()));

	}

	/**
	 * Muestra la lista de los cursos y del resumen
	 */
	public void cargarListaCursos() {

		String numeroColegiadovista = vista.getNumerocolegiadotxt().getText();
		if (numeroColegiadovista.isEmpty()) { 
			JOptionPane.showMessageDialog(null, "Introduzca un número de colegiado");
			return;
		}
		int idColegiado = Integer.parseInt(numeroColegiadovista);
		List<Historico_cursosDTO> cursos = modelo.getListaCursos(idColegiado);

		if (cursos.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Este colegiado " + idColegiado + " no está inscrito en ningún curso.");
			return;
		}

		TableModel tmodel = SwingUtil.getTableModelFromPojos(cursos, new String[]{
				"id_colegiado" ,"id_curso", "titulo", "fecha_inicio", "fecha_fin", "duracion", "estado"
		});

		vista.getTabla().setModel(tmodel);
		SwingUtil.autoAdjustColumns(vista.getTabla());

		//RESUMENES
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

