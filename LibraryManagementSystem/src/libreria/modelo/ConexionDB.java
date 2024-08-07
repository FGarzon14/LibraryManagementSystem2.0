package libreria.modelo;
import java.sql.*;


public class ConexionDB {
	
	private final String host;
	private final String user;
	private final String password;

	public ConexionDB() {
		this.host = "jdbc:mysql://localhost:3306/libreria";
		this.user = "admin";
		this.password = "1234";
	}
	
	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection(host, user, password);
		
	}

	public static void main(String[] args) {
		ConexionDB conexionDB = new ConexionDB();
		try(Connection connection = conexionDB.getConnection()){
			System.out.println("¡Conexión correcta!");
		} catch (SQLException e) {
			 throw new IllegalStateException("¡Problema al conectarse con la BD!", e);
		}

	}

}
