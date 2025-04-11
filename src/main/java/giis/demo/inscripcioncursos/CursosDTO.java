package giis.demo.inscripcioncursos;

//Clase CursoDTO usada en controller para implementar los datos de la clase Cursos a una tabla
public class CursosDTO {
	 	private int id_curso;
	    private String titulo;
	    private String descripcion;
	    private String fechainicio;
	    private String fechafin;
	    private int duracion;
	    private int plazas;
	    private int cuotaprecolegiado, cuotacolegiado, cuotaotros, cuotaminusvalido, cuotadesempleado, cuotaempleado, cuotalumno, cuotaempresa;
	    private String aperturainscripcion;
	    private String cierreinscripcion;
	    private boolean listaEspera;
	    private String estado;
	    
	  public CursosDTO(){};
	    
	  public CursosDTO(int id_curso, String titulo, String descripcion, String fecha_inicio, String fecha_fin, int duracion, int plazas,int cuota_precolegiado,int cuota_colegiado,int cuota_minusvalido,int cuota_desempleado, int cuota_empleado,int cuota_alumno,int cuota_empresa,int cuota_otros, String apertura_inscripcion,String cierre_inscripcion,boolean lista_espera ,String estado) {
	        this.id_curso = id_curso;
	        this.titulo = titulo;
	        this.descripcion = descripcion;
	        this.fechainicio = fecha_inicio;
	        this.fechafin = fecha_fin;
	        this.duracion = duracion;
	        this.plazas = plazas;
	        this.cuotaprecolegiado=cuota_precolegiado;
	        this.cuotacolegiado=cuota_colegiado;
	        this.cuotaotros=cuota_otros;
	        this.aperturainscripcion=apertura_inscripcion;
	        this.cierreinscripcion=cierre_inscripcion;
	        this.estado = estado;
	        this.cuotalumno=cuota_alumno;
	        this.cuotadesempleado=cuota_desempleado;
	        this.cuotaempleado=cuota_empleado;
	        this.cuotaminusvalido=cuota_minusvalido;
	        this.cuotaempresa=cuota_empresa;
	        this.listaEspera=lista_espera;
	    }

	

	public int getCuota_precolegiado() {
		return cuotaprecolegiado;
	}

	public void setCuota_precolegiado(int cuota_precolegiado) {
		this.cuotaprecolegiado = cuota_precolegiado;
	}

	public int getCuota_colegiado() {
		return cuotacolegiado;
	}

	public void setCuota_colegiado(int cuota_colegiado) {
		this.cuotacolegiado = cuota_colegiado;
	}

	public int getCuota_otros() {
		return cuotaotros;
	}

	public void setCuota_otros(int cuota_otros) {
		this.cuotaotros = cuota_otros;
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
		return fechainicio;
	}

	public void setFecha_inicio(String fecha_inicio) {
		this.fechainicio = fecha_inicio;
	}

	public String getFecha_fin() {
		return fechafin;
	}

	public void setFecha_fin(String fecha_fin) {
		this.fechafin = fecha_fin;
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

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getApertura_inscripcion() {
		return aperturainscripcion;
	}

	public void setApertura_inscripcion(String apertura_inscripcion) {
		this.aperturainscripcion = apertura_inscripcion;
	}

	public String getCierre_inscripcion() {
		return cierreinscripcion;
	}

	public void setCierre_inscripcion(String cierre_inscripción) {
		this.cierreinscripcion = cierre_inscripción;
	}

	public int getCuota_minusvalido() {
		return cuotaminusvalido;
	}

	public void setCuota_minusvalido(int cuota_minusvalido) {
		this.cuotaminusvalido = cuota_minusvalido;
	}

	public int getCuota_desempleado() {
		return cuotadesempleado;
	}

	public void setCuota_desempleado(int cuota_desempleado) {
		this.cuotadesempleado = cuota_desempleado;
	}

	public int getCuota_empleado() {
		return cuotaempleado;
	}

	public void setCuota_empleado(int cuota_empleado) {
		this.cuotaempleado = cuota_empleado;
	}

	public int getCuota_alumno() {
		return cuotalumno;
	}

	public void setCuota_alumno(int cuota_alumno) {
		this.cuotalumno = cuota_alumno;
	}

	public int getCuota_empresa() {
		return cuotaempresa;
	}

	public void setCuota_empresa(int cuota_empresa) {
		this.cuotaempresa = cuota_empresa;
	}

	public String getFechainicio() {
		return fechainicio;
	}

	public void setFechainicio(String fechainicio) {
		this.fechainicio = fechainicio;
	}

	public String getFechafin() {
		return fechafin;
	}

	public void setFechafin(String fechafin) {
		this.fechafin = fechafin;
	}

	public int getCuotaprecolegiado() {
		return cuotaprecolegiado;
	}

	public void setCuotaprecolegiado(int cuotaprecolegiado) {
		this.cuotaprecolegiado = cuotaprecolegiado;
	}

	public int getCuotacolegiado() {
		return cuotacolegiado;
	}

	public void setCuotacolegiado(int cuotacolegiado) {
		this.cuotacolegiado = cuotacolegiado;
	}

	public int getCuotaotros() {
		return cuotaotros;
	}

	public void setCuotaotros(int cuotaotros) {
		this.cuotaotros = cuotaotros;
	}

	public int getCuotaminusvalido() {
		return cuotaminusvalido;
	}

	public void setCuotaminusvalido(int cuotaminusvalido) {
		this.cuotaminusvalido = cuotaminusvalido;
	}

	public int getCuotadesempleado() {
		return cuotadesempleado;
	}

	public void setCuotadesempleado(int cuotadesempleado) {
		this.cuotadesempleado = cuotadesempleado;
	}

	public int getCuotaempleado() {
		return cuotaempleado;
	}

	public void setCuotaempleado(int cuotaempleado) {
		this.cuotaempleado = cuotaempleado;
	}

	public int getCuotalumno() {
		return cuotalumno;
	}

	public void setCuotalumno(int cuotalumno) {
		this.cuotalumno = cuotalumno;
	}

	public int getCuotaempresa() {
		return cuotaempresa;
	}

	public void setCuotaempresa(int cuotaempresa) {
		this.cuotaempresa = cuotaempresa;
	}

	public String getAperturainscripcion() {
		return aperturainscripcion;
	}

	public void setAperturainscripcion(String aperturainscripcion) {
		this.aperturainscripcion = aperturainscripcion;
	}

	public String getCierreinscripcion() {
		return cierreinscripcion;
	}

	public void setCierreinscripcion(String cierreinscripcion) {
		this.cierreinscripcion = cierreinscripcion;
	}

	public boolean isLista_espera() {
		return listaEspera;
	}

	public void setLista_espera(boolean lista_espera) {
		this.listaEspera = lista_espera;
	}
	   

}
