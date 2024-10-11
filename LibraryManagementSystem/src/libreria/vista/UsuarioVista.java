package libreria.vista;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import libreria.controlador.LibroController;
import libreria.controlador.PrestamoController;

public class UsuarioVista extends JFrame {
	
	private JPanel mainPanel;
	private CardLayout cardLayout;

	private JButton listaLibrosBtn;
	private JButton misLibrosBtn;
	
	public UsuarioVista() {
		setTitle("Usuario");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		
		 // Crear menú lateral
        JPanel menuPanel = new JPanel(); 
        menuPanel.setLayout(new GridLayout(10, 1, 5, 5)); // 10 filas, 1 columna, con espacios de 5px entre componentes
        menuPanel.setBackground(Color.LIGHT_GRAY);
        
        listaLibrosBtn = new JButton("Listado de libros");
        misLibrosBtn = new JButton("Historial de préstamos");
        
        
        Color customColor = Color.decode("#f0e1e9");
        listaLibrosBtn.setBackground(customColor);
        misLibrosBtn.setBackground(customColor);
        
        menuPanel.add(listaLibrosBtn);
        menuPanel.add(misLibrosBtn);
        
        //Crear menú principal
        mainPanel = new JPanel();
        cardLayout = new CardLayout();
        mainPanel.setLayout(cardLayout);
        
        add(menuPanel, BorderLayout.WEST);
        add(mainPanel, BorderLayout.CENTER);
        
        ListaLibrosVista listaLibrosVista = new ListaLibrosVista();
        ListaPrestamosVista listaPrestamosVista = new ListaPrestamosVista();
        
        mainPanel.add(listaLibrosVista, "ListaLibrosVista");
        mainPanel.add(listaPrestamosVista, "ListaPrestamosVista");
        
        new LibroController(listaLibrosVista);
        new PrestamoController(listaPrestamosVista);
        
        listaLibrosBtn.addActionListener(e -> {
        	System.out.println("Lista libros botón pulsado");
        	cardLayout.show(mainPanel, "ListaLibrosVista");
        });
        
        misLibrosBtn.addActionListener(e -> {
        	System.out.println("Lista prestamos botón pulsado");
        	cardLayout.show(mainPanel, "ListaPrestamosVista");
        });
        
        setVisible(true);    
        
	}

}
