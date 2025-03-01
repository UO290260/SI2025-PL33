package giis.demo.aperturacursos;
import java.awt.Dimension;
import java.awt.SystemColor;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import com.toedter.calendar.JDateChooser;
import net.miginfocom.swing.MigLayout;

public class apertura_cursosView {
	private JFrame frame;
	private JDateChooser DateApertura;
	private JDateChooser DateCierre;
	private JButton btnapertura;
	private JTable TabCurso;
	
	public apertura_cursosView() {
		iniciate();
	}
	
	private void iniciate() {
	    	frame = new JFrame();
			frame.setTitle("Apertura de curso");
			frame.setName("Apertura");
			frame.setBounds(0, 0, 692, 280);
			frame.setResizable(false); // para que la ventana no pueda cambiar de tamaño 
			frame.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
			frame.getContentPane().setLayout(new MigLayout("", "[grow]", "[][][grow][][][][][][][][]")); //Es el layout que usaremos dividiendolo en filas y columnas
			
			final JLabel lblapertura;
			final JLabel lblistacursos;
			lblapertura= new JLabel("Apertura para un nuevo curso");
			frame.getContentPane().add(lblapertura, "cell 0 0 3 1, center"); 
			
			final JLabel fecha_apertura;
			fecha_apertura= new JLabel("Fecha de apertura:");
			frame.getContentPane().add(fecha_apertura, "flowx,cell 0 2,gapright 10");
			
			DateApertura = new JDateChooser();
			DateApertura.setName("FechaApetura");
			DateApertura.setPreferredSize(new Dimension(200, 20));
			frame.getContentPane().add(DateApertura, "cell 0 2");
			 
			
			final JLabel fecha_cierre;
			fecha_cierre= new JLabel("Fecha de cierre:");
			frame.getContentPane().add(fecha_cierre, "flowx,cell 1 2,gapright 10");
			
			DateCierre = new JDateChooser();
			DateCierre.setName("FechaCierre");
			DateCierre.setPreferredSize(new Dimension(200, 20));
			frame.getContentPane().add(DateCierre, "cell 1 2");
		
		
		lblistacursos = new JLabel("Lista de los cursos planificados:");
		frame.getContentPane().add(lblistacursos, "cell 0 3");
		//Lista desplegable de cursos disponibles
		TabCurso = new JTable();
		TabCurso.setName("tabDetalle");
		TabCurso.setRowSelectionAllowed(true);
		TabCurso.setDefaultEditor(Object.class, null); //readonly
		TabCurso.setBackground(SystemColor.control);
		JScrollPane tableDetallePanelCursos = new JScrollPane(TabCurso);
		tableDetallePanelCursos.setMinimumSize(new Dimension(200,65));
		tableDetallePanelCursos.setPreferredSize(new Dimension(1000,100));
		frame.getContentPane().add(tableDetallePanelCursos, "cell 0 4 2 1");
		
		 
		btnapertura = new JButton("Abrir Curso");
		frame.getContentPane().add(btnapertura, "cell 1 7,alignx right");
	    }

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public JDateChooser getDateApertura() {
		return DateApertura;
	}

	public void setDateApertura(JDateChooser dateApertura) {
		DateApertura = dateApertura;
	}

	public JDateChooser getDateCierre() {
		return DateCierre;
	}

	public void setDateCierre(JDateChooser dateCierre) {
		DateCierre = dateCierre;
	}

	public JButton getBtnapertura() {
		return btnapertura;
	}

	public void setBtnapertura(JButton btnapertura) {
		this.btnapertura = btnapertura;
	}

	public JTable getTabCurso() {
		return TabCurso;
	}

	public void setTabCurso(JTable tabCurso) {
		TabCurso = tabCurso;
	}
}
