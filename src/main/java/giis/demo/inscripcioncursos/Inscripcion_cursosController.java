package giis.demo.inscripcioncursos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;

import java.awt.event.KeyEvent;

import java.util.Date;
import java.util.List;

import javax.swing.table.TableModel;

import giis.demo.util.ApplicationException;
import giis.demo.util.SwingUtil;
import giis.demo.util.Util;

//Clase controller que actua como intermediario entre la interfaz y el modelo
public class Inscripcion_cursosController {
	private Inscripcion_cursosModel model;
	private Inscripcion_cursosView view;
	private List<CursosDTO> ListaCursos;

	public Inscripcion_cursosController(Inscripcion_cursosModel m, Inscripcion_cursosView v) {
		this.model = m;
		this.view = v;
		//no hay inicializacion especifica del modelo, solo de la vista
		this.initView();
	}
	
	//Mostrar la ventana generada en el modelo View
	public void initView() {
		view.getFrame().setVisible(true);
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
		
		view.getBtnInscripcion().addActionListener(new ActionListener() { //NOSONAR codigo autogenerado
			public void actionPerformed(ActionEvent e) {
				if(!view.getJTnumero().getText().isEmpty() && view.getTabCurso().getSelectedRow()!=-1) { //Comprueba que la Jtextnumero no se encuentre vacio y se selcciona un curso
					CursosDTO curso=ListaCursos.get(view.getTabCurso().getSelectedRow());
					int cursoId=curso.getId_curso();
					String fechaapertura=ListaCursos.get(view.getTabCurso().getSelectedRow()).getApertura_inscripcion();
					String cierre=ListaCursos.get(view.getTabCurso().getSelectedRow()).getCierre_inscripcion();
					ColegiadoDTO colegiado=Inscripcion_cursosController.this.getDatosColegiados(); //Obtiene el objeto de tipo ColegiadoDTO
					 Date fechaActual = Util.isoStringToDate(SwingUtil.Obtener_fechaActual()); // Convierte la fecha actual a LocalDate
					 Date fechaApertura = Util.isoStringToDate(fechaapertura); // Convierte la fecha de apertura de inscripción a LocalDate
					 Date fechaCierre = Util.isoStringToDate(cierre); // Convierte la fecha de cierre de inscripción a LocalDate
					if(model.Comprobar_Inscripción(colegiado.getId_colegiado(), cursoId)) { //Comprueba si el alumno está o no matriculado
						 	throw new ApplicationException("El alumno ya está matriculado: ");
						}
					if(!model.plazasDisponibles(cursoId)) //Comprueba si hay o no plazas disponibles 
						{
							throw new ApplicationException("No hay plazas disponibles");
						}
					if((fechaActual.before(fechaApertura) || fechaActual.after(fechaCierre))) //Comprueba si el alumno se puede matricular del curso 
					{
						throw new ApplicationException("No está disponible la inscripción del curso ");
					}
					else
						{
							int idInscripcion=model.ObtenerIdInscripcion(); //Obtenemos el nuevo id para insertar en la tabla
							model.InscribirEnCurso(idInscripcion,colegiado,cursoId,SwingUtil.Obtener_fechaActual()); //Inscribimos al alumno en el curso
							Inscripcion_cursosController.this.getListaCursos(); //Actualizar la lista de cursos
							Justificante_Inscripción justificante= new Justificante_Inscripción(colegiado,SwingUtil.Obtener_fechaActual(),curso);
							justificante.getFrame().setVisible(true);
						}
				}
				else
					{
						throw new ApplicationException("El campo no debe de estar vacio y debe seleccionar curso: ");
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
}