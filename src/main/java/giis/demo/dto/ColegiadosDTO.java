package giis.demo.dto;

public class ColegiadosDTO {
	private int id_colegiado;
	private String nombre;
	private String apellidos;
	private String dni;
	private String direccion;
	private String poblacion;
	private String fecha_nacimiento;
	private String cuenta_bancaria;
	private String titulacion;
	private String fecha_colegiacion;
	private String estado;

	public ColegiadosDTO() {}

	public ColegiadosDTO(int id_colegiado, String nombre, String apellidos, String dni, String direccion, String poblacion, String fecha_nacimiento, String cuenta_bancaria, String titulacion, String fecha_colegiacion) {
		this.id_colegiado = id_colegiado;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.dni = dni;
		this.direccion = direccion;
		this.poblacion = poblacion;
		this.fecha_nacimiento = fecha_nacimiento;
		this.cuenta_bancaria = cuenta_bancaria;
		this.titulacion = titulacion;
		this.fecha_colegiacion = fecha_colegiacion;
	}
	
	 public ColegiadosDTO(int id_colegiado, String nombre, String apellidos,String DNI, String direccion, String poblacion, String titulacion, String fecha_colegiacion, String cuenta_bancaria) {
	        this.id_colegiado = id_colegiado;
	        this.nombre = nombre;
	        this.apellidos = apellidos;
	        this.dni=DNI;
	        this.direccion = direccion;
	        this.poblacion = poblacion;
	        this.titulacion = titulacion;
	        this.fecha_colegiacion = fecha_colegiacion;
	        this.cuenta_bancaria=cuenta_bancaria;
	    }
	 
	public int getId_colegiado() { return id_colegiado; } public void setId_colegiado(int id_colegiado) { this.id_colegiado = id_colegiado; }
	public String getNombre() { return nombre; } public void setNombre(String nombre) { this.nombre = nombre; }
	public String getApellidos() { return apellidos; } public void setApellidos(String apellidos) { this.apellidos = apellidos; }
	public String getDni() { return dni; } public void setDni(String dni) { this.dni = dni; }
	public String getDireccion() { return direccion; } public void setDireccion(String direccion) { this.direccion = direccion; }
	public String getPoblacion() { return poblacion; } public void setPoblacion(String poblacion) { this.poblacion = poblacion; }
	public String getFecha_nacimiento() { return fecha_nacimiento; } public void setFecha_nacimiento(String fecha_nacimiento) { this.fecha_nacimiento = fecha_nacimiento; }
	public String getCuenta_bancaria() { return cuenta_bancaria; } public void setCuenta_bancaria(String cuenta_bancaria) { this.cuenta_bancaria = cuenta_bancaria; }
	public String getTitulacion() { return titulacion; } public void setTitulacion(String titulacion) { this.titulacion = titulacion; }
	public String getFecha_colegiacion() { return fecha_colegiacion; } public void setFecha_colegiacion(String fecha_colegiacion) { this.fecha_colegiacion = fecha_colegiacion; }
	public String getEstado() { return estado; } public void setEstado(String estado) { this.estado = estado; }
}