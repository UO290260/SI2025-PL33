package giis.demo.models;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import giis.demo.dto.ColegiadosDTO;
import giis.demo.dto.CursosDTO;
import giis.demo.dto.ExternoDTO;
import giis.demo.util.Database;
import giis.demo.util.Util;

public class InscripcionCursosModel {

	private Database db= new Database();

	/**
	 * Método que devuelve en una consulta todas las cuotas de un curso y las separa y añade en un arraylist
	 * @param idcurso de tipo entero 
	 * @return lista de String s de las cuotas de un curso
	 */
	public List<String> cargarCuotas(int idcurso){
		// Definimos la consulta SQL
		String sql = "SELECT " +
				"CASE WHEN cuota_precolegiado IS NOT NULL THEN 'cuota_precolegiado: ' || cuota_precolegiado ELSE NULL END || " +
				"CASE WHEN cuota_colegiado IS NOT NULL THEN ' | cuota_colegiado: ' || cuota_colegiado ELSE '' END || " +
				"CASE WHEN cuota_minusvalido IS NOT NULL THEN ' | cuota_minusvalido: ' || cuota_minusvalido ELSE '' END || " +
				"CASE WHEN cuota_desempleado IS NOT NULL THEN ' | cuota_desempleado: ' || cuota_desempleado ELSE '' END || " +
				"CASE WHEN cuota_empleado IS NOT NULL THEN ' | cuota_empleado: ' || cuota_empleado ELSE '' END || " +
				"CASE WHEN cuota_alumno IS NOT NULL THEN ' | cuota_alumno: ' || cuota_alumno ELSE '' END || " +
				"CASE WHEN cuota_empresa IS NOT NULL THEN ' | cuota_empresa: ' || cuota_empresa ELSE '' END || " +
				"CASE WHEN cuota_otros IS NOT NULL THEN ' | cuota_otros: ' || cuota_otros ELSE '' END AS item " +
				"FROM Cursos WHERE id_curso = ?";

		// Ejecutamos la consulta y obtenemos los resultados (una lista de una fila con varias columnas)
		List<Object[]> result = db.executeQueryArray(sql, idcurso);

		// Lista para almacenar las cuotas no nulas
		List<String> cuotasNoNulas = new ArrayList<>();

		// Si el resultado no está vacío, procesamos la primera fila
		if (result != null && !result.isEmpty()) {

			Object[] cuotas = result.get(0);
			String cuotasJuntas = cuotas[0].toString();
			//Separamos la consulta que es un único STRING en | para almacenarlo como elemento separados
			String[] cuotasSeparadas = cuotasJuntas.split(" \\| ");

			for (String cuota : cuotasSeparadas) {
				if (cuota != null) {
					// Convertimos la cuota a String y la agregamos a la lista
					cuotasNoNulas.add(cuota.toString()+" €");
				}
			}
		}

		// Devolvemos la lista de cuotas no nulas
		return cuotasNoNulas;
	}

	/**
	 * En via una lista de cursos disponibles
	 * @return una lista de CuroDTO
	 */
	public List<CursosDTO> getListacursos(){
		String sql="SELECT id_curso, titulo, descripcion, fecha_inicio, fecha_fin, duracion, plazas,cuota_precolegiado, cuota_colegiado,cuota_minusvalido,cuota_desempleado,cuota_empleado,cuota_alumno,cuota_empresa, cuota_otros, apertura_inscripcion, cierre_inscripcion,lista_espera,estado "+
				"FROM Cursos "+
				"Where estado='Disponible'";
		List<CursosDTO> rows=db.executeQueryPojo(CursosDTO.class,sql); //Envia en forma de List CursoDTO la consulta sql
		return rows;
	}

	/**Obtiene los datos del colegiado al que qeremos acceder a través de su DNI y los almacena en una clase llamada colegiadoDTO 
	 * @param id del colegiado
	 * @return objeto tipo ColegiadoDTO
	 *  */
	public ColegiadosDTO getDatosColegiado(String dni){
		String sql="Select id_colegiado, nombre, apellidos,DNI, direccion, poblacion, titulacion, fecha_colegiacion, cuenta_bancaria "
				+"FROM Colegiados WHERE DNI=?";
		List<ColegiadosDTO>rows=db.executeQueryPojo(ColegiadosDTO.class, sql,dni); //Obtenemos una listade objetos de clase ColegiadoDTO que será solo un objeto
		if (rows.isEmpty())
			return null;
		else
			return rows.get(0);
	}

