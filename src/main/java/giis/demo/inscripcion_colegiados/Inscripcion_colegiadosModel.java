package giis.demo.inscripcion_colegiados;

import giis.demo.util.Database;

public class Inscripcion_colegiadosModel {

	private Database db = new Database();
	
	public void insertarColegiado () {
		String lista = "INSERT INTO llamadas Colegiados (id_colegiado, nombre, apellidos, DNI, direccion, poblacion, fecha_nacimiento, cuenta_bancaria, titulacion, fecha_colegiacion) VALUES"
				+ " (?, ?, ?, ?, ?, ?, ? , ? , ? , ?)";
	}
	

}
