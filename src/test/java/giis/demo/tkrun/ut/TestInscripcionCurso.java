package giis.demo.tkrun.ut;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.util.Date;
import java.util.List;

import giis.demo.dto.ColegiadosDTO;
import giis.demo.dto.CursosDTO;
import giis.demo.dto.ExternoDTO;
import giis.demo.dto.InscripcionesDTO;
import giis.demo.models.InscripcionCursosModel;
import giis.demo.util.ApplicationException;
import giis.demo.util.Database;
import giis.demo.util.Util;

public class TestInscripcionCurso {

	private Database db;
	private InscripcionCursosModel model;
	private String todayDateStr;
	private Date todayDate;

	// Constantes para DNIs y IDs de Curso
	private static final String DNI_COLEGIADO_OK = "12345678A";
	private static final String DNI_EXTERNO_OK = "67891234F";
	private static final int CURSO_ID_DISPONIBLE_PLAZAS = 1;
	private static final int CURSO_ID_DISPONIBLE_SINPLAZAS_LE_ON = 2;
	private static final int CURSO_ID_DISPONIBLE_SINPLAZAS_LE_OFF = 3;

	@Before
	public void setUp() throws Exception {
		db = new Database();
		model = new InscripcionCursosModel();
		db.createDatabase(true); 
		todayDate = new Date();
		todayDateStr = Util.dateToIsoString(todayDate);

	}



	private void loadDefaultData() {
		//Cargar datos iniciales
		db.executeUpdate("DELETE FROM Inscripciones");
		db.executeUpdate("DELETE FROM Colegiados");
		db.executeUpdate("DELETE FROM Externos");
		db.executeUpdate("DELETE FROM Cursos");

		db.executeUpdate("INSERT INTO Colegiados (id_colegiado, nombre, apellidos, DNI, direccion, poblacion, fecha_nacimiento, cuenta_bancaria, titulacion, fecha_colegiacion, estado) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
				1, "Test", "Colegiado", DNI_COLEGIADO_OK, "Dir", "Pob", "1990-01-01", "ES0000000000000000000001", "Ingenieria Informatica", "2015-01-01", "Aprobada");

		db.executeUpdate("INSERT INTO Externos (id_externo, nombre, apellidos, DNI, direccion, poblacion, fecha_nacimiento, cuenta_bancaria) VALUES (?, ?, ?, ?, ?, ?, ?, ?)",
				1, "Test", "Externo", DNI_EXTERNO_OK, "Dir Ext", "Pob Ext", "1992-01-01", "ES0000000000000000000002");

		db.executeUpdate("INSERT INTO Cursos (id_curso, titulo, descripcion, fecha_inicio, fecha_fin, duracion, plazas, sesiones, cuota_precolegiado, cuota_colegiado, cuota_minusvalido, cuota_desempleado, cuota_empleado, cuota_alumno, cuota_empresa, cuota_otros, apertura_inscripcion, cierre_inscripcion,cancelable, porcentaje_devolucion, fecha_cancelacion, lista_espera, estado) values (?, 'Optimización de algoritmos', 'Curso de algoritmos', '2024-01-03', '2024-01-06', 90, 30, 10, 120, 200, 80, 100, 100, 100, 100, 100, '2023-11-10', '2023-12-10',FALSE,30,NULL,FALSE,'Disponible')",CURSO_ID_DISPONIBLE_PLAZAS);
		db.executeUpdate("INSERT INTO Cursos (id_curso, titulo, descripcion, fecha_inicio, fecha_fin, duracion, plazas, sesiones, cuota_precolegiado, cuota_colegiado, cuota_minusvalido, cuota_desempleado, cuota_empleado, cuota_alumno, cuota_empresa, cuota_otros, apertura_inscripcion, cierre_inscripcion,cancelable, porcentaje_devolucion, fecha_cancelacion, lista_espera, estado) values (?,'Inteligencia artificial', 'Aprendizaje automático de ordenadores', '2024-04-07', '2024-09-10', 90, 0, 3, 400, NULL, 100, NULL, 100, NULL, 100, 100, '2024-02-05', '2026-03-05',FALSE,30,NULL,TRUE,'Disponible')",CURSO_ID_DISPONIBLE_SINPLAZAS_LE_ON);
		db.executeUpdate("INSERT INTO Cursos (id_curso, titulo, descripcion, fecha_inicio, fecha_fin, duracion, plazas, sesiones, cuota_precolegiado, cuota_colegiado, cuota_minusvalido, cuota_desempleado, cuota_empleado, cuota_alumno, cuota_empresa, cuota_otros, apertura_inscripcion, cierre_inscripcion,cancelable, porcentaje_devolucion, fecha_cancelacion, lista_espera, estado) values (?,'Ciberseguridad', 'Principios de seguridad en sistemas operativos', '2024-10-05', '2024-11-08', 120, 0, 5, 250, 250, 100, NULL, 100, 100, 100, NULL, '2024-07-20', '2026-08-20',FALSE,30,NULL,FALSE, 'Disponible')",CURSO_ID_DISPONIBLE_SINPLAZAS_LE_OFF);
	}

