package giis.demo.generarrecibos;

public class ColegiadosRecibosDTO {
    private int id_colegiado;  // Cambiar de idcolegiado a id_colegiado
    private String nombre;
    private String apellidos;
    private String DNI;
    private String titulacion;
    private String estado;

    public ColegiadosRecibosDTO() {}

    public ColegiadosRecibosDTO(int id_colegiado, String nombre, String apellidos, String dNI, String titulacion, String estado) {
        this.id_colegiado = id_colegiado;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.DNI = dNI;
        this.titulacion = titulacion;
        this.estado = estado;
    }

    // Getter y Setter para id_colegiado
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

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getTitulacion() {
        return titulacion;
    }

    public void setTitulacion(String titulacion) {
        this.titulacion = titulacion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}