package giis.demo.solicitudcolegiado;

public class ColegiadoDTO {
	private int idcolegiado;
	private String nombre; 
	private String apellidos;
	private String DNI;
	private String titulacion;
	private String estado;

	public ColegiadoDTO() {}

	public ColegiadoDTO(int id_colegiado, String nombre, String apellidos, String dNI,String titulacion,String estado) {
		this.idcolegiado = id_colegiado;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.DNI = dNI;
		this.titulacion = titulacion;
		this.estado=estado;
	}
	public int getId_colegiado() { return this.idcolegiado; } public void setId_colegiado(int id_colegiado) { this.idcolegiado = id_colegiado; }
	public String getNombre() { return this.nombre; } public void setNombre(String nombre) { this.nombre = nombre; }
	public String getApellidos() { return this.apellidos; }	public void setApellidos(String apellidos) { this.apellidos = apellidos; }
	public String getDNI() { return this.DNI; }	public void setDNI(String dNI) { this.DNI = dNI; }
	public String getTitulacion() { return this.titulacion; } public void setTitulacion(String titulacion) { this.titulacion = titulacion; }
	public String getEstado() { return this.estado;}public void setEstado(String estado) {this.estado = estado; }
}