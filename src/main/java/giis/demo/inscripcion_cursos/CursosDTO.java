package giis.demo.inscripcion_cursos;

public class CursosDTO {
	 	private int id_curso;
	    private String titulo;
	    private String descripcion;
	    private String fecha_inicio;
	    private String fecha_fin;
	    private int duracion;
	    private int plazas;
	    private String estado;
	    
	    public CursosDTO(){};
	    
	  public CursosDTO(int id_curso, String titulo, String descripcion, String fecha_inicio, String fecha_fin, int duracion, int plazas, String estado) {
	        this.id_curso = id_curso;
	        this.titulo = titulo;
	        this.descripcion = descripcion;
	        this.fecha_inicio = fecha_inicio;
	        this.fecha_fin = fecha_fin;
	        this.duracion = duracion;
	        this.plazas = plazas;
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

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	  
	  

}
