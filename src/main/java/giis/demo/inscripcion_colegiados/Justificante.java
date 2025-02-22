package giis.demo.inscripcion_colegiados;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import net.miginfocom.swing.MigLayout;

public class Justificante extends JFrame {

	private JFrame frame;
	private JButton btnCerrar;

	public Justificante(Inscripcion_colegiadosEntity colegiado) {
		//FORMATO DE VENTANA
		frame = new JFrame();
		frame.setTitle("Justificante de Inscripción");
		frame.setBounds(0, 0, 400, 275);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(new MigLayout("", "[grow]", "[][][grow][][][][][][][][]"));
		frame.setLocationRelativeTo(null);

		//MUESTRA LOS DATOS RELLENADOS DE LA INSCRIPCION
		frame.getContentPane().add(new JLabel("Nombre:" + colegiado.getNombre()), "growx, wrap");
		frame.getContentPane().add(new JLabel("Apellidos:" + colegiado.getApellidos()), "growx, wrap");
		frame.getContentPane().add(new JLabel("DNI:" + colegiado.getDni()), "growx, wrap");
		frame.getContentPane().add(new JLabel("Dirección:" + colegiado.getDireccion()), "growx, wrap");
		frame.getContentPane().add(new JLabel("Población:" + colegiado.getPoblacion()), "growx, wrap");
		frame.getContentPane().add(new JLabel("Fecha de nacimiento:" + colegiado.getFechanacimiento()), "growx, wrap");
		frame.getContentPane().add(new JLabel("Fecha de solicitud:"+ colegiado.getFechasolicitud()), "growx, wrap");
		frame.getContentPane().add(new JLabel("Cuenta:" + colegiado.getCuenta()), "growx, wrap");
		frame.getContentPane().add(new JLabel("Titulación:" + colegiado.getTitulacion()), "growx, wrap");

		//BOTON CERRAR
		btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(e -> frame.dispose());
		frame.getContentPane().add(btnCerrar , "span, center, wrap");
		frame.setVisible(true);


	}


}