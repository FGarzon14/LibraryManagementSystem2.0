package libreria.modelo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class PrestamoDAO {
	
	ConexionDB conexionDB;

	public PrestamoDAO() {
		 conexionDB = new ConexionDB();
	}
	public boolean anadirPrestamo(Prestamo prestamo) throws SQLException {
	    String anadirQuery = "INSERT INTO prestamos (libro_id, usuario_id, fecha_prestamo, fecha_devolucion, estado_devuelto) VALUES (?, ?, ?, ?, ?)";

	    try (Connection conexion = conexionDB.getConnection()) {
	        System.out.println("Database connected");

	        // Verifica si el usuario existe
	        String checkUsuarioQuery = "SELECT COUNT(*) FROM usuarios WHERE usuario_id = ?";
	        PreparedStatement checkUsuarioStatement = conexion.prepareStatement(checkUsuarioQuery);
	        checkUsuarioStatement.setInt(1, prestamo.getUsuarioId());
	        ResultSet checkUsuarioResultSet = checkUsuarioStatement.executeQuery();
	        checkUsuarioResultSet.next();
	        int usuarioCount = checkUsuarioResultSet.getInt(1);

	        if (usuarioCount == 0) {
	            JOptionPane.showMessageDialog(null, "No existe ningún usuario con el ID proporcionado");
	            return false;
	        }

	        // Verifica si el libro existe
	        String checkLibroQuery = "SELECT COUNT(*) FROM libros WHERE libro_id = ?";
	        PreparedStatement checkLibroStatement = conexion.prepareStatement(checkLibroQuery);
	        checkLibroStatement.setInt(1, prestamo.getLibroId());
	        ResultSet checkLibroResultSet = checkLibroStatement.executeQuery();
	        checkLibroResultSet.next();
	        int libroCount = checkLibroResultSet.getInt(1);

	        if (libroCount == 0) {
	            JOptionPane.showMessageDialog(null, "No existe ningún libro con el ID proporcionado");
	            return false;
	        }

	        // Verifica si el libro ya está prestado
	        String checkPrestadoQuery = "SELECT COUNT(*) FROM prestamos WHERE libro_id = ? AND estado_devuelto = FALSE";
	        PreparedStatement checkPrestadoStatement = conexion.prepareStatement(checkPrestadoQuery);
	        checkPrestadoStatement.setInt(1, prestamo.getLibroId());
	        ResultSet checkPrestadoResultSet = checkPrestadoStatement.executeQuery();
	        checkPrestadoResultSet.next();
	        int prestadoCount = checkPrestadoResultSet.getInt(1);

	        if (prestadoCount > 0) {
	            JOptionPane.showMessageDialog(null, "El libro con id: " + prestamo.getLibroId() + " está ya en préstamo.");
	            return false;
	        }

	        // Procede a añadir el préstamo
	        PreparedStatement statement = conexion.prepareStatement(anadirQuery);
	        statement.setInt(1, prestamo.getLibroId());
	        statement.setInt(2, prestamo.getUsuarioId());

	        if (prestamo.getFechaPrestamo() != null) {
	            statement.setDate(3, new java.sql.Date(prestamo.getFechaPrestamo().getTime()));
	        } else {
	            statement.setNull(3, java.sql.Types.DATE);
	        }

	        if (prestamo.getFechaDevolucion() != null) {
	            statement.setDate(4, new java.sql.Date(prestamo.getFechaDevolucion().getTime()));
	        } else {
	            statement.setNull(4, java.sql.Types.DATE);
	        }

	        statement.setBoolean(5, prestamo.isEstadoDevuelto());

	        int numOfRows = statement.executeUpdate();

	        return numOfRows > 0;
	    }
	}
	
	public String obtenerTituloLibro(int libroID) {
		String query = "SELECT libro_titulo FROM libros WHERE libro_id = ?";
		String titulo = "";
		try (Connection conexion = conexionDB.getConnection()){
			PreparedStatement statement = conexion.prepareStatement(query);
			statement.setInt(1, libroID);
			ResultSet resultSet = statement.executeQuery();
			while(resultSet.next()) {
				titulo = resultSet.getString("libro_titulo");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return titulo;
	}
	
	public String obtenerNombreUsuario(int usuarioID) {
		String query = "SELECT usuario_nombre FROM usuarios WHERE usuario_ID = ?";
		String nombre = "";
		
		try (Connection conexion = conexionDB.getConnection()){
			PreparedStatement statement = conexion.prepareStatement(query);
			statement.setInt(1, usuarioID);
			ResultSet resultSet = statement.executeQuery();
			while(resultSet.next()) {
				nombre = resultSet.getString("usuario_nombre");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return nombre;
	}
	
	public List<Prestamo> getTodosLosPrestamos() throws SQLException{
		List<Prestamo> prestamos = new ArrayList<>();
		String query = "SELECT * FROM prestamos";
		
		try(Connection connection = conexionDB.getConnection()){
			PreparedStatement statement = connection.prepareStatement(query);
			ResultSet resultSet = statement.executeQuery();
			while(resultSet.next()) {
				int prestamoID = resultSet.getInt("id_prestamo");
				int usuarioID = resultSet.getInt("usuario_id");
				int libroID = resultSet.getInt("libro_id");
				Date fechaPrestamo = resultSet.getDate("fecha_prestamo");
				Date fechaDevolucion = resultSet.getDate("fecha_devolucion");
				Boolean estadoDevuelto = resultSet.getBoolean("estado_devuelto");
				
				Prestamo prestamo = new Prestamo(prestamoID, usuarioID,
						 libroID, fechaPrestamo, fechaDevolucion, estadoDevuelto);
				
				prestamos.add(prestamo);
			}
		}
		
		
		return prestamos;
	}
	
	  public List<Prestamo> getMisPrestamos(int usuarioID) throws SQLException{
	    	List<Prestamo> prestamos = new ArrayList<>();
		  	String query = "SELECT * FROM prestamos WHERE usuario_id = ?";
	    	
		  	try(Connection connection = conexionDB.getConnection()){
		  		PreparedStatement statement = connection.prepareStatement(query);
		  		statement.setInt(1, usuarioID);
		  		
		  		ResultSet resultSet = statement.executeQuery();
		  		while(resultSet.next()) {
		  			int prestamoID = resultSet.getInt("id_prestamo");
					int usuarioID2 = resultSet.getInt("usuario_id");
					int libroID = resultSet.getInt("libro_id");
					Date fechaPrestamo = resultSet.getDate("fecha_prestamo");
					Date fechaDevolucion = resultSet.getDate("fecha_devolucion");
					Boolean estadoDevuelto = resultSet.getBoolean("estado_devuelto");
					
					Prestamo prestamo = new Prestamo(prestamoID, usuarioID2,
							 libroID, fechaPrestamo, fechaDevolucion, estadoDevuelto);
					
					prestamos.add(prestamo);
		  		}
		  	}
			return prestamos;
	    	
	    }
	
}
