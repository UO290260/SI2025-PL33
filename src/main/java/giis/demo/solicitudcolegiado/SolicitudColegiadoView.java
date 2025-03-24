package giis.demo.solicitudcolegiado;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import net.miginfocom.swing.MigLayout;

public class SolicitudColegiadoView {
	private JFrame frame;
	private JTable tabla;
	private JTable tablaEnviados;
	private JButton btnEnviar;
	private JCheckBox checkSeleccionarTodos;

	/**
	 * Crea la aplicacion
	 */
	public SolicitudColegiadoView() {
		initialize();
	}

	/**
	 * Inicializa el contenido del frame
	 */
	private void initialize(){
		frame = new JFrame();
		frame.setTitle("Solicitud Colegiado");
		frame.setBounds(100, 100, 500, 400);
		frame.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(new MigLayout("fillx, insets 10", "[right]10[grow,fill]", "[]5[]5[]5[]5[]5[]5[]5[grow]"));
		frame.setLocationRelativeTo(null);

		JPanel panelPrincipal = new JPanel();
		panelPrincipal.setLayout(new BoxLayout(panelPrincipal, BoxLayout.Y_AXIS));
		frame.add(panelPrincipal, BorderLayout.CENTER);
		frame.setVisible(true);

		JPanel panelTablaPendientes = new JPanel(new BorderLayout());
		JPanel panelTablaEnviados = new JPanel(new BorderLayout());

		//Tabla pendientes
		tabla = new JTable();
		JScrollPane scrollPane = new JScrollPane(tabla);
		panelTablaPendientes.add(new JLabel("Colegiados Pendientes"), BorderLayout.NORTH);
		panelTablaPendientes.add(scrollPane, BorderLayout.CENTER);
		tabla.setDefaultEditor(Object.class, null);

		//Tabla enviados
		tablaEnviados = new JTable();
		JScrollPane scrollPaneEnviados = new JScrollPane(tablaEnviados);
		panelTablaEnviados.add(new JLabel("Colegiados Enviados"), BorderLayout.NORTH);
		panelTablaEnviados.add(scrollPaneEnviados, BorderLayout.CENTER);
		tablaEnviados.setDefaultEditor(Object.class, null);

		panelPrincipal.add(panelTablaPendientes);
		panelPrincipal.add(panelTablaEnviados);

		//Configuracion del checkbox y enviar
		JPanel panelControles = new JPanel();
		checkSeleccionarTodos = new JCheckBox("Seleccionar todos");
		btnEnviar = new JButton("Enviar");
		panelControles.add(checkSeleccionarTodos);
		panelControles.add(btnEnviar);
		panelTablaPendientes.add(panelControles, BorderLayout.SOUTH);

		//Funcion del checkbox
		checkSeleccionarTodos.addActionListener(e -> {SolicitudColegiadoController.seleccionarDeselectarTodos(checkSeleccionarTodos.isSelected(), tabla);});
	}
	public JFrame getFrame() { return this.frame; }
	public JTable getTabla() { return this.tabla; }
	public JTable getTablaEnviados() { return this.tablaEnviados; }
	public JButton getBtnEnviar() { return this.btnEnviar; }
	public JCheckBox getCheckSeleccionarTodos() { return this.checkSeleccionarTodos; }
}