package giis.demo.historicocursos;

/**
 * Clase HistoricocursosDTO que contiene todos los atributos de la tabla Cursos
 * Se utiliza en la clase HistoricocursosController en el metodo cargarListaCursos() y en la clase HistoricocursosModel en el metodo getListaCursos()
 */
public class HistoricocursosDTO {
	private int idcolegiado; 
	private int idcurso;
	private String titulo;
	private String fechainicio;
	private String fechafin;
	private int duracion;
	private String estado;

	public HistoricocursosDTO() {	}

	public HistoricocursosDTO(int id_colegiado, int id_curso, String titulo, String fecha_inicio, String fecha_fin,
			int duracion, String estado) {
		this.idcolegiado = id_colegiado;
		this.idcurso = id_curso;
		this.titulo = titulo;
		this.fechainicio = fecha_inicio;
		this.fechafin = fecha_fin;
		this.duracion = duracion;
		this.estado = estado;
	}
	public int getId_colegiado() { return idcolegiado; } public void setId_colegiado(int id_colegiado) { this.idcolegiado = id_colegiado; } 
	public int getId_curso() { return idcurso; } public void setId_curso(int id_curso) { this.idcurso = id_curso; } 
	public String getTitulo() { return titulo; } public void setTitulo(String titulo) { this.titulo = titulo; } 
	public String getFecha_inicio() { return fechainicio; } public void setFecha_inicio(String fecha_inicio) { this.fechainicio = fecha_inicio; } 
	public String getFecha_fin() { return fechafin; } public void setFecha_fin(String fecha_fin) { this.fechafin = fecha_fin; } 
	public int getDuracion() { return duracion; } public void setDuracion(int duracion) { this.duracion = duracion; } 
	public String getEstado() { return estado; } public void setEstado(String estado) { this.estado = estado; }
}