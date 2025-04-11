package giis.demo.asignarpericiales;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.SystemColor;
import javax.swing.JButton;

public class AsignarPericialesView {
	
	JFrame frame;
	JTable tablaPeritos, tablaPericiales;
	JButton boton;

	public AsignarPericialesView() {
		initialize();
	}
	
	/**
	 * Metodo que inicializa la ventana 
	 */
	public void initialize() {
		
		JLabel lblPericiales;
		JLabel lblPeritos;
		
		frame = new JFrame();
		frame.setBounds(0, 0, 999, 360);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);
		frame.setTitle("Asignar Periciales");
		frame.setName("Asignar Periciales");
		
		lblPericiales = new JLabel("Escoge pericial");
		lblPericiales.setBounds(182, 35, 97, 14);
		frame.getContentPane().add(lblPericiales);
		
		tablaPericiales = new JTable();
		tablaPericiales.setName("tablaPericiales");
		tablaPericiales.setRowSelectionAllowed(true);
		tablaPericiales.setDefaultEditor(Object.class, null); 
		tablaPericiales.setBackground(SystemColor.control);
		JScrollPane panelPericiales = new JScrollPane(tablaPericiales);
		panelPericiales.setBounds(10, 60, 440, 200);
		frame.getContentPane().add(panelPericiales);
		
		lblPeritos = new JLabel("Escoge perito");
		lblPeritos.setBounds(680, 35, 89, 14);
		frame.getContentPane().add(lblPeritos);
		
		tablaPeritos = new JTable();
		tablaPeritos.setName("tablaPeritos");
		tablaPeritos.setRowSelectionAllowed(true);
		tablaPeritos.setDefaultEditor(Object.class, null); 
		tablaPeritos.setBackground(SystemColor.control);
		JScrollPane panelPeritos = new JScrollPane(tablaPeritos);
		panelPeritos.setBounds(500, 60, 452, 200);
		frame.getContentPane().add(panelPeritos);
		
		boton = new JButton("Asignar");
		boton.setBounds(433, 287, 89, 23);
		frame.getContentPane().add(boton);	
	}
	
	public JFrame getFrame() { return frame; }
	public JTable getTablaPericiales() { return tablaPericiales; }
	public JTable getTablaPeritos() { return tablaPeritos; }
	public JButton getBoton() { return boton; }
}
