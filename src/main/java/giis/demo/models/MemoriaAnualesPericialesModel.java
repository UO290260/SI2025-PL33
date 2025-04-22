package giis.demo.models;

import java.util.List;

import giis.demo.dto.PericialesDTO;
import giis.demo.util.Database;

public class MemoriaAnualesPericialesModel {
	private Database db= new Database();
	
	public List<PericialesDTO> cargarPericiales(String anio,String estado)
	{
		String sql1="SELECT p.id_pericial,a.id_perito,c.nombre, p.solicitante, p.fecha, p.urgencia, p.estado "
					+ "FROM Periciales AS p "
					+ "LEFT JOIN Asignacion a ON p.id_pericial = a.id_pericial "
					+ "LEFT JOIN Peritos pt ON a.id_perito = pt.id_colegiado "
					+ "LEFT JOIN Colegiados c ON pt.id_colegiado = c.id_colegiado "
					+ "WHERE strftime('%Y', p.fecha)=? AND (?='Todos' OR p.estado=?);";
		return db.executeQueryPojo(PericialesDTO.class,sql1,anio,estado,estado);
	}
}
