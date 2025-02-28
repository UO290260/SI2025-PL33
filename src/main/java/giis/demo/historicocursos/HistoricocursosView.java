package giis.demo.historicocursos;
import java.awt.SystemColor;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import net.miginfocom.swing.MigLayout;

/**
 * Vista de la pantalla que muestra los cursos que ha realizado un colegiado
 */
public class HistoricocursosView {
	private JFrame frame;
	private JTextField numerocolegiadotxt;
	private JButton btnBuscar;
	private JTable tabla;
	private JLabel totalcursos;
	private JLabel totalhoras;

	/**
	 * Crea la aplicacion
	 */
	public HistoricocursosView() {
		initialize();
	}

	/**
	 * Inicializa el contenido del frame
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Histórico de cursos");
		frame.setBounds(0, 0, 756, 400);
		frame.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(new MigLayout("fillx, insets 10", "[right]10[grow,fill]10[right]", "[]5[]5[]5[]5[grow][]"));
		frame.setLocationRelativeTo(null);
		frame.getContentPane().add(new JLabel("Busca un numero de un colegiado para mostrar los cursos en los que esta inscrito"), "cell 0 0 2 1, growx , wrap");

		//NUMERO DE COLEGIADO
		frame.add(new JLabel("Número de colegiado:"), "cell 0 1");
		numerocolegiadotxt = new JTextField(5);
		HistoricocursosController.soloNumeros(numerocolegiadotxt);
		frame.add(numerocolegiadotxt, "cell 1 1, growx");

		//BOTON BUSCAR
		btnBuscar = new JButton("Buscar");
		frame.add(btnBuscar, "cell 2 1, right");

		//TABLA
		tabla = new JTable();
		tabla.setName("tabDetalle");
		tabla.setRowSelectionAllowed(false);
		tabla.setDefaultEditor(Object.class, null);
		tabla.setBackground(SystemColor.control);
		JScrollPane tableDetallePanel = new JScrollPane(tabla);
		frame.getContentPane().add(tableDetallePanel, "cell 0 3 2 3, grow");

		//PANEL RESUMEN
		JPanel panelResumen = new JPanel(new MigLayout("fill, insets 10"));
		panelResumen.setBorder(BorderFactory.createTitledBorder("Resumen"));
		panelResumen.add(new JLabel("Total de cursos:"));
		totalcursos = new JLabel("0");
		panelResumen.add(totalcursos, "wrap");
		panelResumen.add(new JLabel("Total de horas:"));
		totalhoras = new JLabel("0");
		panelResumen.add(totalhoras, "wrap");
		frame.getContentPane().add(panelResumen, "cell 2 3, top, grow");
	}
	public JFrame getFrame() { return this.frame; }
	public void setFrame(JFrame frame) { this.frame = frame; }
	public JTextField getNumerocolegiadotxt() { return this.numerocolegiadotxt; }
	public void setNumerocolegiadotxt(JTextField numerocolegiadotxt) { this.numerocolegiadotxt = numerocolegiadotxt; }
	public JButton getBtnBuscar() { return this.btnBuscar; }
	public void setBtnBuscar(JButton btnBuscar) { this.btnBuscar = btnBuscar; }
	public JTable getTabla() { return this.tabla; }
	public void setTabla(JTable tabla) { this.tabla = tabla; }
	public JLabel getTotalcursos() { return totalcursos; }
	public void setTotalcursos(JLabel totalcursos) { this.totalcursos = totalcursos; }
	public JLabel getTotalhoras() { return totalhoras; }
	public void setTotalhoras(JLabel totalhoras) { this.totalhoras = totalhoras; }
}