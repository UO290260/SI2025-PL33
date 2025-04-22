package giis.demo.views;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.SystemColor;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import net.miginfocom.swing.MigLayout;

public class VisualizarCursosView {
	
	private JFrame frame;
	private JTable tablaCursos, tablaInscritos;
	private JComboBox<String> boxColectivos;
	private JButton boton;
	private JPanel panelBoton;
	
	public VisualizarCursosView() {
		initialize();
	}
	
	private void initialize() {
		
		JLabel lblColectivo;
		
		frame = new JFrame();
		frame.setTitle("Visualizar Cursos");
		frame.setName("Visualizar Cursos");
		frame.setBounds(0, 0, 1000, 550);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(new MigLayout("", "[grow]", "[][][grow][][][][][][][][]"));
		frame.setLocationRelativeTo(null);
		
		//Interfaz fuera de la tabla
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, "wrap, center");
		panel.setLayout(new GridLayout(1, 2, 20, 10));
		
		lblColectivo = new JLabel("Escoge colectivo");
		panel.add(lblColectivo);
		
		String[] colectivos = {"Todos", "Precolegiados", "Colegiados", "Minusválidos", "Desempleados", "Empleados", "Alumnos", "Empresas", "Otros"};
		boxColectivos = new JComboBox<>(colectivos);
		panel.add(boxColectivos);
				
		//Tabla para mostrar los cursos
		tablaCursos = new JTable();
		tablaCursos.setName("tablaCursos");
		tablaCursos.setRowSelectionAllowed(false);
		tablaCursos.setRowSelectionAllowed(true);
		tablaCursos.setDefaultEditor(Object.class, null);
		tablaCursos.setBackground(SystemColor.control);
		JScrollPane panelCursos = new JScrollPane(tablaCursos);
		frame.getContentPane().add(panelCursos, "cell 0 13 2 1, grow, wrap");
		
		//Tabla para mostrar los inscritos a un curso
		tablaInscritos = new JTable();
		tablaInscritos.setName("tablaInscritos");
		tablaInscritos.setRowSelectionAllowed(false);
		tablaInscritos.setDefaultEditor(Object.class, null); 
		tablaInscritos.setBackground(SystemColor.control);
		JScrollPane panelInscritos = new JScrollPane(tablaInscritos);
		frame.getContentPane().add(panelInscritos, "grow");
		
		//Boton para cancelar un curso
		panelBoton = new JPanel(new FlowLayout(FlowLayout.CENTER));
		boton = new JButton("Cancelar Curso");
		boton.setBounds(0, 0, 130, 23);
		panelBoton.add(boton);
		frame.getContentPane().add(panelBoton);
	}
	
	public JFrame getFrame() { return frame; }
	public JTable getTablaCursos() { return tablaCursos; }
	public JTable getTablaInscritos() { return tablaInscritos; }
	public JComboBox<String> getOpcion() { return boxColectivos; }
	public JButton getBoton() { return boton; }

}

