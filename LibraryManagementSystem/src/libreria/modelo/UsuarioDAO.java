package libreria.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

public class UsuarioDAO {
	ConexionDB conexionDB;

	public UsuarioDAO() {
		
		conexionDB = new ConexionDB();
		
	}

	public void anadirUsuario(Usuario usuario) throws SQLException {
		String query = "INSERT INTO usuarios (usuario_nombre, usuario_password, "
				+ "usuario_fecha_nacimiento, usuario_correo, usuario_tipo) "
				+ "VALUES (?, ?, ?, ?, ?)";
		
		try(Connection conexion = conexionDB.getConnection()){
			System.out.println("Conexión a la DB establecida");
			
			PreparedStatement statement = conexion.prepareStatement(query);
			statement.setString(1, usuario.getNombre());
			statement.setString(2, usuario.getContrasena());

			if(usuario.getFechaNacimiento() != null) {
				statement.setDate(3, new java.sql.Date(usuario.getFechaNacimiento().getTime()));
			} else {
				statement.setNull(3, java.sql.Types.DATE);
			}
			
			statement.setString(4, usuario.getCorreo());
			statement.setInt(5, usuario.getTipo());
			
			int numOfRows = statement.executeUpdate();
			System.out.println("Statement executed");
			if(numOfRows > 0) {
				System.out.println("Usuario añadido");
			
			} else {
				System.out.println("Error al añadir usuario");
				JOptionPane.showMessageDialog(null, "Error al introducir el usuario");
			}
			
		}
				
	}
	
	public void eliminarUsuario(Usuario usuario) throws SQLException {
		StringBuilder query = new StringBuilder("DELETE FROM usuarios where 1=1 ");
		
		if(usuario.getId() != -1) {
			query.append(" AND usuario_id LIKE ? ");
		}
		
		if(usuario.getNombre() != null && !usuario.getNombre().isEmpty()) {
			query.append(" AND usuario_nombre LIKE ? ");
		}
		
		if(usuario.getFechaNacimiento() != null) {
			query.append(" AND usuario_fecha_nacimiento LIKE ? ");
		}
		
		if(usuario.getCorreo() != null && !usuario.getCorreo().isEmpty()) {
			query.append(" AND usuario_correo LIKE ? ");
		}
		
		if(usuario.getTipo() != -1) {
			query.append(" AND usuario_tipo LIKE ? ");
		}
		
		try(Connection conexion = conexionDB.getConnection()){
			PreparedStatement statement = conexion.prepareStatement(query.toString());
		
			int paramIndex = 1;
			
			if(usuario.getId() != -1) {
				statement.setInt(paramIndex++, usuario.getId());
			}
			
			if(usuario.getNombre() != null && !usuario.getNombre().isEmpty()) {
				statement.setString(paramIndex++, "%" + usuario.getNombre() + "%");
			}
			
			if(usuario.getFechaNacimiento() != null) {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				String fechaStr = sdf.format(usuario.getFechaNacimiento());
				statement.setString(paramIndex++, "%" + fechaStr + "%");
			}
			
			if(usuario.getCorreo() != null && !usuario.getCorreo().isEmpty()) {
				statement.setString(paramIndex++, usuario.getCorreo());
			}
			
			if(usuario.getTipo() != -1) {
				statement.setInt(paramIndex++, usuario.getTipo());
			}
			
			int numOfRows = statement.executeUpdate();
			if(numOfRows > 0) {
				JOptionPane.showMessageDialog(null, "El usuario ha sido eliminado");
				System.out.println("Usuario eliminado");
			} else {
				JOptionPane.showMessageDialog(null, "El usuario no ha sido encontrado");
				System.out.println("Usuario no encontrado");
			}
		}	
	}
	
