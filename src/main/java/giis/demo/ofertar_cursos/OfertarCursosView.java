package giis.demo.ofertar_cursos;

import java.awt.Dimension;
import java.awt.SystemColor;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;

import net.miginfocom.swing.MigLayout;

public class OfertarCursosView {
	private JFrame frame;
	private JTextField txtTitulo, txtDescripcion, txtFechaIni, txtFechaFin, txtDuracion, txtPlazas, txtCuota;
	private JButton btnTabCarreras;
	private JTable tabCarreras;
	private JComboBox<Object> lstCarreras;
	private JLabel descuento;
	private JTable tabDetalle;
	
	/**
	 * Create the application.
	 */
	public OfertarCursosView() {
		initialize();
	}
	
	public static void main (String [] args) {
		OfertarCursosView obj = new OfertarCursosView();
		obj.frame.setVisible(true);
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Ofertar Curso");
		frame.setName("Ofertar Curso");
		frame.setBounds(0, 0, 492, 422);
		frame.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new MigLayout("", "[grow]", "[][][grow][][][][][][][][]"));
		
		final JLabel lblIntroduccion;
		final JLabel lblTitulo;
		final JLabel lblFechaIni;
		final JLabel lblFechaFin;
		final JLabel lblDuracion;
		final JLabel lblPlazas;
		final JLabel lblCuota;
		final JLabel lblColectivos;
		final JComboBox<String> boxColectivos;

		//Indicamos que accion vamos a realizar
		lblIntroduccion = new JLabel("Oferta de nuevo curso para la planificación del año");
		frame.getContentPane().add(lblIntroduccion, "growx, wrap");
		
		//Titulo del curso
		lblTitulo = new JLabel("Título del curso");
		frame.getContentPane().add(lblTitulo, "growx, wrap");
		
		txtTitulo = new JTextField();
		txtTitulo.setName("txtTitulo");
		frame.getContentPane().add(txtTitulo, "growx, wrap");
		txtTitulo.setColumns(10);
		
		//Descripcion del curso
		JLabel lblDescripcion = new JLabel("Descripción del curso:");
		frame.getContentPane().add(lblDescripcion, "growx, wrap");
		
		txtDescripcion = new JTextField();
		txtDescripcion.setName("txtDescripcion");
		frame.getContentPane().add(txtDescripcion, "growx, wrap");
		txtDescripcion.setPreferredSize(new Dimension(100,100));
		
		// Fecha de inicio
		lblFechaIni = new JLabel("Fecha de inicio");
		frame.getContentPane().add(lblFechaIni, "growx, wrap");
		
		txtFechaIni = new JTextField();
		txtFechaIni.setName("txtFechaIni");
		frame.getContentPane().add(txtFechaIni, "growx, wrap");
		txtFechaIni.setColumns(10);
		
		// Fecha de fin
		lblFechaFin = new JLabel("Fecha de fin");
		frame.getContentPane().add(lblFechaFin, "growx, wrap");
				
		txtFechaFin = new JTextField();
		txtFechaFin.setName("txtFechaIni");
		frame.getContentPane().add(txtFechaFin, "growx, wrap");
		txtFechaFin.setColumns(10);
		
		// Duracion
		lblDuracion = new JLabel("Duración (horas)");
		frame.getContentPane().add(lblDuracion, "growx, wrap");
						
		txtDuracion = new JTextField();
		txtDuracion.setName("txtDuracion");
		frame.getContentPane().add(txtDuracion, "growx, wrap");
		txtDuracion.setColumns(3);
		
		// Plazas máximas
		lblPlazas = new JLabel("Plazas máximas");
		frame.getContentPane().add(lblPlazas, "growx, wrap");
						
		txtPlazas = new JTextField();
		txtPlazas.setName("txtPlazas");
		frame.getContentPane().add(txtPlazas, "growx, wrap");
		txtPlazas.setColumns(3);
		
		// Cuota
		lblCuota = new JLabel("Cuota");
		frame.getContentPane().add(lblCuota, "growx, wrap");
								
		txtCuota = new JTextField();
		txtCuota.setName("txtCuota");
		frame.getContentPane().add(txtCuota, "growx, wrap");
		txtCuota.setColumns(3);
		
		// Colectivo al que va dirigido
		lblColectivos = new JLabel("Colectivo: ");
		frame.getContentPane().add(lblColectivos, "growx, wrap");
		
		String[] colectivos = {"Colegiados", "Precolegiados", "Otros"};
		boxColectivos = new JComboBox<>(colectivos);
		boxColectivos.setName("boxColectivos");
		frame.getContentPane().add(boxColectivos, "growx, wrap");
		
	}
		//Getters y Setters anyadidos para acceso desde el controlador (repersentacion compacta)
	public JFrame getFrame() { return this.frame; }
	public String getFechaHoy()  { return this.txtTitulo.getText(); }
	public void setFechaHoy(String fechaIso)  { this.txtTitulo.setText(fechaIso); }
	public JButton getBtnTablaCarreras() { return this.btnTabCarreras; }
	public JTable getTablaCarreras() { return this.tabCarreras; }
	public JComboBox<Object> getListaCarreras() { return this.lstCarreras; }
	public void setDescuento(String descuento) { this.descuento.setText(descuento+"%"); }
	public void setDescuentoNoAplicable() { this.descuento.setText("N/A"); }
	public JTable getDetalleCarrera() { return this.tabDetalle; }
}
