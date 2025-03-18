package giis.demo.inscripcionlistaTAP;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.TableModel;
import giis.demo.util.SwingUtil;
import giis.demo.util.Util;

public class InscripcionlistaTAPController {
	private InscripcionlistaTAPModel modelo;
	private InscripcionlistaTAPView vista;

	public InscripcionlistaTAPController(InscripcionlistaTAPModel modelo,InscripcionlistaTAPView vista) {
		this.modelo = modelo;
		this.vista = vista;
		initView();
	}

	/**
	 * Inicializacion del controlador
	 */
	public void initController() {
		vista.getBtnBuscar().addActionListener(e -> SwingUtil.exceptionWrapper(() ->  buscarColegiado()));
		vista.getBtnGuardar().addActionListener(e -> SwingUtil.exceptionWrapper(() -> guardarCambios()));
	}

	public void initView() {	
		vista.getFrame().setVisible(true);
		cargarListaPeritos();
	}

	/**
	 * Metodo que valida que los campos no esten vacios y sean de la longitud esperada
	 */
	private boolean validarCampos() {
		if (vista.getIdColegiadoTxt().getText().isEmpty() ||
				vista.getNombretxt().getText().isEmpty() ||
				vista.getApellidostxt().getText().isEmpty() ||
				vista.getDNItxt().getText().isEmpty() ||
				vista.getDNItxt().getText().length()!=9 ||
				vista.getDirecciontxt().getText().isEmpty() ||
				vista.getPoblaciontxt().getText().isEmpty() ||
				vista.getTelefonotxt().getText().isEmpty() ||
				vista.getTelefonotxt().getText().length()!=9 ||
				vista.getCorreotxt().getText().isEmpty() ||
				vista.getCorreotxt().getText().length()<11 ||
				!(vista.getCorreotxt().getText().contains("@gmail.com")) ||
				vista.getAñotxt().getText().isEmpty() ||
				vista.getAñotxt().getText().length()!=4 ||
				vista.getFechanacimientotxt().getDate() == null ||  
				vista.getCuentatxt().getText().isEmpty() ||
				vista.getCuentatxt().getText().length()!=24 ||
				vista.getTitulaciontxt().getText().isEmpty()) {
			return false;
		}
		return true; 
	}

	/**
	 * Metodo que busca al colegiado por su id_colegiado al pulsar el boton buscar.
	 * En caso de no encontrarlo se imprime el mensaje de error
	 */
	private void buscarColegiado() {
		int idColegiado;
		try {
			idColegiado = Integer.parseInt(vista.getIdColegiadoTxt().getText());
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Ingrese un ID válido.");
			return;
		}

		ColegiadosDTO colegiado = modelo.getColegiadoPorID(idColegiado);
		if (colegiado != null) {
			vista.getNombretxt().setText(colegiado.getNombre());
			vista.getApellidostxt().setText(colegiado.getApellidos());
			vista.getDNItxt().setText(colegiado.getDni());
			vista.getDirecciontxt().setText(colegiado.getDireccion());
			vista.getPoblaciontxt().setText(colegiado.getPoblacion());
			vista.getFechanacimientotxt().setDate(Util.isoStringToDate(colegiado.getFecha_nacimiento()));
			vista.getCuentatxt().setText(colegiado.getCuenta_bancaria());
			vista.getTitulaciontxt().setText(colegiado.getTitulacion());
		} else {
			JOptionPane.showMessageDialog(null, "El colegiado buscado no existe.");
		}
	}

