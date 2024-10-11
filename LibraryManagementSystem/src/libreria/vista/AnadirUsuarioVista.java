package libreria.vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class AnadirUsuarioVista extends JPanel{
	private JTextField nombreField;
	private JPasswordField passwordField;
	private JTextField nacimientoField;
	private JTextField correoField;
	private JButton anadirUsuarioBtn;
	//private JCheckBox adminCheckBox;
	private JRadioButton adminBtn;
	private JRadioButton noAdminBtn;

	public AnadirUsuarioVista() {

		//Estructura del panel
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(10, 10, 10, 10);
		
		//Color del background
		setBackground(Color.decode("#f9f9f9"));
		
		JLabel anadirUsuarioLabel = new JLabel("Añadir usuario:");
		anadirUsuarioLabel.setFont(new Font("Arial", Font.BOLD, 24));
		anadirUsuarioLabel.setForeground(Color.decode("#333333"));
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 2;
		add(anadirUsuarioLabel, gbc);
		
		//Estilo de las etiquetas y los campos
		Font labelFont = new Font("Arial", Font.PLAIN, 16);
		Color labelColor = Color.decode("#555555");
		Color fieldBackGround = Color.decode("#ffffff");
		
		//Campo Nombre de usuario
		JLabel nombreLabel = new JLabel("Nombre de usuario:*");
		nombreLabel.setFont(labelFont);
		nombreLabel.setForeground(labelColor);
		gbc.gridwidth = 1;
		gbc.gridy = 1;
		gbc.anchor = GridBagConstraints.LINE_END;
		add(nombreLabel, gbc);
		
		nombreField = new JTextField(20);
		nombreField.setBackground(fieldBackGround);
		gbc.gridx = 1;
		gbc.anchor = GridBagConstraints.LINE_START;
		add(nombreField, gbc);
		
		//Campo para la contraseña
		JLabel passwordLabel = new JLabel("Contraseña:*");
		passwordLabel.setFont(labelFont);
		passwordLabel.setForeground(labelColor);
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.anchor = GridBagConstraints.LINE_END;
		add(passwordLabel, gbc);
		
		passwordField = new JPasswordField(20);
		passwordField.setBackground(fieldBackGround);
		gbc.gridx = 1;
		gbc.anchor = GridBagConstraints.LINE_START;
		add(passwordField, gbc);
		
		//Campo fecha nacimiento
		JLabel fechaNacimientoLabel = new JLabel("Fecha de nacimiento: (yyyy-MM-dd)");
		fechaNacimientoLabel.setFont(labelFont);
		fechaNacimientoLabel.setForeground(labelColor);
		gbc.gridx = 0;
		gbc.gridy  = 3;
		gbc.anchor = GridBagConstraints.LINE_END;
		add(fechaNacimientoLabel, gbc);
		
		nacimientoField = new JTextField(20);
		nacimientoField.setBackground(fieldBackGround);
		gbc.gridx= 1;
		gbc.anchor = GridBagConstraints.LINE_START;
		add(nacimientoField, gbc);
		
		//Campo correo
		JLabel correoLabel = new JLabel("E-mail:");
		correoLabel.setFont(labelFont);
		correoLabel.setForeground(labelColor);
		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.anchor = GridBagConstraints.LINE_END;
		add(correoLabel, gbc);
		
		correoField = new JTextField(20);
		correoField.setBackground(fieldBackGround);
		gbc.gridx = 1;
		gbc.anchor = GridBagConstraints.LINE_START;
		add(correoField, gbc);
		
		//Campo para declarar si el usuario es admin
		JLabel adminLabel = new JLabel("Usuario administrador:");
		adminLabel.setFont(labelFont);
		adminLabel.setForeground(labelColor);
		gbc.gridx = 0;
		gbc.gridy = 5;
		gbc.anchor = GridBagConstraints.LINE_END;
		add(adminLabel, gbc);
		
		/*adminCheckBox = new JCheckBox();
		adminCheckBox.setSelected(false);
		gbc.gridx = 1;
		gbc.anchor = GridBagConstraints.LINE_START;
		add(adminCheckBox, gbc);*/
		
		ButtonGroup adminGroup = new ButtonGroup();
		adminBtn = new JRadioButton("Administrador");
		noAdminBtn = new JRadioButton("No administrador");
		adminGroup.add(adminBtn);
		adminGroup.add(noAdminBtn);
		
		
		gbc.gridx = 1;
		gbc.anchor = GridBagConstraints.LINE_START;
		add(adminBtn, gbc);
		gbc.gridy = 6;
		add(noAdminBtn, gbc);
		
		
		
		//Botón para añadir
		anadirUsuarioBtn = new JButton("Añadir");
        anadirUsuarioBtn.setFont(new Font("Arial", Font.BOLD, 16));
        anadirUsuarioBtn.setBackground(Color.decode("#4CAF50")); // Color verde para el botón
        anadirUsuarioBtn.setForeground(Color.WHITE); // Texto blanco en el botón
        anadirUsuarioBtn.setFocusPainted(false); // Elimina el borde al hacer clic
        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.gridwidth = 2; // Ocupa dos columnas
        gbc.anchor = GridBagConstraints.CENTER; // Centra el botón
        add(anadirUsuarioBtn, gbc);
        
		setBorder(BorderFactory.createLineBorder(Color.decode("#cccccc"), 1));
		
	}

	public JTextField getNombreField() {
		return nombreField;
	}

	public JPasswordField getPasswordField() {
		return passwordField;
	}

	public JTextField getNacimientoField() {
		return nacimientoField;
	}

	public JTextField getCorreoField() {
		return correoField;
	}

	public JButton getAnadirUsuarioBtn() {
		return anadirUsuarioBtn;
	}
	public JRadioButton getAdminBtn() {
		return adminBtn;
	}

	public JRadioButton getNoAdminBtn() {
		return noAdminBtn;
	}
	

}
