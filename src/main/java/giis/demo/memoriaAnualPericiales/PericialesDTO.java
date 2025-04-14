package giis.demo.memoriaAnualPericiales;



public class PericialesDTO {
	
	private int id_pericial;
	private int id_perito;
	private String nombre;
	private String solicitante;
	private String fecha;
	private String urgencia;
	private String estado;
	
	public PericialesDTO()
	{}
	
	public PericialesDTO(int id_pericial,int id_perito, String nombre,String solicitante, String fecha,String urgencia,String estado)
	{
		this.id_pericial=id_pericial;
		this.id_perito=id_perito;
		this.nombre=nombre;
		this.solicitante=solicitante;
		this.fecha=fecha;
		this.urgencia=urgencia;
		this.estado=estado;
	}

	public int getId_pericial() {
		return id_pericial;
	}

	public void setId_pericial(int id_pericial) {
		this.id_pericial = id_pericial;
	}

	public int getId_perito() {
		return id_perito;
	}

	public void setId_perito(int id_perito) {
		this.id_perito = id_perito;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
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
