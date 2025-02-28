package giis.demo.inscripcion_colegiados;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import net.miginfocom.swing.MigLayout;

/**
 * Vista de la pantalla que muestra el justificante
 */
public class InscripcioncolegiadosJustifcante extends JFrame {
	private JFrame frame;
	private JButton btnCerrar;

	public InscripcioncolegiadosJustifcante(InscripcioncolegiadosDTO colegiado) {
		frame = new JFrame();
		frame.setTitle("Justificante de Inscripción");
		frame.setBounds(0, 0, 400, 275);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(new MigLayout("", "[grow]", "[][][grow][][][][][][][][]"));
		frame.setLocationRelativeTo(null);
		frame.setLocation(1000 ,200);

		frame.getContentPane().add(new JLabel("Nombre:" + colegiado.getNombre()), "growx, wrap");
		frame.getContentPane().add(new JLabel("Apellidos:" + colegiado.getApellidos()), "growx, wrap");
		frame.getContentPane().add(new JLabel("DNI:" + colegiado.getDNI()), "growx, wrap");
		frame.getContentPane().add(new JLabel("Dirección:" + colegiado.getDireccion()), "growx, wrap");
		frame.getContentPane().add(new JLabel("Población:" + colegiado.getPoblacion()), "growx, wrap");
		frame.getContentPane().add(new JLabel("Fecha de nacimiento:" + colegiado.getFecha_nacimiento()), "growx, wrap");
		frame.getContentPane().add(new JLabel("Fecha de solicitud:"+ colegiado.getFecha_colegiacion()), "growx, wrap");
		frame.getContentPane().add(new JLabel("Cuenta:" + colegiado.getCuenta_bancaria()), "growx, wrap");
		frame.getContentPane().add(new JLabel("Titulación:" + colegiado.getTitulacion()), "growx, wrap");

		btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(e -> frame.dispose());
		frame.getContentPane().add(btnCerrar , "span, center, wrap");
		frame.setVisible(true);  
	}
}