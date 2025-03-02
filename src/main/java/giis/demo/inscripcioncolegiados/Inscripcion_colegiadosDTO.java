package giis.demo.inscripcioncolegiados;

/**
 *Cada una de las filas que muestran al usuario los colegiados 
 */
public class Inscripcion_colegiadosDTO {

	private int id_colegiado;
	private String nombre; 
	private String apellidos;
	private String DNI;
	private String direccion;
	private String poblacion;
	private String fecha_nacimiento;
	private String cuenta_bancaria;
	private String titulacion;
	private String fecha_colegiacion;

	public Inscripcion_colegiadosDTO() {}

	public Inscripcion_colegiadosDTO(int id_colegiado, String nombre, String apellidos, String dNI, String direccion,
			String poblacion, String fecha_nacimiento, String cuenta_bancaria, String titulacion,
			String fecha_colegiacion) {

		this.id_colegiado = id_colegiado;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.DNI = dNI;
		this.direccion = direccion;
		this.poblacion = poblacion;
		this.fecha_nacimiento = fecha_nacimiento;
		this.cuenta_bancaria = cuenta_bancaria;
		this.titulacion = titulacion;
		this.fecha_colegiacion = fecha_colegiacion;
	}
	public int getId_colegiado() { return this.id_colegiado; }
	public void setId_colegiado(int id_colegiado) { this.id_colegiado = id_colegiado; }
	public String getNombre() { return this.nombre; }
	public void setNombre(String nombre) { this.nombre = nombre; }
	public String getApellidos() { return this.apellidos; }
	public void setApellidos(String apellidos) { this.apellidos = apellidos; }
	public String getDNI() { return this.DNI; }
	public void setDNI(String dNI) { this.DNI = dNI; }
	public String getDireccion() { return this.direccion; }
	public void setDireccion(String direccion) { this.direccion = direccion; }
	public String getPoblacion() { return this.poblacion; }
	public void setPoblacion(String poblacion) { this.poblacion = poblacion; }
	public String getFecha_nacimiento() { return this.fecha_nacimiento; }
	public void setFecha_nacimiento(String fecha_nacimiento) { this.fecha_nacimiento = fecha_nacimiento; }
	public String getCuenta_bancaria() { return this.cuenta_bancaria; }
	public void setCuenta_bancaria(String cuenta_bancaria) { this.cuenta_bancaria = cuenta_bancaria; }
	public String getTitulacion() { return this.titulacion; }
	public void setTitulacion(String titulacion) { this.titulacion = titulacion; }
	public String getFecha_colegiacion() { return this.fecha_colegiacion; }
	public void setFecha_colegiacion(String fecha_colegiacion) { this.fecha_colegiacion = fecha_colegiacion; }

}
