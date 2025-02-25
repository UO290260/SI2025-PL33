package giis.demo.ofertar_cursos;

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
	private JLabel txtTitulo, txtDescripcion, txtFechaIni, txtFechaFin, txtDuracion, txtPlazas, txtCuotaPrecolegiado, txtCuotaColegiado, txtCuotaOtros;
	OfertarCursosDTO curso;
	
	/**
	 * Inicializa el justificante del curso
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Justificante");
		frame.setName("Justificante");
		frame.setBounds(0, 0, 300, 300);
		frame.setResizable(true);
		frame.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
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
		final JLabel lblCuotaOtros;
		
		
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
		txtCuotaColegiado.setName("CuotaColegiado");
		panel.add(txtCuotaColegiado, "growx, wrap");
		
		lblCuotaOtros = new JLabel("CuotaOtros");
		panel.add(lblCuotaOtros, "growx, wrap");
		txtCuotaOtros = new JLabel(String.valueOf(curso.getCuota_otros()));
		txtCuotaOtros.setName("CuotaOtros");
		panel.add(txtCuotaOtros, "growx, wrap");
		
		frame.setVisible(true);
		frame.pack();
	}
}
