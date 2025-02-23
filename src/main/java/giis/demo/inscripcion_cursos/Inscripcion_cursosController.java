package giis.demo.inscripcion_cursos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;



import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.TableModel;

import giis.demo.util.ApplicationException;
import giis.demo.util.Database;
import giis.demo.util.SwingUtil;
import giis.demo.util.Util;



public class Inscripcion_cursosController {
	private Inscripcion_cursosModel model;
	private Inscripcion_cursosView view;
	private String lastSelectedKey="";
	
	
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
				if(!view.getJTnumero().getText().isEmpty()) { //Comprueba que la Jtextnumero no se encuentre vacio
					int cursoId=Inscripcion_cursosController.this.obteneridCurso(); //Obtiene la ID del curso seleccionado
					ColegiadoDTO colegiado=Inscripcion_cursosController.this.getDatosColegiados(); //Obtiene el objeto de tipo ColegiadoDTO
					if(model.Comprobar_Inscripción(colegiado.getId_colegiado(), cursoId)) { //Comprueba si el alumno está o no matriculado
						 	throw new ApplicationException("El alumno ya está matriculado: ");
						}
					if(!model.plazasDisponibles(cursoId)) //Comprueba si hay o no plazas disponibles 
						{
							throw new ApplicationException("No hay plazas disponibles");
						}
					else
						{
							int idInscripcion=model.ObtenerIdInscripcion(); //Obtenemos el nuevo id para insertar en la tabla
							model.InscribirEnCurso(idInscripcion,colegiado,cursoId,Inscripcion_cursosController.this.Obtener_fechaActual()); //Inscribimos al alumno en el curso
						}
				
				}
				else
					{
						throw new ApplicationException("El campo no debe de estar vacio: ");
					}
			}
			
		});
			
	}
	
	/**
	 * 	Obtiene la lista de cursos disponibles y los carga en el comoboxmodel
	 */
	public void getListaCursos() {
		//A modo de demo, se muestra tambien la misma informacion en forma de lista en un combobox
		
				List<Object[]> ListaCursos=model.getListacursos();
				
				ComboBoxModel<Object> lmodel=SwingUtil.getComboModelFromList(ListaCursos);
				 
				view.getLstCursos().setModel(lmodel);			
		
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
	 * Obtiene el ID del curso seleccionado en la lista
	 * @return el identificador del curso en formato entero
	 */
	public int obteneridCurso() {
		Object curso=  view.getLstCursos().getSelectedItem();
		String  [] partes=curso.toString().split(" - ");
		return Integer.parseInt(partes[0]);	
	}
	
	/**
	 * Obtiene la fecha actual y la trasforma a un formato asequible para la base de datos
	 * @return la fecha actual en formato cadena
	 */
	public String Obtener_fechaActual() {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        // Obtener la fecha actual
        Date currentDate = new Date();

        // Formatear la fecha actual
        return formatter.format(currentDate);
	}
	
		 
}
