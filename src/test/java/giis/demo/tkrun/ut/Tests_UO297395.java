package giis.demo.tkrun.ut;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import java.util.Date;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import giis.demo.dto.ColegiadosDTO;
import giis.demo.dto.PeritosDTO;
import giis.demo.models.InscripcioncolegiadosModel;
import giis.demo.models.InscripcionlistaTAPModel;
import giis.demo.util.Database;
import giis.demo.util.Util;

public class Tests_UO297395 {
	private static Database db  = new Database();

	@Before
	public void setUp() {
		db.createDatabase(true); 
		cargarBase(db);
	}

	@After
	public void tearDown(){
	}

	/**
	 * Base de datos
	 * @param db
	 */
	private void cargarBase(Database db) {
		db.executeUpdate("DELETE FROM Peritos");
		db.executeUpdate("DELETE FROM Colegiados");
		db.executeBatch(new String[] {
				"INSERT INTO Colegiados (id_colegiado, nombre, apellidos, DNI, direccion, poblacion, fecha_nacimiento, cuenta_bancaria, titulacion, fecha_colegiacion , estado) VALUES" +
						"(1, 'Alejandro', 'Torre Llorente', '12345678A', 'Calle Mayor 12', 'Asturias', '1985-10-06', 'ES7621000813610123456789', 'Ingenieria Informatica', '2010-01-09' , 'Aprobada')," +
						"(2, 'Pablo', 'Santos Gomez', '23456789B', 'Avenida de la Paz 8', 'Asturias', '1990-10-03', 'ES9820381600140001234567', 'Ingenieria Informatica', '2015-10-05' , 'Aprobada')," +
						"(3, 'Alejandro', 'Pineiro Mendez', '34567890C', 'Calle del Sol 25', 'Asturias', '1988-11-11', 'ES5520481310123456789012', 'Ingenieria Informatica', '2012-11-07' ,  'Aprobada')," +
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
	 * Metodo que inscribe a un colegiado y comprueba si sus datos son correctos
	 */
	@Test
	public void inscripcionColegiado_Exito() {
		InscripcioncolegiadosModel modelo = new InscripcioncolegiadosModel();
		ColegiadosDTO colegiadoNuevo = new ColegiadosDTO();

		colegiadoNuevo.setNombre("Marcos");
		colegiadoNuevo.setApellidos("Rámirez Fernández");
		colegiadoNuevo.setDni("45567889A");
		colegiadoNuevo.setDireccion("Calle Sol 4");
		colegiadoNuevo.setPoblacion("Asturias");
		colegiadoNuevo.setFecha_nacimiento("1995-05-11");
		colegiadoNuevo.setCuenta_bancaria("ES1122334411111188990011");
		colegiadoNuevo.setTitulacion("Ingeniería de Software");
		colegiadoNuevo.setFecha_colegiacion("2024-04-10");

		modelo.insertarColegiado(colegiadoNuevo);

		assertEquals("El id_colegiado que esperas es 10", 10, colegiadoNuevo.getId_colegiado()); 
		assertEquals("El estado de la inscripcion que esperas del colegiado es Pendiente", "Pendiente", colegiadoNuevo.getEstado());
	}

	/**
	 * Metodo que intenta inscribir un colegiado y si ese DNI introducido ya existe en la base de datos , no se puede insertar
	 */
	@Test
	public void inscripcionColegiado_Duplicado() {
		InscripcioncolegiadosModel modelo = new InscripcioncolegiadosModel();
		ColegiadosDTO colegiadoDuplicado = new ColegiadosDTO();

		colegiadoDuplicado.setNombre("Marcos");
		colegiadoDuplicado.setApellidos("Rámirez Fernández");
		colegiadoDuplicado.setDni("12345678A");
		colegiadoDuplicado.setDireccion("Calle Sol 4");
		colegiadoDuplicado.setPoblacion("Asturias");
		colegiadoDuplicado.setFecha_nacimiento("1995-05-11");
		colegiadoDuplicado.setCuenta_bancaria("ES1122334411111188990011");
		colegiadoDuplicado.setTitulacion("Ingeniería de Software");
		colegiadoDuplicado.setFecha_colegiacion("2024-04-10");

		modelo.insertarColegiado(colegiadoDuplicado);

		assertNull("El estado de inscripcion que esperas es null ya que el DNI es duplicado", colegiadoDuplicado.getEstado());
	}

	/**
	 * Metodo que comprueba si se incrementa correctamente el id_colegiado
	 */
	@Test
	public void inscripcionColegiado_IDTablaDatos() {
		InscripcioncolegiadosModel modelo = new InscripcioncolegiadosModel();
		int nuevoId = modelo.incrementarID();
		assertEquals("El id_colegiado que esperas es 10", 10, nuevoId);
	}

	/**
	 * Metodo que comprueba si se incrementa correctamente el id_colegiado al estar la tabla colegiados vacia
	 */
	@Test
	public void inscripcionColegiado_IDTablaVacia() {
		db.executeUpdate("DELETE FROM Colegiados");
		InscripcioncolegiadosModel modelo = new InscripcioncolegiadosModel();
		int nuevoId = modelo.incrementarID();
		assertEquals("El id_colegiado que esperas es 1", 1, nuevoId);
	}

	/**
	 * Metodo que inscribe a un perito y comprueba si sus datos son correctos
	 */
	@Test
	public void inscripcionTAP_Exito() {
		InscripcionlistaTAPModel modelo = new InscripcionlistaTAPModel();
		ColegiadosDTO colegiado = modelo.getColegiadoPorID(2);
		//Busco si existe el colegiado
		assertNotNull("El colegiado 2 debe existir", colegiado); 
		//El estado de la inscripcion debe de ser Aprobada para que se pueda inscribir en el TAP
		assertEquals("El colegiado 2 debe tener su estado de inscripcion", "Aprobada", colegiado.getEstado()); 
		//El id_colegiado no debe de existir en la tabla Peritos
		assertFalse("El colegiado 2 NO debe ser perito", modelo.existeColegiadoenPeritos(2));

		//Añado los datos de un perito
		PeritosDTO peritoNuevo = new PeritosDTO();
		peritoNuevo.setCorreo("correoprueba@gmail.com");
		peritoNuevo.setTelefono(600112233);
		peritoNuevo.setAño(2024); 
		peritoNuevo.setFecha(Util.dateToIsoString(new Date())); 
		modelo.insertarPerito(colegiado, peritoNuevo);

		//Compruebo si genero correctamente
		List<PeritosDTO> peritos = db.executeQueryPojo(PeritosDTO.class, "SELECT * FROM Peritos WHERE id_colegiado = ?", colegiado.getId_colegiado());
		assertEquals("El perito fue mal insertado", 1, peritos.size());

		//Compruebo los datos
		assertEquals("El estado inicial del perito no Pendiente", "Pendiente", peritos.get(0).getEstado());
		assertEquals("El TAP asignado al perito es incorrecto", 105, peritos.get(0).getTap());
	}

	/**
	 * Metodo que comprueba si existe un colegiado con el metodo existeColegiadoenColegiados
	 */
	@Test
	public void inscripcionTAP_existeColegiado() {
		db.executeUpdate("DELETE FROM Colegiados");
		InscripcionlistaTAPModel modelo = new InscripcionlistaTAPModel();
		assertFalse("El colegiado no existe", modelo.existeColegiadoenColegiados(1));
	}

	/**
	 * Método que comprueba que el estado de un colegiado sea pendiente y por ello , no se podra inscribir al colegiado
	 */
	@Test
	public void inscripcionTAP_colegiadoPendiente() {
		InscripcionlistaTAPModel modelo = new InscripcionlistaTAPModel();
		assertTrue("El colegiado 7 debería de tener el estado Pendiente para que pueda ser Inscrito", modelo.estadoColegiado(7));
	}

	/**
	 * Metodo que comprueba la asignación correcta del TAP cuando ya existen peritos.
	 */
	@Test
	public void inscripcionTAP_TablaDatos() {
		InscripcionlistaTAPModel modelo = new InscripcionlistaTAPModel();
		int nextTap = modelo.incrementarTap();
		assertEquals("El siguiente TAP debería ser el maximo + 1", 105, nextTap);
	}

	/**
	 * Metodo que comprueba la asignación correcta del TAP cuando la tabla de datos "Peritos" esta vacia
	 */
	@Test
	public void inscripcionTAP_TablaVacia() {
		db.executeUpdate("DELETE FROM Peritos");
		InscripcionlistaTAPModel modelo = new InscripcionlistaTAPModel();
		int nextTap = modelo.incrementarTap();
		assertEquals("El primer TAP debería ser 1", 1, nextTap);
	}
}