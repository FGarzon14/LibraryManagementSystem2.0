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
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class EliminarLibroVista extends JPanel{
	
		

		private JTextField IDField;
	    private JTextField tituloField;
	    private JTextField autorField;
	    private JTextField isbnField;
	    private JTextField fechaPublicacionField;
	    private JTextField editorialField;
	    private JTextField generoField;
	    

	public EliminarLibroVista() {
		 // Configuración del panel principal
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Espacio entre componentes

        // Estilo del panel
        setBackground(Color.decode("#f9f9f9")); // Color de fondo suave

        // Etiqueta de título
        JLabel eliminarLibroLabel = new JLabel("Eliminar libro:");
        eliminarLibroLabel.setFont(new Font("Arial", Font.BOLD, 24));
        eliminarLibroLabel.setForeground(Color.decode("#333333")); // Color del texto
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2; // Ocupa dos columnas
        gbc.anchor = GridBagConstraints.CENTER; // Centra el título
        add(eliminarLibroLabel, gbc);

        // Estilo para las etiquetas y campos
        Font labelFont = new Font("Arial", Font.PLAIN, 16);
        Color labelColor = Color.decode("#555555"); // Color de texto para etiquetas
        Color fieldBackground = Color.decode("#ffffff"); // Color de fondo para campos

        // Campo de ID
        JLabel idLabel = new JLabel("Libro ID:");
        idLabel.setFont(labelFont);
        idLabel.setForeground(labelColor); // Cambiado a labelColor
        gbc.gridwidth = 1;
        gbc.gridy = 1;
        gbc.gridx = 0; // Asegurarse de restablecer a la columna 0
        gbc.anchor = GridBagConstraints.LINE_END;
        add(idLabel, gbc);

        IDField = new JTextField(20);
        IDField.setBackground(fieldBackground);
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        add(IDField, gbc);

        // Campo de título
        JLabel tituloLabel = new JLabel("Título:");
        tituloLabel.setFont(labelFont);
        tituloLabel.setForeground(labelColor);
        gbc.gridx = 0; // Asegurarse de restablecer a la columna 0
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.LINE_END;
        add(tituloLabel, gbc);

        tituloField = new JTextField(20);
        tituloField.setBackground(fieldBackground);
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        add(tituloField, gbc);


        // Campo de autor
        JLabel autorLabel = new JLabel("Autor:");
        autorLabel.setFont(labelFont);
        autorLabel.setForeground(labelColor);
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.LINE_END;
        add(autorLabel, gbc);

        autorField = new JTextField(20);
        autorField.setBackground(fieldBackground);
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        add(autorField, gbc);

        // Campo ISBN
        JLabel isbnLabel = new JLabel("ISBN:");
        isbnLabel.setFont(labelFont);
        isbnLabel.setForeground(labelColor);
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.LINE_END;
        add(isbnLabel, gbc);

        isbnField = new JTextField(20);
        isbnField.setBackground(fieldBackground);
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        add(isbnField, gbc);

        // Campo fecha de publicación
        JLabel fechaPublicacionLabel = new JLabel("Fecha de Publicación (YYYY-MM-DD):");
        fechaPublicacionLabel.setFont(labelFont);
        fechaPublicacionLabel.setForeground(labelColor);
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.anchor = GridBagConstraints.LINE_END;
        add(fechaPublicacionLabel, gbc);

        fechaPublicacionField = new JTextField(20);
        fechaPublicacionField.setBackground(fieldBackground);
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        add(fechaPublicacionField, gbc);

        // Campo editorial
        JLabel editorialLabel = new JLabel("Editorial:");
        editorialLabel.setFont(labelFont);
        editorialLabel.setForeground(labelColor);
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.anchor = GridBagConstraints.LINE_END;
        add(editorialLabel, gbc);

        editorialField = new JTextField(20);
        editorialField.setBackground(fieldBackground);
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        add(editorialField, gbc);

        // Campo género
        JLabel generoLabel = new JLabel("Género:");
        generoLabel.setFont(labelFont);
        generoLabel.setForeground(labelColor);
        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.anchor = GridBagConstraints.LINE_END;
        add(generoLabel, gbc);

        generoField = new JTextField(20);
        generoField.setBackground(fieldBackground);
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        add(generoField, gbc);

        

        // Botón Eliminar
        eliminarBtn = new JButton("Eliminar");
        eliminarBtn.setFont(new Font("Arial", Font.BOLD, 16));
        eliminarBtn.setBackground(Color.decode("#4CAF50")); // Color verde para el botón
        eliminarBtn.setForeground(Color.WHITE); // Texto blanco en el botón
        eliminarBtn.setFocusPainted(false); // Elimina el borde al hacer clic
        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.gridwidth = 2; // Ocupa dos columnas
        gbc.anchor = GridBagConstraints.CENTER; // Centra el botón
        add(eliminarBtn, gbc);

        // Estilo adicional para campos
        setBorder(BorderFactory.createLineBorder(Color.decode("#cccccc"), 1)); // Borde ligero alrededor del panel
        
      
  	}
	
	public JTextField getID() {
		return IDField;
	}
	
	public static JButton getEliminarBtn() {
		return eliminarBtn;
	}
	private static JButton eliminarBtn;
    

	public JTextField getTituloField() {
		return tituloField;
	}

	public JTextField getAutorField() {
		return autorField;
	}

	public JTextField getIsbnField() {
		return isbnField;
	}

	public JTextField getFechaPublicacionField() {
		return fechaPublicacionField;
	}

	public JTextField getEditorialField() {
		return editorialField;
	}

	public JTextField getGeneroField() {
		return generoField;
	}

}
