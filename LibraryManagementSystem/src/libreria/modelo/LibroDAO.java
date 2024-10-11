package libreria.modelo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import libreria.controlador.LoginController;

public class LibroDAO {
    ConexionDB conexionDB;

    public LibroDAO() {
    	
        conexionDB = new ConexionDB();

    }
    public void anadirLibro(Libro libro) throws SQLException {
        String query = "INSERT INTO libros (libro_titulo, libro_autor, "
                + "ISBN, fecha_publicacion, editorial, libro_genero, libro_sinopsis)"
                + " VALUES (?,?,?,?,?,?,?)";
        try (Connection conexion = conexionDB.getConnection()) {

            System.out.println("Database connected");
            PreparedStatement statement = conexion.prepareStatement(query);

            statement.setString(1, libro.getTitulo());
            statement.setString(2, libro.getAutor());
            statement.setInt(3, libro.getISBN());

            if (libro.getFechaPublicacion() != null) {
                statement.setDate(4, new java.sql.Date(libro.getFechaPublicacion().getTime()));
            } else {
                statement.setNull(4, java.sql.Types.DATE);
            }

            statement.setString(5, libro.getEditorial());
            statement.setString(6, libro.getGenero());
            statement.setString(7, libro.getSinopsis());

            int numOfRows = statement.executeUpdate();
            System.out.println("Statement executed");
            if (numOfRows > 0) {
                System.out.println("LIBRO INTRODUCIDO. ");
            } else {
                JOptionPane.showMessageDialog(null, "Error al introducir el libro en la base de datos");
                System.out.println("Error al introducir el libro. PRUEBA BOTÓN ERROR");
            }
        }
    }
    
    public void eliminarLibro(Libro libro) throws SQLException{
    	StringBuilder query = new StringBuilder("DELETE FROM libros WHERE 1 = 1 ");
    	
    	if(libro.getId() != -1) {
    		query.append("AND libro_id LIKE ? ");
    	}
    	
    	if(libro.getTitulo() != null && !libro.getTitulo().isEmpty()) {
    		query.append("AND libro_titulo LIKE ? ");
    	}
    	
    	if(libro.getAutor() != null && !libro.getAutor().isEmpty()) {
    		query.append("AND libro_autor LIKE ? ");
    	}
    	
    	if(libro.getISBN() != -1) {
    		query.append("AND ISBN LIKE ? ");
    	}
    	if(libro.getFechaPublicacion() != null) {
    		query.append("AND fecha_publicacion LIKE ? ");
    	}
    	
    	if(libro.getEditorial() != null && !libro.getEditorial().isEmpty()) {
    		query.append("AND editorial LIKE ? ");
    	}
    	
    	if(libro.getGenero() != null && !libro.getGenero().isEmpty()) {
    		query.append("AND libro_genero LIKE ?");
    	}
    	
    	try(Connection conexion = conexionDB.getConnection()){
    		PreparedStatement statement = conexion.prepareStatement(query.toString());
    
    		int paramIndex = 1;
    		
    		if(libro.getId() != -1) {
        		statement.setInt(paramIndex++, libro.getId());
        	}
    		if(libro.getTitulo() != null && !libro.getTitulo().isEmpty()) {
        		statement.setString(paramIndex++, "%" + libro.getTitulo() + "%");
        	}
    		
    		if(libro.getAutor() != null && !libro.getAutor().isEmpty()) {
    			statement.setString(paramIndex++, "%" + libro.getAutor() + "%");
        	}
    		if(libro.getISBN() != -1) {
        		statement.setInt(paramIndex++, libro.getISBN());
        	}
    		if(libro.getFechaPublicacion() != null) {
    			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    			String fechaStr = sdf.format(libro.getFechaPublicacion());
    			statement.setString(paramIndex++, "%" + fechaStr + "%");
        	}
    		if(libro.getEditorial() != null && !libro.getEditorial().isEmpty()) {
        		statement.setString(paramIndex++, "%" + libro.getEditorial() + "%");
        	}
    		if(libro.getGenero() != null && !libro.getGenero().isEmpty()) {
        		statement.setString(paramIndex++, "%" + libro.getGenero() + "%");
        	}
    		
    		int numOfRows = statement.executeUpdate();
    		if(numOfRows > 0) {
    			JOptionPane.showMessageDialog(null, "El libro ha sido eliminado");
    			System.out.println("Libro eliminado");
    		} else {
    			JOptionPane.showMessageDialog(null, "No se encontró el libro en la base de datos");
    		}
    		
    		
    	
    	}	
    	
}
    
