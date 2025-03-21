package giis.demo.inscripcioncursos;

import javax.swing.JFrame;
import javax.swing.JLabel;

import net.miginfocom.swing.MigLayout;

public class Justificante_Inscripción extends JFrame {
	private JFrame frame;
	private CursosDTO curso;
	private String fecha;
	private String nombre,apellidos,cuenta,cuota,DNI;
	


	/**
	 * Clase Justificante utilizada por Inscripcion_cursosController para imprimir datos del justificante
	 * @param colegiado objeto de tipo DTO
	 * @param fecha de tipo String
	 */
	public Justificante_Inscripción(String nombre,String apellidos,String DNI,String cuenta, String fecha,CursosDTO curso,String cuota) {
		this.nombre=nombre;
		this.apellidos=apellidos;
		this.DNI=DNI;
		this.cuota=cuota;
		this.fecha=fecha;
		this.curso=curso;
		init();
	}

	public void init () {
		frame= new JFrame();
		frame.setTitle("Justificante de Inscripción del curso");
		frame.setName("Justificante");
		frame.setBounds(0, 0, 592, 200);
		frame.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(new MigLayout("", "[grow]", "[][][grow][][][][][][][][]")); //Es el layout que usaremos dividiendolo en filas y columnas
		frame.setResizable(false);
		//Contenido de la ventana
		frame.getContentPane().add(new JLabel("Nombre : "+nombre), "growx,wrap");
		frame.getContentPane().add(new JLabel("Apellidos : "+apellidos),"wrap");
		frame.getContentPane().add(new JLabel("DNI del solicitante : "+DNI),"wrap");
		frame.getContentPane().add(new JLabel("Fecha actual de inscripción: : "+fecha),"wrap");
		frame.getContentPane().add(new JLabel("Cuenta bancaria : "+cuenta),"wrap");
		frame.getContentPane().add(new JLabel("Curso : "+curso.getTitulo()),"wrap");
		frame.getContentPane().add(new JLabel(cuota),"wrap");
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public CursosDTO getCurso() {
		return curso;
	}

	public void setCurso(CursosDTO curso) {
		this.curso = curso;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getCuenta() {
		return cuenta;
	}

	public void setCuenta(String cuenta) {
		this.cuenta = cuenta;
	}

	public String getDNI() {
		return DNI;
	}

	public void setDNI(String dNI) {
		DNI = dNI;
	}

	public String getCuota() {
		return cuota;
	}

	public void setCuota(String cuota) {
		this.cuota = cuota;
	}
}
