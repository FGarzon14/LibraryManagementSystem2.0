package libreria.vista;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import libreria.modelo.*;

public class ListaLibrosVista  extends JPanel {
	private JTable tablaLibros;
	private DefaultTableModel tableModel;

	public ListaLibrosVista(){
		setLayout(new BorderLayout());
		
		tableModel = new DefaultTableModel();
		tableModel.addColumn("ID");
		tableModel.addColumn("Título");
		tableModel.addColumn("Autor");
		tableModel.addColumn("ISBN");
		tableModel.addColumn("Fecha de publicación");
		tableModel.addColumn("Editorial");
		tableModel.addColumn("Género");
		
		tablaLibros = new JTable(tableModel);
		JScrollPane scrollPane = new JScrollPane(tablaLibros);
		
		add(scrollPane, BorderLayout.CENTER);
		
		
	}

	public void actualizarTabla(List<Libro> libros) {
	System.out.println("Libros encontrados: " + libros.size()); 
    tableModel.setRowCount(0);
    
		
		for(Libro libro: libros) {
			tableModel.addRow(new Object[] {
					libro.getId(),
					libro.getTitulo() != null ? libro.getTitulo() : "N/A",
					libro.getAutor() != null ? libro.getAutor() : "N/A",
					libro.getISBN() != 0 ? libro.getISBN() : "N/A",
					libro.getFechaPublicacion() != null ? libro.getFechaPublicacion() : "N/A",
					libro.getEditorial()!= null ? libro.getEditorial() : "N/A",
					libro.getGenero()!= null ? libro.getGenero() : "N/A",
					});
		}
	}
	
	public JTable getTablaLibros() {
		return tablaLibros;
	}
	
}
