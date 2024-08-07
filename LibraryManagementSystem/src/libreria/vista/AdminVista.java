package libreria.vista;

import javax.swing.*;

import libreria.controlador.LibroController;

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

        mainPanel.add(anadirLibroVista, "AnadirLibroVista");
        mainPanel.add(eliminarLibroVista, "EliminarLibroVista");

        // Inicializar controladores
        new LibroController(anadirLibroVista);
        new LibroController(eliminarLibroVista);

        // Configurar acciones de los botones para mostrar las vistas correspondientes
        anadirLibroBtn.addActionListener(e -> {
            System.out.println("Añadir libro botón clicado");
            cardLayout.show(mainPanel, "AnadirLibroVista");
        });

        eliminarLibroBtn.addActionListener(e -> {
            System.out.println("Eliminar libro botón clicado");
            cardLayout.show(mainPanel, "EliminarLibroVista");
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(AdminVista::new);
    }
}
