package giis.demo.ofertar_cursos;

import java.awt.Component;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;

import net.miginfocom.swing.MigLayout;
import java.awt.GridLayout;
import java.util.Date;

public class OfertarCursosView {
	private JFrame frame;
	private JTextField txtTitulo, txtDescripcion, txtDuracion, txtPlazas, txtCuota;
	private JDateChooser calFechaIni, calFechaFin;
	private JButton bConfirmar;
	
	/**
	 * Create the application.
	 */
	public OfertarCursosView() {
		initialize();
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Ofertar Curso");
		frame.setName("Ofertar Curso");
		frame.setBounds(0, 0, 400, 500);
		frame.setResizable(false);
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
		

		//Indicamos que accion vamos a realizar
		lblIntroduccion = new JLabel("Oferta de nuevo curso para la planificación del año");
		frame.getContentPane().add(lblIntroduccion, "growx, wrap");
		
		//Titulo del curso
		lblTitulo = new JLabel("Título del curso");
		frame.getContentPane().add(lblTitulo, "growx, wrap");
		
		txtTitulo = new JTextField();
		txtTitulo.setName("txtTitulo");
		frame.getContentPane().add(txtTitulo, "growx, wrap");
		
		//Descripcion del curso
		JLabel lblDescripcion = new JLabel("Descripción del curso:");
		frame.getContentPane().add(lblDescripcion, "growx, wrap");
		
		txtDescripcion = new JTextField();
		txtDescripcion.setName("txtDescripcion");
		frame.getContentPane().add(txtDescripcion, "wrap");
		txtDescripcion.setPreferredSize(new Dimension(350,100));
		
		// Fecha de inicio
		lblFechaIni = new JLabel("Fecha de inicio");
		
		calFechaIni = new JDateChooser();
        calFechaIni.setPreferredSize(new Dimension(100,24));
       
		// Fecha de fin
		lblFechaFin = new JLabel("Fecha de fin");
				
		calFechaFin = new JDateChooser();
        calFechaFin.setPreferredSize(new Dimension(100,24));
		
		// Formato para poner las fechas
		JPanel panelFechas = new JPanel();
		frame.getContentPane().add(panelFechas, "wrap");
		panelFechas.setLayout(new GridLayout(2, 2, 100, 10));
		panelFechas.add(lblFechaIni);
		panelFechas.add(lblFechaFin);
        panelFechas.add(calFechaIni);
        panelFechas.add(calFechaFin);
        panelFechas.setBorder(new EmptyBorder(0,0,15,0));
		
		// Duracion
		lblDuracion = new JLabel("Duración (horas)");
						
		txtDuracion = new JTextField();
		txtDuracion.setName("txtDuracion");
		
		// Plazas máximas
		lblPlazas = new JLabel("Plazas máximas");
						
		txtPlazas = new JTextField();
		txtPlazas.setName("txtPlazas");
		
		// Cuota
		lblCuota = new JLabel("Cuota");
								
		txtCuota = new JTextField();
		txtCuota.setName("txtCuota");
		
		//Panel para organizar Duración, plazas y cuota
		JPanel panelDatos = new JPanel();
		frame.getContentPane().add(panelDatos, "wrap");
		panelDatos.setLayout(new GridLayout(3, 3, 70, 10));
		panelDatos.add(lblDuracion);
		panelDatos.add(txtDuracion);
		panelDatos.add(lblPlazas);
		panelDatos.add(txtPlazas);
		panelDatos.add(lblCuota);
        panelDatos.add(txtCuota);
		
		// Colectivo al que va dirigido
        lblColectivos = new JLabel("Colectivos a los que va dirigido");
        lblColectivos.setBorder(new EmptyBorder(15,0,0,0));
		frame.getContentPane().add(lblColectivos, "growx, wrap");
		
		JPanel colectivos = new JPanel();
		colectivos.setLayout(new BoxLayout(colectivos, BoxLayout.Y_AXIS)); // Acomoda en columna
        JCheckBox col1 = new JCheckBox("Colegiados");
        JCheckBox col2 = new JCheckBox("Precolegiados");
        JCheckBox col3 = new JCheckBox("Otros");

        colectivos.add(col1);
        colectivos.add(col2);
        colectivos.add(col3);

        frame.getContentPane().add(colectivos, "wrap");
        
		//Boton para confirmar el curso
		bConfirmar = new JButton("Confirmar");
		frame.getContentPane().add(bConfirmar, "wrap");
		bConfirmar.setPreferredSize(new Dimension(100,24));
		
	}
	//Getters y Setters añadidos para acceso desde el controlador
	public JFrame getFrame() { return this.frame; }
	public Component getCuota() { return txtCuota; }
	public Component getDuracion() { return txtDuracion; }
	public Component getPlazas() { return txtPlazas; }
	public Date getFechaIni() { return calFechaIni.getDate(); }
	public Date getFechaFin() { return calFechaFin.getDate(); }
	public JButton getBoton() { return bConfirmar; }
}
