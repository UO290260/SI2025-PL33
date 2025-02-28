package giis.demo.inscripcioncolegiados;

/**
 *Clase InscripcioncolegiadosDTO que contiene todos los atributos de la tabla Colegiados
 *Se utiliza en la clase InscripcioncolegiadoController en el metodo cargarListaColegiados() y en la clase InscripcioncolegiadosDTO en el metodo getListaColegiados()
 */
public class InscripcioncolegiadosDTO {
	private int idcolegiado;
	private String nombre; 
	private String apellidos;
	private String DNI;
	private String direccion;
	private String poblacion;
	private String fechanacimiento;
	private String cuentabancaria;
	private String titulacion;
	private String fechacolegiacion;

	public InscripcioncolegiadosDTO() {}

	public InscripcioncolegiadosDTO(int id_colegiado, String nombre, String apellidos, String dNI, String direccion,
			String poblacion, String fecha_nacimiento, String cuenta_bancaria, String titulacion,
			String fecha_colegiacion) {
		this.idcolegiado = id_colegiado;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.DNI = dNI;
		this.direccion = direccion;
		this.poblacion = poblacion;
		this.fechanacimiento = fecha_nacimiento;
		this.cuentabancaria = cuenta_bancaria;
		this.titulacion = titulacion;
		this.fechacolegiacion = fecha_colegiacion;
	}
	public int getId_colegiado() { return this.idcolegiado; } public void setId_colegiado(int id_colegiado) { this.idcolegiado = id_colegiado; }
	public String getNombre() { return this.nombre; } public void setNombre(String nombre) { this.nombre = nombre; }
	public String getApellidos() { return this.apellidos; }	public void setApellidos(String apellidos) { this.apellidos = apellidos; }
	public String getDNI() { return this.DNI; }	public void setDNI(String dNI) { this.DNI = dNI; }
	public String getDireccion() { return this.direccion; }	public void setDireccion(String direccion) { this.direccion = direccion; }
	public String getPoblacion() { return this.poblacion; }	public void setPoblacion(String poblacion) { this.poblacion = poblacion; }
	public String getFecha_nacimiento() { return this.fechanacimiento; } public void setFecha_nacimiento(String fecha_nacimiento) { this.fechanacimiento = fecha_nacimiento; }
	public String getCuenta_bancaria() { return this.cuentabancaria; } public void setCuenta_bancaria(String cuenta_bancaria) { this.cuentabancaria = cuenta_bancaria; }
	public String getTitulacion() { return this.titulacion; } public void setTitulacion(String titulacion) { this.titulacion = titulacion; }
	public String getFecha_colegiacion() { return this.fechacolegiacion; } public void setFecha_colegiacion(String fecha_colegiacion) { this.fechacolegiacion = fecha_colegiacion; }
}