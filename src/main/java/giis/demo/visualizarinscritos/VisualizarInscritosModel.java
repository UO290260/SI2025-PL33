package giis.demo.visualizarinscritos;

import java.util.List;

import giis.demo.util.Database;

public class VisualizarInscritosModel {
private Database db= new Database();
	
	/**
	 * Consulta que selecciona los campos de los inscritos y sus inscripciones correspondientes
	 * @param id_curso
	 * @return Lista de los datos de la consulta en formato InscripcionDTO
	 */
	public List<InscripcionDTO> getListaInscritos(int id_curso) {
		String sql = "SELECT i.id_inscripcion, "
		           + "COALESCE(c.nombre, e.nombre) AS nombre, "
		           + "COALESCE(c.apellidos, e.apellidos) AS apellidos, "
		           + "i.dni, i.estado "
		           + "FROM Inscripciones AS i "
		           + "LEFT JOIN Colegiados AS c ON i.dni = c.dni "
		           + "LEFT JOIN Externos AS e ON i.dni = e.dni "
		           + "WHERE i.id_curso = " + id_curso+ " "
				   + "AND i.lista_espera=FALSE;";
		return db.executeQueryPojo(InscripcionDTO.class, sql);
	}
	
	/**
	 * Consulta que selecciona los campos de las lista de espera y sus inscripciones correspondientes
	 * @param id_curso
	 * @return Lista de los datos de la consulta en formato InscripcionDTO
	 */
	public List<InscripcionDTO> getListaEspera(int id_curso) {
		String sql = "SELECT i.id_inscripcion, "
		           + "COALESCE(c.nombre, e.nombre) AS nombre, "
		           + "COALESCE(c.apellidos, e.apellidos) AS apellidos, "
		           + "i.dni, i.posicion, i.estado "
		           + "FROM Inscripciones AS i "
		           + "LEFT JOIN Colegiados AS c ON i.dni = c.dni "
		           + "LEFT JOIN Externos AS e ON i.dni = e.dni "
		           + "WHERE i.id_curso = " + id_curso+ " "
				   + "AND i.lista_espera=TRUE "
				   + "ORDER BY i.posicion ASC;";
		return db.executeQueryPojo(InscripcionDTO.class, sql);
	}
	
	/**
	 * Consulta que selecciona todos los cursos de la base de datos
	 * @return lista de los cursos en formato CursoDTO
	 */
	public List<CursoDTO> getListaCursos() {
		String sql = "SELECT id_curso, titulo, descripcion, estado FROM Cursos";
		return db.executeQueryPojo(CursoDTO.class, sql);
	}
}
