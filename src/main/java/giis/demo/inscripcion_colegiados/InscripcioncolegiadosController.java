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

/**
 * Controlador para la funcionalidad de visualizacion de un formulario
 * -instancia con la vista y el modelo
 * -ejecutando initController que instalara los manejadores de los eventos
 */
public class InscripcioncolegiadosController {
	private InscripcioncolegiadosModel modelo; 
	private InscripcioncolegiadosView vista;

	public InscripcioncolegiadosController(InscripcioncolegiadosModel model, InscripcioncolegiadosView view) {
		this.modelo = model;
		this.vista = view;
		this.initView();
	}

	/**
	 * Inicializacion del controlador
	 */
	public void initController() {
		//Invoco el metodo que responde al listener para que se encargue de generar las exceciones
		vista.getBtnInscribirColegiado().addActionListener(e -> SwingUtil.exceptionWrapper(() -> inscribirColegiado()));
	}

	public void initView() {	
		//Abre la ventana
		vista.getFrame().setVisible(true);
		//Inicia los datos de la vista
		cargarListaColegiados();
	}

	/**
	 * Metodo que valida que los campos no esten vacios y sean de la longitud esperada
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
	 * Metodo que genera un justificante con los datos introducidos en el formulario si los datos han sido rellenados correctamente.
	 */
	private void inscribirColegiado() {
		String nombre = vista.getNombretxt().getText();
		String apellidos = vista.getApellidostxt().getText();
		String dni = vista.getDNItxt().getText();
		String direccion = vista.getDirecciontxt().getText();
		String poblacion = vista.getPoblaciontxt().getText();
		Date fechanacimiento = vista.getFechanacimientotxt().getDate();
		String cuenta = vista.getCuentatxt().getText();
		String titulacion = vista.getTitulaciontxt().getText();

		if (modelo.dniExiste(dni)) {
			JOptionPane.showMessageDialog(null, "El DNI ya esta en la base de datos"); 
			return; 
		}

		if (!validarCampos()) {
			JOptionPane.showMessageDialog(null, "No estan los campos rellenados");
			return; 
		}

		SimpleDateFormat formatear = new SimpleDateFormat("dd/MM/yyyy");
		String fechanacimiento2 = formatear.format(fechanacimiento);
		String fechacolegiacion2 = formatear.format(new Date());

		InscripcioncolegiadosDTO colegiado2 = new InscripcioncolegiadosDTO();
		colegiado2.setNombre(nombre);
		colegiado2.setApellidos(apellidos);
		colegiado2.setDNI(dni);
		colegiado2.setDireccion(direccion);
		colegiado2.setPoblacion(poblacion);
		colegiado2.setFecha_nacimiento(fechanacimiento2);
		colegiado2.setFecha_colegiacion(fechacolegiacion2); 
		colegiado2.setCuenta_bancaria(cuenta);
		colegiado2.setTitulacion(titulacion);

		modelo.insertarColegiado(colegiado2);
		cargarListaColegiados();

		if (validarCampos()) {
			InscripcioncolegiadosJustifcante justificante = new InscripcioncolegiadosJustifcante(colegiado2);
		} else {
			System.out.println(" Hay campos vacíos");
		}
	}

	/**
	 * Obtencion de la lista de colegiados
	 */
	public void cargarListaColegiados() {
		List<InscripcioncolegiadosDTO> colegiados = modelo.getListaColegiados();
		TableModel tmodel = SwingUtil.getTableModelFromPojos(colegiados, new String[]{
				"id_colegiado", "nombre", "apellidos", "DNI", "direccion", "poblacion",
				"fecha_nacimiento", "cuenta_bancaria", "titulacion", "fecha_colegiacion"
		});
		vista.getTabla().setModel(tmodel);
		SwingUtil.autoAdjustColumns(vista.getTabla());
	}

	/**
	 * Metodo que obliga la entrada de letras 
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
	 * Metodo que permite escribir correctamente un DNI (8 números y una letra)
	 * @param letra
	 */
	public static void validarDNI(JTextField letra) {
		letra.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				char c = evt.getKeyChar();
				String texto = letra.getText();

				if (texto.length() < 8) {
					if (!Character.isDigit(c)) {
						evt.consume(); 
					}
				} 
				else if (texto.length() == 8) {
					if (!Character.isLetter(c)) {
						evt.consume(); 
					}
					else {
						evt.setKeyChar(Character.toUpperCase(c)); 
					}
				} 
				else {
					evt.consume();
				}
			}
		});
	}

	/**
	 * Metodo que permite escribir correctamente una cuenta bancaria (2 letras y 22 números)
	 * @param letra
	 */
	public static void validarCuentaBancaria(JTextField letra) {
		letra.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				char c = evt.getKeyChar();
				String texto = letra.getText();

				if (texto.length() < 2) {
					if (!Character.isLetter(c)) {
						evt.consume(); 
					} 
				} 
				else if (texto.length() >= 2 && texto.length() < 24) {
					if (!Character.isDigit(c)) {
						evt.consume(); 
					}
				} 
				else {
					evt.consume();
				}
			}
		});
	}
}