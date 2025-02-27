package giis.demo.ofertarcursos;

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
	private JTextField txtTitulo, txtDescripcion, txtDuracion, txtPlazas, txtCuotaPrecolegiado, txtCuotaColegiado, txtCuotaOtros;
	private JDateChooser calFechaIni, calFechaFin;
	private JButton bConfirmar;
	private JCheckBox col1, col2, col3;
	
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
		frame.setBounds(0, 0, 400, 550);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new MigLayout("", "[grow]", "[][][grow][][][][][][][][]"));
		frame.setLocationRelativeTo(null);
		
		final JLabel lblIntroduccion;
		final JLabel lblTitulo;
		final JLabel lblFechaIni;
		final JLabel lblFechaFin;
		final JLabel lblDuracion;
		final JLabel lblPlazas;
		final JLabel lblCuotaPrecolegiado;
		final JLabel lblCuotaColegiado;
		final JLabel lblCuotaOtros;
		final JLabel lblColectivos;
		

		//Indicamos que accion vamos a realizar
		lblIntroduccion = new JLabel("Oferta de nuevo curso para la planificación del año");
		frame.getContentPane().add(lblIntroduccion, "growx, wrap");
		
		//Titulo del curso
		lblTitulo = new JLabel("Título del curso*");
		frame.getContentPane().add(lblTitulo, "growx, wrap");
		
		txtTitulo = new JTextField();
		txtTitulo.setName("txtTitulo");
		frame.getContentPane().add(txtTitulo, "growx, wrap");
		
		//Descripcion del curso
		JLabel lblDescripcion = new JLabel("Descripción del curso*");
		frame.getContentPane().add(lblDescripcion, "growx, wrap");
		
		txtDescripcion = new JTextField();
		txtDescripcion.setName("txtDescripcion");
		frame.getContentPane().add(txtDescripcion, "wrap");
		txtDescripcion.setPreferredSize(new Dimension(350,100));
		
		// Fecha de inicio
		lblFechaIni = new JLabel("Fecha de inicio*");
		
		calFechaIni = new JDateChooser();
        calFechaIni.setPreferredSize(new Dimension(100,24));
       
		// Fecha de fin
		lblFechaFin = new JLabel("Fecha de fin*");
				
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
		lblDuracion = new JLabel("Duración (horas)*");
						
		txtDuracion = new JTextField();
		txtDuracion.setName("txtDuracion");
		
		// Plazas máximas
		lblPlazas = new JLabel("Plazas máximas*");
						
		txtPlazas = new JTextField();
		txtPlazas.setName("txtPlazas");
		
		//Panel para organizar Duración y plazas
		JPanel panelDatos = new JPanel();
		frame.getContentPane().add(panelDatos, "wrap");
		panelDatos.setLayout(new GridLayout(2, 2, 70, 10));
		panelDatos.add(lblDuracion);
		panelDatos.add(txtDuracion);
		panelDatos.add(lblPlazas);
		panelDatos.add(txtPlazas);
		panelDatos.setBorder(new EmptyBorder(0,0,15,0));
		
		// Cuotas
		lblCuotaPrecolegiado = new JLabel("Cuota Precolegiados");
								
		txtCuotaPrecolegiado = new JTextField();
		txtCuotaPrecolegiado.setName("txtCuotaPrecolegiado");
		
		lblCuotaColegiado = new JLabel("Cuota Colegiados");
		
		txtCuotaColegiado = new JTextField();
		txtCuotaColegiado.setName("txtCuotaColegiado");
		
		lblCuotaOtros = new JLabel("Cuota Otros");
		
		txtCuotaOtros = new JTextField();
		txtCuotaOtros.setName("txtCuotaOtros");
		
		JPanel panelCuotas = new JPanel();
		frame.getContentPane().add(panelCuotas, "wrap");
		panelCuotas.setLayout(new GridLayout(3, 2, 70, 10));

		panelCuotas.add(lblCuotaPrecolegiado);
        panelCuotas.add(txtCuotaPrecolegiado);
        panelCuotas.add(lblCuotaColegiado);
        panelCuotas.add(txtCuotaColegiado);
        panelCuotas.add(lblCuotaOtros);
        panelCuotas.add(txtCuotaOtros);
		
		// Colectivo al que va dirigido
        lblColectivos = new JLabel("Colectivos a los que va dirigido");
        lblColectivos.setBorder(new EmptyBorder(15,0,0,0));
		frame.getContentPane().add(lblColectivos, "growx, wrap");
		
		JPanel colectivos = new JPanel();
		colectivos.setLayout(new BoxLayout(colectivos, BoxLayout.Y_AXIS)); // Acomoda en columna
        col1 = new JCheckBox("Colegiados");
        col2 = new JCheckBox("Precolegiados");
        col3 = new JCheckBox("Otros");

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
	public JTextField getCuotaPrecolegiado() { return txtCuotaPrecolegiado; }
	public JTextField getCuotaColegiado() { return txtCuotaColegiado; }
	public JTextField getCuotaOtros() { return txtCuotaOtros; }
	public JTextField getDuracion() { return txtDuracion; }
	public JTextField getPlazas() { return txtPlazas; }
	public Date getFechaIni() { return calFechaIni.getDate(); }
	public Date getFechaFin() { return calFechaFin.getDate(); }
	public JButton getBoton() { return bConfirmar; }
	public JTextField getTitulo() {return txtTitulo; }
	public JTextField getDescripcion() {return txtDescripcion; }
	public JCheckBox getCheckPrecolegiado() {return col1; }
	public JCheckBox getCheckColegiado() {return col2; }
	public JCheckBox getCheckOtros() {return col3; }
}
