package giis.demo.inscripcioncursos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;

import java.awt.event.KeyEvent;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

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
		view.getJTnumero().addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) { //keytyped registra el evento de teclado y llama al método
                char c = e.getKeyChar();
                // Permitir solo números y borrar (backspace)
                if (!Character.isDigit(c) && c != '\b') { //verifica si el caracter introducido es un número o espacio en blanco(solo borrado)
                    e.consume(); // Bloquear el carácter
                }
            }
        });
		
		//Este método hará una consulta con el número del colegiado al hacer enter o en su defecto tmb al hacer click en un boton
		view.getJTnumero().addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
            	if(e.getKeyCode() == KeyEvent.VK_ENTER && !view.getJTnumero().getText().isEmpty()) //Comprueba que la Jtextnumero no se encuentre vacio y si presionamos enter
            	{
            		Inscripcion_cursosController.this.getDatosColegiados();
                }
            }
        });
		
		view.getBtnNumero().addActionListener(new ActionListener() { //NOSONAR codigo autogenerado
			public void actionPerformed(ActionEvent e) {
				if(!view.getJTnumero().getText().isEmpty()) //Comprueba que la Jtextnumero no se encuentre vacio
            	{
            		Inscripcion_cursosController.this.getDatosColegiados();
                }
			}
		});
		
		this.getListaCursos();
		
		//Listener que efectua un pago por tarjeta, es necesario sacarlo fuera para no generar listener duplicados que puedan producir fallos.
		ActionListener actionListenerPago = new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        if (Inscripcion_cursosController.this.comprobar_datos_tarjeta()) {
		            System.out.println(idInscripcion);
		            model.InscribirEnCurso(idInscripcion, colegiado, cursoId, SwingUtil.Obtener_fechaActual(), true); // Inscribimos al alumno en el curso con tarjeta
		            Inscripcion_cursosController.this.getListaCursos(); // Actualizamos la lista de cursos
		            tarjetaV.getFrame().dispose(); // Cerramos la ventana tras el pago
		            Justificante_Inscripción justificante = new Justificante_Inscripción(colegiado, SwingUtil.Obtener_fechaActual(), curso);
		            justificante.getFrame().setVisible(true);
		        }
		    }
		};
		
		view.getBtnInscripcion().addActionListener(new ActionListener() { //NOSONAR codigo autogenerado
			public void actionPerformed(ActionEvent e) {
				if(Inscripcion_cursosController.this.comprobar_campos()) { //Comprueba que la Jtextnumero no se encuentre vacio y se selcciona un curso
					curso=ListaCursos.get(view.getTabCurso().getSelectedRow());
					cursoId=curso.getId_curso();
					fechaapertura=ListaCursos.get(view.getTabCurso().getSelectedRow()).getApertura_inscripcion();
					 cierre=ListaCursos.get(view.getTabCurso().getSelectedRow()).getCierre_inscripcion();
					 colegiado=Inscripcion_cursosController.this.getDatosColegiados(); //Obtiene el objeto de tipo ColegiadoDTO
					  fechaActual = Util.isoStringToDate(SwingUtil.Obtener_fechaActual()); // Convierte la fecha actual a LocalDate
					  fechaApertura = Util.isoStringToDate(fechaapertura); // Convierte la fecha de apertura de inscripción a LocalDate
					  fechaCierre = Util.isoStringToDate(cierre); // Convierte la fecha de cierre de inscripción a LocalDate
					if(model.Comprobar_Inscripción(colegiado.getId_colegiado(), cursoId)) { //Comprueba si el alumno está o no matriculado
						JOptionPane.showMessageDialog(view.getFrame(), "El alumno ya está matriculado.", "Error", JOptionPane.ERROR_MESSAGE);
						 	throw new ApplicationException("El alumno ya está matriculado: ");
						}
					if(!model.plazasDisponibles(cursoId)) //Comprueba si hay o no plazas disponibles 
						{
						JOptionPane.showMessageDialog(view.getFrame(), "No hay plazas disponibles.", "Error", JOptionPane.ERROR_MESSAGE);
							throw new ApplicationException("No hay plazas disponibles");
						}
					if((fechaActual.before(fechaApertura) || fechaActual.after(fechaCierre))) //Comprueba si el alumno se puede matricular del curso 
					{
						JOptionPane.showMessageDialog(view.getFrame(), "No está disponible la inscripción del curso.", "Error", JOptionPane.ERROR_MESSAGE);
						throw new ApplicationException("No está disponible la inscripción del curso ");
					}
					else
						{
							 idInscripcion=model.ObtenerIdInscripcion(); //Obtenemos el nuevo id para insertar en la tabla
							if(view.getRbTarjeta().isSelected())
							{
								tarjetaV.getFrame().setVisible(true);
						
								// Remover cualquier ActionListener previamente agregado al botón de pago
			                    tarjetaV.getBtnPagar().removeActionListener(actionListenerPago);

			                    // Agregar el ActionListener para el botón de pagar
			                    tarjetaV.getBtnPagar().addActionListener(actionListenerPago);
							}
							else
							{
								model.InscribirEnCurso(idInscripcion,colegiado,cursoId,SwingUtil.Obtener_fechaActual(),false); //Inscribimos al alumno en el curso con transferencia
								Inscripcion_cursosController.this.getListaCursos(); //Actualizar la lista de cursos
								Justificante_Inscripción justificante= new Justificante_Inscripción(colegiado,SwingUtil.Obtener_fechaActual(),curso);
								justificante.getFrame().setVisible(true);
							}
						}
				}
				else
					{
						throw new ApplicationException("El campo no debe de estar vacio y debe seleccionar  e método de pago: ");
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
	}
	
	/**
	 * 	Obtiene la lista de cursos disponibles y los carga en el una tabla 
	 */
	public void getListaCursos() {
				ListaCursos=model.getListacursos();
				TableModel tmodel=SwingUtil.getTableModelFromPojos(ListaCursos, new String[] {"id_curso","titulo","descripcion","fecha_inicio","fecha_fin","duracion","plazas","cuota_precolegiado", "cuota_colegiado", "cuota_otros","apertura_inscripcion","cierre_inscripcion","estado"});
				view.getTabCurso().setModel(tmodel);
				SwingUtil.autoAdjustColumns(view.getTabCurso());			
	}
	
	/**
	 * Obtiene los datoS y los almacena en una clase llamada ColegiadoDTO y crea una tabla para mostrar los datos correspondientes
	 * @return El objeto de la clase ColeegiadoDTO
	 */
	public ColegiadoDTO getDatosColegiados() {
		ColegiadoDTO colegiado=model.getDatosColegiado(Integer.parseInt(view.getJTnumero().getText()));
		TableModel tmodel=SwingUtil.getTableModelFromPojos(List.of(colegiado), new String[] {"id_colegiado", "nombre", "apellidos","direccion", "poblacion", "titulacion","fecha_colegiacion","cuenta_bancaria"});
		view.getTabDatos().setModel(tmodel);
		SwingUtil.autoAdjustColumns(view.getTabDatos());
		return colegiado;
	}
	/**
	 * Si el campo de busqueda id no está vacio , un curso está seleccionado, y algun método de pago tambien devolverá true sino false
	 * @return booleano
	 */
	boolean comprobar_campos() {
		if(view.getJTnumero().getText().isEmpty()) {
			JOptionPane.showMessageDialog(view.getFrame(), "Debe ingresar su identificdor.", "Error", JOptionPane.WARNING_MESSAGE);
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
        
        if((calActual.get(Calendar.YEAR) > calSel.get(Calendar.YEAR)) || (calActual.get(Calendar.YEAR) == calSel.get(Calendar.YEAR) && calActual.get(Calendar.MONTH) > calSel.get(Calendar.MONTH)))
        	{
        	JOptionPane.showMessageDialog(tarjetaV.getFrame(), "La fecha ha caducado.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        	} //cOMPRUEBA SI LA FECHA ACTUAL ES IGUAL O O INFERIOR A LA FECHA DE CADUCIDAD SINÓ NO DEJARÁ MATRICULARSE

        return true;
	}
	
}