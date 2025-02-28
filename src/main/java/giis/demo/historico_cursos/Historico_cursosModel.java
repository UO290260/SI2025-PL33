package giis.demo.historico_cursos;

import java.util.List;

import giis.demo.util.Database;

public class Historico_cursosModel {

	private Database db = new Database();
	/**
	 * Consulta para buscar los cursos de un mismo colegiado
	 * @param idColegiado
	 * @return
	 */
	public List<Historico_cursosDTO> getListaCursos(int idColegiado) {
		String sql = "SELECT c2.id_colegiado, c1.id_curso, c1.titulo, c1.fecha_inicio, c1.fecha_fin, c1.duracion, c1.estado " +
				"FROM Colegiados c2 " +
				"JOIN Inscripciones i ON c2.id_colegiado = i.id_colegiado " +  
				"JOIN Cursos c1 ON i.id_curso = c1.id_curso " + 
				"WHERE c2.id_colegiado = ?";
		return db.executeQueryPojo(Historico_cursosDTO.class, sql, idColegiado);
	}

	/**
	 * Consulta para contar cuantos cursos ha cursado un colegiado
	 * @param idColegiado
	 * @return
	 */
	public int getTotalCursos(int idColegiado) {
		String sql = "SELECT COUNT(*) FROM Inscripciones WHERE id_colegiado = ?";
		List<Object[]> result = db.executeQueryArray(sql, idColegiado);

		if (!result.isEmpty() && result.get(0)[0] != null) {
			return ((Number) result.get(0)[0]).intValue();
		}
		return 0;
	}

	/**
	 * Consulta para sumar el total de horas que ha realizado un colegiado
	 * @param idColegiado
	 * @return
	 */
	public int getTotalHoras(int idColegiado) {
		String sql = "SELECT SUM(c1.duracion) " +
				"FROM Colegiados c2 " +
				"JOIN Inscripciones i ON c2.id_colegiado = i.id_colegiado " +
				"JOIN Cursos c1 ON i.id_curso = c1.id_curso " +
				"WHERE c2.id_colegiado = ?";

		List<Object[]> result = db.executeQueryArray(sql, idColegiado);

		if (!result.isEmpty() && result.get(0)[0] != null) {
			return ((Number) result.get(0)[0]).intValue();
		}

		return 0;
	}

}
