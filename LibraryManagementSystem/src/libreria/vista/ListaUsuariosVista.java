package libreria.vista;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import libreria.modelo.Usuario;

public class ListaUsuariosVista extends JPanel{
	
	private JTable tablaUsuarios;
	private DefaultTableModel tableModel;

	public ListaUsuariosVista() {
		setLayout(new BorderLayout());
		
		tableModel = new DefaultTableModel();
		tableModel.addColumn("ID");
		tableModel.addColumn("Nombre");
		tableModel.addColumn("Fecha de nacimiento");
		tableModel.addColumn("Correo");
		tableModel.addColumn("Tipo de usuario");
		
		tablaUsuarios = new JTable(tableModel);
		JScrollPane scrollPane = new JScrollPane(tablaUsuarios);
		
		add(scrollPane, BorderLayout.CENTER);
	}
	
	public void actualizarTabla(List<Usuario> usuarios) {
		System.out.println("Usuarios encontrados: " + usuarios.size());
		
		for(Usuario usuario: usuarios) {
			tableModel.addRow(new Object[] {
					usuario.getId(),
					usuario.getNombre() != null ? usuario.getNombre() : "N/A",
					usuario.getFechaNacimiento() != null ? usuario.getFechaNacimiento() : "N/A",
					usuario.getCorreo() != null ? usuario.getCorreo() : "N/A",
					usuario.getTipo()				
			});
		}
	}
	
	public JTable getTablaUsuarios() {
		return tablaUsuarios;
	}
	
	public DefaultTableModel getTableModel() {
		return tableModel;
	}
	
	
	
	
	

}
