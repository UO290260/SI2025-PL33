package giis.demo.generarrecibos;

/**
 *Clase ColegiadosRecibosDTO que contiene todos los atributos de la tabla Colegiados y Recibos
 */
public class ColegiadosRecibosDTO {
	private int id_recibo;
    private int id_colegiado; 
    private String nombre;
    private String apellidos;
    private String DNI;
    private int cuota_pagar;
    private String fecha_recibo;
    private String cuenta_bancaria;
    private String estado;

    public ColegiadosRecibosDTO() { }

    public ColegiadosRecibosDTO(int id_recibo, int id_colegiado, String nombre, String apellidos, String DNI, int cuota_pagar, String fecha_recibo, String cuenta_bancaria, String estado) {
        this.id_recibo = id_recibo;
        this.id_colegiado = id_colegiado;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.DNI = DNI;
        this.cuota_pagar = cuota_pagar;
        this.fecha_recibo = fecha_recibo;
        this.cuenta_bancaria = cuenta_bancaria;
        this.estado = estado;
    }

    public int getId_recibo() { return id_recibo; } public void setId_recibo(int id_recibo) { this.id_recibo = id_recibo; }
    public int getId_colegiado() { return id_colegiado; } public void setId_colegiado(int id_colegiado) { this.id_colegiado = id_colegiado; }
    public String getNombre() { return nombre; } public void setNombre(String nombre) { this.nombre = nombre; }
    public String getApellidos() { return apellidos; } public void setApellidos(String apellidos) { this.apellidos = apellidos; }
    public String getDNI() { return DNI; } public void setDNI(String DNI) { this.DNI = DNI; }
    public int getCuota_pagar() { return cuota_pagar; } public void setCuota_pagar(int cuota_pagar) { this.cuota_pagar = cuota_pagar; }
    public String getFecha_recibo() { return fecha_recibo; } public void setFecha_recibo(String fecha_recibo) { this.fecha_recibo = fecha_recibo; }
    public String getCuenta_bancaria() { return cuenta_bancaria; } public void setCuenta_bancaria(String cuenta_bancaria) { this.cuenta_bancaria = cuenta_bancaria; }
    public String getEstado() { return estado; } public void setEstado(String estado) { this.estado = estado; }
}