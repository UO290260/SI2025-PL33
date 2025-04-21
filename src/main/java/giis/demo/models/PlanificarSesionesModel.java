package giis.demo.models;

import java.util.List;

import giis.demo.dto.CursosDTO;
import giis.demo.dto.SesionDTO;
import giis.demo.util.Database;

public class PlanificarSesionesModel {
	Database db = new Database();
	
	/**
	 * Consulta que selecciona todos los cursos de la base de datos
	 * @return lista de los cursos en formato CursoDTO
	 */
	public List<CursosDTO> getListaCursos() {
		String sql = "SELECT id_curso, titulo, descripcion, fecha_inicio, fecha_fin, sesiones, estado FROM Cursos";
		return db.executeQueryPojo(CursosDTO.class, sql);
	}
	
	/**
	 * Consulta para introducir en la base de datos una nueva sesion
	 * @param id
	 * @param idcurso
	 * @param fecha
	 * @param hora
	 * @param duracion
	 */
	public void añadirSesion(int id, int idcurso, String fecha, String hora, int duracion) {
		String sql = "INSERT INTO Sesiones (id_sesion, id_curso, fecha, hora_inicio, duracion) VALUES (?, ?, ?, ?, ?)";
		db.executeUpdate(sql, id, idcurso, fecha, hora, duracion);
	}
	
	/**
	 * Funcion que obtiene todas las sesiones planificadas para un curso
	 * @param idCurso: id del curso del que queremos obtener las sesiones
	 * @return
	 */
	public List<SesionDTO> listaSesiones(int idCurso) {
		String sql = "SELECT id_sesion, id_curso, fecha, hora_inicio, duracion FROM Sesiones WHERE id_curso = " + idCurso;
		return db.executeQueryPojo(SesionDTO.class, sql);
	}
	
	/**
	 * Metodo para generar la id de un elemento introducido en la base de datos
	 * @return la nueva id
	 */
	public int incrementarID() {
		String sql = "SELECT MAX(id_sesion) FROM Sesiones";
		List<Object[]> resultado = db.executeQueryArray(sql);
		if (resultado.isEmpty() || resultado.get(0)[0]==null)
			return 1;
		else 
			return ((Number) resultado.get(0)[0]).intValue() + 1;
	}
}
