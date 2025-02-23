package giis.demo.inscripcion_cursos;



public class ColegiadoDTO {
	
	private int id_colegiado;
    private String nombre;
    private String apellidos;
    private String direccion;
    private String poblacion;
    private String titulacion;
    private String fecha_colegiacion;
    private String cuenta_bancaria;
    
    public ColegiadoDTO() { }
    
    public ColegiadoDTO(int id_colegiado, String nombre, String apellidos, String direccion, String poblacion, String titulacion, String fecha_colegiacion, String cuenta_bancaria) {
        this.id_colegiado = id_colegiado;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.poblacion = poblacion;
        this.titulacion = titulacion;
        this.fecha_colegiacion = fecha_colegiacion;
        this.cuenta_bancaria=cuenta_bancaria;
    }

	
	
	public int getId_colegiado() {
		return id_colegiado;
	}

	public void setId_colegiado(int id_colegiado) {
		this.id_colegiado = id_colegiado;
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
		return fecha_colegiacion;
	}

	public void setFecha_colegiacion(String fecha_colegiacion) {
		this.fecha_colegiacion = fecha_colegiacion;
	}

	public String getCuenta_bancaria() {
		return cuenta_bancaria;
	}

	public void setCuenta_bancaria(String cuenta_bancaria) {
		this.cuenta_bancaria = cuenta_bancaria;
	}


}
