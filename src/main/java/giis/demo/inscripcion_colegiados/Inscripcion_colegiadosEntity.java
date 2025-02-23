package giis.demo.inscripcion_colegiados;

import java.util.Date;

/**
 * DATOS DEL MODELO DE DOMINIO DE CADA UNO DE LOS COLEGIADOS
 */
public class Inscripcion_colegiadosEntity {

	private String nombre;
	private String apellidos; 
	private String dni;
	private String direccion;
	private String poblacion;
	private Date fechanacimiento;
	private Date fechasolicitud;
	private String cuenta;
	private String titulacion;
	
	public String getNombre() { return this.nombre; }
	public void setNombre(String nombre) { this.nombre = nombre; }
	public String getApellidos() { return this.apellidos; }
	public void setApellidos(String apellidos) { this.apellidos = apellidos; }
	public String getDni() { return this.dni; }
	public void setDni(String dni) { this.dni = dni; }
	public String getDireccion() { return this.direccion; }
	public void setDireccion(String direccion) { this.direccion = direccion; }
	public String getPoblacion() { return this.poblacion; }
	public void setPoblacion(String poblacion) { this.poblacion = poblacion; }
	public Date getFechanacimiento() { return this.fechanacimiento; }
	public void setFechanacimiento(Date fechanacimiento) { this.fechanacimiento = fechanacimiento; }
	public Date getFechasolicitud() { return this.fechasolicitud; }
	public void setFechasolicitud(Date fechasolicitud) { this.fechasolicitud = fechasolicitud; }
	public String getCuenta() { return this.cuenta; }
	public void setCuenta(String cuenta) { this.cuenta = cuenta; }
	public String getTitulacion() { return this.titulacion; }
	public void setTitulacion(String titulacion) { this.titulacion = titulacion; }
	
}