	private void loadData_UsuarioYaInscrito() {
		loadDefaultData();
		//Cargar datos para comrpobación CE5
		int idInsc = model.ObtenerIdInscripcion();
		db.executeUpdate("INSERT INTO Inscripciones (id_inscripcion, DNI, id_curso, fecha_inscripcion, estado, lista_espera, posicion) VALUES (?, ?, ?, ?, ?, ?, ?)",
				idInsc, DNI_COLEGIADO_OK, CURSO_ID_DISPONIBLE_PLAZAS, todayDateStr, "Matriculado", false, null);
		db.executeUpdate("UPDATE Cursos SET plazas = plazas - 1 WHERE id_curso = ?", CURSO_ID_DISPONIBLE_PLAZAS);
	}

	// ----- Tests Casos de Exíto -----

	//CE1
	@Test
	public void testInscribirColegiado_Transferencia_Exito() {
		loadDefaultData(); 
		int cursoId = CURSO_ID_DISPONIBLE_PLAZAS;
		int initialPlazas = db.executeQueryPojo(CursosDTO.class, "SELECT plazas from Cursos where id_curso=?", cursoId).get(0).getPlazas();
		assertEquals("PRECONDICION: Curso debe tener 30 plaza", 30, initialPlazas);

		assertFalse("PRECONDICION: Colegiado no debe estar inscrito", model.Comprobar_Inscripción(DNI_COLEGIADO_OK, cursoId));

		int inscId = model.ObtenerIdInscripcion();
		model.InscribirEnCurso(inscId, DNI_COLEGIADO_OK, cursoId, todayDateStr, false); // false = Transferencia

		// Verificar Inscripcion
		List<InscripcionesDTO> inscripciones = db.executeQueryPojo(InscripcionesDTO.class, "SELECT * FROM Inscripciones WHERE DNI = ? AND id_curso = ?", DNI_COLEGIADO_OK, cursoId);
		assertEquals("Debe existir 1 inscripción", 1, inscripciones.size());
		InscripcionesDTO insc = inscripciones.get(0);
		assertEquals("ID inscripción incorrecto", inscId, insc.getId_inscripcion());
		assertEquals("Estado debe ser Pre-inscrito", "Pre-inscrito", insc.getEstado());
		assertEquals("Posición debe ser NULL",0 ,insc.getPosicion()); 

		// Verificar Plazas Curso
		int finalPlazas = db.executeQueryPojo(CursosDTO.class, "SELECT plazas from Cursos where id_curso=?", cursoId).get(0).getPlazas();
		assertEquals("Plazas deben haberse decrementado", initialPlazas - 1, finalPlazas);
	}
	//CE2
	@Test
	public void testInscribirColegiado_Tarjeta_Exito() {
		loadDefaultData();
		int cursoId = CURSO_ID_DISPONIBLE_PLAZAS;
		int initialPlazas = db.executeQueryPojo(CursosDTO.class, "SELECT plazas from Cursos where id_curso=?", cursoId).get(0).getPlazas();
		assertEquals("PRECONDICION: Curso debe tener 30 plaza", 30, initialPlazas);
		assertFalse("PRECONDICION: Colegiado no debe estar inscrito", model.Comprobar_Inscripción(DNI_COLEGIADO_OK, cursoId));

		int inscId = model.ObtenerIdInscripcion();

		model.InscribirEnCurso(inscId, DNI_COLEGIADO_OK, cursoId, todayDateStr, true);

		// Verificar Inscripcion
		List<InscripcionesDTO> inscripciones = db.executeQueryPojo(InscripcionesDTO.class, "SELECT * FROM Inscripciones WHERE DNI = ? AND id_curso = ?", DNI_COLEGIADO_OK, cursoId);
		assertEquals("Debe existir 1 inscripción", 1, inscripciones.size());
		InscripcionesDTO insc = inscripciones.get(0);
		assertEquals("ID inscripción incorrecto", inscId, insc.getId_inscripcion());
		assertEquals("Estado debe ser Matriculado", "Matriculado", insc.getEstado()); 
		assertEquals("Posición debe ser 0",0,insc.getPosicion());

		// Verificar Plazas Curso
		int finalPlazas = db.executeQueryPojo(CursosDTO.class, "SELECT plazas from Cursos where id_curso=?", cursoId).get(0).getPlazas();
		assertEquals("Plazas deben haberse decrementado", initialPlazas - 1, finalPlazas);
	}
	//CE3
	@Test
	public void testEntrarListaEspera_Exito() {
		loadDefaultData();
		int cursoId = CURSO_ID_DISPONIBLE_SINPLAZAS_LE_ON;
		assertFalse("PRECONDICION: Curso no debe tener plazas", model.plazasDisponibles(cursoId));
		assertTrue("PRECONDICION: Curso debe tener LE habilitada", db.executeQueryPojo(CursosDTO.class, "SELECT lista_espera FROM Cursos WHERE id_curso=?", cursoId).get(0).isLista_espera());
		assertFalse("PRECONDICION: Colegiado no debe estar inscrito", model.Comprobar_Inscripción(DNI_COLEGIADO_OK, cursoId));

		int posEsperada = model.ObtenerPosListaEspera(cursoId);
		assertEquals("PRECONDICION: Posición esperada debe ser 1 (lista vacía)", 1, posEsperada);

		int inscId = model.ObtenerIdInscripcion();
		model.MeterEnlistaEspera(inscId, DNI_COLEGIADO_OK, cursoId, todayDateStr, posEsperada);

		// Verificar Inscripcion
		List<InscripcionesDTO> inscripciones = db.executeQueryPojo(InscripcionesDTO.class, "SELECT * FROM Inscripciones WHERE DNI = ? AND id_curso = ?", DNI_COLEGIADO_OK, cursoId);
		assertEquals("Debe existir 1 inscripción", 1, inscripciones.size());
		InscripcionesDTO insc = inscripciones.get(0);
		assertEquals("ID inscripción incorrecto", inscId, insc.getId_inscripcion());
		assertEquals("Estado debe ser En espera", "En espera", insc.getEstado());
		assertEquals("Posición incorrecta", posEsperada, insc.getPosicion());

		
		int finalPlazas = db.executeQueryPojo(CursosDTO.class, "SELECT plazas from Cursos where id_curso=?", cursoId).get(0).getPlazas();
		assertEquals("Plazas no deben cambiar", 0, finalPlazas);
	}
	//CE4
	@Test
	public void testInscribir_Error_FueraDePlazo() {
		loadDefaultData();
		int cursoId = CURSO_ID_DISPONIBLE_PLAZAS; 
		CursosDTO curso = db.executeQueryPojo(CursosDTO.class, "SELECT apertura_inscripcion, cierre_inscripcion FROM Cursos WHERE id_curso=?", cursoId).get(0);

		
		assertTrue("La fecha actual debe estar fuera del plazo",
				model.ComprobarFechaApertura(todayDate, Util.isoStringToDate(curso.getApertura_inscripcion()), Util.isoStringToDate(curso.getCierre_inscripcion())));
	}
	//CE5
	@Test
	public void testInscribir_Error_YaInscrito() {
		loadData_UsuarioYaInscrito(); 
		int cursoId = CURSO_ID_DISPONIBLE_PLAZAS;

		
		assertTrue("El colegiado ya debería estar inscrito", model.Comprobar_Inscripción(DNI_COLEGIADO_OK, cursoId));

	}
	//CE6
	@Test
	public void testInscribir_Error_SinPlazasSinListaEspera() {
		loadDefaultData();
		int cursoId = CURSO_ID_DISPONIBLE_SINPLAZAS_LE_OFF; // 0 plazas, Lista espera off

		assertFalse("El curso no debería tener plazas", model.plazasDisponibles(cursoId));
		assertFalse("El curso no debería tener LE habilitada", db.executeQueryPojo(CursosDTO.class, "SELECT lista_espera FROM Cursos WHERE id_curso=?", cursoId).get(0).isLista_espera());

	}
	//CE7
	@Test
	public void testCargarCuotas_ConNulos() {
		loadDefaultData(); 
		int cursoId = CURSO_ID_DISPONIBLE_SINPLAZAS_LE_ON;

		List<String> cuotas = model.cargarCuotas(cursoId);

		assertNotNull("La lista de cuotas no debe ser nula", cuotas);
		assertEquals("Debe haber 5 cuotas no nulas", 5, cuotas.size());

		assertTrue("Debe contener cuota_precolegiado", cuotas.stream().anyMatch(s -> s.contains("cuota_precolegiado: 400 €")));
		assertTrue("Debe contener cuota_minusvalido", cuotas.stream().anyMatch(s -> s.contains("cuota_minusvalido: 100 €")));
		assertTrue("Debe contener cuota_empleado", cuotas.stream().anyMatch(s -> s.contains("cuota_empleado: 100 €")));
		assertTrue("Debe contener cuota_empresa", cuotas.stream().anyMatch(s -> s.contains("cuota_empresa: 100 €")));
		assertTrue("Debe contener cuota_otros", cuotas.stream().anyMatch(s -> s.contains("cuota_otros: 100 €")));

	}
	//CE8
	@Test
	public void testPlazasDisponibles() {
		loadDefaultData();
		assertTrue("Curso 1 debería tener plazas", model.plazasDisponibles(CURSO_ID_DISPONIBLE_PLAZAS));
		assertFalse("Curso 2 no debería tener plazas", model.plazasDisponibles(CURSO_ID_DISPONIBLE_SINPLAZAS_LE_ON));
		assertFalse("Curso 3 no debería tener plazas", model.plazasDisponibles(CURSO_ID_DISPONIBLE_SINPLAZAS_LE_OFF));
	}
}


