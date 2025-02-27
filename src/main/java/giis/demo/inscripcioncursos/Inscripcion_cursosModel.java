package giis.demo.inscripcioncursos;

import java.util.List;

import giis.demo.util.Database;






public class Inscripcion_cursosModel {
	
	private Database db= new Database();
	
	public static final String SQL_LISTA_DE_CURSOS="SELECT id_curso,fecha_inicio,plazas"+
	"FROM Cursos"+
	"Where estado='Disponible'";
	
	public List<Object[]> getListacursos(){
		String sql="SELECT id_curso || '-' || fecha_inicio || ' ' || plazas as item from (" + SQL_LISTA_DE_CURSOS + ")";
		return db.executeQueryArray(sql);
	}
		

}
