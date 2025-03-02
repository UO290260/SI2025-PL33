package giis.demo.visualizarcursos;

public class VisualizarCursosDTO {
	private int id_curso;
	private String titulo;
	private String descripcion;
	private String fecha_inicio;
	private String fecha_fin;
	private int duracion;
	private int plazas;
	private String apertura_inscripcion;
	private String cierre_inscripcion;
	private int cuota_precolegiado;
	private int cuota_colegiado;
	private int cuota_otros;
	private String estado;
	
	public VisualizarCursosDTO() {}
	public VisualizarCursosDTO(int id, String tit, String descr, String fini, String ffin, int dur, int plz, int cuotaPre, int cuotaCol, int cuotaOtros, String apertura, String cierre, String est) {
		setId_curso(id);
		setTitulo(tit); 
		setDescripcion(descr);
		setFecha_inicio(fini);
		setFecha_fin(ffin);
		setDuracion(dur);
		setPlazas(plz);
		setApertura_inscripcion(apertura);
		setCierre_inscripcion(cierre);
		setCuota_precolegiado(cuotaPre);
		setCuota_colegiado(cuotaCol);
		setCuota_otros(cuotaOtros);
		setEstado(est);
	}
	
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
	public String getFecha_inicio() {
		return fecha_inicio;
	}
	public void setFecha_inicio(String fecha_inicio) {
		this.fecha_inicio = fecha_inicio;
	}
	public String getFecha_fin() {
		return fecha_fin;
	}
	public void setFecha_fin(String fecha_fin) {
		this.fecha_fin = fecha_fin;
	}
	public int getDuracion() {
		return duracion;
	}
	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}
	public int getPlazas() {
		return plazas;
	}
	public void setPlazas(int plazas) {
		this.plazas = plazas;
	}
	public int getCuota_precolegiado() {
		return cuota_precolegiado;
	}
	public void setCuota_precolegiado(int cuota_precolegiado) {
		this.cuota_precolegiado = cuota_precolegiado;
	}
	public int getCuota_colegiado() {
		return cuota_colegiado;
	}
	public void setCuota_colegiado(int cuota_colegiado) {
		this.cuota_colegiado = cuota_colegiado;
	}
	public int getCuota_otros() {
		return cuota_otros;
	}
	public void setCuota_otros(int cuota_otros) {
		this.cuota_otros = cuota_otros;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getApertura_inscripcion() {
		return apertura_inscripcion;
	}
	public void setApertura_inscripcion(String apertura_inscripcion) {
		this.apertura_inscripcion = apertura_inscripcion;
	}
	public String getCierre_inscripcion() {
		return cierre_inscripcion;
	}
	public void setCierre_inscripcion(String cierre_inscripcion) {
		this.cierre_inscripcion = cierre_inscripcion;
	}
}
