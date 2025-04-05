package giis.demo.asignarpericiales;

import java.util.List;
import giis.demo.util.Database;

public class AsignarPericialesModel {
	private Database db = new Database();
	
	//Obtiene la lista de todos los peritos inscritos
		public List<PeritoDTO> getListaPeritos() {
			String sql = "SELECT tap, id_colegiado, correo, telefono, estado FROM Peritos ORDER BY tap";
			return db.executeQueryPojo(PeritoDTO.class, sql);
		}
		
		//Obtiene la lista de todas las periciales
		public List<PericialDTO> getListaPericiales() {
			String sql = "SELECT id_pericial, solicitante, fecha, urgencia, estado FROM Periciales";
			return db.executeQueryPojo(PericialDTO.class, sql);
		}
		
		public void añadirAsignacion(int idPerito, int idPericial, String fecha){
			String sql = "INSERT INTO Asignacion (?, ?, ?, Asignada)";
			db.executeUpdate(sql, idPerito, idPericial, fecha);
		}
}
