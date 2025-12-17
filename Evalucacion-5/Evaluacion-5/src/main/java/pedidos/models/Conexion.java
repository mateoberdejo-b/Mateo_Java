package pedidos.models;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {

	private static final String URL = "jdbc:mysql://localhost:3306/sistema_pedidos_mateo";
	private static final String USER = "root";
	private static final String PASS = ""; 
	
	public Connection getConnection() {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(URL, USER, PASS);			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	
}

