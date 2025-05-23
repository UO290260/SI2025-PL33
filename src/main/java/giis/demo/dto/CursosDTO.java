package giis.demo.dto;

//Clase CursoDTO usada en controller para implementar los datos de la clase Cursos a una tabla
public class CursosDTO {
	private int id_curso;
	private String DNI;
	private String titulo;
	private String descripcion;
	private String fechainicio;
	private String fechafin;
	private int duracion;
	private int plazas;
	private int sesiones;
	private int cuotaprecolegiado, cuotacolegiado, cuotaotros, cuotaminusvalido, cuotadesempleado, cuotaempleado, cuotalumno, cuotaempresa;
	private String aperturainscripcion;
	private String cierreinscripcion;
	private boolean listaEspera;
	private String estado;
	private boolean cancelable;
	private String fecha_cancelacion; 
	private int porcentaje_devolucion;

	public CursosDTO(){};

	public CursosDTO(int id_curso, String DNI, String titulo, String descripcion, String fecha_inicio, String fecha_fin, int duracion, int plazas, int sesiones, int cuota_precolegiado,int cuota_colegiado,
			int cuota_minusvalido,int cuota_desempleado, int cuota_empleado,int cuota_alumno,int cuota_empresa,int cuota_otros, String apertura_inscripcion,String cierre_inscripcion,
			boolean lista_espera, String estado, boolean canc, String fecha_canc, int porc) {
		this.id_curso = id_curso;
		this.DNI = DNI;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.fechainicio = fecha_inicio;
		this.fechafin = fecha_fin;
		this.duracion = duracion;
		this.plazas = plazas;
		this.sesiones = sesiones;
		this.cuotaprecolegiado=cuota_precolegiado;
		this.cuotacolegiado=cuota_colegiado;
		this.cuotaotros=cuota_otros;
		this.aperturainscripcion=apertura_inscripcion;
		this.cierreinscripcion=cierre_inscripcion;
		this.estado = estado;
		this.cuotalumno=cuota_alumno;
		this.cuotadesempleado=cuota_desempleado;
		this.cuotaempleado=cuota_empleado;
		this.cuotaminusvalido=cuota_minusvalido;
		this.cuotaempresa=cuota_empresa;
		this.listaEspera=lista_espera;
		this.cancelable = canc;
		this.fecha_cancelacion = fecha_canc;
		this.porcentaje_devolucion = porc;
	}

	public CursosDTO(int id, String tit, String descr, String fini, String ffin, int dur, int plz, int ses, int cuotaPre, int cuotaCol, int cuotaMinus, int cuotaDes, 
			int cuotaEmpl, int cuotaAlu, int cuotaEmpr, int cuotaOtros, boolean cancel, int porc, String fcancel, boolean espera) {
		setId_curso(id);
		setTitulo(tit); 
		setDescripcion(descr);
		setFecha_inicio(fini);
		setFecha_fin(ffin);
		setDuracion(dur);
		setPlazas(plz);
		setSesiones(ses);
		setCuota_precolegiado(cuotaPre);
		setCuota_colegiado(cuotaCol);
		setCuota_minusvalido(cuotaMinus);
		setCuota_desempleado(cuotaDes);
		setCuota_empleado(cuotaEmpl);
		setCuota_alumno(cuotaAlu);
		setCuota_empresa(cuotaEmpr);
		setCuota_otros(cuotaOtros);
		setCancelable(cancel);
		setFecha_cancelacion(fcancel);
		setPorcentaje_devolucion(porc);
		setLista_espera(espera);
	}
	
	public CursosDTO(int id, String tit, String descr, String fini, String ffin, int ses, String est) {
		setId_curso(id);
		setTitulo(tit);
		setDescripcion(descr);
		setFecha_inicio(fini);
		setFecha_fin(ffin);
		setSesiones(ses);
		setEstado(est);
	}

	public CursosDTO(int id, String tit, String descr, String fini, String ffin, int dur, int plz, int cuotaPre, int cuotaCol, int cuotaMinus, int coutaDes, int cuotaEmpl, int cuotaAlu, int cuotaEmpr, int cuotaOtros, String apertura, String cierre, String est) {
		setId_curso(id);
		setTitulo(tit); 
		setDescripcion(descr);
		setFecha_inicio(fini);
		setFecha_fin(ffin);
		setDuracion(dur);
		setPlazas(plz);
		setApertura_inscripcion(apertura);
		setCierre_inscripcion(cierre);
		setCuota_precolegiado(cuotaPre);
		setCuota_colegiado(cuotaCol);
		setCuota_minusvalido(cuotaMinus);
		setCuota_desempleado(coutaDes);
		setCuota_empleado(cuotaEmpl);
		setCuota_alumno(cuotaAlu);
		setCuota_empresa(cuotaEmpr);
		setCuota_otros(cuotaOtros);
		setEstado(est);
	}
	
	public CursosDTO(int id, String tit, String descr, String est) {
		setId_curso(id);
		setTitulo(tit);
		setDescripcion(descr);
		setEstado(est);
	}
	
	public String getDNI() {
		return DNI;
	}

	public void setDNI(String dNI) {
		DNI = dNI;
	}

	public boolean isListaEspera() {
		return listaEspera;
	}

	public void setListaEspera(boolean listaEspera) {
		this.listaEspera = listaEspera;
	}

	public int getCuota_precolegiado() {
		return cuotaprecolegiado;
	}

	public void setCuota_precolegiado(int cuota_precolegiado) {
		this.cuotaprecolegiado = cuota_precolegiado;
	}

