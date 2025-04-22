package giis.demo.models;

import java.util.List;

import giis.demo.util.Database;

public class OfertarCursosModel {
	private Database db= new Database();
	
	public static final String SQL_NUEVO_CURSO = 
			"INSERT INTO Cursos (id_curso, titulo, descripcion, fecha_inicio, fecha_fin, duracion, plazas, sesiones, cuota_precolegiado, cuota_colegiado, cuota_minusvalido, cuota_desempleado, cuota_empleado, cuota_alumno, cuota_empresa, cuota_otros, "
			+ "apertura_inscripcion, cierre_inscripcion, cancelable, porcentaje_devolucion, fecha_cancelacion, lista_espera, estado) "
			+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, NULL, NULL, ?, ?, ?, ?, 'Planificado')";
	/**
	 * Consulta para añadir un nuevo curso a la base de datos
	 * @param id
	 * @param titulo
	 * @param descr
	 * @param fini
	 * @param ffin
	 * @param duracion
	 * @param plazas
	 * @param sesiones
	 * @param cuota_precolegiado
	 * @param cuota_colegiado
	 * @param cuota_minusvalido
	 * @param cuota_desempleado
	 * @param cuota_empleado
	 * @param cuota_alumno
	 * @param cuota_empresa
	 * @param cuota_otros
	 */
	public void añadirCurso(int id, String titulo, String descr, String fini, String ffin, int duracion, int plazas, int sesiones, int cuota_precolegiado, int cuota_colegiado, 
			int cuota_minusvalido, int cuota_desempleado, int cuota_empleado, int cuota_alumno, int cuota_empresa,  int cuota_otros, boolean cancelable, int porcentaje, String fcancel, boolean espera) {
		db.executeUpdate(SQL_NUEVO_CURSO, id, titulo, descr, fini, ffin, duracion, plazas, sesiones, 
				cuota_precolegiado==-1 ? null : cuota_precolegiado, cuota_colegiado==-1 ? null : cuota_colegiado, cuota_minusvalido==-1 ? null : cuota_minusvalido,
						cuota_desempleado==-1 ? null : cuota_desempleado, cuota_empleado==-1 ? null : cuota_empleado, cuota_alumno==-1 ? null : cuota_alumno,
								cuota_empresa==-1 ? null : cuota_empresa, cuota_otros==-1 ? null : cuota_otros, cancelable, porcentaje==-1 ? null : cuota_empresa, fcancel, espera);
	}
	
	/**
	 * Metodo para generar la id de un elemento introducido en la base de datos
	 * @return la nueva id
	 */
	public int incrementarID() {
		String sql = "SELECT MAX(id_curso) FROM Cursos";
		List<Object[]> resultado = db.executeQueryArray(sql);
		if (resultado.isEmpty() || resultado.get(0)[0]==null)
			return 1;
		else 
			return ((Number) resultado.get(0)[0]).intValue() + 1;
	}
}
