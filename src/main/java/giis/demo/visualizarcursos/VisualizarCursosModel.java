package giis.demo.visualizarcursos;

import java.util.List;

import giis.demo.util.Database;

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
}
