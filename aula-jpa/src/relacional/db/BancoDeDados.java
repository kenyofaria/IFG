package relacional.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BancoDeDados {

	
	private static final String url = "jdbc:postgresql://localhost/aula-jpa";
	private static Connection conn;

	public static Connection conecta() throws SQLException {
		if(conn == null)
			conn = DriverManager.getConnection(url, "postgres", "minhasenha");

		return conn;
	}
}
