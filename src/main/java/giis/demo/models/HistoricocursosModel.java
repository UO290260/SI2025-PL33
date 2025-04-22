package giis.demo.models;
import java.util.List;

import giis.demo.dto.CursosDTO;
import giis.demo.util.Database;

/**
 * Clase que accede a los datos de los cursos
 */
public class HistoricocursosModel {
	private Database db = new Database();

	/**
	 * Obtiene la lista de cursos que ha cursado/esta cursando un mismo colegiado
	 * @param idColegiado
	 * @return lista de cursos
	 */
	public List<CursosDTO> getListaCursos(String idColegiado) {
		String sql = "SELECT c2.dni, c1.id_curso, c1.titulo, c1.fecha_inicio, c1.fecha_fin, c1.duracion, c1.estado " +
				"FROM Colegiados c2 " +
				"JOIN Inscripciones i ON c2.dni = i.dni " +  
				"JOIN Cursos c1 ON i.id_curso = c1.id_curso " + 
				"WHERE c2.dni = ?";
		return db.executeQueryPojo(CursosDTO.class, sql, idColegiado);
	}

	/**
	 * Obtiene el numero de cursos que ha cursado un colegiado 
	 * @param idColegiado
	 * @return numero de cursos
	 */
	public int getTotalCursos(String idColegiado) {
		String sql = "SELECT COUNT(*) FROM Inscripciones WHERE dni = ?";
		List<Object[]> result = db.executeQueryArray(sql, idColegiado);

		if (!result.isEmpty() && result.get(0)[0] != null) {
			return ((Number) result.get(0)[0]).intValue();
		}
		return 0;
	}

	/**
	 * Obtiene la suma de la cantidad de horas que ha cursado un colegiado 
	 * @param idColegiado
	 * @return 
	 */
	public int getTotalHoras(String idColegiado) {
		String sql = "SELECT SUM(c1.duracion) " +
				"FROM Colegiados c2 " +
				"JOIN Inscripciones i ON c2.dni = i.dni " +
				"JOIN Cursos c1 ON i.id_curso = c1.id_curso " +
				"WHERE c2.dni = ?";

		List<Object[]> result = db.executeQueryArray(sql, idColegiado);

		if (!result.isEmpty() && result.get(0)[0] != null) {
			return ((Number) result.get(0)[0]).intValue();
		}
		return 0;
	}
}