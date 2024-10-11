package libreria.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import libreria.modelo.ConexionDB;
import libreria.vista.AdminVista;
import libreria.vista.LoginVista;
import libreria.vista.UsuarioVista;

public class LoginController {
	
	LoginVista loginVista;
	ConexionDB conexionDB;
	public static int usuarioID;
	

	public LoginController() {
		loginVista = new LoginVista();
		conexionDB = new ConexionDB();
		
		loginVista.getLoginButton().addActionListener(new LoginButtonListener());
		loginVista.getResetButton().addActionListener(new ResetButtonListener());
		
	}
	
	public class LoginButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String usuario = loginVista.getUsuarioText();
			String password = loginVista.getPasswordText();
			
			try(Connection conexion = conexionDB.getConnection()){
				String query = "SELECT * FROM usuarios "
						+ "WHERE usuario_nombre = ? AND usuario_password = ?";
				
				
				try(PreparedStatement statement = conexion.prepareStatement(query)){
					statement.setString(1, usuario);
					statement.setString(2, password);
					
					try(ResultSet resultSet = statement.executeQuery()){
						if(resultSet.next()) {
							usuarioID = resultSet.getInt("usuario_id");
							if(resultSet.getInt("usuario_tipo") > 0) {
								JOptionPane.showMessageDialog(null, "Logging succesful!");
								loginVista.dispose();
								new AdminVista();
								System.out.println("Login succesful");
							} else {
								loginVista.dispose();
								new UsuarioVista();
							}
							
						} 
					}
				}
				
			} catch (SQLException e1) {
				e1.printStackTrace();
				JOptionPane.showMessageDialog(null, "There was an error connecting to the DB.");
				}
			
		}
	}
		
	private class ResetButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			loginVista.setUsuarioText("");
			loginVista.setPasswordText("");
		}
		
	}
	
	

	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(LoginController::new);
	}
}


