package giis.demo.visualizarcursos;

import java.util.List;

import giis.demo.util.Database;

public class VisualizarCursosModel {
private Database db= new Database();
	
	public List<VisualizarCursosDTO> getListaCursos(String colectivo) {
		String sql = "SELECT * FROM Cursos WHERE " + colectivo + " NOT NULL";
		return db.executeQueryPojo(VisualizarCursosDTO.class, sql);
	}
	
	public List<VisualizarCursosDTO> getTodosCursos() {
		String sql = "SELECT * FROM Cursos";
		return db.executeQueryPojo(VisualizarCursosDTO.class, sql);
	}
}
