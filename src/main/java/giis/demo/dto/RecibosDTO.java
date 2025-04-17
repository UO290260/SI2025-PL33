package giis.demo.dto;

/**
 *Clase RecibosDTO que contiene todos los atributos de la tabla Colegiados y Recibos
 */
public class RecibosDTO {
	private int id_recibo;
    private String DNI;
    private int cuota_pagar;
    private String fecha_recibo;
    private String estado;

    public RecibosDTO() { }

    public RecibosDTO(int id_recibo, String DNI, int cuota_pagar, String fecha_recibo, String estado) {
        this.id_recibo = id_recibo;
        this.DNI = DNI;
        this.cuota_pagar = cuota_pagar;
        this.fecha_recibo = fecha_recibo;
        this.estado = estado;
    }
    
    public int getId_recibo() { return id_recibo; } public void setId_recibo(int id_recibo) { this.id_recibo = id_recibo; }
    public String getDNI() { return DNI; } public void setDNI(String DNI) { this.DNI = DNI; }
    public int getCuota_pagar() { return cuota_pagar; } public void setCuota_pagar(int cuota_pagar) { this.cuota_pagar = cuota_pagar; }
    public String getFecha_recibo() { return fecha_recibo; } public void setFecha_recibo(String fecha_recibo) { this.fecha_recibo = fecha_recibo; }
    public String getEstado() { return estado; } public void setEstado(String estado) { this.estado = estado; }
}