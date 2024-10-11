package libreria.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

public class DevolucionDAO {
	ConexionDB conexionDB;

	public DevolucionDAO() {

		conexionDB = new ConexionDB();
	}

	public boolean anadirDevolucion(Devolucion devolucion) throws SQLException{

		if(!checkPrestamo(devolucion.getLibroId())) {
			return false;
		}
		if(!checkUsuario(devolucion.getUsuarioId())) {
			return false;
		}


		try(Connection conexion = conexionDB.getConnection()){
			System.out.println("Conexion a la DB establecida. "
					+ "Función anadirDevolucion");


			/*
			 * Query para insertar la devolución
			 */

			String query = "INSERT INTO devoluciones (usuario_id, "
					+ "libro_id, fecha_devolucion) VALUES (?,?,?)";

			PreparedStatement statement = conexion.prepareStatement(query);

			statement.setInt(1, devolucion.getUsuarioId());
			statement.setInt(2, devolucion.getLibroId());

			statement.setDate(3, new java.sql.Date(devolucion.getFechaDevolucion().getTime())); 

			int numOfRows = statement.executeUpdate();
			if(numOfRows > 0) {
				actualizarPrestamo(devolucion.getLibroId());
				JOptionPane.showMessageDialog(null, "Devolución realizada con éxito");
				return true;
			}


		}

		return false;
	}

	private boolean checkPrestamo(int libroID) {
	    String checkQuery = "SELECT COUNT(*) FROM prestamos WHERE libro_id = ? AND estado_devuelto = FALSE";

	    try (Connection conexion = conexionDB.getConnection();
	         PreparedStatement checkStatement = conexion.prepareStatement(checkQuery)) {

	        checkStatement.setInt(1, libroID);
	        ResultSet checkResultSet = checkStatement.executeQuery();
	        checkResultSet.next();
	        int checkCount = checkResultSet.getInt(1);

	        if (checkCount == 0) {
	            JOptionPane.showMessageDialog(null, "No existe ningún préstamo activo para el libro con el ID indicado.");
	            return false;
	        } else {
	            return true;
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	        return false;
	    }
	}


	private boolean checkUsuario(int usuarioID) {
		String query = "SELECT COUNT(*) FROM usuarios WHERE usuario_id = ?";
		try (Connection conexion = conexionDB.getConnection()){
			PreparedStatement statement = conexion.prepareStatement(query);
			statement.setInt(1, usuarioID);
			ResultSet resultSet = statement.executeQuery();
			resultSet.next();
			int checkCount = resultSet.getInt(1);
			if(checkCount == 0) {
				JOptionPane.showMessageDialog(null, "No existe ningún usuario con el ID proporcionado");
				return false;
			} else {
				return true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}


	}

	private void actualizarPrestamo(int libroID) throws SQLException {

		try(Connection conexion = conexionDB.getConnection()){
			String query = "UPDATE prestamos SET estado_devuelto = true WHERE libro_id = ?"
					+ " AND estado_devuelto = FALSE";

			PreparedStatement statement = conexion.prepareStatement(query);
			statement.setInt(1, libroID);
			int numOfRows = statement.executeUpdate();
			if(numOfRows == 0) {
				JOptionPane.showMessageDialog(null, "No se pudo actualizar el estado "
						+ "del préstamo.");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<Devolucion> getTodasLasDevoluciones() {
		List<Devolucion> devoluciones = new ArrayList<>();
		String query = "SELECT * FROM devoluciones";
		
		try(Connection connection = conexionDB.getConnection()){
			PreparedStatement statement = connection.prepareStatement(query);
			ResultSet resultSet = statement.executeQuery();
			
			while(resultSet.next()) {
				int devolucionID = resultSet.getInt("id_devolucion");
				int usuarioID = resultSet.getInt("usuario_id");
				int libroID = resultSet.getInt("libro_id");
				Date fecha = resultSet.getDate("fecha_devolucion");
				
				Devolucion devolucion = new Devolucion(devolucionID, usuarioID,
						 libroID, fecha);
				
				devoluciones.add(devolucion);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return devoluciones;
	}

}
