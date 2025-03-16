package giis.demo.visualizarinscritos;

public class CursoDTO {
	private int id_curso;
	private String titulo;
	private String descripcion;
	private String estado;
	
	public CursoDTO(int id, String tit, String descr, String est) {
		setId_curso(id);
		setTitulo(tit);
		setDescripcion(descr);
		setEstado(est);
	}
	
	public CursoDTO() {}

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
	
}
