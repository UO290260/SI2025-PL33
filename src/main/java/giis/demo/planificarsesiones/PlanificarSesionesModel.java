package giis.demo.planificarsesiones;

import java.util.List;

import giis.demo.util.Database;
import giis.demo.visualizarinscritos.CursoDTO;

public class PlanificarSesionesModel {
	Database db = new Database();
	
	/**
	 * Consulta que selecciona todos los cursos de la base de datos
	 * @return lista de los cursos en formato CursoDTO
	 */
	public List<CursoDTO> getListaCursos() {
		String sql = "SELECT id_curso, titulo, descripcion, estado FROM Cursos";
		return db.executeQueryPojo(CursoDTO.class, sql);
	}
	
	/**
	 * Consulta para introducir en la base de datos una nueva sesion
	 * @param id
	 * @param idcurso
	 * @param fecha
	 * @param hora
	 * @param duracion
	 */
	public void añadirSesion(int id, int idcurso, String fecha, int hora, int duracion) {
		String sql = "INSERT INTO Sesiones (id_sesion, id_curso, fecha, hora_inicio, duracion) VALUES (?, ?, ?, ?, ?)";
		db.executeUpdate(sql, id, idcurso, fecha, hora, duracion);
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
