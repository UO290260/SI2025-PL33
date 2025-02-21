package giis.demo.inscripcion_colegiados;

import giis.demo.util.SwingUtil;

public class Inscripcion_colegiadosController {

	private Inscripcion_colegiadosModel modelo;
	private Inscripcion_colegiadosView vista;
	
	
	public Inscripcion_colegiadosController(Inscripcion_colegiadosModel model, Inscripcion_colegiadosView view) {
		this.modelo = model;
		this.vista = view;
		this.initView();
	}
	
	/**
	 * Incializa la vista de la interfaz 
	 */
	public void initView() {
		//getFrame , metodo de la clase View para poder acceder a el	
		vista.getFrame().setVisible(true); 
	}
	
	public void initController() {
		//ActionListener define solo un metodo actionPerformed(), es un interfaz funcional que se puede invocar de la siguiente forma:
		//view.getBtnTablaCarreras().addActionListener(e -> getListaCarreras());
		//ademas invoco el metodo que responde al listener en el exceptionWrapper para que se encargue de las excepciones
		
		/**
		 * vista.getBtnInscribirColegiado().addActionListener(e -> SwingUtil.exceptionWrapper(() -> getListaCarreras()));
		 */
	
		//En el caso del mouse listener (para detectar seleccion de una fila) no es un interfaz funcional puesto que tiene varios metodos
		//ver discusion: https://stackoverflow.com/questions/21833537/java-8-lambda-expressions-what-about-multiple-methods-in-nested-class
		/**
		 * 
		 
		vista.getTablaCarreras().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				//no usa mouseClicked porque al establecer seleccion simple en la tabla de carreras
				//el usuario podria arrastrar el raton por varias filas e interesa solo la ultima
				SwingUtil.exceptionWrapper(() -> updateDetail());
			}
		});
		*/
	}
}
