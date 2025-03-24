package giis.demo.inscripcioncursos;

public class ExternoDTO {
	
	private int idexterno;
    private String nombre;
    private String apellidos;
    private String DNI;
    private String direccion;
    private String poblacion;
    private String fechanacimiento; 
    private String cuentabancaria;
    
    public ExternoDTO(){}
    
    public ExternoDTO(int id_externo,String nombre,String apellidos,String DNI,String direccion,String poblacion,String fecha_nacimiento,String cuenta_bancaria)
    {
    	 this.idexterno = id_externo;
         this.nombre = nombre;
         this.apellidos = apellidos;
         this.DNI=DNI;
         this.direccion = direccion;
         this.poblacion = poblacion;
         this.fechanacimiento = fecha_nacimiento;
         this.cuentabancaria=cuenta_bancaria;
    	
    }

	public int getId_externo() {
		return idexterno;
	}

	public void setId_externo(int id_externo) {
		this.idexterno = id_externo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDNI() {
		return DNI;
	}

	public void setDNI(String dNI) {
		DNI = dNI;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getPoblacion() {
		return poblacion;
	}

	public void setPoblacion(String poblacion) {
		this.poblacion = poblacion;
	}

	public String getFecha_nacimiento() {
		return fechanacimiento;
	}

	public void setFecha_nacimiento(String fecha_nacimiento) {
		this.fechanacimiento = fecha_nacimiento;
	}

	public String getCuenta_bancaria() {
		return cuentabancaria;
	}

	public void setCuenta_bancaria(String cuenta_bancaria) {
		this.cuentabancaria = cuenta_bancaria;
	}
}
