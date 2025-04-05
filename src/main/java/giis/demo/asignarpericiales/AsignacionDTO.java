package giis.demo.asignarpericiales;

public class AsignacionDTO {
	private int id_perito;
	private int id_pericial;
	private String fecha;
	
	public AsignacionDTO() {}
	
	public AsignacionDTO(int idPerito, int idPericial, String fecha) {
		this.setId_perito(idPerito);
		this.setId_pericial(idPericial);
		this.setFecha(fecha);
	}
	
		public int getId_perito() {
		return id_perito;
	}

	public void setId_perito(int id_perito) {
		this.id_perito = id_perito;
	}

	public int getId_pericial() {
		return id_pericial;
	}

	public void setId_pericial(int id_pericial) {
		this.id_pericial = id_pericial;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
}
