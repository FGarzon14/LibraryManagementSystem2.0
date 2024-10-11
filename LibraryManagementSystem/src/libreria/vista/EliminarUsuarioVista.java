package libreria.vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class EliminarUsuarioVista extends JPanel{
	private JTextField IDField;
	private JTextField nombreField;
	private JButton eliminarBtn;
	
	public EliminarUsuarioVista() {
		// Configuración del panel principal
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Espacio entre componentes

        // Estilo del panel
        setBackground(Color.decode("#f9f9f9")); 

        // Etiqueta de título
        JLabel eliminarUsuarioLabel = new JLabel("Eliminar Usuario:");
        eliminarUsuarioLabel.setFont(new Font("Arial", Font.BOLD, 24));
        eliminarUsuarioLabel.setForeground(Color.decode("#333333")); // Color del texto
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2; // Ocupa dos columnas
        gbc.anchor = GridBagConstraints.CENTER; // Centra el título
        add(eliminarUsuarioLabel, gbc);
        
        // Estilo para las etiquetas y campos
        Font labelFont = new Font("Arial", Font.PLAIN, 16);
        Color labelColor = Color.decode("#555555"); // Color de texto para etiquetas
        Color fieldBackground = Color.decode("#ffffff"); // Color de fondo para campos

        // Campo de UsuarioID
        JLabel IDLabel = new JLabel("*Usuario ID:");
        IDLabel.setFont(labelFont);
        IDLabel.setForeground(labelColor);
        gbc.gridwidth = 1; 
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.LINE_END;
        add(IDLabel, gbc);

        IDField = new JTextField(20);
        IDField.setBackground(fieldBackground);
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        add(IDField, gbc);
        
        JLabel nombreLabel = new JLabel("Nombre de usuario:");
        nombreLabel.setFont(labelFont);
        nombreLabel.setForeground(labelColor);
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.LINE_END;
        add(nombreLabel, gbc);
        
        nombreField = new JTextField(20);
        nombreField.setBackground(fieldBackground);
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        add(nombreField, gbc);
       
        
        // Botón Añadir
        eliminarBtn = new JButton("Eliminar");
        eliminarBtn.setFont(new Font("Arial", Font.BOLD, 16));
        eliminarBtn.setBackground(Color.decode("#4CAF50")); // Color verde para el botón
        eliminarBtn.setForeground(Color.WHITE); // Texto blanco en el botón
        eliminarBtn.setFocusPainted(false); // Elimina el borde al hacer clic
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2; // Ocupa dos columnas
        gbc.anchor = GridBagConstraints.CENTER; // Centra el botón
        add(eliminarBtn, gbc);
        
        // Estilo adicional para campos
        setBorder(BorderFactory.createLineBorder(Color.decode("#cccccc"), 1)); // Borde ligero alrededor del panel
        
        
	}

	public JTextField getIDField() {
		return IDField;
	}

	public JTextField getNombreField() {
		return nombreField;
	}

	public JButton getEliminarBtn() {
		return eliminarBtn;
	}
	

}
