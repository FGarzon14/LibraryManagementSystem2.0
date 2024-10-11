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

public class PrestamoVista extends JPanel{
	
	private JTextField idField;
	private JTextField userField;
	private JTextField fechaPrestamoField;
	private JTextField fechaDevolucionField;
	private JButton prestarBtn;

	public PrestamoVista() {

		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(10, 10, 10, 10);

        setBackground(Color.decode("#f9f9f9")); 
        
		JLabel prestamoLabel = new JLabel("Crear préstamo:");
		prestamoLabel.setFont(new Font("Arial", Font.BOLD, 24));
		prestamoLabel.setForeground(Color.decode("#333333"));
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 2;
		gbc.anchor = GridBagConstraints.CENTER;
		add(prestamoLabel, gbc);
		
		// Estilo para las etiquetas y campos
        Font labelFont = new Font("Arial", Font.PLAIN, 16);
        Color labelColor = Color.decode("#555555"); // Color de texto para etiquetas
        Color fieldBackground = Color.decode("#ffffff"); // Color de fondo para campos

        JLabel idLabel = new JLabel("Libro ID: ");
        idLabel.setFont(labelFont);
        idLabel.setForeground(labelColor);
        gbc.gridwidth = 1;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.LINE_END;
        add(idLabel, gbc);
        
        idField = new JTextField(20);
        idField.setBackground(fieldBackground);
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        add(idField, gbc);
        
        JLabel userLabel = new JLabel("Prestado al usuario:");
        userLabel.setFont(labelFont);
        userLabel.setForeground(labelColor);
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.LINE_END;
        add(userLabel, gbc);
        
        userField = new JTextField(20);
        userField.setBackground(fieldBackground);
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        add(userField, gbc);
        
        JLabel fechaPrestamoLabel = new JLabel("Prestado a fecha de: (yyyy-MM-dd)");
        fechaPrestamoLabel.setFont(labelFont);
        fechaPrestamoLabel.setForeground(labelColor);
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.LINE_END;
        add(fechaPrestamoLabel, gbc);
        
        fechaPrestamoField = new JTextField(20);
        fechaPrestamoField.setBackground(fieldBackground);
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        add(fechaPrestamoField, gbc);
        
        JLabel fechaDevolucionLabel = new JLabel("Devolver el día: (yyyy-MM-dd)");
        fechaDevolucionLabel.setFont(labelFont);
        fechaDevolucionLabel.setForeground(labelColor);
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.LINE_END;
        add(fechaDevolucionLabel, gbc);
        
        fechaDevolucionField = new JTextField(20);
        fechaDevolucionField.setBackground(fieldBackground);
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        add(fechaDevolucionField, gbc);

        
        
        prestarBtn = new JButton("Prestar libro");
        prestarBtn.setFont(new Font("Arial", Font.BOLD, 16));
        prestarBtn.setBackground(Color.decode("#4CAF50"));
        prestarBtn.setForeground(Color.WHITE);
        prestarBtn.setFocusPainted(false);
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        add(prestarBtn, gbc);
        
        setBorder(BorderFactory.createLineBorder(Color.decode("#cccccc"), 1)); // Borde ligero alrededor del panel
        
	}

	public JTextField getIdField() {
		return idField;
	}

	public JTextField getUserField() {
		return userField;
	}

	public JTextField getFechaPrestamoField() {
		return fechaPrestamoField;
	}

	
	public JTextField getFechaDevolucionField() {
		return fechaDevolucionField;
	}

	public JButton getPrestarBtn() {
		return prestarBtn;
	}

}
