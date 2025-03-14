package giis.demo.visualizarinscritos;

import java.awt.SystemColor;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import net.miginfocom.swing.MigLayout;

public class VisualizarInscritosView {
	private JFrame frame;
	private JTable tablaCursos, tablaInscritos;
	
	public VisualizarInscritosView() {
		initialize();
	}
	
	private void initialize() {
		
		frame = new JFrame();
		frame.setTitle("Visualizar Inscritos");
		frame.setName("Visualizar Inscritos");
		frame.setBounds(0, 0, 800, 500);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(new MigLayout("", "[grow]", "[][][grow][][][][][][][][]"));
		frame.setLocationRelativeTo(null);
		
		tablaCursos = new JTable();
		tablaCursos.setName("tablaInscritos");
		tablaCursos.setRowSelectionAllowed(true);
		tablaCursos.setDefaultEditor(Object.class, null); 
		tablaCursos.setBackground(SystemColor.control);
		JScrollPane panelCursos = new JScrollPane(tablaCursos);
		frame.getContentPane().add(panelCursos, "cell 0 4 2 1, grow, wrap");
		
		tablaInscritos = new JTable();
		tablaInscritos.setName("tablaInscritos");
		tablaInscritos.setRowSelectionAllowed(false);
		tablaInscritos.setDefaultEditor(Object.class, null); 
		tablaInscritos.setBackground(SystemColor.control);
		JScrollPane panelInscritos = new JScrollPane(tablaInscritos);
		frame.getContentPane().add(panelInscritos, "cell 0 5 2 1, grow, wrap");
	}
	
	public JFrame getFrame() { return frame; }
	public JTable getTablaInscritos() { return tablaInscritos; }
	public JTable getTablaCursos() { return tablaCursos; }
}
