package giis.demo.ofertar_cursos;

import java.util.Date;
import java.util.List;

import giis.demo.util.ApplicationException;
import giis.demo.util.Database;

public class OfertarCursosModel {
	private Database db= new Database();
	
	public static final String SQL_NUEVO_CURSO = 
			"INSERT INTO Cursos (id_curso, titulo, descripcion, fecha_inicio, fecha_fin, duracion, plazas, cuota_precolegiado, cuota_colegiado, cuota_otros, estado) "
			+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, 'Planificado')";
	
	void añadirCurso(int id, String titulo, String descr, String fini, String ffin, int duracion, int plazas, int cuota_precolegiado, int cuota_colegiado, int cuota_otros) {
		db.executeUpdate(SQL_NUEVO_CURSO, id, titulo, descr, fini, ffin, duracion, plazas, cuota_precolegiado, cuota_colegiado, cuota_otros);
	}
	
	private void validateCondition(boolean condition, String message) {
		if (!condition)
			throw new ApplicationException(message);
	}
	
	public int incrementarID() {
		String sql = "SELECT MAX(id_curso) FROM Cursos";
		List<Object[]> resultado = db.executeQueryArray(sql);
		if (resultado.isEmpty() || resultado.get(0)[0]==null)
			return 1;
		else 
			return ((Number) resultado.get(0)[0]).intValue() +1;
	}
}
