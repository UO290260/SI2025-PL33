package giis.demo.planificarsesiones;

public class PlanificarSesionesDTO {
	private int id_curso;
	private String titulo;
	private String descripcion;
	private String fecha_inicio;
	private String fecha_fin;
	private int sesiones;
	private String estado;
	
	public PlanificarSesionesDTO(int id, String tit, String descr, String fini, String ffin, int ses, String est) {
		setId_curso(id);
		setTitulo(tit);
		setDescripcion(descr);
		setFecha_inicio(fini);
		setFecha_fin(ffin);
		setSesiones(ses);
		setEstado(est);
	}
	
	public PlanificarSesionesDTO() {}

	public int getId_curso() {
		return id_curso;
	}

	public void setId_curso(int id_curso) {
		this.id_curso = id_curso;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public int getSesiones() {
		return sesiones;
	}

	public void setSesiones(int sesiones) {
		this.sesiones = sesiones;
	}

	public String getFecha_inicio() {
		return fecha_inicio;
	}

	public void setFecha_inicio(String fechaIni) {
		this.fecha_inicio = fechaIni;
	}

	public String getFecha_fin() {
		return fecha_fin;
	}

	public void setFecha_fin(String fechaFin) {
		this.fecha_fin = fechaFin;
	}
}