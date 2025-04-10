package giis.demo.visualizarinscritos;

public class InscripcionDTO {
	private int id_inscripcion;
	private String nombre;
	private String apellidos;
	private String dni;
	private int posicion;
	private String estado;
	
	public InscripcionDTO(int id, String nom, String ap, String dni,int posicion, String est) {
		setId_inscripcion(id);
		setNombre(nom);
		setApellidos(ap);
		setDni(dni);
		setPosicion(posicion);
		setEstado(est);
	}
	
	public InscripcionDTO() {}
	
	public int getId_inscripcion() {
		return id_inscripcion;
	}
	public void setId_inscripcion(int id_colegiado) {
		this.id_inscripcion = id_colegiado;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public int getPosicion() {
		return posicion;
	}

	public void setPosicion(int posicion) {
		this.posicion = posicion;
	}
	
}