	/**
	 * Metodo que al pulsar guardar , comprobara que los campos no estaran
	 */
	private void guardarCambios() {
		int idColegiado=0;
		String idColegiadoText = vista.getIdColegiadoTxt().getText();
		if (idColegiadoText.isEmpty()) {
			JOptionPane.showMessageDialog(null, "El ID de colegiado no puede estar vacío.");
			return; 
		}
		else {
			idColegiado = Integer.parseInt(idColegiadoText);
		}

		String nombre = vista.getNombretxt().getText();
		String apellidos = vista.getApellidostxt().getText();
		String dni = vista.getDNItxt().getText();
		String direccion = vista.getDirecciontxt().getText();
		String poblacion = vista.getPoblaciontxt().getText();
		Date fechaNacimiento = vista.getFechanacimientotxt().getDate();  
		String cuentaBancaria = vista.getCuentatxt().getText();
		String titulacion = vista.getTitulaciontxt().getText();
		String correo = vista.getCorreotxt().getText();

		int telefono = 0;
		String telefonoText = vista.getTelefonotxt().getText();
		if (telefonoText.isEmpty()) {
			JOptionPane.showMessageDialog(null, "El teléfono no puede estar vacío.");
			return; 
		}
		else {
			telefono = Integer.parseInt(telefonoText);
		} 

		String añoText = vista.getAñotxt().getText();
		String fechasolicitud = Util.dateToIsoString(new Date()); 
		int añoSolicitud = Integer.parseInt(fechasolicitud.substring(0, 4)); // Me quedo con el año de la fecha solicitud
		int año = 0; 
		if (!añoText.isEmpty()) {
			try {
				año = Integer.parseInt(añoText);
				if (añoSolicitud < año || año < 2000) { 
					JOptionPane.showMessageDialog(null, "El año ingresado no puede ser mayor que el año de la fecha de solicitud o el año debe de ser mayor a 2000");
					return;
				}
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "El año debe ser un número válido.");
				return;
			}
		} else {
			JOptionPane.showMessageDialog(null, "El campo año no puede estar vacío.");
			return;
		}

		String fechaNacimientoStr = Util.dateToIsoString(fechaNacimiento); 
		ColegiadosDTO colegiado = new ColegiadosDTO();
		colegiado.setId_colegiado(idColegiado);
		colegiado.setNombre(nombre);
		colegiado.setApellidos(apellidos);
		colegiado.setDni(dni);
		colegiado.setDireccion(direccion);
		colegiado.setPoblacion(poblacion);
		colegiado.setFecha_nacimiento(fechaNacimientoStr);
		colegiado.setCuenta_bancaria(cuentaBancaria);
		colegiado.setTitulacion(titulacion);

		PeritosDTO perito = new PeritosDTO();
		perito.setCorreo(correo);
		perito.setTelefono(telefono); 
		perito.setAño(año);
		perito.setFecha(fechasolicitud);

		//Deben de estar escritos todos los campos
		if (!validarCampos()) {
			JOptionPane.showMessageDialog(null, "No estan los campos rellenados");
			return; 
		}

		//Mensaje de error del correo
		if (!correo.endsWith("@gmail.com")) {
			JOptionPane.showMessageDialog(null, "El correo introducido no acaba por @gmail.com");
		} 
		if (modelo.existeColegiado(colegiado.getId_colegiado())) {
			JOptionPane.showMessageDialog(null, "El colegiado ya es un Perito , no se puede volver a añadir");
			return;
		}
		else {
			modelo.actualizarColegiado(colegiado);  
			modelo.insertarPerito(colegiado , perito); 
			JOptionPane.showMessageDialog(null, "Datos actualizados correctamente.");
			InscripcionlistaTAPJustificante justificante = new InscripcionlistaTAPJustificante(colegiado, perito);
		}
	}

	/**
	 * Tabla para visualizar todo mejor y para ver que esta correctamente (se puede eliminar)
	 */
	public void cargarListaPeritos() {
		List<PeritosDTO> peritos = modelo.getListaPeritos();
		TableModel tmodel = SwingUtil.getTableModelFromPojos(peritos, new String[]{
				"id_colegiado", "correo", "telefono", "fecha" , "año" , "tap" , "estado"
		});
		vista.getTabla().setModel(tmodel);
		SwingUtil.autoAdjustColumns(vista.getTabla());
	}

	/**
	 * Metodo para poder escribir solo 4 numeros en el año 
	 * @param campo
	 */
	public static void validar4numeros(JTextField campo) {
		campo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				char c = evt.getKeyChar();
				String texto = campo.getText();
				if (!Character.isDigit(c) || texto.length() >= 4) {
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
	 * Método para que solo puedas introducir números 
	 * @param letra
	 */
	public static void soloNumeros(JTextField numero) {
		numero.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				char c = evt.getKeyChar();
				if (!Character.isDigit(c) && c != KeyEvent.VK_BACK_SPACE) {
					evt.consume(); 
				}
			}
		});
	}

	/**
	 * Metodo que permite solo la entrada de 9 numeros de un telefono
	 * @param campoTelefono
	 */
	public static void validarTelefono(JTextField campoTelefono) {
		campoTelefono.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				char c = evt.getKeyChar();
				String texto = campoTelefono.getText();

				if (!Character.isDigit(c) || texto.length() >= 9) {
					evt.consume(); 
				}
			}
		});
	}
}