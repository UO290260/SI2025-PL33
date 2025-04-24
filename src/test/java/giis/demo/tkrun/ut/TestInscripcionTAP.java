package giis.demo.tkrun.ut;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import giis.demo.dto.ColegiadosDTO;
import giis.demo.dto.PeritosDTO;
import giis.demo.models.InscripcionlistaTAPModel;
import giis.demo.util.Database;
import giis.demo.util.Util;

public class TestInscripcionTAP {

	private static Database db  = new Database();
	private String todayDateStr  = Util.dateToIsoString(new Date());

	@Before
	public void setUp() throws Exception {
		db.createDatabase(true); 
		cargarBase(db);

	}

	@After
	public void tearDown(){
	}
	private void cargarBase(Database db) {
		db.executeUpdate("DELETE FROM Peritos");
		db.executeUpdate("DELETE FROM Colegiados");
		db.executeBatch(new String[] {
				"INSERT INTO Colegiados (id_colegiado, nombre, apellidos, DNI, direccion, poblacion, fecha_nacimiento, cuenta_bancaria, titulacion, fecha_colegiacion , estado) VALUES" +
						"(1, 'Alejandro', 'Torre Llorente', '12345678A', 'Calle Mayor 12', 'Asturias', '1985-10-06', 'ES7621000813610123456789', 'Ingenieria Informatica', '2010-01-09' , 'Aprobada')," +
						"(2, 'Pablo', 'Santos Gomez', '23456789B', 'Avenida de la Paz 8', 'Asturias', '1990-10-03', 'ES9820381600140001234567', 'Ingenieria Informatica', '2015-10-05' , 'Aprobada')," +
						"(3, 'Alejandro', 'Pineiro Mendez', '34567890C', 'Calle del Sol 25', 'Asturias', '1988-11-11', 'ES5520481310123456789012', 'Ingenieria Informatica', '2012-11-07' ,  'Aprobada')," +
						"(4, 'Sara', 'Revolver Revolver', '45678901D', 'Plaza Mayor 5', 'Barcelona', '1993-11-09', 'ES9920002510123456789011', 'Ingenieria Informatica', '2017-11-01' , 'Aprobada')," +
						"(5, 'Ramon', 'Suarez del Valle', '56789012E', 'Calle Luna 14', 'Sevilla', '1980-05-04', 'ES2320891510123456789015', 'Ingenieria Informatica', '2008-11-10', 'Aprobada')," +
						"(6, 'Tommy', 'Miller Fernandez', '58796050F', 'Calle Sol 14', 'Sevilla', '1980-05-04', 'ES9920002510123456789015', 'Master Ingenieria Informatica', '2010-11-01' , 'Aprobada')," +
						"(7, 'Joel', 'Miller Fernandez', '58796050P', 'Calle Sol 14', 'Sevilla', '1980-05-04', 'ES2320891510123456789018', 'Golf', '2010-11-10', 'Pendiente')," +
						"(8, 'Carlos', 'Sainz Vazquez', '51796050P', 'Calle Madrid 14', 'Madrid', '1980-05-04', 'ES2347891510123456789018', 'Licenciatura Informatica', '2012-11-10', 'Pendiente')," +
						"(9, 'Fernando', 'Alonso Diaz', '52796050P', 'Calle Uria 33', 'Oviedo', '1998-05-04', 'ES2320451510123456789018', 'Ingenieria Informatica', '2013-11-10', 'Pendiente')"

		});

		db.executeBatch(new String[] {
				"INSERT INTO Peritos (id_colegiado, correo, telefono, fecha , año , tap ,estado) VALUES" +
						"(1, 'alejandro.torre@gmail.com', 600123456, '2012-01-09' , 2011 , 101 , 'Inscrito')," +
						"(3, 'alejandro.pineiro@gmail.com', 623456789, '2019-11-07' , 2018 , 102 , 'Inscrito')," +
						"(4, 'sara.revolver@gmail.com', 634567890, '2018-11-01' , 2017, 103 , 'Inscrito')," +
						"(5, 'ramon.suarez@gmail.com', 654321987, '2019-11-01' , 2018, 104 , 'Inscrito')"
		});
	}

