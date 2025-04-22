package giis.demo.views;
import javax.swing.JFrame;
import javax.swing.JLabel;

import giis.demo.dto.ColegiadosDTO;
import giis.demo.dto.PeritosDTO;
import net.miginfocom.swing.MigLayout;

public class InscripcionlistaTAPJustificanteView extends JFrame {
	private JFrame frame;

	public InscripcionlistaTAPJustificanteView(ColegiadosDTO colegiado , PeritosDTO perito) {
		frame = new JFrame();
		frame.setTitle("Justificante");
		frame.setSize(600, 600); 
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setLayout(new MigLayout("", "[grow]", "[][][grow][][][][][][][][]"));
		frame.setLocationRelativeTo(null); 

		frame.getContentPane().add(new JLabel("Se ha generado el justificante de inscripcion en las listas de peritos privados "), "growx, wrap");
		frame.getContentPane().add(new JLabel("Nombre: " + colegiado.getNombre()), "growx, wrap");
		frame.getContentPane().add(new JLabel("Apellidos: " + colegiado.getApellidos()), "growx, wrap");
		frame.getContentPane().add(new JLabel("DNI: " + colegiado.getDni()), "growx, wrap");
		frame.getContentPane().add(new JLabel("Dirección: " + colegiado.getDireccion()), "growx, wrap");
		frame.getContentPane().add(new JLabel("Población: " + colegiado.getPoblacion()), "growx, wrap");
		frame.getContentPane().add(new JLabel("Teléfono: " + perito.getTelefono()), "growx, wrap");
		frame.getContentPane().add(new JLabel("Correo electrónico: " + perito.getCorreo()), "growx, wrap");
		frame.getContentPane().add(new JLabel("Fecha de solicitud:"+ perito.getFecha()), "growx, wrap");
		frame.getContentPane().add(new JLabel("Fecha de nacimiento: " + colegiado.getFecha_nacimiento()), "growx, wrap");
		frame.getContentPane().add(new JLabel("Cuenta bancaria: " + colegiado.getCuenta_bancaria()), "growx, wrap");
		frame.getContentPane().add(new JLabel("Titulación: " + colegiado.getTitulacion()), "growx, wrap");

		frame.setVisible(true);
		frame.pack();
	}
}