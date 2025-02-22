package giis.demo.ofertar_cursos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Date;

import javax.swing.JOptionPane;

public class OfertarCursosController {
	private OfertarCursosModel model;
	private OfertarCursosView view;
	
	public OfertarCursosController(OfertarCursosModel m, OfertarCursosView v) {
		this.model = m;
		this.view = v;
		
		this.initView();	
	}
	
	
	
	public void initView() {
		view.getFrame().setVisible(true);
		
		view.getCuota().addKeyListener(new KeyAdapter() {
			//Cambiamos el método que registra las teclas pulsadas para que solo acepte formátos numéricos
			@Override
			public void keyTyped(KeyEvent e) { 
				char c = e.getKeyChar();
				if (!Character.isDigit(c) && c != '\b' && c != ',' && c != '.') { 
					e.consume();
				}
			}
		});
		
		view.getPlazas().addKeyListener(new KeyAdapter() {
			//Cambiamos el método que registra las teclas pulsadas para que solo acepte formátos numéricos
			@Override
			public void keyTyped(KeyEvent e) { 
				char c = e.getKeyChar();
				if (!Character.isDigit(c) && c != '\b') { 
					e.consume();
				}
			}
		});
		
		view.getDuracion().addKeyListener(new KeyAdapter() {
			//Cambiamos el método que registra las teclas pulsadas para que solo acepte formátos numéricos
			@Override
			public void keyTyped(KeyEvent e) { 
				char c = e.getKeyChar();
				if (!Character.isDigit(c) && c != '\b') { 
					e.consume();
				}
			}
		});
		
		this.view.getBoton().addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            insertarCurso();
	        }
	    });
	}
	
	private void insertarCurso() {
		Date fechaIni = view.getFechaIni();
		Date fechaFin = view.getFechaFin();
		
		if (fechaFin.before(fechaIni)) {
            JOptionPane.showMessageDialog(null, "La fecha de fin debe ser posterior a la fecha de inicio.");
            return;
        }
		
	}

}