    public void eliminarLibroConfirmacion(Libro libro) throws SQLException{
    	Libro libroEncontrado = buscarLibro(libro);
    	
    	if(libroEncontrado == null) {
    		JOptionPane.showMessageDialog(null, "No se encontró ningún libro con los criterios introducidos");
    		return;
    	}
    	
    	String mensaje = String.format(
    			"¿Desea eliminar el siguiente libro?\n\nID: %d\nTítulo: %s\nAutor: %s\nISBN: %d\nFecha de Publicación: %s\nEditorial: %s\nGénero: %s",
    			libroEncontrado.getId(),
    			libroEncontrado.getTitulo(),
    			libroEncontrado.getAutor(),
    			libroEncontrado.getISBN(),
    			libroEncontrado.getFechaPublicacion() != null ? new SimpleDateFormat("yyyy-MM-dd").format(libroEncontrado.getFechaPublicacion()) : "N/A",
    			libroEncontrado.getEditorial(),
    			libroEncontrado.getGenero());
    	
    	int confirmacion = JOptionPane.showConfirmDialog(null, mensaje, "Confirmar eliminación", JOptionPane.YES_NO_OPTION);
    	
    	if(confirmacion == JOptionPane.YES_OPTION) {
    		eliminarLibro(libroEncontrado);	
    	}
    }
    public Libro buscarLibro(Libro libro) throws SQLException {
    	StringBuilder query = new StringBuilder("SELECT * FROM libros WHERE 1 = 1 ");
    	
    	if(libro.getId() != -1) {
    		query.append("AND libro_id = ? ");
    	}
    	
    	if(libro.getTitulo() != null && !libro.getTitulo().isEmpty()) {
    		query.append("AND libro_titulo LIKE ? ");
    	}
    	
    	if(libro.getAutor() != null && !libro.getAutor().isEmpty()) {
    		query.append("AND libro_autor LIKE ?");
    	}
    	
    	if(libro.getISBN() != -1) {
    		query.append("AND ISBN = ?");
    	}
    	if(libro.getFechaPublicacion() != null) {
    		query.append("AND fecha_publicacion LIKE ?");
    	}
    	
    	if(libro.getEditorial() != null && !libro.getEditorial().isEmpty()) {
    		query.append("AND editorial LIKE ?");
    	}
    	
    	if(libro.getGenero() != null && !libro.getGenero().isEmpty()) {
    		query.append("AND libro_genero LIKE ?");
    	}
    	try(Connection conexion = conexionDB.getConnection()){
    		PreparedStatement statement = conexion.prepareStatement(query.toString());
    
    		int paramIndex = 1;
    		
    		if(libro.getId() != -1) {
        		statement.setInt(paramIndex++, libro.getId());
        	}
    		if(libro.getTitulo() != null && !libro.getTitulo().isEmpty()) {
        		statement.setString(paramIndex++, "%" + libro.getTitulo() + "%");
        	}
    		
    		if(libro.getAutor() != null && !libro.getAutor().isEmpty()) {
    			statement.setString(paramIndex++, "%" + libro.getAutor() + "%");
        	}
    		if(libro.getISBN() != -1) {
        		statement.setInt(paramIndex++, libro.getISBN());
        	}
    		if(libro.getFechaPublicacion() != null) {
    			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    			String fechaStr = sdf.format(libro.getFechaPublicacion());
    			statement.setString(paramIndex++, "%" + fechaStr + "%");
        	}
    		if(libro.getEditorial() != null && !libro.getEditorial().isEmpty()) {
        		statement.setString(paramIndex++, "%" + libro.getEditorial() + "%");
        	}
    		if(libro.getGenero() != null && !libro.getGenero().isEmpty()) {
        		statement.setString(paramIndex++, "%" + libro.getGenero() + "%");
        	}
    		
    		ResultSet rs = statement.executeQuery();
    		if(rs.next()) {
    			return new Libro(
    					rs.getInt("libro_id"),
    					rs.getString("libro_titulo"),
    					rs.getString("libro_autor"),
    					rs.getInt("ISBN"),
    					rs.getDate("fecha_publicacion"),
    					rs.getString("editorial"),
    					rs.getString("libro_genero")
    					);
    		} else {
    			return null;
    		}
    	
	}
    }
    
    public List<Libro> getTodosLosLibros() throws SQLException {
    	List<Libro> libros = new ArrayList<>();
    	String query = "SELECT * FROM libros";
    	
    	try(Connection connection = conexionDB.getConnection()){
    		PreparedStatement statement = connection.prepareStatement(query);
    		ResultSet resultSet = statement.executeQuery();
    		
    		while(resultSet.next()) {
    			int id = resultSet.getInt("libro_id");
    			String titulo = resultSet.getString("libro_titulo");
    			String autor = resultSet.getString("libro_autor");
    			int ISBN = resultSet.getInt("ISBN");
    			Date fechaPublicacion = resultSet.getDate("fecha_publicacion");
    			String editorial = resultSet.getString("editorial");
    			String genero = resultSet.getString("libro_genero");
    			String sinopsis = resultSet.getString("libro_sinopsis");
    			
    			System.out.println("Libro: " + titulo + ", Autor: " + autor);

    			
    			Libro libro = new Libro(id, titulo, autor,
    					ISBN, fechaPublicacion, editorial, genero, sinopsis);
    			
    			libros.add(libro);
    			
    		}
    		
    	}
    	return libros;
    }
    
  
    
    
}
