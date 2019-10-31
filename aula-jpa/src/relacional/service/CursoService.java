package relacional.service;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import relacional.db.BancoDeDados;
import relacional.model.Curso;

public class CursoService {

	
	private void salvaCurso(Curso curso) {
		
		try {
			PreparedStatement ps = BancoDeDados.conecta().prepareStatement("insert into curso (nome) values (?)");
			ps.setString(1, curso.getNome());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {
		new CursoService().salvaCurso(new Curso("Ciência da Computação"));
	}


}
