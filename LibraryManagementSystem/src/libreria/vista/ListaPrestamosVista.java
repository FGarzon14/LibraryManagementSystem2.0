package libreria.vista;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import libreria.modelo.Prestamo;

public class ListaPrestamosVista  extends JPanel{
	private JTable tablaPrestamos;
	private DefaultTableModel tableModel;
	
	
	public ListaPrestamosVista() {
		setLayout(new BorderLayout());
		
		tableModel = new DefaultTableModel();

		tableModel.addColumn("Préstamo ID");
		tableModel.addColumn("Usuario ID");
		tableModel.addColumn("Libro ID");
		tableModel.addColumn("Fecha préstamo");
		tableModel.addColumn("Estado devolución");
		
		tablaPrestamos = new JTable(tableModel);
		JScrollPane scrollPane = new JScrollPane(tablaPrestamos);
		
		add(scrollPane, BorderLayout.CENTER);
		
		
	}

	public void actualizarTabla(List<Prestamo> prestamos) {
		tableModel.setRowCount(0);
		
		for(Prestamo prestamo: prestamos) {
			tableModel.addRow(new Object[] {
					prestamo.getIdPrestamo(),
					prestamo.getUsuarioId(),
					prestamo.getLibroId(),
					prestamo.getFechaDevolucion(),
					prestamo.isEstadoDevuelto()
			});
			
		}
	}
	
	public JTable getTablaPrestamos(){
		return tablaPrestamos;
	}
}
