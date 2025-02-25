package giis.demo.inscripcion_cursos;




import java.util.Date;
import java.util.List;

import giis.demo.util.ApplicationException;
import giis.demo.util.Database;
import giis.demo.util.Util;


public class Inscripcion_cursosModel {
	
	private Database db= new Database();
	
	
	public List<CursosDTO> getListacursos(){
		String sql="SELECT id_curso, titulo, descripcion, fecha_inicio, fecha_fin, duracion, plazas, estado "+
				"FROM Cursos "+
				"Where estado='Disponible'";
		 List<CursosDTO> rows=db.executeQueryPojo(CursosDTO.class,sql); //Envia en forma de List CursoDTO la consulta sql
		 return rows;
	}
	
	/**Obtiene los datos del colegiado al que qeremos acceder a través de su ID y los almacena en una clase llamada colegiadoDTO 
	 * @param id del colegiado
	 * @return objeto tipo ColegiadoDTO
	 *  */
	public ColegiadoDTO getDatosColegiado(int id_colegiado){
		String sql="Select id_colegiado, nombre, apellidos, direccion, poblacion, titulacion, fecha_colegiacion, cuenta_bancaria "
				+"FROM Colegiados WHERE id_colegiado=?";
		List<ColegiadoDTO>rows=db.executeQueryPojo(ColegiadoDTO.class, sql,id_colegiado); //Obtenemos una listade objetos de clase ColegiadoDTO que será solo un objeto
		if (rows.isEmpty())
			throw new ApplicationException("Id de colegiado no encontrado: ");
		else
			return rows.get(0);
	}
	
	/**
	 * Inscribe al colegiado en el curso indicado, resta el número de plazas del curso siempre y cuando no sean 0 e imprime justificante
	 * @param InscripciónID número entero
	 * @param colegiado Objeto de la clase ColegiadoDTO
	 * @param cursoID número entero
	 * @param fecha String de la fecha actual
	 */
	public void InscribirEnCurso(int InscripciónID,ColegiadoDTO colegiado,int cursoID,String fecha) {
		String sql= "INSERT INTO Inscripciones (id_inscripcion, id_colegiado, id_curso, fecha_inscripcion) VALUES (?, ?, ?, ?);";
		String sql2 = "UPDATE Cursos SET plazas = plazas - 1 WHERE id_curso = ? AND plazas > 0;";
		db.executeUpdate(sql,InscripciónID,colegiado.getId_colegiado(),cursoID,Util.isoStringToDate(fecha));
		db.executeUpdate(sql2,cursoID);
		System.out.println("--------------Justificante de Inscripción------------------ ");
		System.out.println("Nombre: "+colegiado.getNombre()+" Apellidos: "+colegiado.getApellidos()
							+"\nColegiadoID: "+colegiado.getId_colegiado()+" Fecha actual de inscripción: "+fecha
							+"\nCuenta bancaria: "+colegiado.getCuenta_bancaria());
	}
	
	/**
	 * Obtiene la ID actual necesaria para la inscripción del curso 
	 * @return ID actual necesario de tipo entero
	 */
	public int ObtenerIdInscripcion() {
		String sql="SELECT COUNT(*) FROM Inscripciones;";
		List<Object[]>lista= db.executeQueryArray(sql, null);
		return (1+Integer.parseInt(lista.get(0)[0].toString()))*10;
	}
	
	/**
	 * Comprueba si en el curso al que queremos matricularnos hay plazas disponibles o no
	 * @param cursoID Identificador del curso de tipo entero
	 * @return true si hay plazas o false si no hay
	 */
	public boolean plazasDisponibles(int cursoID) {
		String sql="SELECT (plazas > 0) FROM Cursos WHERE id_curso = ?;";
		List<Object[]>NInscripciones= db.executeQueryArray(sql,cursoID);
		if(Integer.parseInt(NInscripciones.get(0)[0].toString())==1) {
			return true;
		}else {
			return false;
		}
	}
	
	/**
	 * Comprueba si el colegiado o precolegiado ha sido ya matriculado en el curso
	 * @param colegiadoID Identificador de colegiado o pre de tipo entero
	 * @param cursoID Identificador del curso de tipo entero
	 * @return true si ya ha sido matriculado y false en caso contrario
	 */
	public boolean Comprobar_Inscripción(int colegiadoID, int cursoID){
		String sql="SELECT COUNT(*) FROM Inscripciones WHERE id_colegiado = ? AND id_curso = ?;";
		
		List<Object[]>NInscripciones= db.executeQueryArray(sql,colegiadoID,cursoID);
		if(Integer.parseInt(NInscripciones.get(0)[0].toString())>0) {
			return true;
		}else {
			return false;
		}
		
	}
	
}
