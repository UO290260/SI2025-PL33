package giis.demo.generarrecibos;
import java.util.List;
import giis.demo.util.Database;

public class GenerarrecibosModel {
	private Database db = new Database();

	/**
	 * Obtiene la lista de colegiados con estado 'Aprobada' y recibos con estado 'No Emitido'.
	 * @return
	 */
	public List<ColegiadosRecibosDTO> getListaColegiados() {
		String sql = "SELECT c.id_colegiado, c.nombre, c.apellidos, c.DNI, r.cuota_pagar, c.cuenta_bancaria, c.estado " +
				"FROM Colegiados c " +
				"JOIN Recibos r ON c.DNI = r.DNI " +
				"WHERE c.estado = 'Aprobada' AND r.estado = 'No Emitido'";
		return db.executeQueryPojo(ColegiadosRecibosDTO.class, sql);
	}

	/**
	 * Obtencion de la lista de recibos con estado emitido
	 * @return
	 */
	public List<ColegiadosRecibosDTO> getListaRecibos() {
		String sql = "SELECT r.id_recibo, c.nombre, c.apellidos, c.DNI, r.cuota_pagar, r.fecha_recibo, c.cuenta_bancaria, r.estado " +
				"FROM Recibos r " +
				"JOIN Colegiados c ON r.DNI = c.DNI " +
				"WHERE r.estado = 'Emitido'";
		return db.executeQueryPojo(ColegiadosRecibosDTO.class, sql);
	}

	/**
	 * Actualiza el estado de un recibo
	 * @param dni
	 * @param estado
	 */
	public void actualizarEstadoRecibo(String dni, String estado) {
		String sql = "UPDATE Recibos SET estado = ? WHERE DNI = ?";
		db.executeUpdate(sql, estado, dni);
	}
}