	public int getCuota_colegiado() {
		return cuotacolegiado;
	}

	public void setCuota_colegiado(int cuota_colegiado) {
		this.cuotacolegiado = cuota_colegiado;
	}

	public int getCuota_otros() {
		return cuotaotros;
	}

	public void setCuota_otros(int cuota_otros) {
		this.cuotaotros = cuota_otros;
	}

	public int getId_curso() {
		return id_curso;
	}

	public void setId_curso(int id_curso) {
		this.id_curso = id_curso;
	}


	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}



	public String getFecha_inicio() {
		return fechainicio;
	}

	public void setFecha_inicio(String fecha_inicio) {
		this.fechainicio = fecha_inicio;
	}

	public String getFecha_fin() {
		return fechafin;
	}

	public void setFecha_fin(String fecha_fin) {
		this.fechafin = fecha_fin;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	public int getPlazas() {
		return plazas;
	}

	public void setPlazas(int plazas) {
		this.plazas = plazas;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getApertura_inscripcion() {
		return aperturainscripcion;
	}

	public void setApertura_inscripcion(String apertura_inscripcion) {
		this.aperturainscripcion = apertura_inscripcion;
	}

	public String getCierre_inscripcion() {
		return cierreinscripcion;
	}

	public void setCierre_inscripcion(String cierre_inscripción) {
		this.cierreinscripcion = cierre_inscripción;
	}

	public int getCuota_minusvalido() {
		return cuotaminusvalido;
	}

	public void setCuota_minusvalido(int cuota_minusvalido) {
		this.cuotaminusvalido = cuota_minusvalido;
	}

	public int getCuota_desempleado() {
		return cuotadesempleado;
	}

	public void setCuota_desempleado(int cuota_desempleado) {
		this.cuotadesempleado = cuota_desempleado;
	}

	public int getCuota_empleado() {
		return cuotaempleado;
	}

	public void setCuota_empleado(int cuota_empleado) {
		this.cuotaempleado = cuota_empleado;
	}

	public int getCuota_alumno() {
		return cuotalumno;
	}

	public void setCuota_alumno(int cuota_alumno) {
		this.cuotalumno = cuota_alumno;
	}

	public int getCuota_empresa() {
		return cuotaempresa;
	}

	public void setCuota_empresa(int cuota_empresa) {
		this.cuotaempresa = cuota_empresa;
	}

	public String getFechainicio() {
		return fechainicio;
	}

	public void setFechainicio(String fechainicio) {
		this.fechainicio = fechainicio;
	}

	public String getFechafin() {
		return fechafin;
	}

	public void setFechafin(String fechafin) {
		this.fechafin = fechafin;
	}

	public int getCuotaprecolegiado() {
		return cuotaprecolegiado;
	}

	public void setCuotaprecolegiado(int cuotaprecolegiado) {
		this.cuotaprecolegiado = cuotaprecolegiado;
	}

	public int getCuotacolegiado() {
		return cuotacolegiado;
	}

	public void setCuotacolegiado(int cuotacolegiado) {
		this.cuotacolegiado = cuotacolegiado;
	}

	public int getCuotaotros() {
		return cuotaotros;
	}

	public void setCuotaotros(int cuotaotros) {
		this.cuotaotros = cuotaotros;
	}

	public int getCuotaminusvalido() {
		return cuotaminusvalido;
	}

	public void setCuotaminusvalido(int cuotaminusvalido) {
		this.cuotaminusvalido = cuotaminusvalido;
	}

	public int getCuotadesempleado() {
		return cuotadesempleado;
	}

	public void setCuotadesempleado(int cuotadesempleado) {
		this.cuotadesempleado = cuotadesempleado;
	}

	public int getCuotaempleado() {
		return cuotaempleado;
	}

	public void setCuotaempleado(int cuotaempleado) {
		this.cuotaempleado = cuotaempleado;
	}

	public int getCuotalumno() {
		return cuotalumno;
	}

	public void setCuotalumno(int cuotalumno) {
		this.cuotalumno = cuotalumno;
	}

	public int getCuotaempresa() {
		return cuotaempresa;
	}

	public void setCuotaempresa(int cuotaempresa) {
		this.cuotaempresa = cuotaempresa;
	}

	public String getAperturainscripcion() {
		return aperturainscripcion;
	}

	public void setAperturainscripcion(String aperturainscripcion) {
		this.aperturainscripcion = aperturainscripcion;
	}

	public String getCierreinscripcion() {
		return cierreinscripcion;
	}

	public void setCierreinscripcion(String cierreinscripcion) {
		this.cierreinscripcion = cierreinscripcion;
	}

	public boolean isLista_espera() {
		return listaEspera;
	}

	public void setLista_espera(boolean lista_espera) {
		this.listaEspera = lista_espera;
	}

	public String getFecha_cancelacion() {
		return fecha_cancelacion;
	}

	public void setFecha_cancelacion(String fecha_cancelacion) {
		this.fecha_cancelacion = fecha_cancelacion;
	}

	public int getPorcentaje_devolucion() {
		return porcentaje_devolucion;
	}

	public void setPorcentaje_devolucion(int porcentaje_devolucion) {
		this.porcentaje_devolucion = porcentaje_devolucion;
	}

	public boolean isCancelable() {
		return cancelable;
	}

	public void setCancelable(boolean cancelable) {
		this.cancelable = cancelable;
	}

	public int getSesiones() {
		return sesiones;
	}

	public void setSesiones(int sesiones) {
		this.sesiones = sesiones;
	}


}
