package libreria.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

import libreria.modelo.LibroDAO;
import libreria.modelo.Usuario;
import libreria.modelo.UsuarioDAO;
import libreria.vista.AnadirUsuarioVista;
import libreria.vista.EliminarUsuarioVista;
import libreria.vista.ListaUsuariosVista;

public class UsuarioController {
	private AnadirUsuarioVista anadirUsuarioVista;
	private EliminarUsuarioVista eliminarUsuarioVista;
	private UsuarioDAO usuarioDAO;
	private ListaUsuariosVista listaUsuariosVista;

	public UsuarioController(AnadirUsuarioVista anadirUsuarioVista, ListaUsuariosVista listaUsuariosVista) {
		this.anadirUsuarioVista = anadirUsuarioVista;
		this.usuarioDAO = new UsuarioDAO();
		this.listaUsuariosVista = listaUsuariosVista;
		
		JButton anadirUsuario = anadirUsuarioVista.getAnadirUsuarioBtn();
		anadirUsuario.addActionListener(new AnadirUsuarioListener());
	}
	
	public UsuarioController(EliminarUsuarioVista eliminarUsuarioVista, ListaUsuariosVista listaUsuariosVista) {
		this.eliminarUsuarioVista = eliminarUsuarioVista;
		this.usuarioDAO = new UsuarioDAO();
		this.listaUsuariosVista = listaUsuariosVista;
		
		JButton eliminarUsuario = eliminarUsuarioVista.getEliminarBtn();
		eliminarUsuario.addActionListener(new EliminarUsuarioListener());
	}
	
	public UsuarioController(ListaUsuariosVista listaUsuariosVista) {
		this.listaUsuariosVista = listaUsuariosVista;
        this.usuarioDAO = new UsuarioDAO();
        cargarUsuariosEnTabla();
	}
	
    class AnadirUsuarioListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			
			System.out.println("Añadir usuario botón clicado");
			String usuarioNombre = anadirUsuarioVista.getNombreField().getText();
			String usuarioPassword = new String(anadirUsuarioVista.getPasswordField().getPassword());
			String fechaNacimientoTexto = anadirUsuarioVista.getNacimientoField().getText();
			String correo = anadirUsuarioVista.getCorreoField().getText();
			JRadioButton adminBtn = anadirUsuarioVista.getAdminBtn();
			JRadioButton noAdminBtn = anadirUsuarioVista.getNoAdminBtn();
			
			System.out.println("Datos recogidos: " + usuarioNombre + ", " + correo);
			
			if(usuarioNombre.isEmpty() || usuarioPassword.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Por favor, inserte un nombre de usuario y una contraseña.");
				return;
			}
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			java.util.Date fechaNacimiento = null;
			if (!fechaNacimientoTexto.isEmpty()) {
			    try {
			        fechaNacimiento = sdf.parse(fechaNacimientoTexto);
			    } catch (ParseException ex) {
			        JOptionPane.showMessageDialog(null, "Formato de fecha inválido. Por favor, use el formato yyyy-MM-dd");
			        return;  
			    }
			}
			
			int admin = 0;
			if(adminBtn.isSelected()) {
				admin = 1;
			}
			
			Usuario usuario = new Usuario(usuarioNombre, usuarioPassword, fechaNacimiento, correo, admin);
			try {
				System.out.println("Añadiendo usuario: " + usuario.getNombre());
				usuarioDAO.anadirUsuario(usuario);
				JOptionPane.showMessageDialog(null, "Usuario añadido con éxito");
				System.out.println("Usuario añadido en UsuarioController");
			} catch (SQLException ex) {
				System.out.println("Error en UsuarioController al añadir usuario");
				JOptionPane.showMessageDialog(null, "El usuario no pudo ser añadido");
			}
			
			cargarUsuariosEnTabla();
		}
		 
    	
    }
    
    class EliminarUsuarioListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String IDTexto = eliminarUsuarioVista.getIDField().getText();
			String nombre = eliminarUsuarioVista.getNombreField().getText();
			
			int ID = -1;
			if(!IDTexto.isEmpty()) {
				try {
					ID = Integer.parseInt(IDTexto);
				} catch (NumberFormatException ex) {
					ex.printStackTrace();
					JOptionPane.showMessageDialog(null, "El campo ID debe ser númerico");
					return;
				}
			}
			
			Usuario usuario = new Usuario(ID, nombre);
			try {
				usuarioDAO.eliminarUsuarioConfirmacion(usuario);
			}catch(SQLException ex) {
			ex.printStackTrace();
			}
			
			cargarUsuariosEnTabla();
		}
    	
    }
    
	public void cargarUsuariosEnTabla() {
		try {
			System.out.println("Funcion cargarUsuariosEnTabla");
			List<Usuario> usuarios = usuarioDAO.getTodosLosUsuario();

			listaUsuariosVista.getTableModel().setRowCount(0);
			
			listaUsuariosVista.actualizarTabla(usuarios);
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error al cargar los usuarios en la lista");
		}
	}
}
