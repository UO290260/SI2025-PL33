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
	    private String aperturainscripcion;
	    private String cierreinscripcion;
	    private String estado;
	    
	  public CursosDTO(){};
	    
	  public CursosDTO(int id_curso, String titulo, String descripcion, String fecha_inicio, String fecha_fin, int duracion, int plazas,String apertura_inscripcion,String cierre_inscripcion, String estado) {
	        this.id_curso = id_curso;
	        this.titulo = titulo;
	        this.descripcion = descripcion;
	        this.fechainicio = fecha_inicio;
	        this.fechafin = fecha_fin;
	        this.duracion = duracion;
	        this.plazas = plazas;
	        this.aperturainscripcion=apertura_inscripcion;
	        this.cierreinscripcion=cierre_inscripcion;
	        this.estado = estado;
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
	  
	  

}
