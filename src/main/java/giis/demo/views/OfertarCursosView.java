package giis.demo.views;

import java.awt.Dimension;

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
	private JTextField txtTitulo, txtDescripcion, txtDuracion, txtPlazas, txtSesiones, txtCuotaPrecolegiado, txtCuotaColegiado, txtCuotaMinusvalido, 
	txtCuotaDesempleado, txtCuotaEmpleado, txtCuotaAlumno, txtCuotaEmpresa, txtCuotaOtros, txtPorcentaje;
	private JDateChooser calFechaIni, calFechaFin, calFechaCancel;
	private JButton bConfirmar;
	private JCheckBox col1, col2, col3, col4, col5, col6, col7, col8, cancelable, espera;
	
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
		frame.setBounds(0, 0, 750, 750);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(new MigLayout("", "[grow]", "[][][grow][][][][][][][][]"));
		frame.setLocationRelativeTo(null);
		
		final JLabel lblIntroduccion;
		final JLabel lblTitulo;
		final JLabel lblFechaIni;
		final JLabel lblFechaFin;
		final JLabel lblDuracion;
		final JLabel lblPlazas;
		final JLabel lblSesiones;
		final JLabel lblCuotaPrecolegiado;
		final JLabel lblCuotaColegiado;
		final JLabel lblCuotaMinusvalido;
		final JLabel lblCuotaDesempleado;
		final JLabel lblCuotaEmpleado;
		final JLabel lblCuotaAlumno;
		final JLabel lblCuotaEmpresa;
		final JLabel lblCuotaOtros;
		final JLabel lblColectivos;
		final JLabel lblOpcionesExtra;
		final JLabel lblFechaCancelacion;
		final JLabel lblPorcentaje;
		

		//Indicamos que accion vamos a realizar
		lblIntroduccion = new JLabel("Oferta de nuevo curso para la planificación del año");
		frame.getContentPane().add(lblIntroduccion, "growx, wrap");
		
		//Titulo del curso
		lblTitulo = new JLabel("Título del curso*");
		frame.getContentPane().add(lblTitulo, "growx, wrap");
		
		txtTitulo = new JTextField();
		txtTitulo.setName("txtTitulo");
		txtTitulo.setPreferredSize(new Dimension(350,30));
		frame.getContentPane().add(txtTitulo, "wrap");
		
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
		
		// Numero de sesiones
		lblSesiones = new JLabel("Sesiones*");
		txtSesiones = new JTextField();
		txtSesiones.setName("txtSesiones");
		
		//Panel para organizar Duración y plazas
		JPanel panelDatos = new JPanel();
		frame.getContentPane().add(panelDatos, "wrap");
		panelDatos.setLayout(new GridLayout(1, 6, 20, 10));
		panelDatos.add(lblDuracion);
		panelDatos.add(txtDuracion);
		panelDatos.add(lblPlazas);
		panelDatos.add(txtPlazas);
		panelDatos.add(lblSesiones);
		panelDatos.add(txtSesiones);
		panelDatos.setBorder(new EmptyBorder(0,0,15,0));
		
		// Cuotas
		lblCuotaPrecolegiado = new JLabel("Cuota Precolegiados");
								
		txtCuotaPrecolegiado = new JTextField();
		txtCuotaPrecolegiado.setName("txtCuotaPrecolegiado");
		
		lblCuotaColegiado = new JLabel("Cuota Colegiados");
		
		txtCuotaColegiado = new JTextField();
		txtCuotaColegiado.setName("txtCuotaColegiado");
		
		lblCuotaMinusvalido = new JLabel("Cuota Minusvalidos");
		
		txtCuotaMinusvalido = new JTextField();
		txtCuotaMinusvalido.setName("txtCuotaMinusvalido");
		
		lblCuotaDesempleado = new JLabel("Cuota Desempleados");
		
		txtCuotaDesempleado = new JTextField();
		txtCuotaDesempleado.setName("txtCuotaDesempleado");
		
		lblCuotaEmpleado = new JLabel("Cuota Empleados");
		
		txtCuotaEmpleado = new JTextField();
		txtCuotaEmpleado.setName("txtCuotaEmpleado");
		
		lblCuotaAlumno = new JLabel("Cuota Alumnos");
		
		txtCuotaAlumno = new JTextField();
		txtCuotaAlumno.setName("txtCuotaAlumno");
		
		lblCuotaEmpresa = new JLabel("Cuota Empresas");
		
		txtCuotaEmpresa = new JTextField();
		txtCuotaEmpresa.setName("txtCuotaEmpresa");
		
		lblCuotaOtros = new JLabel("Cuota Otros");
		
		txtCuotaOtros = new JTextField();
		txtCuotaOtros.setName("txtCuotaOtros");
		
		JPanel panelCuotas = new JPanel();
		frame.getContentPane().add(panelCuotas, "wrap");
		panelCuotas.setLayout(new GridLayout(4, 4, 70, 10));

		panelCuotas.add(lblCuotaPrecolegiado);
        panelCuotas.add(txtCuotaPrecolegiado);
        panelCuotas.add(lblCuotaColegiado);
        panelCuotas.add(txtCuotaColegiado);
        panelCuotas.add(lblCuotaMinusvalido);
        panelCuotas.add(txtCuotaMinusvalido);
        panelCuotas.add(lblCuotaDesempleado);
        panelCuotas.add(txtCuotaDesempleado);
        panelCuotas.add(lblCuotaEmpleado);
        panelCuotas.add(txtCuotaEmpleado);
        panelCuotas.add(lblCuotaAlumno);
        panelCuotas.add(txtCuotaAlumno);
        panelCuotas.add(lblCuotaEmpresa);
        panelCuotas.add(txtCuotaEmpresa);
        panelCuotas.add(lblCuotaOtros);
        panelCuotas.add(txtCuotaOtros);
		
		// Colectivo al que va dirigido
        lblColectivos = new JLabel("Colectivos a los que va dirigido");
        lblColectivos.setBorder(new EmptyBorder(15,0,0,0));
		frame.getContentPane().add(lblColectivos, "growx, wrap");
		
		JPanel colectivos = new JPanel();
		colectivos.setLayout(new GridLayout(2, 4, 20, 10)); 
        col1 = new JCheckBox("Colegiados");
        col2 = new JCheckBox("Precolegiados");
        col3 = new JCheckBox("Minusvalidos");
        col4 = new JCheckBox("Desempleados");
        col5 = new JCheckBox("Empleados");
        col6 = new JCheckBox("Alumnos");
        col7 = new JCheckBox("Empresas");
        col8 = new JCheckBox("Otros");

        colectivos.add(col1);
        colectivos.add(col2);
        colectivos.add(col3);
        colectivos.add(col4);
        colectivos.add(col5);
        colectivos.add(col6);
        colectivos.add(col7);
        colectivos.add(col8);

        frame.getContentPane().add(colectivos, "wrap");
        colectivos.setBorder(new EmptyBorder(0,0,20,0));
        
        //Opciones adicionales
        lblOpcionesExtra = new JLabel("Opciones adicionales: ");
        frame.getContentPane().add(lblOpcionesExtra, "wrap");
        
        JPanel panelChecks = new JPanel(new GridLayout(1, 2, 20, 10));
        frame.getContentPane().add(panelChecks, "wrap");
        panelChecks.setBorder(new EmptyBorder(0,0,10,0));
        
        cancelable = new JCheckBox("Curso Cancelable");
        panelChecks.add(cancelable, "wrap");
        espera = new JCheckBox("Habilitar Lista de espera");
        panelChecks.add(espera, "wrap");
        
        JPanel panelOpciones = new JPanel(new GridLayout(2, 2, 20, 10));
        frame.getContentPane().add(panelOpciones, "wrap");
        
        lblFechaCancelacion = new JLabel("Fecha de cancelación");
        panelOpciones.add(lblFechaCancelacion, "wrap");
		calFechaCancel = new JDateChooser();
		calFechaCancel.setPreferredSize(new Dimension(100,24));
		panelOpciones.add(calFechaCancel, "wrap");
        
        lblPorcentaje = new JLabel("Porcentaje de devolución");
        panelOpciones.add(lblPorcentaje, "wrap");
        txtPorcentaje = new JTextField();
        txtPorcentaje.setName("txtPorcentaje");
        txtPorcentaje.setPreferredSize(new Dimension(100,24));
        panelOpciones.add(txtPorcentaje, "wrap");
        panelOpciones.setBorder(new EmptyBorder(0,0,20,0));
        
		//Boton para confirmar el curso
		bConfirmar = new JButton("Confirmar");
		frame.getContentPane().add(bConfirmar, "wrap");
		bConfirmar.setPreferredSize(new Dimension(100,24));
		
	}
	//Getters y Setters añadidos para acceso desde el controlador
	public JFrame getFrame() { return this.frame; }
	public JTextField getCuotaPrecolegiado() { return txtCuotaPrecolegiado; }
	public JTextField getCuotaColegiado() { return txtCuotaColegiado; }
	public JTextField getCuotaMinusvalido() { return txtCuotaMinusvalido; }
	public JTextField getCuotaDesempleado() { return txtCuotaDesempleado; }
	public JTextField getCuotaEmpleado() { return txtCuotaEmpleado; }
	public JTextField getCuotaAlumno() { return txtCuotaAlumno; }
	public JTextField getCuotaEmpresa() { return txtCuotaEmpresa; }
	public JTextField getCuotaOtros() { return txtCuotaOtros; }
	public JTextField getDuracion() { return txtDuracion; }
	public JTextField getPlazas() { return txtPlazas; }
	public JTextField getSesiones() { return txtSesiones; }
	public Date getFechaIni() { return calFechaIni.getDate(); }
	public Date getFechaFin() { return calFechaFin.getDate(); }
	public JButton getBoton() { return bConfirmar; }
	public JTextField getTitulo() {return txtTitulo; }
	public JTextField getDescripcion() {return txtDescripcion; }
	public JCheckBox getCheckPrecolegiado() {return col2; }
	public JCheckBox getCheckColegiado() {return col1; }
	public JCheckBox getCheckMinusvalido() {return col3; }
	public JCheckBox getCheckDesempleado() {return col4; }
	public JCheckBox getCheckEmpleado() {return col5; }
	public JCheckBox getCheckAlumno() {return col6; }
	public JCheckBox getCheckEmpresa() {return col7; }
	public JCheckBox getCheckOtros() {return col8; }
	public JCheckBox getCheckCancelable() { return cancelable; }
	public JCheckBox getCheckEspera() { return espera; }
	public JTextField getPorcentaje() {return txtPorcentaje; }
	public Date getFechaCancel() { return calFechaCancel.getDate(); }
	public JDateChooser getCalFechaCancel() { return calFechaCancel; }
}
