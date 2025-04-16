package giis.demo.generarrecibos;
import java.util.List;
import giis.demo.inscripcioncolegiados.InscripcioncolegiadosDTO;
import giis.demo.util.Database;

public class GenerarrecibosModel {
	private Database db = new Database();

	/**
	 * Obtiene la lista de colegiados con estado 'Aprobada' y recibos con estado 'No Emitido'.
	 * @return
	 */
	public List<InscripcioncolegiadosDTO> getListaColegiados() {
		String sql = "SELECT c.id_colegiado, c.nombre, c.apellidos, c.DNI, r.cuota_pagar, c.cuenta_bancaria, c.estado " +
				"FROM Colegiados c " +
				"JOIN Recibos r ON c.DNI = r.DNI " +
				"WHERE c.estado = 'Aprobada' AND r.estado = 'No Emitido'";
		return db.executeQueryPojo(InscripcioncolegiadosDTO.class, sql);
	}

	/**
	 * Obtencion de la lista de recibos con estado emitido
	 * @return
	 */
	public List<RecibosDTO> getListaRecibos() {
		String sql = "SELECT r.id_recibo, c.nombre, c.apellidos, c.DNI, r.cuota_pagar, r.fecha_recibo, c.cuenta_bancaria, r.estado " +
				"FROM Recibos r " +
				"JOIN Colegiados c ON r.DNI = c.DNI " +
				"WHERE r.estado = 'Emitido'";
		return db.executeQueryPojo(RecibosDTO.class, sql);
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
	
	/**
	 * Actualiza todos los campos del recibo
	 * @param recibo
	 */
	public void actualizarRecibo(RecibosDTO recibo) {
	    String sql = "UPDATE Recibos SET cuota_pagar = ?, fecha_recibo = ?, estado = ? WHERE DNI = ?";
	    db.executeUpdate(sql,recibo.getCuota_pagar(),recibo.getFecha_recibo(),recibo.getEstado(),recibo.getDNI());
	}
	
	/**
	 * Buscar la cuota asignada al colegiado
	 * @param DNI
	 * @return
	 */
	public int obtenerCuota(String DNI) {
	    String sql = "SELECT cuota_pagar FROM Recibos WHERE DNI = ?";  
	    List<RecibosDTO> recibos = db.executeQueryPojo(RecibosDTO.class, sql, DNI);
	    return recibos.get(0).getCuota_pagar();  
	}
}