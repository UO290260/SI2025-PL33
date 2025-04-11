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
	public List<ColegiadoDTO> getListaColegiadosAprobadosCancelados() {
		String sql = "SELECT id_colegiado, nombre, apellidos, DNI, titulacion, estado FROM Colegiados WHERE estado IN ('Aprobada', 'Cancelado')";
		return db.executeQueryPojo(ColegiadoDTO.class, sql);
	}
}