package giis.demo.planificarsesiones;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class PlanificarSesionesController {
	
	PlanificarSesionesModel model;
	PlanificarSesionesView view;
	
	public PlanificarSesionesController (PlanificarSesionesModel m, PlanificarSesionesView v) {
		model = m;
		view = v;
		
		initView();
	}
	
	public void initView() {
		view.getFrame().setVisible(true);
		
		//Cambiamos el método que registra las teclas pulsadas para que solo acepte formátos numéricos
				view.getDuracion().addKeyListener(new KeyAdapter() {
					@Override
					public void keyTyped(KeyEvent e) { 
						char c = e.getKeyChar();
						if (!Character.isDigit(c) && c != '\b') { 
							e.consume();
						}
					}
				});
	}
	
	
}
