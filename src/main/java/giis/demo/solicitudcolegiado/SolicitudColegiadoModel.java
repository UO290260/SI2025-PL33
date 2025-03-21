package giis.demo.solicitudcolegiado;

import java.util.List;

import giis.demo.util.Database;

public class SolicitudColegiadoModel {

	private Database db = new Database();
	

	public List<ColegiadoDTO> getListaPendientes() {
		String sql = "SELECT id_colegiado, nombre, apellidos, DNI, direccion, poblacion, fecha_nacimiento, cuenta_bancaria, titulacion, fecha_colegiacion, estado "
				+ "FROM Colegiados WHERE estado = 'Pendiente'";
		return db.executeQueryPojo(ColegiadoDTO.class, sql);
	}
}

