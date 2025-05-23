package giis.demo.views;
import java.awt.SystemColor;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;

import giis.demo.controllers.InscripcioncolegiadosController;
import net.miginfocom.swing.MigLayout;

/**
 * Vista de la pantalla que muestra los colegiados
 */
public class InscripcioncolegiadosView {
	private JFrame frame;
	private JTextField nombretxt;
	private JTextField apellidostxt;
	private JTextField DNItxt;
	private JTextField direcciontxt;
	private JTextField poblaciontxt;
	private JDateChooser fechanacimientoDate;
	private JDateChooser fechasolicitudDate;
	private JTextField cuentatxt;
	private JComboBox<String> titulacionComboBox;
	private JButton btnInscribir;
	private JTable tabla;

	/**
	 * Crea la aplicacion
	 */
	public InscripcioncolegiadosView() {
		initialize();
	}

	/**
	 * Inicializa el contenido del frame
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Inscripcion Colegiados");
		frame.setBounds(0, 0, 1080, 500);
		frame.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(new MigLayout("fillx, insets 10", "[right]10[grow,fill]", "[]5[]5[]5[]5[]5[]5[]5[grow]"));
		frame.setLocationRelativeTo(null);

		frame.getContentPane().add(new JLabel("(*)Nombre:"), "cell 0 0, right");
		nombretxt = new JTextField(15);
		InscripcioncolegiadosController.soloLetras(nombretxt);
		frame.getContentPane().add(nombretxt, "cell 1 0, growx");

		frame.getContentPane().add(new JLabel("(*)Apellidos:"), "cell 0 1, right");
		apellidostxt = new JTextField(20);
		InscripcioncolegiadosController.soloLetras(apellidostxt);
		frame.getContentPane().add(apellidostxt, "cell 1 1, growx");

		frame.getContentPane().add(new JLabel("(*)DNI:"), "cell 0 2, right");
		DNItxt = new JTextField(20);
		InscripcioncolegiadosController.validarDNI(DNItxt);
		frame.getContentPane().add(DNItxt, "cell 1 2, growx");

		frame.getContentPane().add(new JLabel("(*)Dirección:"), "cell 0 3, right");
		direcciontxt = new JTextField(20);		
		InscripcioncolegiadosController.soloLetras(direcciontxt);
		frame.getContentPane().add(direcciontxt, "cell 1 3, growx");

		frame.getContentPane().add(new JLabel("(*)Población:"), "cell 0 4, right");
		poblaciontxt = new JTextField(20);
		InscripcioncolegiadosController.soloLetras(poblaciontxt);
		frame.getContentPane().add(poblaciontxt, "cell 1 4, growx");

		frame.getContentPane().add(new JLabel("(*)Fecha de nacimiento:"), "cell 0 5, right");
		fechanacimientoDate = new JDateChooser();
		frame.getContentPane().add(fechanacimientoDate, "cell 1 5, growx");

		frame.getContentPane().add(new JLabel("(*)Cuenta bancaria:"), "cell 0 6, right");
		cuentatxt = new JTextField(20);
		InscripcioncolegiadosController.validarCuentaBancaria(cuentatxt);
		frame.getContentPane().add(cuentatxt, "cell 1 6, growx");

		frame.getContentPane().add(new JLabel("(*)Titulación:"), "cell 0 7, right");
		String[] titulaciones = {
			"Licenciatura Informatica",
			"Ingenieria Informatica",
			"Master Ingenieria Informatica"
		};
		titulacionComboBox = new JComboBox<>(titulaciones); 
		frame.getContentPane().add(titulacionComboBox, "cell 1 7, growx");

		tabla = new JTable();
		tabla.setName("tabDetalle");
		tabla.setRowSelectionAllowed(false);
		tabla.setDefaultEditor(Object.class, null); 
		tabla.setBackground(SystemColor.control);
		JScrollPane tableDetallePanel = new JScrollPane(tabla);
		frame.getContentPane().add(tableDetallePanel, "cell 0 8 2 1, grow, wrap");

		btnInscribir = new JButton("Inscribir un colegiado");
		frame.getContentPane().add(btnInscribir, "span, center, wrap");
	}
	public JTable getTabla() { return this.tabla; }
	public JFrame getFrame() { return this.frame; } public void setTabla(JTable tabla) { this.tabla = tabla; }
	public JButton getBtnInscribir() { return this.btnInscribir; } public void setBtnInscribir(JButton btnInscribir) { this.btnInscribir = btnInscribir; }
	public JTextField getNombretxt() { return this.nombretxt; }	public void setNombretxt(JTextField nombretxt) { this.nombretxt = nombretxt; }
	public JTextField getApellidostxt() { return this.apellidostxt; } public void setApellidostxt(JTextField apellidostxt) { this.apellidostxt = apellidostxt; }
	public JTextField getDNItxt() { return this.DNItxt; } public void setDNItxt(JTextField dNItxt) { this.DNItxt = dNItxt; }
	public JTextField getDirecciontxt() { return this.direcciontxt; } public void setDirecciontxt(JTextField direcciontxt) { this.direcciontxt = direcciontxt; }
	public JTextField getPoblaciontxt() { return this.poblaciontxt; } public void setPoblaciontxt(JTextField poblaciontxt) { this.poblaciontxt = poblaciontxt; }
	public JDateChooser getFechanacimientotxt() { return this.fechanacimientoDate; } public void setFechanacimientotxt(JDateChooser fechanacimientoDate) { this.fechanacimientoDate = fechanacimientoDate; }
	public JDateChooser getFechasolicitudtxt() { return this.fechasolicitudDate; } public void setFechasolicitudtxt(JDateChooser fechasolicitudDate) { this.fechasolicitudDate = fechasolicitudDate; }
	public JTextField getCuentatxt() { return this.cuentatxt; }	public void setCuentatxt(JTextField cuentatxt) { this.cuentatxt = cuentatxt; }
	public void setTitulacionComboBox(JComboBox<String> titulacionComboBox) {this.titulacionComboBox = titulacionComboBox;}
	public JComboBox<String> getTitulacionComboBox() {return titulacionComboBox;}
	public JButton getBtnInscribirColegiado() { return this.btnInscribir; }
}