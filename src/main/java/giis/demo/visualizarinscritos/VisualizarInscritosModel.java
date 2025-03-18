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
		String sql = "SELECT i.id_inscripcion, c.nombre, c.apellidos, c.dni, i.estado FROM Colegiados "
				+ "AS c INNER JOIN Inscripciones AS i USING(id_colegiado) WHERE i.id_curso = " + id_curso;
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
