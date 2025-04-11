package giis.demo.asignarpericiales;

public class PericialDTO {
	private int id_pericial;
	private String solicitante;
	private String fecha;
	private String urgencia;
	private String estado;
	
	public PericialDTO() {}
	
	public PericialDTO(int id, String sol, String fecha, String urg, String est) {
		setId_pericial(id);
		setSolicitante(sol);
		setFecha(fecha);
		setUrgencia(urg);
		setEstado(est);
	}

	public int getId_pericial() {
		return id_pericial;
	}

	public void setId_pericial(int id_pericial) {
		this.id_pericial = id_pericial;
	}

	public String getSolicitante() {
		return solicitante;
	}

	public void setSolicitante(String solicitante) {
		this.solicitante = solicitante;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getUrgencia() {
		return urgencia;
	}

	public void setUrgencia(String urgencia) {
		this.urgencia = urgencia;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
}
