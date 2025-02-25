package giis.demo.inscripcion_colegiados;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.TableModel;
import giis.demo.util.SwingUtil;

public class Inscripcion_colegiadosController {

	private Inscripcion_colegiadosModel modelo; 
	private Inscripcion_colegiadosView vista;

	/**
	 * Constructor
	 * @param model
	 * @param view
	 */
	public Inscripcion_colegiadosController(Inscripcion_colegiadosModel model, Inscripcion_colegiadosView view) {
		this.modelo = model;
		this.vista = view;
		this.initView();
	}

	/**
	 * Inicializo la interfaz
	 */
	public void initView() {	
		vista.getFrame().setVisible(true);
		cargarListaColegiados();
	}

	/**
	 * Boton de inscribir colegiado , que generara una excepcion en caso de error
	 */
	public void initController() {
		vista.getBtnInscribirColegiado().addActionListener(e -> SwingUtil.exceptionWrapper(() -> inscribirColegiado()));
	}

	/**
	 * Valida que los campos no esten vacios
	 * @return
	 */
	private boolean validarCampos() {
		if (vista.getNombretxt().getText().isEmpty() ||
				vista.getApellidostxt().getText().isEmpty() ||
				vista.getDNItxt().getText().isEmpty() ||
				vista.getDNItxt().getText().length()!=9 ||
				vista.getDirecciontxt().getText().isEmpty() ||
				vista.getPoblaciontxt().getText().isEmpty() ||
				vista.getFechanacimientotxt().getDate() == null ||  
				vista.getCuentatxt().getText().isEmpty() ||
				vista.getCuentatxt().getText().length()!=24 ||
				vista.getTitulaciontxt().getText().isEmpty()) {
			return false;
		}
		return true; 
	}

	/**
	 * Inscribir al colegiado en la base de datos
	 */
	private void inscribirColegiado() {
		//RECOJO LOS DATOS INTRODUCIDOS EN LA VISTA
		String nombre = vista.getNombretxt().getText();
		String apellidos = vista.getApellidostxt().getText();
		String dni = vista.getDNItxt().getText();
		String direccion = vista.getDirecciontxt().getText();
		String poblacion = vista.getPoblaciontxt().getText();
		Date fechanacimiento = vista.getFechanacimientotxt().getDate();
		String cuenta = vista.getCuentatxt().getText();
		String titulacion = vista.getTitulaciontxt().getText();


		//VERIFICO SI EL DNI YA EXISTE EN LA BASE DE DATOS
		if (modelo.dniExiste(dni)) {
			JOptionPane.showMessageDialog(null, "El DNI ya esta en la base de datos"); 
			return; 
		}

		//VERIFICO SI LOS CAMPOS ESTAN TODOS RELLENADOS
		if (!validarCampos()) {
			JOptionPane.showMessageDialog(null, "No estan los campos rellenados");
			return; 
		}

		//FORMATO PARA LAS FECHAS
		SimpleDateFormat formatear = new SimpleDateFormat("dd/MM/yyyy");
		String fechanacimiento2 = formatear.format(fechanacimiento);
		String fechacolegiacion2 = formatear.format(new Date());

		//CREO UN COLEGIADO DTO
		Inscripcion_colegiadosDTO colegiado2 = new Inscripcion_colegiadosDTO();
		colegiado2.setNombre(nombre);
		colegiado2.setApellidos(apellidos);
		colegiado2.setDNI(dni);
		colegiado2.setDireccion(direccion);
		colegiado2.setPoblacion(poblacion);
		colegiado2.setFecha_nacimiento(fechanacimiento2);
		colegiado2.setFecha_colegiacion(fechacolegiacion2); 
		colegiado2.setCuenta_bancaria(cuenta);
		colegiado2.setTitulacion(titulacion);

		//INSERTO EN LA BASE DE DATOS
		modelo.insertarColegiado(colegiado2);
		cargarListaColegiados();

		//CREO EL JUSTIFICANTE CON LOS DATOS RELLENADOS Y MUESTRO EL JUSTIFICANTE POR PANTALLA
		if (validarCampos()) {
			Justificante justificante = new Justificante(colegiado2);
		} else {
			System.out.println(" Hay campos vacíos");

		}

	}

	/**
	 * Carga la lista de los colegiados
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

	/**
	 * Metodo que restringe la entrada de numeros
	 * @param letra
	 */
	public static void  soloLetras(JTextField letra) {
		letra.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				char c = evt.getKeyChar();
				if (!Character.isLetter(c) && c != KeyEvent.VK_SPACE && c != KeyEvent.VK_BACK_SPACE) {
					evt.consume(); 
				}
			}
		});
	}

	/**
	 * Introduce la entrada de caracteres del DNI (debe de ser de 8 digitos y una letra)
	 * @param letra
	 */
	public static void validarDNI(JTextField letra) {
		letra.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				char c = evt.getKeyChar();
				String texto = letra.getText();

				//SOLO PERMITE 8 CARACTERES
				if (texto.length() < 8) {
					if (!Character.isDigit(c)) {
						evt.consume(); 
					}
				} 
				//SOLO PERMITE 8 CARACTERES
				else if (texto.length() == 8) {
					if (!Character.isLetter(c)) {
						evt.consume(); 
					}
					else {
						evt.setKeyChar(Character.toUpperCase(c)); 
					}
				} 
				//SI YA HAY 9 CARACTERES , NO PERMITE MAS ENTRADAS
				else {
					evt.consume();
				}
			}
		});
	}


	/**
	 * Valida la cuenta bancaria y solo permite 2 letras y 22 digitos
	 * @param letra
	 */
	public static void validarCuentaBancaria(JTextField letra) {
		letra.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				char c = evt.getKeyChar();
				String texto = letra.getText();

				//SOLO PERMITE 2 LETRAS
				if (texto.length() < 2) {
					if (!Character.isLetter(c)) {
						evt.consume(); 
					} 
				} 
				//NUMERO DE CARACTERES MENOR DE 24
				else if (texto.length() >= 2 && texto.length() < 24) {
					if (!Character.isDigit(c)) {
						evt.consume(); 
					}
				} 
				//SI YA ESTA LA CUENTA BANCARIA , NO PERMITE MAS ENTRADAS
				else {
					evt.consume();
				}
			}
		});
	}


}
