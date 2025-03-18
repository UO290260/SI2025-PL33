package giis.demo.visualizarinscritos;

import java.util.List;

import giis.demo.util.Database;

public class VisualizarInscritosModel {
private Database db= new Database();
	
	public List<InscripcionDTO> getListaInscritos(int id_curso) {
		String sql = "SELECT i.id_inscripcion, c.nombre, c.apellidos, c.dni, i.estado FROM Colegiados "
				+ "AS c INNER JOIN Inscripciones AS i USING(id_colegiado) WHERE i.id_curso = " + id_curso;
		return db.executeQueryPojo(InscripcionDTO.class, sql);
	}
	
	public List<CursoDTO> getListaCursos() {
		String sql = "SELECT id_curso, titulo, descripcion, estado FROM Cursos";
		return db.executeQueryPojo(CursoDTO.class, sql);
	}
}
