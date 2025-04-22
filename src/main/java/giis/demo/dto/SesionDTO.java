package giis.demo.dto;

public class SesionDTO {
	private int id_sesion;
	private int id_curso;
	private String fecha;
	private String hora_inicio;
	private int duracion;
	
	public SesionDTO() {}
	
	public SesionDTO(int id, int curso, String fecha, String h, int dur) {
		this.setId_sesion(id);
		this.setId_curso(curso);
		this.setFecha(fecha);
		this.setHora_inicio(h);
		this.setDuracion(dur);
	}

    public int getId_sesion() {
    	return id_sesion; 
    }
    
    public void setId_sesion(int id_sesion) { 
    	this.id_sesion = id_sesion; 
    }

	public String getHora_inicio() {
		return hora_inicio;
	}

	public void setHora_inicio(String hora) {
		this.hora_inicio = hora;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	public int getId_curso() {
		return id_curso;
	}

	public void setId_curso(int id_curso) {
		this.id_curso = id_curso;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
}
