package giis.demo.historico_cursos;
/**
 *Cada una de las filas que muestran los cursos
 */
public class Historico_cursosDTO {

	private int id_colegiado; 
	private int id_curso;
	private String titulo;
	private String fecha_inicio;
	private String fecha_fin;
	private int duracion;
	private int suma_total; 
	private String estado;

	public Historico_cursosDTO() {	}

	public Historico_cursosDTO(int id_colegiado, int id_curso, String titulo, String fecha_inicio, String fecha_fin,
			int duracion, int suma_total, String estado) {
		this.id_colegiado = id_colegiado;
		this.id_curso = id_curso;
		this.titulo = titulo;
		this.fecha_inicio = fecha_inicio;
		this.fecha_fin = fecha_fin;
		this.duracion = duracion;
		this.suma_total = suma_total;
		this.estado = estado;
	}
	public int getId_colegiado() { return id_colegiado; } public void setId_colegiado(int id_colegiado) { this.id_colegiado = id_colegiado; } 
	public int getId_curso() { return id_curso; } public void setId_curso(int id_curso) { this.id_curso = id_curso; } 
	public String getTitulo() { return titulo; } public void setTitulo(String titulo) { this.titulo = titulo; } 
	public String getFecha_inicio() { return fecha_inicio; } public void setFecha_inicio(String fecha_inicio) { this.fecha_inicio = fecha_inicio; } 
	public String getFecha_fin() { return fecha_fin; } public void setFecha_fin(String fecha_fin) { this.fecha_fin = fecha_fin; } 
	public int getDuracion() { return duracion; } public void setDuracion(int duracion) { this.duracion = duracion; } 
	public int getSuma_total() { return suma_total; } public void setSuma_total(int suma_total) { this.suma_total = suma_total; } 
	public String getEstado() { return estado; } public void setEstado(String estado) { this.estado = estado; }
}

