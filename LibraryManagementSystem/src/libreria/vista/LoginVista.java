package libreria.vista;

import java.awt.*;
import javax.swing.*;

public class LoginVista {
	
	private JTextField usuarioText;
	private JPasswordField passwordText;
	private JButton loginButton;
	private JButton resetButton;
	static JFrame loginFrame;

    public LoginVista() {
        // Crear el frame, establecer tamaño y diseño
        loginFrame = new JFrame("Login");
        loginFrame.setSize(400, 250);
        loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginFrame.setLayout(new BorderLayout());
        loginFrame.setBackground(Color.decode("#48829e"));

        // Establecer el fondo blanco para el frame
        loginFrame.getContentPane().setBackground(Color.white);

        // Crear un panel central con BoxLayout y establecer fondo blanco
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        centerPanel.setBackground(Color.white);
        centerPanel.setBorder(BorderFactory.createEmptyBorder(20, 60, 20, 60));
        centerPanel.setPreferredSize(new Dimension(200, 150));
        centerPanel.setBackground(Color.decode("#f2f8fd"));


        // Crear etiquetas y campos de texto
        JLabel usuarioLabel = new JLabel("Usuario:");
        usuarioLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        usuarioText = new JTextField();
        usuarioText.setMaximumSize(new Dimension(Integer.MAX_VALUE, usuarioText.getPreferredSize().height));
        usuarioText.setHorizontalAlignment(SwingConstants.CENTER);
       
        
        JLabel passwordLabel = new JLabel("Contraseña:");
        passwordLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
       
        
        passwordText = new JPasswordField();
        passwordText.setMaximumSize(new Dimension(Integer.MAX_VALUE, passwordText.getPreferredSize().height));
        passwordText.setHorizontalAlignment(SwingConstants.CENTER);
        
        // Añadir componentes al panel central
        centerPanel.add(usuarioLabel);
        centerPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        centerPanel.add(usuarioText);
        centerPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        centerPanel.add(passwordLabel);
        centerPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        centerPanel.add(passwordText);
        centerPanel.add(Box.createRigidArea(new Dimension(0, 20)));

        // Crear un panel para los botones con FlowLayout y establecer fondo blanco
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 0));
        buttonPanel.setBackground(Color.white);
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 30, 0)); // Empujar botones hacia arriba
        buttonPanel.setBackground(Color.decode("#f2f8fd"));
        
        loginButton = new JButton("Login");
        resetButton = new JButton("Reset");
        
        //Añadir color a los botones
        loginButton.setBackground(Color.decode("#f0e1e9"));
        resetButton.setBackground(Color.decode("#f0e1e9"));
        
        

        // Añadir botones al panel de botones
        buttonPanel.add(loginButton);
        buttonPanel.add(resetButton);

        // Añadir paneles al frame
        loginFrame.add(centerPanel, BorderLayout.CENTER);
        loginFrame.add(buttonPanel, BorderLayout.SOUTH);

        // Mostrar el frame
        loginFrame.setVisible(true);
        
       
    }
    
    public String getUsuarioText() {
    	return usuarioText.getText();
    	
    }
    
    public void setUsuarioText(String string) {
    	usuarioText.setText(string);
    }
    public void setPasswordText(String string) {
    	passwordText.setText(string);
    }
    
    public String getPasswordText() {
    	return new String(passwordText.getPassword());
    }
    
    public JButton getLoginButton() {
    	return loginButton;
    }
    	
    public JButton getResetButton() {
    	return resetButton;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(LoginVista::new);
    }
    
    public void dispose() {
    	loginFrame.dispose();
    }
}
