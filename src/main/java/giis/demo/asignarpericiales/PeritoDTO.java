package giis.demo.asignarpericiales;

public class PeritoDTO {
	private int tap; 
	private int id_colegiado;
	private String correo;
	private int telefono;
	private String estado;
	
	public PeritoDTO() {}
	
	public PeritoDTO(int tap, int id, String correo, String telf, String est) {
		this.setTap(tap);
		this.setId_colegiado(id);
		this.setCorreo(correo);
		this.setTelefono(id);
		this.setEstado(est);
	}

	public int getTap() {
		return tap;
	}

	public void setTap(int tap) {
		this.tap = tap;
	}

	public int getId_colegiado() {
		return id_colegiado;
	}

	public void setId_colegiado(int id_colegiado) {
		this.id_colegiado = id_colegiado;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
}