	/**
	 * 
	 */
	@Test
	public void inscripcionTAP_Exito() {
		cargarBase(db); 
	
		InscripcionlistaTAPModel modelo = new InscripcionlistaTAPModel();
		//Condiciones para que se pueda inscribir a un colegiado para ser Perito
		ColegiadosDTO colegiado = modelo.getColegiadoPorID(2);
		assertNotNull("El colegiado 2 debe existir", colegiado); //Busco si existe el colegiado
		assertEquals("El colegiado 2 debe tener su estado de inscripcion", "Aprobada", colegiado.getEstado()); //El estado de la inscripcion debe de ser Aprobada para que se pueda inscribir en el TAP
		assertFalse("El colegiado 2 NO debe ser perito", modelo.existeColegiadoenPeritos(2));//El id_colegiado no debe de existir en la tabla Peritos

		//Añado los datos de un perito
		PeritosDTO peritoNuevo = new PeritosDTO();
		peritoNuevo.setCorreo("correoprueba@gmail.com");//COMPROBAR CON OTRO QUE NO EXISTA
		peritoNuevo.setTelefono(600112233);//COMPROBAR CON OTRO QUE NO SEA DE 9 DIGITOS
		peritoNuevo.setAño(2024); // COMPROBAR CON OTRO QUE NO SEA DE 9 DIGITOS
		peritoNuevo.setFecha(Util.dateToIsoString(new Date())); // Fecha asignada por el sistema
		modelo.insertarPerito(colegiado, peritoNuevo);

		//Compruebo si existe el perito
		List<PeritosDTO> peritos = db.executeQueryPojo(PeritosDTO.class,"SELECT * FROM Peritos WHERE id_colegiado = ?",colegiado.getId_colegiado());
		assertEquals("El perito fue mal insertado", 1, peritos.size());

		//Compruebo si los datos del perito son correctos
		PeritosDTO peritoCreado = peritos.get(0);
		assertEquals("El correo es incorrecto", "correoprueba@gmail.com", peritoCreado.getCorreo());
		assertEquals("El telefono es incorrecto", 600112233, peritoCreado.getTelefono());
		assertEquals("El año introducido es incorrecto", 2024, peritoCreado.getAño());
		assertEquals("La fecha introducida es incorrecta", Util.dateToIsoString(new Date()), peritoCreado.getFecha());
		assertEquals("El estado inicial del perito no Pendiente", "Pendiente", peritoCreado.getEstado());
		assertEquals("El TAP asignado al perito es incorrecto", 105, peritoCreado.getTap()); 
	}

	/**
	 * Compruebo si existe un colegiado
	 */
	@Test
	public void inscripcionTAP_existeColegiado() {
		db.executeUpdate("DELETE FROM Colegiados");
		InscripcionlistaTAPModel modelo = new InscripcionlistaTAPModel();
		assertFalse("El colegiado no existe", modelo.existeColegiadoenColegiados(1));
	}

	/**
	 * Compruebo que si un colegiado no puede ser inscrito ya que estado es de inscripcion es Pendiente
	 */
	@Test
	public void inscripcionTAP_colegiadoPendiente() {
		InscripcionlistaTAPModel modelo = new InscripcionlistaTAPModel();
		assertTrue("El colegiado 7 debería de existir y ser colegiado con estado Pendiente", modelo.estadoColegiado(7));
	}

	/**
	 * Comprueba que no se puede inscribir un colegiado que ya es perito.
	 * Se prueba verificando la condición que usaría el controller.
	 */
	@Test
	public void testInscripcionTAP_esPerito() {
		InscripcionlistaTAPModel modelo = new InscripcionlistaTAPModel();
		assertFalse("El estado del perito es aporbado", modelo.estadoColegiado(1));
		
	}

	/**
	 * Comprueba la asignación correcta del TAP cuando la tabla Peritos está vacía.
	 */
	@Test
	public void testIncrementarTap_TablaVacia() {
		db.executeUpdate("DELETE FROM Peritos");
		InscripcionlistaTAPModel modelo = new InscripcionlistaTAPModel();

		int nextTap = modelo.incrementarTap();
		assertEquals("El primer TAP debería ser 1", 1, nextTap);
	}

	/**
	 * Comprueba la asignación correcta del TAP cuando ya existen peritos.
	 */
	@Test
	public void testIncrementarTap_TablaConDatos() {
		InscripcionlistaTAPModel modelo = new InscripcionlistaTAPModel();
		db.executeUpdate("INSERT INTO Peritos (id_colegiado, correo, telefono, fecha, año, tap, estado) VALUES (?, ?, ?, ?, ?, ?, ?)",
				12, "otro@test.com", 111222333, todayDateStr, 2022, 200, "Inscrito");

		int nextTap = modelo.incrementarTap();
		assertEquals("El siguiente TAP debería ser el maximo + 1", 201, nextTap);
	}

}