	public void eliminarUsuarioConfirmacion (Usuario usuario) throws SQLException {
		Usuario usuarioEncontrado = buscarUsuario(usuario);
		
		if(usuarioEncontrado == null) {
			JOptionPane.showMessageDialog(null, "El usuario con los criterios establecidos"
					+ " no ha sido encontrado");
			System.out.println("Usuario no encontrado. "
					+ "Función eliminarUsuarioConfirmacion");
			return;
		}
		
		String mensaje = String.format(
				"¿Desea eliminar el siguiente usuario?\n\nID: %d"
				+ "\nNombre: %s",
				usuarioEncontrado.getId(),
				usuarioEncontrado.getNombre()
				);
		
		int confirmacion = JOptionPane.showConfirmDialog(null, mensaje);
		
		if(confirmacion == JOptionPane.YES_OPTION) {
			eliminarUsuario(usuarioEncontrado);
		}
	}
	
	public Usuario buscarUsuario (Usuario usuario) throws SQLException {
		StringBuilder query = new StringBuilder("SELECT * FROM usuarios WHERE 1 = 1 ");
		
		if(usuario.getId() != -1) {
			query.append(" AND usuario_id LIKE ? ");
		}
		
		if(usuario.getNombre() != null && !usuario.getNombre().isEmpty()) {
			query.append(" AND usuario_nombre LIKE ? ");
		}
		/*
		if(usuario.getFechaNacimiento() != null) {
			query.append(" AND usuario_fecha_nacimiento LIKE ? ");
		}
		
		if(usuario.getCorreo() != null && !usuario.getCorreo().isEmpty()) {
			query.append(" AND usuario_correo LIKE ? ");
		}
		
		if(usuario.getTipo() != -1) {
			query.append(" AND usuario_tipo LIKE ? ");
		}
		*/
		try(Connection conexion = conexionDB.getConnection()){
			PreparedStatement statement = conexion.prepareStatement(query.toString());
		
			int paramIndex = 1;
			
			if(usuario.getId() != -1) {
				statement.setInt(paramIndex++, usuario.getId());
			}
			
			if(usuario.getNombre() != null && !usuario.getNombre().isEmpty()) {
				statement.setString(paramIndex++, "%" + usuario.getNombre() + "%");
			}
			/*
			if(usuario.getFechaNacimiento() != null) {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				String fechaStr = sdf.format(usuario.getFechaNacimiento());
				statement.setString(paramIndex++, "%" + fechaStr + "%");
			}
			
			if(usuario.getCorreo() != null) {
				statement.setString(paramIndex++, usuario.getCorreo());
			}
			
			if(usuario.getTipo() != -1) {
				statement.setInt(paramIndex++, usuario.getTipo());
			}
			*/
			ResultSet rs = statement.executeQuery();
			
			if(rs.next()) {
				return new Usuario(
						rs.getInt("usuario_id"),
						rs.getString("usuario_nombre"),
						rs.getString("usuario_password"),
						rs.getDate("usuario_fecha_nacimiento"),
						rs.getString("usuario_correo"),
						rs.getInt("usuario_tipo")
						);
						
			} else {
				return null;
			}
		}
	}
	
	public List<Usuario> getTodosLosUsuario() throws SQLException {
		System.out.println("funcion GetTodosLosUsuarios USUARIODAO");
		List<Usuario> usuarios = new ArrayList<>();
		String query = "SELECT * FROM usuarios";
		try (Connection connection = conexionDB.getConnection()){
			PreparedStatement statement = connection.prepareStatement(query);
			ResultSet resultSet = statement.executeQuery();
			
			while(resultSet.next()) {
				int id = resultSet.getInt("usuario_id");
				String nombre = resultSet.getString("usuario_nombre");
				Date fechaNacimiento = resultSet.getDate("usuario_fecha_nacimiento");
				String correo = resultSet.getString("usuario_correo");
				int tipo = resultSet.getInt("usuario_tipo");
				
				Usuario usuario = new Usuario(id, nombre, 
						fechaNacimiento, correo, tipo);
				
				usuarios.add(usuario);
			}
		}		
		return usuarios;
	}
}
