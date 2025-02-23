package giis.demo.inscripcion_colegiados;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.table.TableModel;

import giis.demo.util.SwingMain;
import giis.demo.util.SwingUtil;

public class Inscripcion_colegiadosController {
	private Inscripcion_colegiadosModel modelo; // NO HACE NADA POR AHORA
	private Inscripcion_colegiadosView vista;

	/**
	 * CONSTRUCTOR
	 * @param model
	 * @param view
	 */
	public Inscripcion_colegiadosController(Inscripcion_colegiadosModel model, Inscripcion_colegiadosView view) {
		this.modelo = model;
		this.vista = view;
		this.initView();
	}

	/**
	 * INICIALIZO LA INTERFAZ 
	 */
	public void initView() {	
		vista.getFrame().setVisible(true); 
		cargarListaColegiados();
	}

	/**
	 * BOTON INSCRIBIR COLEGIADO ; QUE GENERA UNA EXCEPCION EN CASO DE QUE FUNCIONE MAL
	 */
	public void initController() {
		vista.getBtnInscribirColegiado().addActionListener(e -> SwingUtil.exceptionWrapper(() -> inscribirColegiado()));
	}

	private void inscribirColegiado() {
		// RECOJO LOS DATOS INTRODUCIDOS EN LA VISTA
		String nombre = vista.getNombretxt().getText();
		String apellidos = vista.getApellidostxt().getText();
		String dni = vista.getDNItxt().getText();
		String direccion = vista.getDirecciontxt().getText();
		String poblacion = vista.getPoblaciontxt().getText();
		Date fechanacimiento = vista.getFechanacimientotxt().getDate();
		String cuenta = vista.getCuentatxt().getText();
		String titulacion = vista.getTitulaciontxt().getText();


		// CREO UN COLEGIADO 
		Inscripcion_colegiadosEntity colegiado = new Inscripcion_colegiadosEntity();
		colegiado.setNombre(nombre);
		colegiado.setApellidos(apellidos);
		colegiado.setDni(dni);
		colegiado.setDireccion(direccion);
		colegiado.setPoblacion(poblacion);
		colegiado.setFechanacimiento(fechanacimiento);
		colegiado.setFechasolicitud(new Date()); 
		colegiado.setCuenta(cuenta);
		colegiado.setTitulacion(titulacion);

		// CREO UN COLEGIADO DTO
		Inscripcion_colegiadosDTO colegiado2 = new Inscripcion_colegiadosDTO();
		colegiado2.setNombre(nombre);
		colegiado2.setApellidos(apellidos);
		colegiado2.setDNI(dni);
		colegiado2.setDireccion(direccion);
		colegiado2.setPoblacion(poblacion);
		colegiado2.setFecha_nacimiento(fechanacimiento);
		colegiado2.setCuenta_bancaria(cuenta);
		colegiado2.setTitulacion(titulacion);

		// INSERTO EN LA BASE DE DATOS
		modelo.insertarColegiado(colegiado2);
		cargarListaColegiados();

		// CREO EL JUSTIFICANTE CON LOS DATOS RELLENADOS Y MUESTRO EL JUSTIFICANTE POR PANTALLA
		Justificante justificante = new Justificante(colegiado);
		justificante.setVisible(true);

	}
	/**
	 * CARGA LA LISTA DE COLEGIADOS
	 */
	public void cargarListaColegiados() {
		List<Inscripcion_colegiadosDTO> colegiados = modelo.getListaColegiados();
		TableModel tmodel = SwingUtil.getTableModelFromPojos(colegiados, new String[]{
				"id_colegiado", "nombre", "apellidos", "DNI", "direccion", "poblacion",
				"fecha_nacimiento", "cuenta_bancaria", "titulacion", "fecha_colegiacion"
		});

		vista.getTabla().setModel(tmodel);
		SwingUtil.autoAdjustColumns(vista.getTabla());
	}





}
