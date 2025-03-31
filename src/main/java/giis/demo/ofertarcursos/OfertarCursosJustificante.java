package giis.demo.ofertarcursos;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.miginfocom.swing.MigLayout;

public class OfertarCursosJustificante {
	public OfertarCursosJustificante(OfertarCursosDTO curso){
		this.curso = curso;
		initialize();
	}
	
	JFrame frame;
	private JLabel txtTitulo, txtDescripcion, txtFechaIni, txtFechaFin, txtDuracion, txtPlazas, txtCuotaPrecolegiado, txtCuotaColegiado, txtCuotaMinusvalido, txtCuotaDesempleado,
	txtCuotaEmpleado, txtCuotaAlumno, txtCuotaEmpresa, txtCuotaOtros, txtCancelable, txtPorcentaje, txtFechaCancel, txtEspera;
	OfertarCursosDTO curso;
	
	/**
	 * Inicializa el justificante del curso
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Justificante");
		frame.setName("Justificante");
		frame.setBounds(0, 0, 600, 300);
		frame.setResizable(true);
		frame.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(new MigLayout("", "[grow]", "[][][grow][][][][][][][][]"));
		frame.setLocationRelativeTo(null);
		
		final JLabel lblInicio;
		final JLabel lblTitulo;
		final JLabel lblDescripcion;
		final JLabel lblFechaIni;
		final JLabel lblFechaFin;
		final JLabel lblDuracion;
		final JLabel lblPlazas;
		final JLabel lblCuotaPrecolegiado;
		final JLabel lblCuotaColegiado;
		final JLabel lblCuotaMinusvalido;
		final JLabel lblCuotaDesempleado;
		final JLabel lblCuotaEmpleado;
		final JLabel lblCuotaAlumno;
		final JLabel lblCuotaEmpresa;
		final JLabel lblCuotaOtros;
		final JLabel lblCancelable;
		final JLabel lblPorcentaje;
		final JLabel lblFechaCancel;
		final JLabel lblEspera;
		
		
		lblInicio = new JLabel("Justificante del curso añadido");
		lblInicio.setBorder(new EmptyBorder(0, 0, 10, 0));
		frame.getContentPane().add(lblInicio, "wrap");
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, "wrap");
		panel.setLayout(new GridLayout(9, 2, 50, 10));
		
		lblTitulo = new JLabel("Título");
		panel.add(lblTitulo, "growx, wrap");
		txtTitulo = new JLabel(curso.getTitulo());
		txtTitulo.setName("txtTitulo");
		panel.add(txtTitulo, "growx, wrap");
		
		lblDescripcion = new JLabel("Descipción");
		panel.add(lblDescripcion, "growx, wrap");
		txtDescripcion = new JLabel();
		txtDescripcion.setName("txtDescripcion");
		txtDescripcion.setText(curso.getDescripcion());
		panel.add(txtDescripcion, "growx, wrap");
		
		lblFechaIni = new JLabel("Fecha de inicio");
		panel.add(lblFechaIni, "growx, wrap");
		txtFechaIni = new JLabel(curso.getFecha_inicio());
		txtFechaIni.setName("txtFechaIni");
		panel.add(txtFechaIni, "growx, wrap");
		
		lblFechaFin = new JLabel("Fecha de fin");
		panel.add(lblFechaFin, "growx, wrap");
		txtFechaFin = new JLabel(curso.getFecha_fin());
		txtFechaFin.setName("txtFechaFin");
		panel.add(txtFechaFin, "growx, wrap");
		
		lblDuracion = new JLabel("Duracion");
		panel.add(lblDuracion, "growx, wrap");
		txtDuracion = new JLabel(String.valueOf(curso.getDuracion()));
		txtDuracion.setName("txtDuracion");
		panel.add(txtDuracion, "growx, wrap");

		lblPlazas = new JLabel("Plazas");
		panel.add(lblPlazas, "growx, wrap");
		txtPlazas = new JLabel(String.valueOf(curso.getPlazas()));
		txtPlazas.setName("txtPlazas");
		panel.add(txtPlazas, "growx, wrap");
		
		lblCuotaPrecolegiado = new JLabel("Cuota Precolegiado");
		panel.add(lblCuotaPrecolegiado, "growx, wrap");
		txtCuotaPrecolegiado = new JLabel(String.valueOf(curso.getCuota_precolegiado()));
		txtCuotaPrecolegiado.setName("txtCuotaPrecolegiado");
		panel.add(txtCuotaPrecolegiado, "growx, wrap");
		
		lblCuotaColegiado = new JLabel("Cuota Colegiado");
		panel.add(lblCuotaColegiado, "growx, wrap");
		txtCuotaColegiado = new JLabel(String.valueOf(curso.getCuota_colegiado()));
		txtCuotaColegiado.setName("txtCuotaColegiado");
		panel.add(txtCuotaColegiado, "growx, wrap");
		
		lblCuotaMinusvalido = new JLabel("Cuota Minusvalido");
		panel.add(lblCuotaMinusvalido, "growx, wrap");
		txtCuotaMinusvalido = new JLabel(String.valueOf(curso.getCuota_minusvalido()));
		txtCuotaMinusvalido.setName("txtCuotaMinusvalido");
		panel.add(txtCuotaMinusvalido, "growx, wrap");
		
		lblCuotaDesempleado = new JLabel("Cuota Desempleado");
		panel.add(lblCuotaDesempleado, "growx, wrap");
		txtCuotaDesempleado = new JLabel(String.valueOf(curso.getCuota_desempleado()));
		txtCuotaDesempleado.setName("txtCuotaDesempleado");
		panel.add(txtCuotaDesempleado, "growx, wrap");
		
		lblCuotaEmpleado = new JLabel("Cuota Empleado");
		panel.add(lblCuotaEmpleado, "growx, wrap");
		txtCuotaEmpleado = new JLabel(String.valueOf(curso.getCuota_empleado()));
		txtCuotaEmpleado.setName("txtCuotaEmpleado");
		panel.add(txtCuotaEmpleado, "growx, wrap");
		
		lblCuotaAlumno = new JLabel("Cuota Alumno");
		panel.add(lblCuotaAlumno, "growx, wrap");
		txtCuotaAlumno = new JLabel(String.valueOf(curso.getCuota_alumno()));
		txtCuotaAlumno.setName("txtCuotaAlumno");
		panel.add(txtCuotaAlumno, "growx, wrap");
		
		lblCuotaEmpresa = new JLabel("Cuota Empresa");
		panel.add(lblCuotaEmpresa, "growx, wrap");
		txtCuotaEmpresa = new JLabel(String.valueOf(curso.getCuota_empresa()));
		txtCuotaEmpresa.setName("txtCuotaEmpresa");
		panel.add(txtCuotaEmpresa, "growx, wrap");
		
		lblCuotaOtros = new JLabel("CuotaOtros");
		panel.add(lblCuotaOtros, "growx, wrap");
		txtCuotaOtros = new JLabel(String.valueOf(curso.getCuota_otros()));
		txtCuotaOtros.setName("CuotaOtros");
		panel.add(txtCuotaOtros, "growx, wrap");
		
		lblCancelable = new JLabel("Cancelable");
		panel.add(lblCancelable, "growx, wrap");
		txtCancelable = new JLabel(String.valueOf(curso.isCancelable()));
		txtCancelable.setName("txtCancelable");
		panel.add(txtCancelable, "growx, wrap");
		
		lblPorcentaje = new JLabel("Porcentaje de devolucion: ");
		panel.add(lblPorcentaje, "growx, wrap");
		txtPorcentaje = new JLabel(String.valueOf(curso.getPorcentaje_devolucion()));
		txtPorcentaje.setName("txtPorcentaje");
		panel.add(txtPorcentaje, "growx, wrap");
		
		lblFechaCancel = new JLabel("Fecha de Cancelacion");
		panel.add(lblFechaCancel, "growx, wrap");
		txtFechaCancel = new JLabel(curso.getFecha_cancelacion());
		txtFechaCancel.setName("txtFechaFin");
		panel.add(txtFechaCancel, "growx, wrap");
		
		lblEspera = new JLabel("Lista de espera: ");
		panel.add(lblEspera, "growx, wrap");
		txtEspera = new JLabel(String.valueOf(curso.isCancelable()));
		txtEspera.setName("txtEspera");
		panel.add(txtEspera, "growx, wrap");
		
		frame.setVisible(true);
		frame.pack();
	}
}
