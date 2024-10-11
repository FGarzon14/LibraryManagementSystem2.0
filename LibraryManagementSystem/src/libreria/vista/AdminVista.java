package libreria.vista;

import javax.swing.*;

import libreria.controlador.DevolucionController;
import libreria.controlador.LibroController;
import libreria.controlador.PrestamoController;
import libreria.controlador.UsuarioController;

import java.awt.*;

public class AdminVista extends JFrame {

    private JPanel mainPanel;
    private CardLayout cardLayout;
    
    private JButton anadirLibroBtn;
    private JButton eliminarLibroBtn;
    private JButton anadirUsuarioBtn;
    private JButton eliminarUsuarioBtn;
    private JButton prestarLibroBtn;
    private JButton devolverLibroBtn;
    private JButton listaLibrosBtn;
    private JButton listaUsuariosBtn;
    private JButton listaPrestamosBtn;
    private JButton listaDevolucionesBtn;

    public AdminVista() {
        setTitle("Administrador");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Crear menú lateral
        JPanel menuPanel = new JPanel(); 
        menuPanel.setLayout(new GridLayout(10, 1, 5, 5)); // 10 filas, 1 columna, con espacios de 5px entre componentes
        menuPanel.setBackground(Color.LIGHT_GRAY);

        anadirLibroBtn = new JButton("Añadir libro");
        eliminarLibroBtn = new JButton("Eliminar libro");
        anadirUsuarioBtn = new JButton("Añadir usuario");
        eliminarUsuarioBtn = new JButton("Eliminar usuario");
        prestarLibroBtn = new JButton("Préstamo");
        devolverLibroBtn = new JButton("Devolución");
        listaLibrosBtn = new JButton("Listado de libros");
        listaUsuariosBtn = new JButton("Listado de usuarios");
        listaPrestamosBtn = new JButton("Listado de préstamos");
        listaDevolucionesBtn = new JButton("Listado de devoluciones");
        
        Color customColor = Color.decode("#f0e1e9");
        anadirLibroBtn.setBackground(customColor);
        eliminarLibroBtn.setBackground(customColor);
        anadirUsuarioBtn.setBackground(customColor);
        eliminarUsuarioBtn.setBackground(customColor);
        prestarLibroBtn.setBackground(customColor);
        devolverLibroBtn.setBackground(customColor);
        listaLibrosBtn.setBackground(customColor);
        listaUsuariosBtn.setBackground(customColor);
        listaPrestamosBtn.setBackground(customColor);
        listaDevolucionesBtn.setBackground(customColor);

        menuPanel.add(anadirLibroBtn);
        menuPanel.add(eliminarLibroBtn);
        menuPanel.add(anadirUsuarioBtn);
        menuPanel.add(eliminarUsuarioBtn);
        menuPanel.add(prestarLibroBtn);
        menuPanel.add(devolverLibroBtn);
        menuPanel.add(listaLibrosBtn);
        menuPanel.add(listaUsuariosBtn);
        menuPanel.add(listaPrestamosBtn);
        menuPanel.add(listaDevolucionesBtn);

        // Crear el panel principal con CardLayout
        mainPanel = new JPanel();
        cardLayout = new CardLayout();
        mainPanel.setLayout(cardLayout);

        // Añadir el menú lateral y el panel principal al frame
        add(menuPanel, BorderLayout.WEST);
        add(mainPanel, BorderLayout.CENTER);

        // Crear instancias de las vistas y añadirlas al CardLayout con claves únicas
        AnadirLibroVista anadirLibroVista = new AnadirLibroVista();
        EliminarLibroVista eliminarLibroVista = new EliminarLibroVista();
        AnadirUsuarioVista anadirUsuarioVista = new AnadirUsuarioVista();
        EliminarUsuarioVista eliminarUsuarioVista = new EliminarUsuarioVista();
        PrestamoVista prestamoVista = new PrestamoVista();
        DevolucionVista devolucionVista = new DevolucionVista();
        ListaLibrosVista listaLibrosVista = new ListaLibrosVista();
        ListaUsuariosVista listaUsuariosVista = new ListaUsuariosVista();
        ListaPrestamosVista listaPrestamosVista = new ListaPrestamosVista();
        ListaDevolucionesVista listaDevolucionesVista = new ListaDevolucionesVista();
        
        mainPanel.add(anadirLibroVista, "AnadirLibroVista");
        mainPanel.add(eliminarLibroVista, "EliminarLibroVista");
        mainPanel.add(anadirUsuarioVista, "AnadirUsuarioVista");
        mainPanel.add(eliminarUsuarioVista, "EliminarUsuarioVista"); 
        mainPanel.add(prestamoVista, "PrestamoVista");
        mainPanel.add(devolucionVista, "DevolucionVista");
        mainPanel.add(listaLibrosVista, "ListaLibrosVista");
        mainPanel.add(listaUsuariosVista, "ListaUsuariosVista");
        mainPanel.add(listaPrestamosVista, "ListaPrestamosVista");
        mainPanel.add(listaDevolucionesVista, "ListaDevolucionesVista");

        // Inicializar controladores
        new LibroController(anadirLibroVista, listaLibrosVista);
        new LibroController(eliminarLibroVista, listaLibrosVista);
        new UsuarioController(anadirUsuarioVista, listaUsuariosVista);
        new UsuarioController(eliminarUsuarioVista, listaUsuariosVista);
        new PrestamoController(prestamoVista, listaPrestamosVista);
        new DevolucionController(devolucionVista, listaDevolucionesVista);
        new LibroController(listaLibrosVista);
        new UsuarioController(listaUsuariosVista);
        new PrestamoController(listaPrestamosVista);
        new DevolucionController(listaDevolucionesVista);
        

        // Configurar acciones de los botones para mostrar las vistas correspondientes
        anadirLibroBtn.addActionListener(e -> {
            System.out.println("Añadir libro botón clicado");
            cardLayout.show(mainPanel, "AnadirLibroVista");
        });

        eliminarLibroBtn.addActionListener(e -> {
            System.out.println("Eliminar libro botón clicado");
            cardLayout.show(mainPanel, "EliminarLibroVista");
        });
        
        anadirUsuarioBtn.addActionListener(e -> {
        	System.out.println("Añadir usuario botón clicado");
        	cardLayout.show(mainPanel, "AnadirUsuarioVista");
        });
        
        eliminarUsuarioBtn.addActionListener(e -> {
        	System.out.println("Eliminar usuario botón clicado");
        	cardLayout.show(mainPanel, "EliminarUsuarioVista");
        });
        prestarLibroBtn.addActionListener(e -> {
        	System.out.println("Prestar libro botón clicado");
        	cardLayout.show(mainPanel, "PrestamoVista");
        });
        
        devolverLibroBtn.addActionListener(e -> {
        	System.out.println("Devolver libro botón clicado");
        	cardLayout.show(mainPanel, "DevolucionVista");
        });
        
        listaLibrosBtn.addActionListener(e -> {
        	System.out.println("Lista libros botón pulsado");
        	cardLayout.show(mainPanel, "ListaLibrosVista");
        });
        
        listaUsuariosBtn.addActionListener(e -> {
        	System.out.println("Lista de usuarios botón pulsado");
        	cardLayout.show(mainPanel, "ListaUsuariosVista");
        });
        
        listaPrestamosBtn.addActionListener(e -> {
        	System.out.println("Lista prestamos botón pulsado");
        	cardLayout.show(mainPanel, "ListaPrestamosVista");
        });
        
        listaDevolucionesBtn.addActionListener(e -> {
        	System.out.println("Lista de devoluciones botón pulsado");
        	cardLayout.show(mainPanel, "ListaDevolucionesVista");
        });
        

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(AdminVista::new);
    }
}
