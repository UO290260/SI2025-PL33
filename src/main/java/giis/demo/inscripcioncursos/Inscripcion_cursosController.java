package giis.demo.inscripcioncursos;

import java.awt.event.KeyAdapter;


import java.awt.event.KeyEvent;
import java.util.List;

import javax.swing.ComboBoxModel;

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
            	if(e.getKeyCode() == KeyEvent.VK_ENTER && !view.getJTnumero().getText().isEmpty())
            	{
            		System.out.print("Hará algo mas adelante.....");
                }
            }
          
        });
			
	}
	
	public void getListaCursos() {
		//A modo de demo, se muestra tambien la misma informacion en forma de lista en un combobox
				List<Object[]> ListaCursos=model.getListacursos();
				ComboBoxModel<Object> lmodel=SwingUtil.getComboModelFromList(ListaCursos);
				view.getLstCursos().setModel(lmodel);;
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
