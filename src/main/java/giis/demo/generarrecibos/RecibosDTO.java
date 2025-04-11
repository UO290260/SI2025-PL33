package giis.demo.generarrecibos;

public class RecibosDTO {
    private int id_recibo;  // id_recibo que proviene de la tabla Recibos
    private String DNI;
    private double cuota_pagar;
    private String fecha_recibo;
    private String estado;

    
    public RecibosDTO() { }
    
    // Constructor
    public RecibosDTO(int id_recibo, String DNI, double cuota_pagar, String fecha_recibo, String estado) {
        this.id_recibo = id_recibo;
        this.DNI = DNI;
        this.cuota_pagar = cuota_pagar;
        this.fecha_recibo = fecha_recibo;
        this.estado = estado;
    }

    // Getters y Setters
    public int getId_recibo() {
        return id_recibo;
    }

    public void setId_recibo(int id_recibo) {
        this.id_recibo = id_recibo;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public double getCuota_pagar() {
        return cuota_pagar;
    }

    public void setCuota_pagar(double cuota_pagar) {
        this.cuota_pagar = cuota_pagar;
    }

    public String getFecha_recibo() {
        return fecha_recibo;
    }

    public void setFecha_recibo(String fecha_recibo) {
        this.fecha_recibo = fecha_recibo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}