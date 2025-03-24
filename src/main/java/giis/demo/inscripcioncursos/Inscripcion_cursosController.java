package giis.demo.inscripcioncursos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.table.TableModel;
import giis.demo.util.ApplicationException;
import giis.demo.util.SwingUtil;
import giis.demo.util.Util;

//Clase controller que actua como intermediario entre la interfaz y el modelo
public class Inscripcion_cursosController {
	private Inscripcion_cursosModel model;
	private Inscripcion_cursosView view;
	private tarjetaView tarjetaV;
	private List<CursosDTO> ListaCursos;
	private int  idInscripcion;
	private int cursoId;
	private ColegiadoDTO colegiado;
	private ExternoDTO externo;
	private CursosDTO curso;
	private String fechaapertura;
	private String cierre;
	private Date fechaActual;
	private Date fechaApertura;
	private Date fechaCierre;


	public Inscripcion_cursosController(Inscripcion_cursosModel m, Inscripcion_cursosView v) {
		this.model = m;
		this.view = v;
		//no hay inicializacion especifica del modelo, solo de la vista
		this.initView();
	}

	//Mostrar la ventana generada en el modelo View
	public void initView() {
		view.getFrame().setVisible(true);
		tarjetaV= new tarjetaView();
		// Agregar KeyListener para restringir la entrada y solo se pueden incluir caracteres numéricos
		view.getJTDNI().addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				String text = view.getJTDNI().getText();

				// Si es número y aún no hay 8 dígitos, lo deja escribir
				if (Character.isDigit(c)) {
					if (text.length() >= 8) {
						e.consume(); // Bloquea si ya hay 8 números
					}
				} 
				// Si es letra y está en la posición 9 (después de 8 números)
				else if (Character.isLetter(c) && text.length() == 8) {
					if (!Character.isUpperCase(c)) {
						e.setKeyChar(Character.toUpperCase(c)); // Convierte a mayúscula automáticamente
					}
				} 
				// Bloquea cualquier otro caso (más de 9 caracteres, letras en posiciones incorrectas, etc.)
				else {
					e.consume();
				}
			}
		});

		view.getBtnNumero().addActionListener(new ActionListener() { //NOSONAR codigo autogenerado
			public void actionPerformed(ActionEvent e) {

				if(view.getJTDNI().getText().isEmpty()) //Comprueba que la Jtextnumero no se encuentre vacio
				{
					JOptionPane.showMessageDialog(view.getFrame(), "El campo DNI no debe estar vacio.", "Error", JOptionPane.ERROR_MESSAGE);
				}
				else if(!view.getJTDNI().getText().matches("\\d{8}[A-Za-z]"))
				{
					JOptionPane.showMessageDialog(view.getFrame(), "El DNI debe contener 8 digitos y una letra.", "Error", JOptionPane.ERROR_MESSAGE);
				}
				else 
				{
					Inscripcion_cursosController.this.getDatos();
					if(colegiado ==null && externo==null){
						JOptionPane.showMessageDialog(view.getFrame(), "No hay nadie registrado con ese DNI.", "Error", JOptionPane.WARNING_MESSAGE);
					}
				}
			}
		});

		this.getListaCursos();

		//Listener que efectua un pago por tarjeta, es necesario sacarlo fuera para no generar listener duplicados que puedan producir fallos.
		ActionListener actionListenerPago = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (Inscripcion_cursosController.this.comprobar_datos_tarjeta()) {
					String dni = (colegiado != null) ? colegiado.getDNI() : externo.getDNI();
					String nombre = (colegiado != null) ? colegiado.getNombre() : externo.getNombre();
					String apellidos = (colegiado != null) ? colegiado.getApellidos() : externo.getApellidos();
					Justificante_tarjeta justificante = new Justificante_tarjeta(nombre,apellidos,dni, SwingUtil.Obtener_fechaActual(), curso,tarjetaV.getTxtNumeroTarjeta().getText(),view.getLstcuotas().getSelectedItem().toString());
					justificante.getFrame().setVisible(true);	
				}
			}
		};

		view.getBtnInscripcion().addActionListener(new ActionListener() { //NOSONAR codigo autogenerado
			public void actionPerformed(ActionEvent e) {
				if(Inscripcion_cursosController.this.comprobar_campos()) { //Comprueba que la Jtextnumero no se encuentre vacio y se selciona un curso
					curso=ListaCursos.get(view.getTabCurso().getSelectedRow());
					cursoId=curso.getId_curso();
					fechaapertura=ListaCursos.get(view.getTabCurso().getSelectedRow()).getApertura_inscripcion();
					cierre=ListaCursos.get(view.getTabCurso().getSelectedRow()).getCierre_inscripcion();
					Inscripcion_cursosController.this.getDatos(); //Obtiene el objeto de tipo ColegiadoDTO u externoDTO
					fechaActual = Util.isoStringToDate(SwingUtil.Obtener_fechaActual()); // Convierte la fecha actual a LocalDate
					fechaApertura = Util.isoStringToDate(fechaapertura); // Convierte la fecha de apertura de inscripción a LocalDate
					fechaCierre = Util.isoStringToDate(cierre); // Convierte la fecha de cierre de inscripción a LocalDate
					// Verificar si la inscripción está abierta
					if (model.ComprobarFechaApertura(fechaActual, fechaApertura, fechaCierre)) {
						JOptionPane.showMessageDialog(view.getFrame(), "No está disponible la inscripción del curso.", "Error", JOptionPane.ERROR_MESSAGE);
						throw new ApplicationException("No está disponible la inscripción del curso ");
					}

					// Verificar si hay plazas disponibles
					if (!model.plazasDisponibles(cursoId)) {
						JOptionPane.showMessageDialog(view.getFrame(), "No hay plazas disponibles.", "Error", JOptionPane.ERROR_MESSAGE);
						throw new ApplicationException("No hay plazas disponibles");
					}

					// Comprobar si el usuario ya está inscrito (colegiado o externo)
					if (colegiado != null && model.Comprobar_Inscripción(colegiado.getDNI(), cursoId)) {
						JOptionPane.showMessageDialog(view.getFrame(), "El alumno ya está matriculado.", "Error", JOptionPane.ERROR_MESSAGE);
						throw new ApplicationException("El alumno ya está matriculado.");
					}

					if (externo != null && model.Comprobar_Inscripción(externo.getDNI(), cursoId)) {
						JOptionPane.showMessageDialog(view.getFrame(), "El alumno ya está matriculado.", "Error", JOptionPane.ERROR_MESSAGE);
						throw new ApplicationException("El alumno ya está matriculado.");
					}

					// Verificar si un externo tiene una cuota de colegiado (error de inscripción)
					if (externo != null && !Inscripcion_cursosController.this.ComprobarCuotaAplicada()) {
						JOptionPane.showMessageDialog(view.getFrame(), "No se puede aplicar cuota de colegiados o precolegiados a externo.", "Error", JOptionPane.ERROR_MESSAGE);
						return; // No lanzamos excepción, solo detenemos el proceso
					}

					// Obtener un nuevo ID de inscripción
					idInscripcion = model.ObtenerIdInscripcion();

					// Manejo de pago con tarjeta
					if (view.getRbTarjeta().isSelected()) {
						tarjetaV.getFrame().setVisible(true);

						// Remover cualquier ActionListener previamente agregado al botón de pago
						tarjetaV.getBtnPagar().removeActionListener(actionListenerPago);

						// Agregar el ActionListener para el botón de pagar
						tarjetaV.getBtnPagar().addActionListener(actionListenerPago);
					} 
					else {
						// Determinar el tipo de usuario e inscribirlo
						String dni = (colegiado != null) ? colegiado.getDNI() : externo.getDNI();
						String nombre = (colegiado != null) ? colegiado.getNombre() : externo.getNombre();
						String apellidos = (colegiado != null) ? colegiado.getApellidos() : externo.getApellidos();
						String cuentaBancaria = (colegiado != null) ? colegiado.getCuenta_bancaria() : externo.getCuenta_bancaria();

						model.InscribirEnCurso(idInscripcion, dni, cursoId, SwingUtil.Obtener_fechaActual(), false);
						Inscripcion_cursosController.this.getListaCursos(); // Actualizar la lista de cursos

						// Generar justificante
						Justificante_Inscripción justificante = new Justificante_Inscripción(
								nombre, apellidos, dni, cuentaBancaria, SwingUtil.Obtener_fechaActual(), curso, view.getLstcuotas().getSelectedItem().toString()
								);
						justificante.getFrame().setVisible(true);
					}
				}
			}	
		});

		tarjetaV.getTxtNumeroTarjeta().addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) { //keytyped registra el evento de teclado y llama al método
				char c = e.getKeyChar();
				// Permitir solo números y borrar (backspace)
				if (!Character.isDigit(c) && c != '\b') { //verifica si el caracter introducido es un número o espacio en blanco(solo borrado)
					e.consume(); // Bloquear el carácter
				}
				//Limita el tamaño del nº a 16 dígitos
				if(tarjetaV.getTxtNumeroTarjeta().getText().length()>= 16) {
					e.consume();
				}
			}
		});

		tarjetaV.getTxtCVV().addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) { //keytyped registra el evento de teclado y llama al método
				JPasswordField passwordField = (JPasswordField) e.getSource();
				char c = e.getKeyChar();
				// Permitir solo números y borrar (backspace)
				if (!Character.isDigit(c) && c != '\b') { //verifica si el caracter introducido es un número o espacio en blanco(solo borrado)
					e.consume(); // Bloquear el carácter
				}

				//Limitar a 3 de longitud
				if (passwordField.getPassword().length >= 3) {
					e.consume();
				}
			}
		});

		view.getTabCurso().addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				curso=ListaCursos.get(view.getTabCurso().getSelectedRow());
				cursoId=curso.getId_curso();
				List<String> cuotasCurso=model.cargarCuotas(cursoId);
				ComboBoxModel<Object> lmodel=new DefaultComboBoxModel<>(cuotasCurso.toArray(new String[0]));
				view.getLstcuotas().setModel(lmodel);
			}
		});
	}

	/**
	 * 	Obtiene la lista de cursos disponibles y los carga en el una tabla 
	 */
	public void getListaCursos() {
		ListaCursos=model.getListacursos();
		TableModel tmodel=SwingUtil.getTableModelFromPojos(ListaCursos, new String[] {"id_curso","titulo","descripcion","fecha_inicio","fecha_fin","duracion","plazas","cuota_precolegiado", "cuota_colegiado","cuota_minusvalido","cuota_desempleado","cuota_empleado","cuota_alumno","cuota_empresa", "cuota_otros","apertura_inscripcion","cierre_inscripcion","estado"});
		view.getTabCurso().setModel(tmodel);
		SwingUtil.autoAdjustColumns(view.getTabCurso());			
	}

	/**
	 * Obtiene los datoS y los almacena en una clase llamada ColegiadoDTO y crea una tabla para mostrar los datos correspondientes
	 * @return El objeto de la clase ColeegiadoDTO
	 */
	public void getDatos() {
		colegiado=model.getDatosColegiado(view.getJTDNI().getText());
		externo=model.getDatosExterno(view.getJTDNI().getText());
		if(colegiado!=null)
		{
			TableModel tmodel=SwingUtil.getTableModelFromPojos(List.of(colegiado), new String[] {"id_colegiado", "nombre", "apellidos","DNI","direccion", "poblacion", "titulacion","fecha_colegiacion","cuenta_bancaria"});
			view.getTabDatos().setModel(tmodel);
			SwingUtil.autoAdjustColumns(view.getTabDatos());
		}
		else if (externo !=null)
		{
			TableModel tmodel=SwingUtil.getTableModelFromPojos(List.of(externo), new String[] {"id_externo", "nombre", "apellidos","DNI","direccion", "poblacion","fecha_nacimiento","cuenta_bancaria"});
			view.getTabDatos().setModel(tmodel);
			SwingUtil.autoAdjustColumns(view.getTabDatos());
		}
	}
	/**
	 * Si el campo de busqueda id no está vacio , un curso está seleccionado, y algun método de pago tambien devolverá true sino false
	 * @return booleano
	 */
	boolean comprobar_campos() {
		if(view.getJTDNI().getText().isEmpty()) {
			JOptionPane.showMessageDialog(view.getFrame(), "El campo DNI no debe estar vacio.", "Error", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		if(!view.getJTDNI().getText().matches("\\d{8}[A-Za-z]"))
		{
			JOptionPane.showMessageDialog(view.getFrame(), "El DNI debe contener 8 digitos y una letra.", "Error", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		if(view.getTabCurso().getSelectedRow()==-1) {
			JOptionPane.showMessageDialog(view.getFrame(), "Debe seleccionar curso.", "Error", JOptionPane.WARNING_MESSAGE);
			return false;
		}
		if(!view.getRbTarjeta().isSelected() && !view.getRbTransferencia().isSelected()) {
			JOptionPane.showMessageDialog(view.getFrame(), "Debe seleccionar método de pago.", "Error", JOptionPane.WARNING_MESSAGE);
			return false;
		}

		this.getDatos(); //Actualizamos en busqueda de si existe o no la persona buscada
		if(colegiado==null && externo==null){
			JOptionPane.showMessageDialog(view.getFrame(), "No hay nadie registrado con ese DNI.", "Error", JOptionPane.WARNING_MESSAGE);
			return false;
		}
		return true;
	}

	/**
	 * Comprueba si todos los campos de la ventana de tarjeta son correctos, si no lo son devolverá false y avisará con un mensaje
	 * 
	 * @return true si son correctos y false si no lo son con un dialogo descriptivo
	 */
	public boolean comprobar_datos_tarjeta() {
		String numeroTarjeta = tarjetaV.getTxtNumeroTarjeta().getText().trim();
		String cvv = new String(tarjetaV.getTxtCVV().getPassword()).trim();
		Date fechaSEL=(Date)tarjetaV.getSpinner().getValue();
		fechaActual=Util.isoStringToDate(SwingUtil.Obtener_fechaActual());

		Calendar calSel = Calendar.getInstance();
		calSel.setTime(fechaSEL);

		Calendar calActual = Calendar.getInstance();
		calActual.setTime(fechaActual);

		if (numeroTarjeta.isEmpty() || cvv.isEmpty() || tarjetaV.getSpinner().getValue()==null) {
			JOptionPane.showMessageDialog(tarjetaV.getFrame(), "Todos los campos son obligatorios.", "Error", JOptionPane.ERROR_MESSAGE);
			return false;
		}

		if (!numeroTarjeta.matches("\\d{16}")) {
			JOptionPane.showMessageDialog(tarjetaV.getFrame(), "Número de tarjeta inválido. Deben ser 16 dígitos.", "Error", JOptionPane.ERROR_MESSAGE);
			return false;
		}

		if (!cvv.matches("\\d{3}")) {
			JOptionPane.showMessageDialog(tarjetaV.getFrame(), "CVV inválido. Deben ser 3 dígitos.", "Error", JOptionPane.ERROR_MESSAGE);
			return false;
		}

		if(!model.ComrprobarFechaTarjeta(calActual, calSel)) {
			JOptionPane.showMessageDialog(tarjetaV.getFrame(), "La fecha de la tarjeta ha caducado.", "Error", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		return true;
	}

	public boolean ComprobarCuotaAplicada() {
		String cuotacompleta=view.getLstcuotas().getSelectedItem().toString();
		String [] cuota=cuotacompleta.split(" ");
		if(cuota[0].equals("cuota_precolegiado:") || cuota[0].equals("cuota_colegiado:"))return false;
		else return true;		
	}

}