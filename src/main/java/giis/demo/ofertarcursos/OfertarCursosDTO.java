package giis.demo.ofertarcursos;

public class OfertarCursosDTO {
	private int id_curso;
	private String titulo;
	private String descripcion;
	private String fecha_inicio;
	private String fecha_fin;
	private int duracion;
	private int plazas;
	private int sesiones;
	private int cuota_precolegiado;
	private int cuota_colegiado;
	private int cuota_minusvalido;
	private int cuota_desempleado;
	private int cuota_empleado;
	private int cuota_alumno;
	private int cuota_empresa;
	private int cuota_otros;
	
	public OfertarCursosDTO() {}
	public OfertarCursosDTO(int id, String tit, String descr, String fini, String ffin, int dur, int plz, int ses, int cuotaPre, int cuotaCol, int cuotaMinus, int cuotaDes, int cuotaEmpl, int cuotaAlu, int cuotaEmpr, int cuotaOtros) {
		setId_curso(id);
		setTitulo(tit); 
		setDescripcion(descr);
		setFecha_inicio(fini);
		setFecha_fin(ffin);
		setDuracion(dur);
		setPlazas(plz);
		setSesiones(ses);
		setCuota_precolegiado(cuotaPre);
		setCuota_colegiado(cuotaCol);
		setCuota_minusvalido(cuotaMinus);
		setCuota_desempleado(cuotaDes);
		setCuota_empleado(cuotaEmpl);
		setCuota_alumno(cuotaAlu);
		setCuota_empresa(cuotaEmpr);
		setCuota_otros(cuotaOtros);
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
	public int getCuota_minusvalido() {
		return cuota_minusvalido;
	}
	public void setCuota_minusvalido(int cuota_minusvalido) {
		this.cuota_minusvalido = cuota_minusvalido;
	}
	public int getCuota_desempleado() {
		return cuota_desempleado;
	}
	public void setCuota_desempleado(int cuota_desempleado) {
		this.cuota_desempleado = cuota_desempleado;
	}
	public int getCuota_empleado() {
		return cuota_empleado;
	}
	public void setCuota_empleado(int cuota_empleado) {
		this.cuota_empleado = cuota_empleado;
	}
	public int getCuota_alumno() {
		return cuota_alumno;
	}
	public void setCuota_alumno(int cuota_alumno) {
		this.cuota_alumno = cuota_alumno;
	}
	public int getCuota_empresa() {
		return cuota_empresa;
	}
	public void setCuota_empresa(int cuota_empresa) {
		this.cuota_empresa = cuota_empresa;
	}
	public int getSesiones() {
		return sesiones;
	}
	public void setSesiones(int sesiones) {
		this.sesiones = sesiones;
	}
	
	
}
