package libreria.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import libreria.modelo.Libro;
import libreria.modelo.LibroDAO;
import libreria.vista.AnadirLibroVista;
import libreria.vista.AnadirUsuarioVista;
import libreria.vista.EliminarLibroVista;
import libreria.vista.ListaLibrosVista;

public class LibroController {

    private AnadirLibroVista libroVista;
    private EliminarLibroVista eliminarLibroVista;
    private ListaLibrosVista listaLibrosVista;
    private LibroDAO libroDAO;
    
    

    public LibroController(AnadirLibroVista libroVista, ListaLibrosVista listaLibrosVista) {
        this.libroVista = libroVista;
        this.listaLibrosVista = listaLibrosVista;
        this.libroDAO = new LibroDAO();

        JButton anadirBtn = libroVista.getAnadirBtn();
        anadirBtn.addActionListener(new AnadirLibroListener());

        System.out.println("LibroController initialized and listener added.");
    }

    public LibroController(EliminarLibroVista eliminarLibroVista, ListaLibrosVista listaLibrosVista) {
        this.eliminarLibroVista = eliminarLibroVista;
        this.listaLibrosVista = listaLibrosVista;
        this.libroDAO = new LibroDAO();

        JButton eliminarBtn = eliminarLibroVista.getEliminarBtn();
        eliminarBtn.addActionListener(new EliminarLibroListener());

        System.out.println("LibroController initialized and listener added.");
    }

    public LibroController(ListaLibrosVista listaLibrosVista) {
        this.listaLibrosVista = listaLibrosVista;
        this.libroDAO = new LibroDAO();
        cargarLibrosEnTabla();
    }

    class AnadirLibroListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Anadir button clicked.");
            String titulo = libroVista.getTituloField().getText();
            String autor = libroVista.getAutorField().getText();
            String isbnTexto = libroVista.getIsbnField().getText();
            String fechaTexto = libroVista.getFechaPublicacionField().getText();
            String editorial = libroVista.getEditorialField().getText();
            String genero = libroVista.getGeneroField().getText();
            String sinopsis = libroVista.getSinopsisArea().getText();

            // Requiere que al menos el título y el autor estén completos
            if (titulo.isEmpty() || autor.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Es necesario completar los campos marcados con *");
                return;
            }

            int ISBN = 0;

            // Verifica si el campo ISBN no está vacío y trata de convertirlo a número
            if (!isbnTexto.isEmpty()) {
                try {
                    ISBN = Integer.parseInt(isbnTexto);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "ISBN debe ser un número.");
                    return;
                }
            }

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date fechaPublicacion = null;

            // Verifica si el campo fecha no está vacío y trata de convertirlo a una fecha válida
            if (!fechaTexto.isEmpty()) {
            	
                try {
                    fechaPublicacion = sdf.parse(fechaTexto);
                } catch (ParseException ex) {
                    JOptionPane.showMessageDialog(null, "Formato de fecha inválido. Por favor, use el formato yyyy-MM-dd");
                    return;
                }
            } 

            // Crea el libro con la información proporcionada
            Libro libro = new Libro(titulo, autor, ISBN, fechaPublicacion, editorial, genero, sinopsis);

            // Trata de añadir el libro a la base de datos
            try {
                libroDAO.anadirLibro(libro);
                JOptionPane.showMessageDialog(null, "Libro añadido con éxito.");
                
            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error al conectar con la base de datos.");
            }
            cargarLibrosEnTabla();	
        }
        
    }
    
    class EliminarLibroListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {


                System.out.println("Eliminar button clicked.");
                String IDTexto = eliminarLibroVista.getID().getText();
                String titulo = eliminarLibroVista.getTituloField().getText();
                String autor = eliminarLibroVista.getAutorField().getText();
                String ISBNTexto = eliminarLibroVista.getIsbnField().getText();
                String fechaTexto = eliminarLibroVista.getFechaPublicacionField().getText();
                String editorial = eliminarLibroVista.getEditorialField().getText();
                String genero = eliminarLibroVista.getGeneroField().getText();

                int ID = -1;
                if (!IDTexto.isEmpty()) {
                    try {
                        ID = Integer.parseInt(IDTexto);
                    } catch (NumberFormatException ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(null, "El campo ID debe poseer un formato numérico.");
                        return;
                    }
                }

                int ISBN = -1;
                if (!ISBNTexto.isEmpty()) {
                    try {
                        ISBN = Integer.parseInt(ISBNTexto);
                    } catch (NumberFormatException ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(null, "El campo ISBN debe poseer un formato numérico.");
                        return;
                    }
                }

                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                java.util.Date fechaPublicacion = null;
                if (!fechaTexto.isEmpty()) {
                    try {
                        fechaPublicacion = sdf.parse(fechaTexto);
                    } catch (ParseException ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(null, "La fecha debe poseer un formato 'yyyy-MM-dd'.");
                        return;
                    }
                }

                Libro libro = new Libro(ID, titulo, autor, ISBN, fechaPublicacion, editorial, genero, null);
                try {
					libroDAO.eliminarLibroConfirmacion(libro);
					cargarLibrosEnTabla();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
        	
        }
    }
    
    
    public void cargarLibrosEnTabla() {
       
            try {
                List<Libro> libros = libroDAO.getTodosLosLibros();
                listaLibrosVista.actualizarTabla(libros);
            } catch (SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error al cargar los libros.");
            }
     
    }

}