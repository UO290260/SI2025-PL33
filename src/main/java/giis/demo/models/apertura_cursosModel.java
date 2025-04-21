package giis.demo.models;

import java.util.List;

import giis.demo.dto.CursosDTO;
import giis.demo.util.Database;


public class apertura_cursosModel {
	
private Database db= new Database();
	
	public List<CursosDTO> getListacursos(){
		String sql="SELECT id_curso, titulo, descripcion, fecha_inicio, fecha_fin, duracion, plazas,cuota_precolegiado, cuota_colegiado, cuota_otros, apertura_inscripcion, cierre_inscripcion, estado "+
				"FROM Cursos "+
				"Where estado='Planificado'";
		 List<CursosDTO> rows=db.executeQueryPojo(CursosDTO.class,sql); //Envia en forma de List CursoDTO la consulta sql
		 return rows;
	}
	
	public void AbrirCurso(int idCurso,String fecha_apertura,String fecha_cierre) {
		String sql1 = "UPDATE Cursos SET estado = 'Disponible', apertura_inscripcion = ?, cierre_inscripcion = ? WHERE id_curso = ?;";
		db.executeUpdate(sql1,fecha_apertura,fecha_cierre,idCurso);
	}

}
