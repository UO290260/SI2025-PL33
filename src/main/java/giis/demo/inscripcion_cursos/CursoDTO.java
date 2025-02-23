package giis.demo.inscripcion_cursos;

public class CursoDTO {
	    private int idCurso;
	    private String titulo;
	    private String fechaInicio;
	    private int plazas;
	   

	    // Constructor vacío
	    public CursoDTO() {}

	    // Constructor con parámetros
	    public CursoDTO(int idCurso, String titulo, String fechaInicio, int plazas) {
	        this.idCurso = idCurso;
	        this.titulo = titulo;
	        this.fechaInicio = fechaInicio;
	        this.plazas = plazas;
	    }

	    // Getters y Setters
	    public int getIdCurso() {
	        return idCurso;
	    }

	    public void setIdCurso(int idCurso) {
	        this.idCurso = idCurso;
	    }

	    public String getTitulo() {
	        return titulo;
	    }

	    public void setTitulo(String titulo) {
	        this.titulo = titulo;
	    }


	    public String getFechaInicio() {
	        return fechaInicio;
	    }

	    public void setFechaInicio(String fechaInicio) {
	        this.fechaInicio = fechaInicio;
	    }

	 

	    public int getPlazas() {
	        return plazas;
	    }

	    public void setPlazas(int plazas) {
	        this.plazas = plazas;
	    }

		@Override
		public String toString() {
			return "CursoDTO [idCurso=" + idCurso + ", titulo=" + titulo + ", fechaInicio=" + fechaInicio + ", plazas="
					+ plazas + "]";
		}

	   


}
