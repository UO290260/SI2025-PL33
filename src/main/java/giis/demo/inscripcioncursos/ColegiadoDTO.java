package giis.demo.inscripcioncursos;

public class ColegiadoDTO {
	
	private int idcolegiado;
    private String nombre;
    private String apellidos;
    private String direccion;
    private String poblacion;
    private String titulacion;
    private String fechacolegiacion;
    private String cuentabancaria;
    /**
     * Clase ColegiadoDTO usada por la clase Controller para almacenar los datos en una tabla
     * Clase que contiene todos los datos con los campos de la tabla colegiados
     */
    public ColegiadoDTO() { }
    
    public ColegiadoDTO(int id_colegiado, String nombre, String apellidos, String direccion, String poblacion, String titulacion, String fecha_colegiacion, String cuenta_bancaria) {
        this.idcolegiado = id_colegiado;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.poblacion = poblacion;
        this.titulacion = titulacion;
        this.fechacolegiacion = fecha_colegiacion;
        this.cuentabancaria=cuenta_bancaria;
    }
    
	public int getId_colegiado() {
		return idcolegiado;
	}

	public void setId_colegiado(int id_colegiado) {
		this.idcolegiado = id_colegiado;
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

	public String getTitulacion() {
		return titulacion;
	}

	public void setTitulacion(String titulacion) {
		this.titulacion = titulacion;
	}

	public String getFecha_colegiacion() {
		return fechacolegiacion;
	}

	public void setFecha_colegiacion(String fecha_colegiacion) {
		this.fechacolegiacion = fecha_colegiacion;
	}

	public String getCuenta_bancaria() {
		return cuentabancaria;
	}

	public void setCuenta_bancaria(String cuenta_bancaria) {
		this.cuentabancaria = cuenta_bancaria;
	}
}
