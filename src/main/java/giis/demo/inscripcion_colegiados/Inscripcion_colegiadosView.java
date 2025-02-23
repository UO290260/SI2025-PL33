package giis.demo.inscripcion_colegiados;

import java.awt.Dimension;
import java.awt.SystemColor;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
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
	private JTable tabla;


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

		//Nombre
		frame.getContentPane().add(new JLabel("Nombre:"));
		nombretxt = new JTextField(15);
		frame.getContentPane().add(nombretxt, "growx , wrap");

		//Apellidos
		frame.getContentPane().add(new JLabel("Apellidos:"));
		apellidostxt = new JTextField(20);
		frame.getContentPane().add(apellidostxt, "growx, wrap");

		//DNI
		frame.getContentPane().add(new JLabel("DNI:"));
		DNItxt = new JTextField(20);
		frame.getContentPane().add(DNItxt, "growx, wrap");

		//Dirección
		frame.getContentPane().add(new JLabel("Dirección:"));
		direcciontxt = new JTextField(20);
		frame.getContentPane().add(direcciontxt, "growx, wrap");

		//Población
		frame.getContentPane().add(new JLabel("Población:"));
		poblaciontxt = new JTextField(20);
		frame.getContentPane().add(poblaciontxt, "growx, wrap");

		//Fecha de nacimiento
		frame.getContentPane().add(new JLabel("Fecha de nacimiento:"));
		fechanacimientoDate = new JDateChooser();
		frame.getContentPane().add(fechanacimientoDate, "growx, wrap");

		//Cuenta
		frame.getContentPane().add(new JLabel("Cuenta bancaria:"));
		cuentatxt = new JTextField(20);
		frame.getContentPane().add(cuentatxt, "growx, wrap");

		//Titulación
		frame.getContentPane().add(new JLabel("Titulación:"));
		titulaciontxt = new JTextField(20);
		frame.getContentPane().add(titulaciontxt, "growx, wrap");

		//Tabla
		tabla = new JTable();
		tabla.setName("tabDetalle");
		tabla.setRowSelectionAllowed(false);
		tabla.setDefaultEditor(Object.class, null); //readonly
		tabla.setBackground(SystemColor.control);
		JScrollPane tableDetallePanel = new JScrollPane(tabla);
		tableDetallePanel.setMinimumSize(new Dimension(200,95));
		tableDetallePanel.setPreferredSize(new Dimension(300,95));
		frame.getContentPane().add(tableDetallePanel, "growx, wrap");

		// Botón de inscripción
		btnInscribir = new JButton("Inscribir un colegiado");
		frame.getContentPane().add(btnInscribir, "span, center, wrap");


	}
	public JTable getTabla() { return this.tabla; }
	public void setTabla(JTable tabla) { this.tabla = tabla; }
	public JFrame getFrame() { return this.frame; }
	public JButton getBtnInscribir() { return this.btnInscribir; }
	public void setBtnInscribir(JButton btnInscribir) { this.btnInscribir = btnInscribir; }
	public JTextField getNombretxt() { return this.nombretxt; }
	public void setNombretxt(JTextField nombretxt) { this.nombretxt = nombretxt; }
	public JTextField getApellidostxt() { return this.apellidostxt; }
	public void setApellidostxt(JTextField apellidostxt) { this.apellidostxt = apellidostxt; }
	public JTextField getDNItxt() { return this.DNItxt; }
	public void setDNItxt(JTextField dNItxt) { this.DNItxt = dNItxt; }
	public JTextField getDirecciontxt() { return this.direcciontxt; }
	public void setDirecciontxt(JTextField direcciontxt) { this.direcciontxt = direcciontxt; }
	public JTextField getPoblaciontxt() { return this.poblaciontxt; }
	public void setPoblaciontxt(JTextField poblaciontxt) { this.poblaciontxt = poblaciontxt; }
	public JDateChooser getFechanacimientotxt() { return this.fechanacimientoDate; }
	public void setFechanacimientotxt(JDateChooser fechanacimientoDate) { this.fechanacimientoDate = fechanacimientoDate; }
	public JDateChooser getFechasolicitudtxt() { return this.fechasolicitudDate; }
	public void setFechasolicitudtxt(JDateChooser fechasolicitudDate) { this.fechasolicitudDate = fechasolicitudDate; }
	public JTextField getCuentatxt() { return this.cuentatxt; }
	public void setCuentatxt(JTextField cuentatxt) { this.cuentatxt = cuentatxt; }
	public JTextField getTitulaciontxt() { return this.titulaciontxt; }
	public void setTitulaciontxt(JTextField titulaciontxt) { this.titulaciontxt = titulaciontxt; }
	public JButton getBtnInscribirColegiado() { return this.btnInscribir; }

}
