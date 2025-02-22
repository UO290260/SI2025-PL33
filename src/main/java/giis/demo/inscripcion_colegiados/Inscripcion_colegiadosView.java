package giis.demo.inscripcion_colegiados;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

import net.miginfocom.swing.MigLayout;

public class Inscripcion_colegiadosView {
	private JFrame frame;

	private JTextField nombretxt;
	private JTextField apellidostxt;
	private JTextField DNItxt;
	private JTextField direcciontxt;
	private JTextField poblaciontxt;
	private JDateChooser fechanacimientoDate;
	private JDateChooser fechasolicitudDate;
	private JTextField cuentatxt;
	private JTextField titulaciontxt;
	private JButton btnInscribir;


	public Inscripcion_colegiadosView() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Inscripcion Colegiados");
		frame.setBounds(0, 0, 400, 275);
		frame.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new MigLayout("", "[grow]", "[][][grow][][][][][][][][]"));
		frame.setLocationRelativeTo(null);

		// Nombre
		frame.getContentPane().add(new JLabel("Nombre:"));
		nombretxt = new JTextField(15);
		frame.getContentPane().add(nombretxt, "growx , wrap");

		// Apellidos
		frame.getContentPane().add(new JLabel("Apellidos:"));
		apellidostxt = new JTextField(20);
		frame.getContentPane().add(apellidostxt, "growx, wrap");

		// DNI
		frame.getContentPane().add(new JLabel("DNI:"));
		DNItxt = new JTextField(20);
		frame.getContentPane().add(DNItxt, "growx, wrap");

		// Dirección
		frame.getContentPane().add(new JLabel("Dirección:"));
		direcciontxt = new JTextField(20);
		frame.getContentPane().add(direcciontxt, "growx, wrap");

		// Población
		frame.getContentPane().add(new JLabel("Población:"));
		poblaciontxt = new JTextField(20);
		frame.getContentPane().add(poblaciontxt, "growx, wrap");

		// Fecha de nacimiento
		frame.getContentPane().add(new JLabel("Fecha de nacimiento:"));
		fechanacimientoDate = new JDateChooser();
		frame.getContentPane().add(fechanacimientoDate, "growx, wrap");

		// Cuenta
		frame.getContentPane().add(new JLabel("Cuenta bancaria:"));
		cuentatxt = new JTextField(20);
		frame.getContentPane().add(cuentatxt, "growx, wrap");

		// Titulación
		frame.getContentPane().add(new JLabel("Titulación:"));
		titulaciontxt = new JTextField(20);
		frame.getContentPane().add(titulaciontxt, "growx, wrap");

		// Botón de inscripción
		btnInscribir = new JButton("Inscribir un colegiado");
		frame.getContentPane().add(btnInscribir, "span, center, wrap");


	}

	public JFrame getFrame() {
		return this.frame;
	}
	
	public JButton getBtnInscribir() {
		return btnInscribir;
	}

	public void setBtnInscribir(JButton btnInscribir) {
		this.btnInscribir = btnInscribir;
	}

	public JTextField getNombretxt() {
		return nombretxt;
	}

	public void setNombretxt(JTextField nombretxt) {
		this.nombretxt = nombretxt;
	}

	public JTextField getApellidostxt() {
		return apellidostxt;
	}

	public void setApellidostxt(JTextField apellidostxt) {
		this.apellidostxt = apellidostxt;
	}

	public JTextField getDNItxt() {
		return DNItxt;
	}

	public void setDNItxt(JTextField dNItxt) {
		DNItxt = dNItxt;
	}

	public JTextField getDirecciontxt() {
		return direcciontxt;
	}

	public void setDirecciontxt(JTextField direcciontxt) {
		this.direcciontxt = direcciontxt;
	}

	public JTextField getPoblaciontxt() {
		return poblaciontxt;
	}

	public JDateChooser getFechanacimientotxt() {
		return fechanacimientoDate;
	}

	public void setFechanacimientotxt(JDateChooser fechanacimientoDate) {
		this.fechanacimientoDate = fechanacimientoDate;
	}

	public JDateChooser getFechasolicitudtxt() {
		return fechasolicitudDate;
	}

	public void setFechasolicitudtxt(JDateChooser fechasolicitudDate) {
		this.fechasolicitudDate = fechasolicitudDate;
	}

	public void setPoblaciontxt(JTextField poblaciontxt) {
		this.poblaciontxt = poblaciontxt;
	}

	public JTextField getCuentatxt() {
		return cuentatxt;
	}

	public void setCuentatxt(JTextField cuentatxt) {
		this.cuentatxt = cuentatxt;
	}

	public JTextField getTitulaciontxt() {
		return titulaciontxt;
	}

	public void setTitulaciontxt(JTextField titulaciontxt) {
		this.titulaciontxt = titulaciontxt;
	}

	public JButton getBtnInscribirColegiado() { 
		return this.btnInscribir; 
	}
}
