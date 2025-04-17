package giis.demo.models;
import java.util.List;

import giis.demo.dto.ColegiadosDTO;
import giis.demo.dto.PeritosDTO;
import giis.demo.util.Database;

public class InscripcionlistaTAPModel {
	private Database db = new Database();

	/**
	 * Metodo para obtener los datos de un colegiado
	 * @param idColegiado
	 * @return
	 */
	public ColegiadosDTO getColegiadoPorID(int idColegiado) {
		String sql = "SELECT * FROM Colegiados WHERE id_colegiado = ?";
	    List<ColegiadosDTO> lista = db.executeQueryPojo(ColegiadosDTO.class, sql, idColegiado);
	    if (lista.isEmpty()) {
	        return null;  
	    } else {
	        return lista.get(0);
	    }
	}
	
	/**
	 * Metodo que inserta al Perito en la base de datos y añade el estado "Pendiente"
	 * @param colegiado
	 * @param perito
	 */
	public void insertarPerito(ColegiadosDTO colegiado, PeritosDTO perito) {
		perito.setEstado("Pendiente");
		int nuevoTap = incrementarTap();
		String sql = "INSERT INTO Peritos (id_colegiado, correo, telefono, fecha, año, tap, estado) VALUES (?, ?, ?, ?, ?, ?, ?)";
		db.executeUpdate(sql,colegiado.getId_colegiado(),perito.getCorreo(),perito.getTelefono(),perito.getFecha(),perito.getAño(),nuevoTap,perito.getEstado());
	}

	/**
	 * Metodo que busca el maximo del tap y si lo encuentra lo aumenta en 1 y sino empieza en 1
	 * @return
	 */
	public int incrementarTap() {
		String sql = "SELECT MAX(tap) FROM Peritos";
		List<Object[]> resultado = db.executeQueryArray(sql);
		if (resultado.isEmpty() || resultado.get(0)[0] == null) {
			return 1;  
		} else {
			return ((Number) resultado.get(0)[0]).intValue() + 1;
		}
	}

	/**
	 * Modifica la tabla Colegiados por si hubo modificaciones
	 * @param colegiado
	 */
	public void actualizarColegiado(ColegiadosDTO colegiado) {
		String sql = "UPDATE Colegiados SET nombre = ?, apellidos = ?, DNI = ?, direccion = ?, poblacion = ?, fecha_nacimiento = ?, cuenta_bancaria = ?, titulacion = ? WHERE id_colegiado = ?";
		db.executeUpdate(sql,colegiado.getNombre(),colegiado.getApellidos(),colegiado.getDni(),colegiado.getDireccion(),colegiado.getPoblacion(),colegiado.getFecha_nacimiento(),colegiado.getCuenta_bancaria(),colegiado.getTitulacion(),colegiado.getId_colegiado());  
	}
	
	/**
	 * Muestra para ver todo mas claro en una tabla (se puede eliminar)
	 * @return
	 */
	public List<PeritosDTO> getListaPeritos() {
		String sql = "SELECT id_colegiado, correo, telefono, fecha ,año , tap , estado FROM Peritos WHERE estado='Inscrito'";
		return db.executeQueryPojo(PeritosDTO.class, sql);
	}
	
	/**
	 * Metodo que busca en la tabla Peritos el id_colegiado y si lo encuentra no se va a poder inscribir en el TAP
	 * @param id_colegiado
	 * @return
	 */
	public boolean existeColegiadoenPeritos(int id_colegiado) {
		String sql = "SELECT COUNT(*) FROM Peritos WHERE id_colegiado = ?";
		List<Object[]> resultado = db.executeQueryArray(sql, id_colegiado);
		return (resultado.get(0)[0] != null && ((Number) resultado.get(0)[0]).intValue() > 0);
	}
	
	/**
	 * Metodo que comprueba si el id_colegiado buscado no es un colegiado
	 * @param dni
	 */
	public boolean existeColegiadoenColegiados(int id_colegiado) {
		String sql = "SELECT COUNT(*) FROM Colegiados WHERE id_colegiado = ?";
		List<Object[]> result = db.executeQueryArray(sql, id_colegiado);
		//Si es mayor a 0 retornara true , en caso contrario false
		return ((Number) result.get(0)[0]).intValue() > 0;
	}

	/**
	 * Metodo que comprueba si el colegiado es un colegiado con estado de inscripcion aprobada
	 * @param idColegiado
	 * @return
	 */
	public boolean estadoColegiado(int idColegiado) {
		String sql = "SELECT COUNT(*) FROM Colegiados WHERE id_colegiado = ? AND estado = 'Pendiente'";
	    List<Object[]> resultado = db.executeQueryArray(sql, idColegiado);
		//Si es mayor a 0 retornara true , en caso contrario false
	    return ((Number) resultado.get(0)[0]).intValue() > 0;
	}
}