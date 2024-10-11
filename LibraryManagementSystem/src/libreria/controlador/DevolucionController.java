package libreria.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import libreria.modelo.Devolucion;
import libreria.modelo.DevolucionDAO;
import libreria.modelo.Libro;
import libreria.vista.DevolucionVista;
import libreria.vista.ListaDevolucionesVista;

public class DevolucionController {
	private DevolucionVista devolucionVista;
	private DevolucionDAO devolucionDAO;
	private ListaDevolucionesVista listaDevolucionesVista;

	public DevolucionController(DevolucionVista devolucionVista, ListaDevolucionesVista listaDevolucionesVista) {
		this.devolucionVista = devolucionVista;
		devolucionDAO = new DevolucionDAO();
		this.listaDevolucionesVista = listaDevolucionesVista;	
		
		JButton devolverBtn = devolucionVista.getDevolverBtn();
		
		devolverBtn.addActionListener(new AnadirDevolucionListener());
		
		
	}
	
	public DevolucionController(ListaDevolucionesVista listaDevolucionesVista) {
		devolucionDAO = new DevolucionDAO();
		this.listaDevolucionesVista = listaDevolucionesVista;
		
		cargarDevolucionesEnTabla();
	}
	
	class AnadirDevolucionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			System.out.println("Devolver Botón Pulsado. AnadirDevolucionListener");

			String libroIDTexto = devolucionVista.getLibroIDField().getText();
			String usuarioIDTexto = devolucionVista.getUsuarioIDField().getText();

			int libroID = 0;
			int usuarioID = 0;
			Date fechaDevolucion = new java.util.Date();
			
			
			// Verifica que los campos de libro y usuario no estén vacíos
			if (libroIDTexto.isEmpty() || usuarioIDTexto.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Los campos marcados con * son obligatorios");
				return;
			} else {
				try {
					libroID = Integer.parseInt(libroIDTexto);
					usuarioID = Integer.parseInt(usuarioIDTexto);
				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(null, "Los datos Libro ID y Usuario ID deben ser de tipo numérico");
					return;
				}
			}
			
			Devolucion devolucion = new Devolucion(usuarioID, libroID, fechaDevolucion);
		
			try {
				boolean exito = devolucionDAO.anadirDevolucion(devolucion);
				if(exito) {
					JOptionPane.showMessageDialog(null, "Devolución realizada con éxito");
				} else {
					JOptionPane.showMessageDialog(null, "No se pudo completar la devolución");
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			

			cargarDevolucionesEnTabla();

		}
	}
	
	public void cargarDevolucionesEnTabla() {
		
		  List<Devolucion> devoluciones = devolucionDAO.getTodasLasDevoluciones();
		  listaDevolucionesVista.actualizarTabla(devoluciones);
		
	}
}
