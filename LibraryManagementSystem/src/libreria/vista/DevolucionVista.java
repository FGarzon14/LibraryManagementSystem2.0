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

public class DevolucionVista extends JPanel {
    
    private JTextField libroIDField;
    private JTextField usuarioIDField;
    private JButton devolverBtn;

    public DevolucionVista() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        setBackground(Color.decode("#f9f9f9")); 

        JLabel devolucionLabel = new JLabel("Registrar Devolución:");
        devolucionLabel.setFont(new Font("Arial", Font.BOLD, 24));
        devolucionLabel.setForeground(Color.decode("#333333"));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        add(devolucionLabel, gbc);

        // Estilo para las etiquetas y campos
        Font labelFont = new Font("Arial", Font.PLAIN, 16);
        Color labelColor = Color.decode("#555555"); // Color de texto para etiquetas
        Color fieldBackground = Color.decode("#ffffff"); // Color de fondo para campos

        JLabel libroIDLabel = new JLabel("Libro ID:* ");
        libroIDLabel.setFont(labelFont);
        libroIDLabel.setForeground(labelColor);
        gbc.gridwidth = 1;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.LINE_END;
        add(libroIDLabel, gbc);

        libroIDField = new JTextField(20);
        libroIDField.setBackground(fieldBackground);
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        add(libroIDField, gbc);

        JLabel usuarioIDLabel = new JLabel("ID de usuario:* ");
        usuarioIDLabel.setFont(labelFont);
        usuarioIDLabel.setForeground(labelColor);
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.LINE_END;
        add(usuarioIDLabel, gbc);

        usuarioIDField = new JTextField(20);
        usuarioIDField.setBackground(fieldBackground);
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        add(usuarioIDField, gbc);

        devolverBtn = new JButton("Devolver libro");
        devolverBtn.setFont(new Font("Arial", Font.BOLD, 16));
        devolverBtn.setBackground(Color.decode("#4CAF50"));
        devolverBtn.setForeground(Color.WHITE);
        devolverBtn.setFocusPainted(false);
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        add(devolverBtn, gbc);

        setBorder(BorderFactory.createLineBorder(Color.decode("#cccccc"), 1)); // Borde ligero alrededor del panel
    }

    // Métodos getters para obtener los campos de texto y el botón en otras clases
    public JTextField getLibroIDField() {
        return libroIDField;
    }

    public JTextField getUsuarioIDField() {
        return usuarioIDField;
    }

    public JButton getDevolverBtn() {
        return devolverBtn;
    }
}
