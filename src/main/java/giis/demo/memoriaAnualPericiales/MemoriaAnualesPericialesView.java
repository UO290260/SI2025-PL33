package giis.demo.memoriaAnualPericiales;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.SystemColor;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class MemoriaAnualesPericialesView {
	private JFrame frmIncidenciasPericiales;
	private JTable TablaPericiales;
	private JComboBox <Object> ComboAño;
	private JComboBox <Object> ComboEstado;
	
	public MemoriaAnualesPericialesView()
	{
		this.initialize();
	}
	
	private void initialize() 
	{
		frmIncidenciasPericiales = new JFrame();
		frmIncidenciasPericiales.setResizable(false);
		frmIncidenciasPericiales.setTitle("Incidencias periciales");
		frmIncidenciasPericiales.setName("Incidencias periciales");
		frmIncidenciasPericiales.setBounds(0, 0, 740, 250);
		frmIncidenciasPericiales.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		frmIncidenciasPericiales.setLocationRelativeTo(null);
		frmIncidenciasPericiales.getContentPane().setLayout(null);
		
		JLabel lblIncidencias = new JLabel("Incidencias de periciales: ");
		lblIncidencias.setBounds(10, 11, 143, 14);
		frmIncidenciasPericiales.getContentPane().add(lblIncidencias);
		
		JLabel lblAño = new JLabel("Año");
		lblAño.setBounds(186, 11, 49, 14);
		frmIncidenciasPericiales.getContentPane().add(lblAño);
		
		ComboAño = new JComboBox<>(cargarAños(2017).toArray(new String[0])); //Carga la lista desde el año actual hasta el que se elija
		ComboAño.setBounds(220, 7, 90, 22);
		frmIncidenciasPericiales.getContentPane().add(ComboAño);
		
		
		
		JLabel lblEstado = new JLabel("Estado");
		lblEstado.setBounds(386, 11, 49, 14);
		frmIncidenciasPericiales.getContentPane().add(lblEstado);
		
		ComboEstado = new JComboBox<>(cargarEstados().toArray(new String[0]));
		ComboEstado.setBounds(478, 7, 143, 22);
		frmIncidenciasPericiales.getContentPane().add(ComboEstado);
		
		TablaPericiales = new JTable();
		TablaPericiales.setName("tablaPericiales");
		TablaPericiales.setRowSelectionAllowed(false);
		TablaPericiales.setDefaultEditor(Object.class, null); 
		TablaPericiales.setBackground(SystemColor.control);
		
		JScrollPane scrollPane = new JScrollPane(TablaPericiales);
		scrollPane.setBounds(10, 60, 706, 123);
		frmIncidenciasPericiales.getContentPane().add(scrollPane);	
	}
	
	public List<String> cargarAños(int año)
	{
		int anioActual = LocalDate.now().getYear();
		List<String> anios= new ArrayList<>();
		while(anioActual>=año)
		{
			anios.add(String.valueOf(anioActual));
			anioActual--;
		}
		return anios;
	}
	
	public List<String> cargarEstados()
	{
		List<String> estados= new ArrayList<>();
		estados.add("Aceptado");
		estados.add("Rechazado");
		estados.add("Pendiente");
		estados.add("Todos");
		return estados;
	}

	public JFrame getFrmIncidenciasPericiales() {return frmIncidenciasPericiales;}
	public JTable getTablaPericiales() {return TablaPericiales;}
	public JComboBox<Object> getComboAño() {return ComboAño;}
	public JComboBox<Object> getComboEstado() {return ComboEstado;}
}
