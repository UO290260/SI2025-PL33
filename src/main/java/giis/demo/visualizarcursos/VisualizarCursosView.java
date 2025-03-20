package giis.demo.visualizarcursos;

import java.awt.GridLayout;
import java.awt.SystemColor;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import net.miginfocom.swing.MigLayout;

public class VisualizarCursosView {
	
	private JFrame frame;
	private JTable tabla;
	private JComboBox<String> boxColectivos;
	
	public VisualizarCursosView() {
		initialize();
	}
	
	private void initialize() {
		
		JLabel lblColectivo;
		
		frame = new JFrame();
		frame.setTitle("Visualizar Cursos");
		frame.setName("Visualizar Cursos");
		frame.setBounds(0, 0, 1400, 550);
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
		tabla = new JTable();
		tabla.setName("tablaCursos");
		tabla.setRowSelectionAllowed(false);
		tabla.setDefaultEditor(Object.class, null); 
		tabla.setBackground(SystemColor.control);
		JScrollPane tableDetallePanel = new JScrollPane(tabla);
		frame.getContentPane().add(tableDetallePanel, "cell 0 13 2 1, grow, wrap");
		
	}
	
	public JFrame getFrame() { return frame; }
	public JTable getTabla() { return tabla; }
	public JComboBox<String> getOpcion() { return boxColectivos; }

}

