package giis.demo.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

import giis.demo.dto.CursosDTO;
import giis.demo.models.OfertarCursosModel;
import giis.demo.views.OfertarCursosJustificante;
import giis.demo.views.OfertarCursosView;

public class OfertarCursosController {
	private OfertarCursosModel model;
	private OfertarCursosView view;
	private OfertarCursosJustificante justificante;
	
	public OfertarCursosController(OfertarCursosModel m, OfertarCursosView v) {
		this.model = m;
		this.view = v;
		
		this.initView();	
	}
	
	/**
	 * Acciones que se van a ejecutar al iniciar el programa
	 */
	public void initView() {
		view.getFrame().setVisible(true);
		
		//Para que los cuadros de texto comiencen en el mismo estado que sus checkBox
		view.getCuotaPrecolegiado().setEnabled(false);
		view.getCuotaColegiado().setEnabled(false);
		view.getCuotaMinusvalido().setEnabled(false);
		view.getCuotaDesempleado().setEnabled(false);
		view.getCuotaEmpleado().setEnabled(false);
		view.getCuotaAlumno().setEnabled(false);
		view.getCuotaEmpresa().setEnabled(false);
		view.getCuotaOtros().setEnabled(false);
		view.getPorcentaje().setEnabled(false);
		view.getCalFechaCancel().setEnabled(false);
		
		//Cambiamos el método que registra las teclas pulsadas para que solo acepte formátos numéricos
		view.getCuotaPrecolegiado().addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) { 
				char c = e.getKeyChar();
				if (!Character.isDigit(c) && c != '\b') { 
					e.consume();
				}
			}
		});
		
		//Cambiamos el método que registra las teclas pulsadas para que solo acepte formátos numéricos
		view.getCuotaColegiado().addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) { 
				char c = e.getKeyChar();
				if (!Character.isDigit(c) && c != '\b') { 
					e.consume();
				}
			}
		});
		
		//Cambiamos el método que registra las teclas pulsadas para que solo acepte formátos numéricos
		view.getCuotaMinusvalido().addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) { 
				char c = e.getKeyChar();
				if (!Character.isDigit(c) && c != '\b') { 
					e.consume();
				}
			}
		});
		
		//Cambiamos el método que registra las teclas pulsadas para que solo acepte formátos numéricos
		view.getCuotaDesempleado().addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) { 
				char c = e.getKeyChar();
				if (!Character.isDigit(c) && c != '\b') { 
					e.consume();
				}
			}
		});
				
		//Cambiamos el método que registra las teclas pulsadas para que solo acepte formátos numéricos
		view.getCuotaEmpleado().addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) { 
				char c = e.getKeyChar();
				if (!Character.isDigit(c) && c != '\b') { 
					e.consume();
				}
			}
		});
				
		//Cambiamos el método que registra las teclas pulsadas para que solo acepte formátos numéricos
		view.getCuotaAlumno().addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) { 
				char c = e.getKeyChar();
				if (!Character.isDigit(c) && c != '\b') { 
					e.consume();
				}
			}
		});
			
				//Cambiamos el método que registra las teclas pulsadas para que solo acepte formátos numéricos
		view.getCuotaEmpresa().addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) { 
				char c = e.getKeyChar();
				if (!Character.isDigit(c) && c != '\b') { 
					e.consume();
				}
			}
		});
		
		//Cambiamos el método que registra las teclas pulsadas para que solo acepte formátos numéricos
		view.getCuotaOtros().addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) { 
				char c = e.getKeyChar();
				if (!Character.isDigit(c) && c != '\b') { 
					e.consume();
				}
			}
		});
		
		//Cambiamos el método que registra las teclas pulsadas para que solo acepte formátos numéricos
		view.getPlazas().addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) { 
				char c = e.getKeyChar();
				if (!Character.isDigit(c) && c != '\b') { 
					e.consume();
				}
			}
		});
		
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
		
		//Cambiamos el método que registra las teclas pulsadas para que solo acepte formátos numéricos
		view.getPorcentaje().addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) { 
				char c = e.getKeyChar();
				if (!Character.isDigit(c) && c != '\b') { 
					e.consume();
				}
			}
		});
		
		//Acción ejecutada al pulsar el boton
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
		
		view.getCheckMinusvalido().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.getCuotaMinusvalido().setEnabled(view.getCheckMinusvalido().isSelected());
                if (!view.getCuotaMinusvalido().isEnabled()) view.getCuotaMinusvalido().setText("");
            }
        });
		
		view.getCheckDesempleado().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.getCuotaDesempleado().setEnabled(view.getCheckDesempleado().isSelected());
                if (!view.getCuotaDesempleado().isEnabled()) view.getCuotaDesempleado().setText("");
            }
        });
		
		view.getCheckEmpleado().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.getCuotaEmpleado().setEnabled(view.getCheckEmpleado().isSelected());
                if (!view.getCuotaEmpleado().isEnabled()) view.getCuotaEmpleado().setText("");
            }
        });
		
		view.getCheckAlumno().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.getCuotaAlumno().setEnabled(view.getCheckAlumno().isSelected());
                if (!view.getCuotaAlumno().isEnabled()) view.getCuotaAlumno().setText("");
            }
        });
		
		view.getCheckEmpresa().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.getCuotaEmpresa().setEnabled(view.getCheckEmpresa().isSelected());
                if (!view.getCuotaEmpresa().isEnabled()) view.getCuotaEmpresa().setText("");
            }
        });
		
		view.getCheckCancelable().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.getPorcentaje().setEnabled(view.getCheckCancelable().isSelected());
                view.getCalFechaCancel().setEnabled(view.getCheckCancelable().isSelected());
                if (!view.getPorcentaje().isEnabled()) view.getPorcentaje().setText("");
                if (!view.getCalFechaCancel().isEnabled()) view.getCalFechaCancel().setDate(null);
            }
        });

	}
	/**
	 * Metodo que ejecuta una serie de instrucciones con el fin de
	 * insertar un curso en la base de datos
	 */
	private void insertarCurso() {	
		//Pasar las fechas al formato de la base de datos
		Date fechaIni = view.getFechaIni();
		Date fechaFin = view.getFechaFin();
		Date fechaCancel = view.getFechaCancel();
		
		if (fechaIni == null) {
            JOptionPane.showMessageDialog(null, "La fecha de inicio no puede ser nula.");
            return;
        }
		
		if (fechaFin == null) {
            JOptionPane.showMessageDialog(null, "La fecha de fin no puede ser nula.");
            return;
        }
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String fechaIniStr = sdf.format(fechaIni);
		String fechaFinStr = sdf.format(fechaFin);
		String fechaCancelStr = null;
		if (fechaCancel != null) {
			fechaCancelStr = sdf.format(fechaCancel);
        }
		
		//Codigo para poder permitir campos nulos y que sean
		//detectados mas adelante
		int duracion = -1;
		int plazas = -1;
		int sesiones = -1;
		int cuotaPre = -1;
		int cuotaCol = -1;
		int cuotaMinus = -1;
		int cuotaDes = -1;
		int cuotaEmpl = -1;
		int cuotaAlu = -1;
		int cuotaEmpr = -1;
		int cuotaOtr = -1;
		int porcentaje = -1;
		if (!view.getDuracion().getText().isBlank()) duracion = Integer.parseInt(view.getDuracion().getText());
		if (!view.getPlazas().getText().isBlank()) plazas = Integer.parseInt(view.getPlazas().getText());
		if (!view.getPlazas().getText().isBlank()) sesiones = Integer.parseInt(view.getSesiones().getText());
		if (!view.getCuotaPrecolegiado().getText().isBlank()) cuotaPre = Integer.parseInt(view.getCuotaPrecolegiado().getText());
		if (!view.getCuotaColegiado().getText().isBlank()) cuotaCol = Integer.parseInt(view.getCuotaColegiado().getText());
		if (!view.getCuotaMinusvalido().getText().isBlank()) cuotaMinus = Integer.parseInt(view.getCuotaMinusvalido().getText());
		if (!view.getCuotaDesempleado().getText().isBlank()) cuotaDes = Integer.parseInt(view.getCuotaDesempleado().getText());
		if (!view.getCuotaEmpleado().getText().isBlank()) cuotaEmpl = Integer.parseInt(view.getCuotaEmpleado().getText());
		if (!view.getCuotaAlumno().getText().isBlank()) cuotaAlu = Integer.parseInt(view.getCuotaAlumno().getText());
		if (!view.getCuotaEmpresa().getText().isBlank()) cuotaEmpr = Integer.parseInt(view.getCuotaEmpresa().getText());
		if (!view.getCuotaOtros().getText().isBlank()) cuotaOtr = Integer.parseInt(view.getCuotaOtros().getText());
		if (!view.getPorcentaje().getText().isBlank()) porcentaje = Integer.parseInt(view.getPorcentaje().getText());
		
		CursosDTO curso = new CursosDTO( model.incrementarID(), view.getTitulo().getText(), view.getDescripcion().getText(),
				fechaIniStr, fechaFinStr, duracion, plazas, sesiones, cuotaPre, cuotaCol, cuotaMinus, cuotaDes, cuotaEmpl, cuotaAlu, cuotaEmpr, cuotaOtr, 
				view.getCheckCancelable().isEnabled(), porcentaje, fechaCancelStr, view.getCheckEspera().isEnabled());
		
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
		
		if (fechaCancelStr != null && fechaCancel.after(fechaIni)) {
			JOptionPane.showMessageDialog(null, "La fecha de cancelación debe ser anterior a la fecha de inicio");
            return;
		}
		
		if (fechaCancelStr == null && curso.isCancelable()) {
			JOptionPane.showMessageDialog(null, "La fecha de cancelación no puede ser nula");
            return;
		}
		
		if (curso.getPorcentaje_devolucion() == -1 && curso.isCancelable()) {
			JOptionPane.showMessageDialog(null, "El porcentaje de devolución no puede ser nulo");
            return;
		}
		
		if ((curso.getPorcentaje_devolucion() > 100 || curso.getPorcentaje_devolucion() < 0) && curso.isCancelable()) {
			JOptionPane.showMessageDialog(null, "El porcentaje de devolución debe estar entre 0 y 100");
            return;
		}
		
		model.añadirCurso(curso.getId_curso(), curso.getTitulo(), curso.getDescripcion(), curso.getFecha_inicio(), curso.getFecha_fin(), curso.getDuracion(),
				curso.getPlazas(), curso.getSesiones(), curso.getCuota_precolegiado(), curso.getCuota_colegiado(), curso.getCuota_minusvalido(), curso.getCuota_desempleado(), 
				curso.getCuota_empleado(), curso.getCuota_alumno(), curso.getCuota_empresa(), curso.getCuota_otros(), curso.isCancelable(), curso.getPorcentaje_devolucion(),
				curso.getFecha_cancelacion(), curso.isLista_espera());
		view.getFrame().setVisible(false);
		justificante = new OfertarCursosJustificante(curso);
	}

}
