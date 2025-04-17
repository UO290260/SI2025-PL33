package giis.demo.models;
import java.util.Date;
import java.util.List;

import giis.demo.dto.ColegiadosDTO;
import giis.demo.util.Database;
import giis.demo.util.Util;

public class SolicitudColegiadoModel {
	private Database db = new Database();

	/**
	 * Obtener lista de colegiados pendientes
	 * @return
	 */
	public List<ColegiadosDTO> getListaPendientes() {
		String sql = "SELECT id_colegiado, nombre, apellidos, DNI, titulacion, estado FROM Colegiados WHERE estado = 'Pendiente'";
		return db.executeQueryPojo(ColegiadosDTO.class, sql);
	}

	/**
	 * Obtener lista de colegiados enviados
	 * @return
	 */
	public List<ColegiadosDTO> getListaColegiadosEnviados() {
		String sql = "SELECT id_colegiado, nombre, apellidos, DNI, titulacion, estado FROM Colegiados WHERE estado = 'Enviado'";
		return db.executeQueryPojo(ColegiadosDTO.class, sql);
	}

	/**
	 * Actualizar el estado del colegiado
	 * @param colegiado
	 * @param estado
	 */
	public void actualizarEstadoColegiado(ColegiadosDTO colegiado, String estado) {
		String sql = "UPDATE Colegiados SET estado = ? WHERE DNI = ?";
		db.executeUpdate(sql, estado, colegiado.getDni());
	}

	/**
	 * Metodo que comprueba si se existen colegiados repetidos con diferente estado a enviado
	 * @param dni
	 * @return
	 */
	public boolean dniEstado(String dni) {
		String sql = "SELECT COUNT(*) FROM Colegiados WHERE DNI = ? AND estado != 'Enviado'";
		List<Object[]> result = db.executeQueryArray(sql, dni);
		//Si es mayor a 0 retornara true , en caso contrario false
		return ((Number) result.get(0)[0]).intValue() > 0;
	}

	/**
	 * Obtener la lista de colegiados con estado Aprobados y Cancelados
	 * @return
	 */
	public List<ColegiadosDTO> getListaColegiadosAprobadosCancelados() {
		String sql = "SELECT id_colegiado, nombre, apellidos, DNI, titulacion, estado FROM Colegiados WHERE estado IN ('Aprobada', 'Cancelado')";
		return db.executeQueryPojo(ColegiadosDTO.class, sql);
	}

	/**
	 * Metodo que incremneta en uno el numero de los recibos
	 * @return
	 */
	private int incrementarIDRecibo() {
		String sql = "SELECT MAX(id_recibo) FROM Recibos";
		List<Object[]> result = db.executeQueryArray(sql);

		if (result.isEmpty() || result.get(0)[0] == null) {
			return 1;
		} else {
			return ((Number) result.get(0)[0]).intValue() + 1;
		}
	}

	/**
	 * Metodo que inserta en la base de datos un recibo
	 * @param colegiado
	 */
	public void insertarRecibo(ColegiadosDTO colegiado) {
		String sql = "INSERT INTO Recibos (id_recibo, DNI, cuota_pagar, fecha_recibo, estado) VALUES (?, ?, ?, ?, ?)";
		int nuevoId = incrementarIDRecibo();
		int num_random = (int)(Math.random() * 100);
		double cuota;
		if (num_random < 50) {
			cuota = 100.00;
		} else {
			cuota = 200.00;
		}
		String estado = "No Emitido";
		String fecha_recibo2 = Util.dateToIsoString(new Date());
		db.executeUpdate(sql, nuevoId, colegiado.getDni(), cuota, fecha_recibo2, estado);
	}
}