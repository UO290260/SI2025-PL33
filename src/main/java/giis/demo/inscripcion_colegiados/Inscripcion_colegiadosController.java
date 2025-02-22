package giis.demo.inscripcion_colegiados;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JFrame;

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
	}

	/**
	 * BOTON INSCRIBIR COLEGIADO ; QUE GENERA UNA EXCEPCION EN CASO DE QUE FUNCIONE MAL
	 */
	public void initController() {
		vista.getBtnInscribirColegiado().addActionListener(e -> SwingUtil.exceptionWrapper(() -> inscribirColegiado()));
	}

	private void inscribirColegiado() {
		// RECOGO LOS DATOS INTRODUCIDOS EN LA VISTA
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

		// CREO EL JUSTIFICANTE CON LOS DATOS RELLENADOS Y MUESTRO EL JUSTIFICANTE POR PANTALLA
		Justificante justificante = new Justificante(colegiado);
		justificante.setVisible(true);
	}





}
