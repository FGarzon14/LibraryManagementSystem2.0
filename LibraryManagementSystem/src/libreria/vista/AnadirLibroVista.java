package libreria.vista;

import javax.swing.*;

import libreria.controlador.LibroController;

import java.awt.*;

public class AnadirLibroVista extends JPanel {
	private JButton anadirBtn;
	private JTextField tituloField;
    private JTextField autorField;
    private JTextField isbnField;
    private JTextField fechaPublicacionField;
    private JTextField editorialField;
    private JTextField generoField;
    private JTextArea sinopsisArea;

    public AnadirLibroVista() {
        // Configuración del panel principal
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Espacio entre componentes

        // Estilo del panel
        setBackground(Color.decode("#f9f9f9")); 

        // Etiqueta de título
        JLabel anadirLibroLabel = new JLabel("Añadir libro:");
        anadirLibroLabel.setFont(new Font("Arial", Font.BOLD, 24));
        anadirLibroLabel.setForeground(Color.decode("#333333")); // Color del texto
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2; // Ocupa dos columnas
        gbc.anchor = GridBagConstraints.CENTER; // Centra el título
        add(anadirLibroLabel, gbc);

        // Estilo para las etiquetas y campos
        Font labelFont = new Font("Arial", Font.PLAIN, 16);
        Color labelColor = Color.decode("#555555"); // Color de texto para etiquetas
        Color fieldBackground = Color.decode("#ffffff"); // Color de fondo para campos

        // Campo de título
        JLabel tituloLabel = new JLabel("*Título:");
        tituloLabel.setFont(labelFont);
        tituloLabel.setForeground(labelColor);
        gbc.gridwidth = 1; // Solo una columna
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.LINE_END;
        add(tituloLabel, gbc);

        tituloField = new JTextField(20);
        tituloField.setBackground(fieldBackground);
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        add(tituloField, gbc);

        // Campo de autor
        JLabel autorLabel = new JLabel("*Autor:");
        autorLabel.setFont(labelFont);
        autorLabel.setForeground(labelColor);
        gbc.gridx = 0;
        gbc.gridy = 2;
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
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.LINE_END;
        add(isbnLabel, gbc);

        isbnField = new JTextField(20);
        isbnField.setBackground(fieldBackground);
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        add(isbnField, gbc);

        // Campo fecha de publicación
        JLabel fechaPublicacionLabel = new JLabel("Fecha de Publicación (yyyy-MM-dd):");

        fechaPublicacionLabel.setFont(labelFont);
        fechaPublicacionLabel.setForeground(labelColor);
        gbc.gridx = 0;
        gbc.gridy = 4;
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
        gbc.gridy = 5;
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
        gbc.gridy = 6;
        gbc.anchor = GridBagConstraints.LINE_END;
        add(generoLabel, gbc);

        generoField = new JTextField(20);
        generoField.setBackground(fieldBackground);
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        add(generoField, gbc);

        // Campo sinopsis
        JLabel sinopsisLabel = new JLabel("Sinopsis:");
        sinopsisLabel.setFont(labelFont);
        sinopsisLabel.setForeground(labelColor);
        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.anchor = GridBagConstraints.FIRST_LINE_END;
        add(sinopsisLabel, gbc);

        sinopsisArea = new JTextArea(5, 20);
        sinopsisArea.setLineWrap(true);
        sinopsisArea.setWrapStyleWord(true);
        sinopsisArea.setBackground(fieldBackground);
        JScrollPane sinopsisScrollPane = new JScrollPane(sinopsisArea);
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        add(sinopsisScrollPane, gbc);

        // Botón Añadir
        anadirBtn = new JButton("Añadir");
        anadirBtn.setFont(new Font("Arial", Font.BOLD, 16));
        anadirBtn.setBackground(Color.decode("#4CAF50")); // Color verde para el botón
        anadirBtn.setForeground(Color.WHITE); // Texto blanco en el botón
        anadirBtn.setFocusPainted(false); // Elimina el borde al hacer clic
        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.gridwidth = 2; // Ocupa dos columnas
        gbc.anchor = GridBagConstraints.CENTER; // Centra el botón
        add(anadirBtn, gbc);

        // Estilo adicional para campos
        setBorder(BorderFactory.createLineBorder(Color.decode("#cccccc"), 1)); // Borde ligero alrededor del panel
        
        
     
    }
    
    public JButton getAnadirBtn() {
    	return anadirBtn;
    }

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

	public JTextArea getSinopsisArea() {
		return sinopsisArea;
	}
   
}
