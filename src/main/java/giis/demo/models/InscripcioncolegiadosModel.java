package giis.demo.models;
import java.util.List;
import javax.swing.JOptionPane;

import giis.demo.dto.ColegiadosDTO;
import giis.demo.util.Database;

/**
 *Clase que accede a los datos de los colegiados  
 */
public class InscripcioncolegiadosModel {
	private Database db = new Database();

	/**
	 * Obtiene toda la informacion de la lista de colegiados necesaria
	 */
	public List<ColegiadosDTO> getListaColegiados() {
		String sql = "SELECT id_colegiado, nombre, apellidos, DNI, direccion, poblacion, fecha_nacimiento, cuenta_bancaria, titulacion, fecha_colegiacion , estado FROM Colegiados";
		return db.executeQueryPojo(ColegiadosDTO.class, sql);
	}

	/**
	 * Metodo que inserta en la base de datos el colegiado
	 * @param colegiado
	 */
	public void insertarColegiado(ColegiadosDTO colegiado) {
		if (dniExiste(colegiado.getDni())) {
			JOptionPane.showMessageDialog(null, "El DNI ya existe en la base de datos");
			return;
		}
		colegiado.setEstado("Pendiente");
		String sql="INSERT INTO Colegiados (id_colegiado ,nombre, apellidos, DNI, direccion, poblacion, fecha_nacimiento, cuenta_bancaria, titulacion, fecha_colegiacion ,estado) " + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ? , ?)";
		int nuevoId= incrementarID();
		colegiado.setId_colegiado(nuevoId);
		db.executeUpdate(sql,nuevoId,colegiado.getNombre(),colegiado.getApellidos(),colegiado.getDni(),colegiado.getDireccion(),colegiado.getPoblacion(),colegiado.getFecha_nacimiento(),colegiado.getCuenta_bancaria(),colegiado.getTitulacion(),colegiado.getFecha_colegiacion(),colegiado.getEstado());
	}

	/**
	 * Metodo que comprueba si el DNI del colegiado esta en la base de datos
	 * @param dni
	 */
	public boolean dniExiste(String dni) {
		String sql = "SELECT COUNT(*) FROM Colegiados WHERE DNI = ?";
		List<Object[]> result = db.executeQueryArray(sql, dni);
		//Si es mayor a 0 retornara true , en caso contrario false
		return ((Number) result.get(0)[0]).intValue() > 0;
	}
	
	/**
	 * Añadido para el Test
	 * @param dni
	 * @return
	 */
	public boolean dniExiste2(String dni) {
		String sql = "SELECT COUNT(*) FROM Colegiados WHERE DNI = ?";
		List<Object[]> result = db.executeQueryArray(sql, dni);
		return ((Number) result.get(0)[0]).intValue() > 1; 
	}

	/**
	 * Metodo que comprueba el numero maximo de los colegiados y lo aumenta en 1 para asignarle ese numero al colegiado
	 * @return
	 */
	public int incrementarID() {
		String sql = "SELECT MAX(id_colegiado) FROM Colegiados";
		List<Object[]> resultado = db.executeQueryArray(sql);

		if (resultado.isEmpty() || resultado.get(0)[0] == null) {
			return 1;
		} else {
			return ((Number) resultado.get(0)[0]).intValue() + 1;
		}
	}
}