	/**
	 * Devuelve en una consulta la persona externa a partir de su DNI
	 * @param dni
	 * @return objeto tipo ExternoDTO 
	 */
	public ExternoDTO getDatosExterno(String dni){
		String sql="Select id_externo, nombre, apellidos, DNI, direccion, poblacion, fecha_nacimiento, cuenta_bancaria "
				+"FROM Externos WHERE DNI=?";
		List<ExternoDTO>rows=db.executeQueryPojo(ExternoDTO.class, sql,dni); //Obtenemos una listade objetos de clase ExternaDTO que será solo un objeto
		if (rows.isEmpty())
			return null;
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
	public void InscribirEnCurso(int InscripciónID,String DNI,int cursoID,String fecha,boolean tarjeta) {
		String sql=null;
		if(tarjeta) {
			sql= "INSERT INTO Inscripciones (id_inscripcion, DNI, id_curso, fecha_inscripcion,estado,cantidad_pagar,cantidad_devolver,lista_espera,posicion) VALUES (?, ?, ?, ?,'Matriculado',NULL,NULL,FALSE,NULL);";
		}
		else {
			sql= "INSERT INTO Inscripciones (id_inscripcion, DNI, id_curso, fecha_inscripcion,estado,cantidad_pagar,cantidad_devolver,lista_espera,posicion) VALUES (?, ?, ?, ?,'Pre-inscrito',NULL,NULL,FALSE,NULL);";
		}
		String sql2 = "UPDATE Cursos SET plazas = plazas - 1 WHERE id_curso = ? AND plazas > 0;";
		db.executeUpdate(sql,InscripciónID,DNI,cursoID,Util.isoStringToDate(fecha));
		db.executeUpdate(sql2,cursoID);
	}

	/**
	 * Obtiene la ID actual necesaria para la inscripción del curso 
	 * @return ID actual necesario de tipo entero
	 */
	public int ObtenerIdInscripcion() {
		String sql="SELECT COUNT(*) FROM Inscripciones;";
		List<Object[]>lista= db.executeQueryArray(sql);
		return (1+Integer.parseInt(lista.get(0)[0].toString()));
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
	 * Por defecto la lista de espera de un curso está desactivada hasta que las plazas se aagotan y si puede está activada la lista de espera , entonces se actualiza el dato
	 * @param cursoID
	 */
	public void activarlistaEspera(int cursoID,String dni)
	{
		String sql1="UPDATE Inscripciones SET lista_espera = TRUE WHERE id_curso = ? AND dni=?;";
		db.executeUpdate(sql1,cursoID,dni);
	}
	
	/**
	 * Obtiene la posición de la lista de espera disponible 
	 * @param cursoID
	 * @return 
	 */
	public int ObtenerPosListaEspera(int cursoID) {
		String sql="SELECT COUNT(*) FROM Inscripciones WHERE id_curso= ? AND lista_espera=TRUE;";
		List<Object[]>lista= db.executeQueryArray(sql,cursoID);
		return (Integer.parseInt(lista.get(0)[0].toString()))+1;
	}
	
	/**
	 * Mete en la lista de espera del curso a la perosna que se quiere matricular
	 * @param InscripciónID
	 * @param DNI
	 * @param cursoID
	 * @param fecha
	 * @param pos
	 */
	public void MeterEnlistaEspera(int InscripciónID,String DNI,int cursoID,String fecha,int pos)
	{
		String sql1="INSERT INTO Inscripciones (id_inscripcion, DNI, id_curso, fecha_inscripcion,estado,cantidad_pagar,cantidad_devolver,lista_espera,posicion) VALUES (?, ?, ?, ?,'En espera',NULL,NULL,TRUE,?);";
		db.executeUpdate(sql1,InscripciónID,DNI,cursoID,Util.isoStringToDate(fecha),pos);
	}
	
	/**
	 * Comprueba si el colegiado o precolegiado ha sido ya matriculado en el curso
	 * @param colegiadoID Identificador de colegiado o pre de tipo entero
	 * @param cursoID Identificador del curso de tipo entero
	 * @return true si ya ha sido matriculado y false en caso contrario
	 */
	public boolean Comprobar_Inscripción(String DNI ,int cursoID){
		String sql="SELECT COUNT(*) FROM Inscripciones WHERE DNI = ? AND id_curso = ?;";

		List<Object[]>NInscripciones= db.executeQueryArray(sql,DNI,cursoID);
		if(Integer.parseInt(NInscripciones.get(0)[0].toString())>0) {
			return true;
		}else {
			return false;
		}
	}

	/**
	 * Comprueba si la fecha que se psa en la tarjeta es correcta o por el contrario está caducada
	 * @return true si la fecha no está caducada, sino false
	 */
	public boolean ComrprobarFechaTarjeta(Calendar calActual,Calendar calSel) {
		if((calActual.get(Calendar.YEAR) > calSel.get(Calendar.YEAR)) || (calActual.get(Calendar.YEAR) == calSel.get(Calendar.YEAR) && calActual.get(Calendar.MONTH) > calSel.get(Calendar.MONTH))) return false;
		else return true;
	}
	
	/**
	 * Comrprueba si la fecha actual está entre la apertura de inscripción y cierre
	 * @param fechaActual
	 * @param fechaApertura
	 * @param fechaCierre
	 * @return true si no se encuentra en el intervalo de apertura y false si se encuentra
	 */
	public boolean ComprobarFechaApertura(Date fechaActual, Date fechaApertura,Date fechaCierre) {
		if((fechaActual.before(fechaApertura) || fechaActual.after(fechaCierre))) return true; //Comprueba si el alumno se puede matricular del curso 
		else return false;
	}
}
