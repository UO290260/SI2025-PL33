package giis.demo.solicitudcolegiado;

import java.awt.SystemColor;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import com.toedter.calendar.JDateChooser;

import net.miginfocom.swing.MigLayout;


public class SolicitudColegiadoView {
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
	private JButton btnEnviar;
	private JTable tabla;



	    public SolicitudColegiadoView() {
	        initialize();
	    }

	    /**
	     * Inicializa el contenido del frame
	     */
	    private void initialize() {
	        frame = new JFrame();
	        frame.setTitle("Solicitud Enviadas");
	        frame.setBounds(0, 0, 1080, 500);
	        frame.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
	        frame.getContentPane().setLayout(new MigLayout("fillx, insets 10", "[right]10[grow,fill]", "[]5[]5[]5[]5[]5[]5[]5[grow]"));
	        frame.setLocationRelativeTo(null);

	        // Crear la tabla y configurarla para permitir selección de filas
	        tabla = new JTable();
	        tabla.setName("tabDetalle");
	        tabla.setRowSelectionAllowed(true); // Permite la selección de filas
	        tabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // Permite solo una fila seleccionada
	        tabla.setDefaultEditor(Object.class, null);
	        tabla.setBackground(SystemColor.control);

	        // Hacer que la tabla se ajuste automáticamente al contenido
	        JScrollPane tablaEnviar = new JScrollPane(tabla);
	        frame.getContentPane().add(tablaEnviar, "cell 0 8 2 1, grow, wrap");
	        
	        btnEnviar = new JButton("Inscribir");
	        frame.getContentPane().add(btnEnviar, "cell 0 6 2 1, grow, wrap");

	        
	        

	    }
	public JTable getTabla() { return this.tabla; }
	public JFrame getFrame() { return this.frame; } public void setTabla(JTable tabla) { this.tabla = tabla; }
	public JButton getBtnInscribir() { return this.btnEnviar; } public void setBtnInscribir(JButton btnInscribir) { this.btnEnviar = btnInscribir; }
	public JTextField getNombretxt() { return this.nombretxt; }	public void setNombretxt(JTextField nombretxt) { this.nombretxt = nombretxt; }
	public JTextField getApellidostxt() { return this.apellidostxt; } public void setApellidostxt(JTextField apellidostxt) { this.apellidostxt = apellidostxt; }
	public JTextField getDNItxt() { return this.DNItxt; } public void setDNItxt(JTextField dNItxt) { this.DNItxt = dNItxt; }
	public JTextField getDirecciontxt() { return this.direcciontxt; } public void setDirecciontxt(JTextField direcciontxt) { this.direcciontxt = direcciontxt; }
	public JTextField getPoblaciontxt() { return this.poblaciontxt; } public void setPoblaciontxt(JTextField poblaciontxt) { this.poblaciontxt = poblaciontxt; }
	public JDateChooser getFechanacimientotxt() { return this.fechanacimientoDate; } public void setFechanacimientotxt(JDateChooser fechanacimientoDate) { this.fechanacimientoDate = fechanacimientoDate; }
	public JDateChooser getFechasolicitudtxt() { return this.fechasolicitudDate; } public void setFechasolicitudtxt(JDateChooser fechasolicitudDate) { this.fechasolicitudDate = fechasolicitudDate; }
	public JTextField getCuentatxt() { return this.cuentatxt; }	public void setCuentatxt(JTextField cuentatxt) { this.cuentatxt = cuentatxt; }
	public JTextField getTitulaciontxt() { return this.titulaciontxt; } public void setTitulaciontxt(JTextField titulaciontxt) { this.titulaciontxt = titulaciontxt; }
	public JButton getBtnInscribirColegiado() { return this.btnEnviar; }
}