package giis.demo.generarrecibos;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import net.miginfocom.swing.MigLayout;

public class GenerarrecibosView {
	private JFrame frame;
	private JTable tablaColegiados;
	private JTable tablaRecibos;
	private JButton btnEnviar;
	private JButton btnCargar;

	/**
	 * Crea la aplicacion
	 */
	public GenerarrecibosView() {
		initialize();
	}

	/**
	 * Inicializa el contenido del frame
	 */
	private void initialize(){
		frame = new JFrame();
		frame.setTitle("Gestionar Recibos");
		frame.setBounds(100, 100, 500, 400);
		frame.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(new MigLayout("fillx, insets 10", "[right]10[grow,fill]", "[]5[]5[]5[]5[]5[]5[]5[grow]"));
		frame.setLocationRelativeTo(null);

		JPanel panelPrincipal = new JPanel();
		panelPrincipal.setLayout(new BoxLayout(panelPrincipal, BoxLayout.Y_AXIS));
		frame.add(panelPrincipal, BorderLayout.CENTER);
		frame.setVisible(true);

		JPanel panelColegiados = new JPanel(new BorderLayout());
		JPanel panelRecibos = new JPanel(new BorderLayout());

		tablaColegiados = new JTable();
		JScrollPane scrollPane = new JScrollPane(tablaColegiados);
		panelColegiados.add(new JLabel("Colegiados Pendientes a Generar Recibos"), BorderLayout.NORTH);
		panelColegiados.add(scrollPane, BorderLayout.CENTER);
		tablaColegiados.setDefaultEditor(Object.class, null);

		tablaRecibos = new JTable();
		JScrollPane scrollPaneEnviados = new JScrollPane(tablaRecibos);
		panelRecibos.add(new JLabel("Recibos con estado Emitido y No Cobrado/Cobrado"), BorderLayout.NORTH);
		panelRecibos.add(scrollPaneEnviados, BorderLayout.CENTER);
		tablaRecibos.setDefaultEditor(Object.class, null);

		panelPrincipal.add(panelColegiados);
		panelPrincipal.add(panelRecibos);

		JPanel panelControles = new JPanel();
		btnEnviar = new JButton("Enviar");
		btnCargar = new JButton("Cargar");
		panelControles.add(btnEnviar);
		panelControles.add(btnCargar);

		panelColegiados.add(panelControles, BorderLayout.SOUTH);

	}
	public JFrame getFrame() { return frame; } public void setFrame(JFrame frame) { this.frame = frame; }
	public JTable getTablaColegiados() { return tablaColegiados; } public void setTablaColegiados(JTable tablaColegiados) { this.tablaColegiados = tablaColegiados; }
	public JTable getTablaRecibos() { return tablaRecibos; } public void setTablaRecibos(JTable tablaRecibos) { this.tablaRecibos = tablaRecibos; }
	public JButton getBtnEnviar() { return btnEnviar; } public void setBtnEnviar(JButton btnEnviar) { this.btnEnviar = btnEnviar; }
	public JButton getBtnCargar() { return btnCargar; } public void setBtnCargar(JButton btnCargar) { this.btnCargar = btnCargar; }
}