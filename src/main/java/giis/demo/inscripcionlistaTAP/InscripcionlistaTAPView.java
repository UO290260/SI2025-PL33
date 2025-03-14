package giis.demo.inscripcionlistaTAP;
import java.awt.SystemColor;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;
import net.miginfocom.swing.MigLayout;

public class InscripcionlistaTAPView {
	private JFrame frame;
	private JTextField idColegiadoTxt, nombretxt, apellidostxt, DNItxt, direcciontxt, poblaciontxt, cuentatxt, titulaciontxt;
	private JTextField telefonotxt;
	private JTextField correotxt;
	private JTextField añotxt;
	private JTextField fechasolicitudtxt;
	private JDateChooser fechanacimientotxt;
	private JButton btnBuscar, btnGuardar;
	private JTable tabla;

	public InscripcionlistaTAPView() {
		frame = new JFrame();
		frame.setTitle("Justificante de Inscripción de Peritos");
		frame.setBounds(0, 0, 600, 400);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(new MigLayout("fillx, insets 10", "[right]10[grow,fill]", "[]5[]5[]5[]5[]5[]5[]5[]5[grow]"));
		frame.setLocationRelativeTo(null);

		frame.getContentPane().add(new JLabel("ID Colegiado:"), "cell 0 0, right");
		idColegiadoTxt = new JTextField(10);
		InscripcionlistaTAPController.soloNumeros(idColegiadoTxt);
		frame.getContentPane().add(idColegiadoTxt, "cell 1 0, growx");

		btnBuscar = new JButton("Buscar");
		frame.getContentPane().add(btnBuscar, "cell 2 0, wrap");

		frame.getContentPane().add(new JLabel("Nombre:"), "cell 0 1, right");
		nombretxt = new JTextField(15);
		InscripcionlistaTAPController.soloLetras(nombretxt);
		frame.getContentPane().add(nombretxt, "cell 1 1, growx");

		frame.getContentPane().add(new JLabel("Apellidos:"), "cell 0 2, right");
		apellidostxt = new JTextField(20);
		InscripcionlistaTAPController.soloLetras(apellidostxt);
		frame.getContentPane().add(apellidostxt, "cell 1 2, growx");

		frame.getContentPane().add(new JLabel("DNI:"), "cell 0 3, right");
		DNItxt = new JTextField(20);
		InscripcionlistaTAPController.validarDNI(DNItxt);
		frame.getContentPane().add(DNItxt, "cell 1 3, growx");

		frame.getContentPane().add(new JLabel("Dirección:"), "cell 0 4, right");
		direcciontxt = new JTextField(20);
		frame.getContentPane().add(direcciontxt, "cell 1 4, growx");

		frame.getContentPane().add(new JLabel("Población:"), "cell 0 5, right");
		poblaciontxt = new JTextField(20);
		InscripcionlistaTAPController.soloLetras(poblaciontxt);
		frame.getContentPane().add(poblaciontxt, "cell 1 5, growx");

		frame.getContentPane().add(new JLabel("(*)Teléfono:"), "cell 0 6, right");
		telefonotxt = new JTextField(20);
		InscripcionlistaTAPController.validarTelefono(telefonotxt);
		frame.getContentPane().add(telefonotxt, "cell 1 6, growx");

		frame.getContentPane().add(new JLabel("(*)Correo Electrónico:"), "cell 0 7, right");
		correotxt = new JTextField(20);
		frame.getContentPane().add(correotxt, "cell 1 7, growx");

		frame.getContentPane().add(new JLabel("(*)Año de realizacion:"), "cell 0 8, right");
		añotxt = new JTextField(20);
		InscripcionlistaTAPController.validar4numeros(añotxt);
		frame.getContentPane().add(añotxt, "cell 1 8, growx");

		frame.getContentPane().add(new JLabel("Fecha de nacimiento:"), "cell 0 10, right");
		fechanacimientotxt = new JDateChooser();
		frame.getContentPane().add(fechanacimientotxt, "cell 1 10, growx");

		frame.getContentPane().add(new JLabel("Cuenta bancaria:"), "cell 0 11, right");
		cuentatxt = new JTextField(20);
		InscripcionlistaTAPController.validarCuentaBancaria(cuentatxt);
		frame.getContentPane().add(cuentatxt, "cell 1 11, growx");

		frame.getContentPane().add(new JLabel("Titulación:"), "cell 0 12, right");
		titulaciontxt = new JTextField(20);
		InscripcionlistaTAPController.soloLetras(titulaciontxt);
		frame.getContentPane().add(titulaciontxt, "cell 1 12, growx");

		tabla = new JTable();
		tabla.setName("tabDetalle");
		tabla.setRowSelectionAllowed(false);
		tabla.setDefaultEditor(Object.class, null); 
		tabla.setBackground(SystemColor.control);
		JScrollPane tableDetallePanel = new JScrollPane(tabla);
		frame.getContentPane().add(tableDetallePanel, "cell 0 15 2 1, grow, wrap");

		btnGuardar = new JButton("Guardar Cambios");
		frame.getContentPane().add(btnGuardar, "span, center, wrap");
		frame.setVisible(true);
	}
	public JFrame getFrame() { return frame; } public void setFrame(JFrame frame) { this.frame = frame; }
	public JTextField getTelefonotxt() { return telefonotxt; } public void setTelefonotxt(JTextField telefonotxt) { this.telefonotxt = telefonotxt; }
	public JTextField getAñotxt() { return añotxt; } public void setAñotxt(JTextField añotxt) { this.añotxt = añotxt; }
	public JTextField getFechasolicitudtxt() { return fechasolicitudtxt; } public void setFechasolicitudtxt(JTextField fechasolicitudtxt) { this.fechasolicitudtxt = fechasolicitudtxt; }
	public JTextField getCorreotxt() { return correotxt; } public void setCorreotxt(JTextField correotxt) { this.correotxt = correotxt; }
	public JTextField getIdColegiadoTxt() { return idColegiadoTxt; } public void setIdColegiadoTxt(JTextField idColegiadoTxt) { this.idColegiadoTxt = idColegiadoTxt; }
	public JTextField getNombretxt() { return nombretxt; } public void setNombretxt(JTextField nombretxt) { this.nombretxt = nombretxt; }
	public JTextField getApellidostxt() { return apellidostxt; } public void setApellidostxt(JTextField apellidostxt) { this.apellidostxt = apellidostxt; }
	public JTextField getDNItxt() { return DNItxt; } public void setDNItxt(JTextField dNItxt) { DNItxt = dNItxt; }
	public JTextField getDirecciontxt() { return direcciontxt; } public void setDirecciontxt(JTextField direcciontxt) { this.direcciontxt = direcciontxt; }
	public JTextField getPoblaciontxt() { return poblaciontxt; } public void setPoblaciontxt(JTextField poblaciontxt) { this.poblaciontxt = poblaciontxt; }
	public JTextField getCuentatxt() { return cuentatxt; } public void setCuentatxt(JTextField cuentatxt) { this.cuentatxt = cuentatxt; }
	public JTextField getTitulaciontxt() { return titulaciontxt; } public void setTitulaciontxt(JTextField titulaciontxt) { this.titulaciontxt = titulaciontxt; }
	public JDateChooser getFechanacimientotxt() { return fechanacimientotxt; } public void setFechanacimientotxt(JDateChooser fechanacimientotxt) { this.fechanacimientotxt = fechanacimientotxt; }
	public JButton getBtnBuscar() { return btnBuscar; } public void setBtnBuscar(JButton btnBuscar) { this.btnBuscar = btnBuscar; }
	public JButton getBtnGuardar() { return btnGuardar; } public void setBtnGuardar(JButton btnGuardar) { this.btnGuardar = btnGuardar; }
	public JTable getTabla() { return tabla; } public void setTabla(JTable tabla) { this.tabla = tabla; }
}