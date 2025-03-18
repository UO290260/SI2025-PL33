package giis.demo.inscripcioncursos;

import javax.swing.JFrame;
import javax.swing.JLabel;

import net.miginfocom.swing.MigLayout;

public class Justificante_tarjeta extends JFrame {
	private JFrame frame;
	private ColegiadoDTO colegiado;
	private CursosDTO curso;
	private String fecha;
	private String numeroTarjeta;

	/**
	 * Clase Justificante utilizada por Inscripcion_cursosController para imprimir datos del justificante
	 * @param colegiado objeto de tipo DTO
	 * @param fecha de tipo String
	 */
	public Justificante_tarjeta(ColegiadoDTO colegiado, String fecha,CursosDTO curso,String numeroTarjeta) {
		this.colegiado=colegiado;
		this.fecha=fecha;
		this.curso=curso;
		this.numeroTarjeta=numeroTarjeta;
		init();
	}

	public void init () {
		frame= new JFrame();
		frame.setTitle("Justificante de Inscripción de curso");
		frame.setName("Justificante Inscripción");
		frame.setBounds(0, 0, 592, 200);
		frame.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(new MigLayout("", "[grow]", "[][][grow][][][][][][][][]")); //Es el layout que usaremos dividiendolo en filas y columnas
		frame.setResizable(false);
		//Contenido de la ventana
		frame.getContentPane().add(new JLabel("Nombre : "+colegiado.getNombre()), "growx,wrap");
		frame.getContentPane().add(new JLabel("Apellidos : "+colegiado.getApellidos()),"wrap");
		frame.getContentPane().add(new JLabel("ColegiadoID : "+colegiado.getId_colegiado()),"wrap");
		frame.getContentPane().add(new JLabel("Fecha actual de inscripción:  "+fecha),"wrap");
		frame.getContentPane().add(new JLabel("Número de la tarjeta:  "+numeroTarjeta),"wrap");
		frame.getContentPane().add(new JLabel("Curso : "+curso.getTitulo()),"wrap");
		frame.getContentPane().add(new JLabel("Cuota precolegiado : "+curso.getCuota_precolegiado()),"wrap");
		frame.getContentPane().add(new JLabel("Cuota colegiado : "+curso.getCuota_colegiado()),"wrap");
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public ColegiadoDTO getColegiado() {
		return colegiado;
	}

	public void setColegiado(ColegiadoDTO colegiado) {
		this.colegiado = colegiado;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
}
