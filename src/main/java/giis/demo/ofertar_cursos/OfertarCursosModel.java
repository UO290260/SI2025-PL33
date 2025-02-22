package giis.demo.ofertar_cursos;

import java.util.Date;

import giis.demo.util.ApplicationException;
import giis.demo.util.Database;

public class OfertarCursosModel {
	private Database db= new Database();
	
	public static final String SQL_NUEVO_CURSO = 
			"INSERT INTO Cursos (id_curso, titulo, descripcion, fecha_inicio, fecha_fin, duracion, plazas, estado) "
			+ "VALUES (?, ?, ?, ?, ?, ?, ?, 'Planificado')";
	
	/*
	private void añadirCurso() {
		db.executeUpdate(SQL_NUEVO_CURSO, getId_curso(), getTitulo(), getDescripcion(), getFecha_inicio(), getFecha_fin(), getDuracion(), getPlazas());;
	}
	*/
	
	private void validarFechaCurso(Date ini, Date fin) {
		validateCondition(ini.compareTo(fin)<=0, "La fecha de inicio no puede ser posterior a la de fin");
	}
	
	private void validateCondition(boolean condition, String message) {
		if (!condition)
			throw new ApplicationException(message);
	}
}
