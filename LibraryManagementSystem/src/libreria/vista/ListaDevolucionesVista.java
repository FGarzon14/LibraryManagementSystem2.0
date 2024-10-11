package libreria.vista;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import libreria.modelo.Devolucion;

public class ListaDevolucionesVista  extends JPanel{
	private JTable tablaDevoluciones;
	private DefaultTableModel tableModel;
	
	
	public ListaDevolucionesVista() {
		setLayout(new BorderLayout());
		
		tableModel = new DefaultTableModel();
		
		tableModel.addColumn("Devolución ID");
		tableModel.addColumn("Usuario ID");
		tableModel.addColumn("Libro ID");
		tableModel.addColumn("Fecha de devolución");
		
		tablaDevoluciones = new JTable(tableModel);
		JScrollPane scrollPane = new JScrollPane(tablaDevoluciones);
		
		add(scrollPane, BorderLayout.CENTER);
		}
	
	public void actualizarTabla(List<Devolucion> devoluciones) {
		tableModel.setRowCount(0);
		
		for(Devolucion devolucion: devoluciones) {
			tableModel.addRow(new Object[] {
					devolucion.getIdDevolucion(),
					devolucion.getUsuarioId(),
					devolucion.getLibroId(),
					devolucion.getFechaDevolucion()
			});
		}
		
	}

	public JTable getTablaDevoluciones() {
		return tablaDevoluciones;
	}

	public DefaultTableModel getTableModel() {
		return tableModel;
	}
	
	
}
