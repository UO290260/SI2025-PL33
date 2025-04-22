package giis.demo.models;

import java.util.List;

import giis.demo.dto.PericialesDTO;
import giis.demo.dto.PeritosDTO;
import giis.demo.util.Database;

public class AsignarPericialesModel {
	private Database db = new Database();
	
		/**
		 * Obtiene la lista de todos los peritos inscritos ordenados por tap
		 * @return La lista de peritos
		 */
		public List<PeritosDTO> getListaPeritos() {
			String sql = "SELECT tap, id_colegiado, correo, telefono, estado FROM Peritos ORDER BY tap";
			return db.executeQueryPojo(PeritosDTO.class, sql);
		}
		
		/**
		 * Obtiene la lista de todas las periciales ordenadas por estado
		 * @return la lista de periciales
		 */
		public List<PericialesDTO> getListaPericiales() {
			String sql = "SELECT id_pericial, solicitante, fecha, urgencia, estado FROM Periciales ORDER BY CASE WHEN estado = 'Pendiente' THEN 0 ELSE 1 END, estado";
			return db.executeQueryPojo(PericialesDTO.class, sql);
		}
		
		/**
		 * Añade a la base de datos la asignación de una pericial a un perito
		 */
		public void añadirAsignacion(int idPerito, int idPericial, String fecha){
			String sql = "INSERT INTO Asignacion (id_perito, id_pericial, fecha, estado) VALUES (?, ?, ?, ?)";
					db.executeUpdate(sql, idPerito, idPericial, fecha, "Asignada");
		}
		
		/**
		 * Función que actualiza el estado de la pericial tras ser asignada y
		 * actualiza el tap del perito
		 */
		public void actualizarTablas(int idPerito, int idPericial) {
			String tapEscogido = "SELECT tap FROM Peritos WHERE id_colegiado = " + idPerito;
			String sqlTapAux = "UPDATE Peritos SET tap = (SELECT MAX(tap)+1 FROM Peritos) WHERE id_colegiado = ?";
			String sqlEstado = "UPDATE Periciales SET estado = ? WHERE id_pericial = ?";
			String sqlResto = "UPDATE Peritos SET tap = (tap - 1) WHERE tap > ?";
			List<PeritosDTO> tap = db.executeQueryPojo(PeritosDTO.class, tapEscogido);
			db.executeUpdate(sqlTapAux, idPerito);
			db.executeUpdate(sqlEstado, "Asignada", idPericial);
			db.executeUpdate(sqlResto, tap.get(0).getTap());
		}
}
