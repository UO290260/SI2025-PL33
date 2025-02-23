package giis.demo.inscripcion_colegiados;

import java.util.List;

import giis.demo.util.Database;

public class Inscripcion_colegiadosModel {

	private Database db = new Database();

	/**
	 * Lista de Colegiados 
	 * @return
	 */
	public List<Inscripcion_colegiadosDTO> getListaColegiados() {
		String sql = "SELECT id_colegiado, nombre, apellidos, DNI, direccion, poblacion, fecha_nacimiento, cuenta_bancaria, titulacion, fecha_colegiacion FROM Colegiados";
		return db.executeQueryPojo(Inscripcion_colegiadosDTO.class, sql);
	}
	
	/**
	 * 	Insertar el Colegiado
	 * @param colegiado
	 */
	public void insertarColegiado(Inscripcion_colegiadosDTO colegiado) {
		String sql = "INSERT INTO Colegiados (nombre, apellidos, DNI, direccion, poblacion, fecha_nacimiento, cuenta_bancaria, titulacion, fecha_colegiacion) " + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
		db.executeUpdate(sql, colegiado.getNombre(),colegiado.getApellidos(),colegiado.getDNI(),colegiado.getDireccion(),colegiado.getPoblacion(),colegiado.getFecha_nacimiento(),colegiado.getCuenta_bancaria(),colegiado.getTitulacion(),colegiado.getFecha_colegiacion());
	}

}
