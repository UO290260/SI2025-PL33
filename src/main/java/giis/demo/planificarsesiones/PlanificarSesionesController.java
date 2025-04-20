package giis.demo.planificarsesiones;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;
import giis.demo.util.SwingUtil;

public class PlanificarSesionesController {
	
	PlanificarSesionesModel model;
	PlanificarSesionesView view;
	
	public PlanificarSesionesController (PlanificarSesionesModel m, PlanificarSesionesView v) {
		model = m;
		view = v;
		
		initView();
		mostrarCursos();
		mostrarSesiones();
	}
	
	/**
	 * Metodo que obtiene los cursos de la base de datos para cargarlos en la tabla de la interfaz
	 */
	public void mostrarCursos () {
		List<PlanificarSesionesDTO> cursos = model.getListaCursos();
		
		TableModel modelCursos = SwingUtil.getTableModelFromPojos(cursos, new String[]{
				"id_curso", "titulo", "descripcion", "fecha_inicio", "fecha_fin", "sesiones",  "estado"}
		);
		
		view.getTablaCursos().setModel(modelCursos);
		SwingUtil.autoAdjustColumns(view.getTablaCursos());
	}
	
	/**
	 * Funcion que carga las sesiones de un curso en la tabla
	 */
	public void mostrarSesiones () {
		view.getTablaCursos().getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
            	if ((int) view.getTablaCursos().getSelectedRow() != -1) {
            		List<SesionDTO> sesiones = model.listaSesiones((int) view.getTablaCursos().getValueAt(view.getTablaCursos().getSelectedRow(), 0));
                	TableModel modelSesiones = SwingUtil.getTableModelFromPojos(sesiones, new String[]{
            				"id_sesion", "id_curso", "fecha", "hora_inicio", "duracion"}
            		);
            		
            		view.getTablaSesiones().setModel(modelSesiones);
            		SwingUtil.autoAdjustColumns(view.getTablaSesiones());
                }
          	} 	
        });
	}
	
	/**
	 * Método que inserta en la base de datos una sesión
	 * 
	 */
	public void insertarSesion () {	
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String fechaStr = sdf.format(view.getFecha());
		
		PlanificarSesionesDTO cursoSel = model.getListaCursos().get((int) view.getTablaCursos().getValueAt(view.getTablaCursos().getSelectedRow(), 0) - 1);
		
		LocalDate fechaIni = LocalDate.parse(cursoSel.getFecha_inicio());
		LocalDate fechaFin = LocalDate.parse(cursoSel.getFecha_fin());
		LocalDate fecha = LocalDate.parse(fechaStr);
		
		if (cursoSel.getEstado().equals("Cancelado")) {
			JOptionPane.showMessageDialog(null, "No se puede planificar una sesion para un curso cancelado");
            return;
		}
		if (view.getFecha() == null) {
            JOptionPane.showMessageDialog(null, "La fecha no puede ser nula.");
            return;
        }
		if (view.getDuracion().getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "La duración no puede ser nula.");
            return;
        }
		if (view.getHoraInicio().getText().length() !=5) {
			JOptionPane.showMessageDialog(null, "La hora no está en formato HH:MM");
            return;
		}
		if (model.listaSesiones(cursoSel.getId_curso()).size() == 0 && !fechaStr.equals(cursoSel.getFecha_inicio())) {
			JOptionPane.showMessageDialog(null, "La primera sesión debe coincidir con la fecha de inicio");
            return;
		}
		if (model.listaSesiones(cursoSel.getId_curso()).size() == cursoSel.getSesiones()-1 && !fechaStr.equals(cursoSel.getFecha_fin())) {
			JOptionPane.showMessageDialog(null, "La ultima sesión debe coincidir con la fecha de fin");
            return;
		}
		if (fecha.isAfter(fechaFin) || fecha.isBefore(fechaIni)) {
			JOptionPane.showMessageDialog(null, "La fecha debe estar dentro del plazo del curso");
            return;
		}
		if (model.listaSesiones(cursoSel.getId_curso()).size() == cursoSel.getSesiones()) {
			JOptionPane.showMessageDialog(null, "Este curso tiene todas las sesiones planificiadas");
            return;
		}
		
		//Controlamos el solapamiento de sesiones
		List<SesionDTO> listaSesiones = model.listaSesiones(cursoSel.getId_curso());
		for (SesionDTO s : listaSesiones) {
			if (s.getFecha().equals(fechaStr)) {
				LocalTime horaIni = LocalTime.parse(s.getHora_inicio());
				LocalTime horaFin = horaIni.plusMinutes(s.getDuracion()*60);
				LocalTime nuevaHoraIni = LocalTime.parse(view.getHoraInicio().getText());
				LocalTime nuevaHoraFin = nuevaHoraIni.plusMinutes(Integer.parseInt(view.getDuracion().getText())*60);
			    
				if (nuevaHoraIni.isBefore(horaFin) && nuevaHoraFin.isAfter(horaIni)) {
					JOptionPane.showMessageDialog(null, "La sesión se solapa con otra ya planificada");
		            return;
				}
			}
		}
		
		model.añadirSesion(model.incrementarID(), cursoSel.getId_curso(), fechaStr, view.getHoraInicio().getText(), Integer.parseInt(view.getDuracion().getText()));
			JOptionPane.showMessageDialog(null, "Se ha añadido la sesión correctamente");
		view.getHoraInicio().setText("");
		view.getDuracion().setText("");
		view.getCalendario().setDate(null);
	} 
	
	/**
	 * Método para inicializar la ventana
	 */
	public void initView() {
		view.getFrame().setVisible(true);
		view.getDuracion().setEnabled(false);
		view.getCalendario().setEnabled(false);
		view.getHoraInicio().setEnabled(false);
		
		view.getTablaCursos().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int fila = view.getTablaCursos().getSelectedRow();
				if (fila != -1) {
					view.getDuracion().setEnabled(true);
					view.getCalendario().setEnabled(true);
					view.getHoraInicio().setEnabled(true);	
				}
			}
		});
		
		//Cambiamos el método que registra las teclas pulsadas para que solo acepte formátos numéricos
		view.getDuracion().addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) { 
				char c = e.getKeyChar();
				String texto = view.getDuracion().getText();
				if (!Character.isDigit(c) && c != '\b') { 
					e.consume();
				}
				if (texto.length()==1) {
					e.consume();
				}
			}
		});
		
		//Solo deja un formato de hora correcto
		view.getHoraInicio().addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				String texto = view.getHoraInicio().getText();		
				if (texto.length() == 0) {  
		            if (c < '0' || c > '2') 
		            	e.consume();
		        } 
		        else if (texto.length() == 1) {  
		            if (texto.charAt(0) == '2' && (c < '0' || c > '3')) 
		            	e.consume();
		            else if (texto.charAt(0) != '2' && (c < '0' || c > '9')) 
		            	e.consume();
		        } 
		        else if (texto.length() == 2) {  
		            if (c != ':') 
		            	e.consume();
		        } 
		        else if (texto.length() == 3) {  
		            if (c < '0' || c > '5') 
		            	e.consume();
		        } 
		        else if (texto.length() == 4) {  
		            if (c < '0' || c > '9') 
		            	e.consume();
		        } 
		        else 
		            e.consume();
			}
		});	
		
		//Acción ejecutada al pulsar el boton
		this.view.getBoton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
					insertarSesion();
			}
		});	
	}
}
