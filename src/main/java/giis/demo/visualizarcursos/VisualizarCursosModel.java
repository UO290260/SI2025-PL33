package giis.demo.visualizarcursos;

import java.util.List;
import giis.demo.util.Database;
import giis.demo.visualizarinscritos.InscripcionDTO;

public class VisualizarCursosModel {
private Database db= new Database();
	
 	//Obtiene la lista de cursos para el colectivo seleccionado
	public List<VisualizarCursosDTO> getListaCursos(String colectivo) {
		String sql = "SELECT * FROM Cursos WHERE " + colectivo + " NOT NULL";
		return db.executeQueryPojo(VisualizarCursosDTO.class, sql);
	}
	
	//Obtiene la lista de todos los cursos
	public List<VisualizarCursosDTO> getTodosCursos() {
		String sql = "SELECT * FROM Cursos";
		return db.executeQueryPojo(VisualizarCursosDTO.class, sql);
	}
	
	/**
	 * Función que actualiza el estado de un curso a "Cancelado"
	 * @param id del curso a cancelar
	 */
	public void cancelarCurso(int idCurso) {
		String sqlCurso = "UPDATE Cursos SET estado = ? WHERE id_curso = ?";
		db.executeUpdate(sqlCurso, "Cancelado", idCurso);
	}
	
	/**
	 * Función que establece la cantidad de dinero a devolver al cancelar un curso
	 * @param idCurso: id del curso cancelado
	 */
	public void actualizarInscritos(int idCurso) {
		String sqlEstado = "UPDATE Inscripciones SET estado = ? WHERE id_curso = ?";
		db.executeUpdate(sqlEstado, "Cancelado", idCurso);
	}
	
	/**
	 * Funcion para obtener la lista de inscritos del curso seleccionado
	 * @param id_curso: la id del curso seleccionado
	 * @return la lista de inscritos a un curso
	 */
	public List<InscripcionDTO> getListaInscritos(int id_curso) {
		String sql = "SELECT i.id_inscripcion, "
		           + "COALESCE(c.nombre, e.nombre) AS nombre, "
		           + "COALESCE(c.apellidos, e.apellidos) AS apellidos, "
		           + "i.dni, i.estado "
		           + "FROM Inscripciones AS i "
		           + "LEFT JOIN Colegiados AS c ON i.dni = c.dni "
		           + "LEFT JOIN Externos AS e ON i.dni = e.dni "
		           + "WHERE i.id_curso = " + id_curso + " "
				   + "AND i.lista_espera=FALSE;";
		return db.executeQueryPojo(InscripcionDTO.class, sql);
	}
}
