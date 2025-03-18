package giis.demo.visualizarinscritos;

import java.awt.SystemColor;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class VisualizarInscritosView {
	private JFrame frame;
	private JTable tablaCursos, tablaInscritos;
	private JLabel lblNumero;
	
	public VisualizarInscritosView() {
		initialize();
	}
	
	private void initialize() {
		
		JLabel lblCurso;
		JLabel lblInscritos;
		
		frame = new JFrame();
		frame.setTitle("Visualizar Inscritos");
		frame.setName("Visualizar Inscritos");
		frame.setBounds(0, 0, 795, 440);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);
		
		lblCurso = new JLabel("Selecciona un curso:");
		lblCurso.setBounds(7, 7, 400, 14);
		frame.getContentPane().add(lblCurso);
		
		tablaCursos = new JTable();
		tablaCursos.setName("tablaInscritos");
		tablaCursos.setRowSelectionAllowed(true);
		tablaCursos.setDefaultEditor(Object.class, null); 
		tablaCursos.setBackground(SystemColor.control);
		JScrollPane panelCursos = new JScrollPane(tablaCursos);
		panelCursos.setBounds(7, 32, 770, 150);
		frame.getContentPane().add(panelCursos);
		
		lblInscritos = new JLabel("Inscritos en el curso seleccionado:");
		lblInscritos.setBounds(7, 193, 400, 14);
		frame.getContentPane().add(lblInscritos);
		
		tablaInscritos = new JTable();
		tablaInscritos.setName("tablaInscritos");
		tablaInscritos.setRowSelectionAllowed(false);
		tablaInscritos.setDefaultEditor(Object.class, null); 
		tablaInscritos.setBackground(SystemColor.control);
		JScrollPane panelInscritos = new JScrollPane(tablaInscritos);
		panelInscritos.setBounds(7, 218, 770, 150);
		frame.getContentPane().add(panelInscritos);
		
		lblNumero = new JLabel("");
		lblNumero.setBounds(7, 376, 400, 14);
		frame.getContentPane().add(lblNumero);
	}
	
	public JFrame getFrame() { return frame; }
	public JTable getTablaInscritos() { return tablaInscritos; }
	public JTable getTablaCursos() { return tablaCursos; }
	public JLabel getLblNumero() { return lblNumero; }
}
