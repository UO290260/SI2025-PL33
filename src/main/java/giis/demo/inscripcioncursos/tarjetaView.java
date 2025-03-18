package giis.demo.inscripcioncursos;

import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import net.miginfocom.swing.MigLayout;

public class tarjetaView {

	private JFrame frame;
	private JTextField txtNumeroTarjeta;
	private JPasswordField txtCVV;
	private JButton btnPagar;
	private JSpinner spinner;

	public tarjetaView() {
		frame = new JFrame("Pago con Tarjeta");
		frame.setSize(420, 250);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setResizable(false); // para que la ventana no pueda cambiar de tamaño 
		frame.getContentPane().setLayout(new MigLayout("", "[grow]", "[][][grow][][][][][][][][]"));

		// Etiquetas y campos de entrada
		frame.add(new JLabel("Número de Tarjeta:"),"cell 0 0");
		txtNumeroTarjeta = new JTextField();
		txtNumeroTarjeta.setPreferredSize(new Dimension(200, 25));  // 200px de ancho, 25px de alto
		frame.add(txtNumeroTarjeta,"cell 1 0");

		frame.add(new JLabel("CVV:"),"cell 0 1");
		txtCVV = new JPasswordField();
		txtCVV.setPreferredSize(new Dimension(200, 25));  // 200px de ancho, 25px de alto
		frame.add(txtCVV,"cell 1 1");

		frame.add(new JLabel("Fecha de Caducidad (MM/YY):"),"cell 0 2");   
		// Crear Spinner con modelo de fecha
		SpinnerDateModel model = new SpinnerDateModel();
		spinner = new JSpinner(model);
		spinner.setPreferredSize(new Dimension(100, 25));// 200px de ancho, 25px de alto
		// Formatear Spinner para mostrar MM/YY
		JSpinner.DateEditor editor = new JSpinner.DateEditor(spinner, "MM/yy");
		((JFormattedTextField) editor.getTextField()).setEditable(false);
		spinner.setEditor(editor);
		frame.add(spinner,"cell 1 2,alignx right");

		// Botón de pago
		btnPagar = new JButton("Pagar");
		frame.add(new JLabel()); // Espacio vacío
		frame.add(btnPagar,"cell 1 4,alignx right");
	}

	public JFrame getFrame() {return frame;}
	public void setFrame(JFrame frame) {this.frame = frame;}
	public JTextField getTxtNumeroTarjeta() {return txtNumeroTarjeta;}
	public void setTxtNumeroTarjeta(JTextField txtNumeroTarjeta) {this.txtNumeroTarjeta = txtNumeroTarjeta;}
	public JPasswordField getTxtCVV() {return txtCVV;}
	public void setTxtCVV(JPasswordField txtCVV) {this.txtCVV = txtCVV;}
	public JButton getBtnPagar() {return btnPagar;}
	public void setBtnPagar(JButton btnPagar) {this.btnPagar = btnPagar;}
	public JSpinner getSpinner() {return spinner;}
	public void setSpinner(JSpinner spinner) {this.spinner = spinner;}

}
