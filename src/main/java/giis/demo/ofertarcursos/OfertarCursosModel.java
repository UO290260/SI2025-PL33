package giis.demo.ofertarcursos;

import java.util.List;

import giis.demo.util.Database;

public class OfertarCursosModel {
	private Database db= new Database();
	
	public static final String SQL_NUEVO_CURSO = 
			"INSERT INTO Cursos (id_curso, titulo, descripcion, fecha_inicio, fecha_fin, duracion, plazas, cuota_precolegiado, cuota_colegiado, cuota_otros, apertura_inscripcion, cierre_inscripcion, estado) "
			+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, NULL, NULL, 'Planificado')";
	
	void añadirCurso(int id, String titulo, String descr, String fini, String ffin, int duracion, int plazas, int cuota_precolegiado, int cuota_colegiado, int cuota_otros) {
		db.executeUpdate(SQL_NUEVO_CURSO, id, titulo, descr, fini, ffin, duracion, plazas, cuota_precolegiado==-1 ? null : cuota_precolegiado, cuota_colegiado==-1 ? null : cuota_colegiado, cuota_otros==-1 ? null : cuota_otros);
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
