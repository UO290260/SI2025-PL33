package giis.demo.inscripcioncursos;

import javax.swing.JFrame;
import javax.swing.JLabel;

import net.miginfocom.swing.MigLayout;

public class Justificante_Inscripción extends JFrame {
	private JFrame frame;
	private ColegiadoDTO colegiado;
	private String fecha;
	
	/**
	 * Clase Justificante utilizada por Inscripcion_cursosController para imprimir datos del justificante
	 * @param colegiado objeto de tipo DTO
	 * @param fecha de tipo String
	 */
	public Justificante_Inscripción(ColegiadoDTO colegiado, String fecha) {
		this.colegiado=colegiado;
		this.fecha=fecha;
		init();
	}
	
	public void init () {
		frame= new JFrame();
		frame.setTitle("Justificante");
		frame.setName("Justificante");
		frame.setBounds(0, 0, 592, 200);
		frame.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(new MigLayout("", "[grow]", "[][][grow][][][][][][][][]")); //Es el layout que usaremos dividiendolo en filas y columnas
		frame.setResizable(false);
		//Contenido de la ventana
		frame.getContentPane().add(new JLabel("Nombre : "+colegiado.getNombre()), "growx,wrap");
		frame.getContentPane().add(new JLabel("Apellidos : "+colegiado.getApellidos()),"wrap");
		frame.getContentPane().add(new JLabel("ColegiadoID : "+colegiado.getId_colegiado()),"wrap");
		frame.getContentPane().add(new JLabel("Fecha actual de inscripción: : "+fecha),"wrap");
		frame.getContentPane().add(new JLabel("Cuenta bancaria : "+colegiado.getCuenta_bancaria()),"wrap");
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
