package giis.demo.solicitudcolegiado;
import java.util.List;
import giis.demo.util.Database;

public class SolicitudColegiadoModel {
	private Database db = new Database();

	/**
	 * Obtener lista de colegiados pendientes
	 * @return
	 */
	public List<ColegiadoDTO> getListaPendientes() {
		String sql = "SELECT id_colegiado, nombre, apellidos, DNI, titulacion, estado FROM Colegiados WHERE estado = 'Pendiente'";
		return db.executeQueryPojo(ColegiadoDTO.class, sql);
	}

	/**
	 * Obtener lista de colegiados enviados
	 * @return
	 */
	public List<ColegiadoDTO> getListaColegiadosEnviados() {
		String sql = "SELECT id_colegiado, nombre, apellidos, DNI, titulacion, estado FROM Colegiados WHERE estado = 'Enviado'";
		return db.executeQueryPojo(ColegiadoDTO.class, sql);
	}

	/**
	 * Actualizar el estado del colegiado
	 * @param colegiado
	 * @param estado
	 */
	public void actualizarEstadoColegiado(ColegiadoDTO colegiado, String estado) {
		String sql = "UPDATE Colegiados SET estado = ? WHERE DNI = ?";
		db.executeUpdate(sql, estado, colegiado.getDNI());
	}
}