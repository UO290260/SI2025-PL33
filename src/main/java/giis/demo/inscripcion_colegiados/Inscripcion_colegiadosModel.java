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
	 * 	Insertar el Colegiado en la base de datos
	 * @param colegiado
	 */
	public void insertarColegiado(Inscripcion_colegiadosDTO colegiado) {
		
		if (dniExiste(colegiado.getDNI())) {
	        System.out.println("Error: El DNI ya está registrado en la base de datos ");	 
	        return;
	    }
		
		String sql="INSERT INTO Colegiados (id_colegiado ,nombre, apellidos, DNI, direccion, poblacion, fecha_nacimiento, cuenta_bancaria, titulacion, fecha_colegiacion) " + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		int nuevoId= incrementarID();
		db.executeUpdate(sql,nuevoId,colegiado.getNombre(),colegiado.getApellidos(),colegiado.getDNI(),colegiado.getDireccion(),colegiado.getPoblacion(),colegiado.getFecha_nacimiento(),colegiado.getCuenta_bancaria(),colegiado.getTitulacion(),colegiado.getFecha_colegiacion());
	}
	
	/**
	 * Comprueba si el DNI del colegiado esta en la base de datos
	 * @param dni
	 * @return
	 */
	public boolean dniExiste(String dni) {
	    String sql = "SELECT COUNT(*) FROM Colegiados WHERE DNI = ?";
	    List<Object[]> result = db.executeQueryArray(sql, dni);
	    
	    //SI EL RESULTADO ES MAYOR A 0 , SIGNNFICA QUE EL DNI YA EXISTE 
	    return ((Number) result.get(0)[0]).intValue() > 0;
	}
	
	/**
	 * Comprueba el numero maximo del colegiado y aumenta en 1 
	 * @return
	 */
	public int incrementarID() {
        String sql = "SELECT MAX(id_colegiado) FROM Colegiados";
        List<Object[]> resultado = db.executeQueryArray(sql);
        
        //SI ES NULO
        if (resultado.isEmpty() || resultado.get(0)[0] == null) {
            return 1;
        } else {
            return ((Number) resultado.get(0)[0]).intValue() + 1;
        }
    }
}
