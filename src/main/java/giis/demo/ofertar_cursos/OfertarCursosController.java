package giis.demo.ofertar_cursos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.text.JTextComponent;

public class OfertarCursosController {
	private OfertarCursosModel model;
	private OfertarCursosView view;
	private OfertarCursosJustificante justificante;
	
	public OfertarCursosController(OfertarCursosModel m, OfertarCursosView v) {
		this.model = m;
		this.view = v;
		
		this.initView();	
	}

	public void initView() {
		view.getFrame().setVisible(true);
		
		//Para que comiencen en el mismo estado que sus checkBox
		view.getCuotaPrecolegiado().setEnabled(false);
		view.getCuotaColegiado().setEnabled(false);
		view.getCuotaOtros().setEnabled(false);
		
		view.getCuotaPrecolegiado().addKeyListener(new KeyAdapter() {
			//Cambiamos el método que registra las teclas pulsadas para que solo acepte formátos numéricos
			@Override
			public void keyTyped(KeyEvent e) { 
				char c = e.getKeyChar();
				if (!Character.isDigit(c) && c != '\b') { 
					e.consume();
				}
			}
		});
		
		view.getCuotaColegiado().addKeyListener(new KeyAdapter() {
			//Cambiamos el método que registra las teclas pulsadas para que solo acepte formátos numéricos
			@Override
			public void keyTyped(KeyEvent e) { 
				char c = e.getKeyChar();
				if (!Character.isDigit(c) && c != '\b') { 
					e.consume();
				}
			}
		});
		
		view.getCuotaOtros().addKeyListener(new KeyAdapter() {
			//Cambiamos el método que registra las teclas pulsadas para que solo acepte formátos numéricos
			@Override
			public void keyTyped(KeyEvent e) { 
				char c = e.getKeyChar();
				if (!Character.isDigit(c) && c != '\b') { 
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
		
		//Metodos para que solo se puedan introducir las cuotas de los colectivos a los que va dirigido el curso
		view.getCheckPrecolegiado().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.getCuotaPrecolegiado().setEnabled(view.getCheckPrecolegiado().isSelected());
                if (!view.getCuotaPrecolegiado().isEnabled()) view.getCuotaPrecolegiado().setText("");
            }
        });
		
		view.getCheckOtros().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.getCuotaOtros().setEnabled(view.getCheckOtros().isSelected());
                if (!view.getCuotaOtros().isEnabled()) view.getCuotaOtros().setText("");
            }
        });
		
		view.getCheckColegiado().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.getCuotaColegiado().setEnabled(view.getCheckColegiado().isSelected());
                if (!view.getCuotaColegiado().isEnabled()) view.getCuotaColegiado().setText("");
            }
        });

	}
	
	private void insertarCurso() {	
		//Pasar las fechas al formato de la base de datos
		Date fechaIni = view.getFechaIni();
		Date fechaFin = view.getFechaFin();
		
		if (fechaIni == null) {
            JOptionPane.showMessageDialog(null, "La fecha de inicio no puede ser nula.");
            return;
        }
		
		if (fechaFin == null) {
            JOptionPane.showMessageDialog(null, "La fecha de fin no puede ser nula.");
            return;
        }
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		String fechaIniStr = sdf.format(fechaIni);
		String fechaFinStr = sdf.format(fechaFin);
		
		//Codigo para poder permitir nulos los campos
		int duracion = -1;
		int plazas = -1;
		int cuotaPre = -1;
		int cuotaCol = -1;
		int cuotaOtr = -1;
		if (!view.getDuracion().getText().isBlank()) duracion = Integer.parseInt(view.getDuracion().getText());
		if (!view.getPlazas().getText().isBlank()) plazas = Integer.parseInt(view.getPlazas().getText());
		if (!view.getCuotaPrecolegiado().getText().isBlank()) cuotaPre = Integer.parseInt(view.getCuotaPrecolegiado().getText());
		if (!view.getCuotaColegiado().getText().isBlank()) cuotaCol = Integer.parseInt(view.getCuotaColegiado().getText());
		if (!view.getCuotaOtros().getText().isBlank()) cuotaOtr = Integer.parseInt(view.getCuotaOtros().getText());
		
		OfertarCursosDTO curso = new OfertarCursosDTO( model.incrementarID(),
				view.getTitulo().getText(),
				view.getDescripcion().getText(),
				fechaIniStr,
				fechaFinStr,
				duracion,
				plazas,
				cuotaPre,
				cuotaCol,
				cuotaOtr);
		
		//Comprobaciones para que el formulario sea correcto
		if (fechaFin.before(fechaIni)) {
            JOptionPane.showMessageDialog(null, "La fecha de fin debe ser posterior a la fecha de inicio.");
            return;
        }
		
		if (curso.getTitulo().isBlank()) {
            JOptionPane.showMessageDialog(null, "El titulo no puede ser nulo");
            return;
        }
		
		if (curso.getDescripcion().isBlank()) {
            JOptionPane.showMessageDialog(null, "La descripcion no puede ser nula");
            return;
        }
		
		if (curso.getPlazas() == 0 || (view.getPlazas().getText().isBlank())) {
            JOptionPane.showMessageDialog(null, "No puede haber 0 plazas o plazas nulas");
            return;
        }
		
		if (curso.getDuracion() == 0 || (view.getDuracion().getText().isBlank())) {
            JOptionPane.showMessageDialog(null, "La duracion no puede ser 0 o nula");
            return;
        }
		
		model.añadirCurso(curso.getId_curso(), curso.getTitulo(), curso.getDescripcion(), curso.getFecha_inicio(), curso.getFecha_fin(), curso.getDuracion(),
				curso.getPlazas(), curso.getCuota_precolegiado(), curso.getCuota_colegiado(), curso.getCuota_otros());
		view.getFrame().setVisible(false);
		justificante = new OfertarCursosJustificante(curso);
	}

}
