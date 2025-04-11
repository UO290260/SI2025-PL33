package giis.demo.generarrecibos;

import java.util.List;
import giis.demo.util.Database;

public class GenerarrecibosModel {

	private Database db = new Database();
	/**
	 * Obtener lista de colegiados pendientes
	 * @return
	 */
	public List<ColegiadosRecibosDTO> getListaColegiados() {
		String sql = "SELECT id_colegiado, nombre, apellidos, DNI, titulacion, estado FROM Colegiados WHERE estado = 'Aprobada'";
		return db.executeQueryPojo(ColegiadosRecibosDTO.class, sql);
	}

	public List<RecibosDTO> getListaRecibos() {
	    String sql = "SELECT id_recibo, DNI, cuota_pagar, fecha_recibo, estado FROM Recibos WHERE estado = 'Emitido'";

	    // Ejecuta la consulta y mapea los resultados a objetos de tipo RecibosDTO
	    return db.executeQueryPojo(RecibosDTO.class, sql);
	}
	
	public void actualizarEstadoColegiadoReal(ColegiadosRecibosDTO colegiado, String estado) {
		String sql = "UPDATE Colegiados SET estado = ? WHERE id_colegiado = ?";
		db.executeUpdate(sql, estado, colegiado.getId_colegiado());
	}
	
	public void actualizarEstadoRecibo(String dni, String estado) {
		String sql = "UPDATE Recibos SET estado = ? WHERE DNI = ?";
		db.executeUpdate(sql, estado, dni);
	}
	
}