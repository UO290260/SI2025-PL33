package giis.demo.inscripcionlistaTAP;

public class PeritosDTO {
	private int id_colegiado;
	private String correo;
	private int telefono;
	private String fecha;
	private int año;
	private int tap;
	private String estado;

	public PeritosDTO(){}

	public PeritosDTO(int id_colegiado, String correo, int telefono, String fecha, int año, int tap, String estado) {
		this.id_colegiado = id_colegiado;
		this.correo = correo;
		this.telefono = telefono;
		this.fecha = fecha;
		this.año = año;
		this.tap = tap;
		this.estado = estado;
	}
	public int getId_colegiado() { return id_colegiado; } public void setId_colegiado(int id_colegiado) { this.id_colegiado = id_colegiado; }
	public String getCorreo() { return correo; } public void setCorreo(String correo) { this.correo = correo; }
	public int getTelefono() { return telefono; } public void setTelefono(int telefono) { this.telefono = telefono; }
	public String getFecha() { return fecha; } public void setFecha(String fecha) { this.fecha = fecha; }
	public int getAño() { return año; } public void setAño(int año) { this.año = año; }
	public int getTap() { return tap; } public void setTap(int tap) { this.tap = tap; }
	public String getEstado() { return estado; } public void setEstado(String estado) { this.estado = estado; }
}