package libreria.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import libreria.modelo.Prestamo;
import libreria.modelo.PrestamoDAO;
import libreria.vista.ListaPrestamosVista;
import libreria.vista.PrestamoVista;

public class PrestamoController {

	private PrestamoVista prestamoVista;
	private PrestamoDAO prestamoDAO;
	private ListaPrestamosVista listaPrestamosVista;

	public PrestamoController(PrestamoVista prestamoVista, ListaPrestamosVista listaPrestamosVista) {
		this.prestamoVista = prestamoVista;
		this.prestamoDAO = new PrestamoDAO();
		this.listaPrestamosVista = listaPrestamosVista;

		JButton prestarBtn = prestamoVista.getPrestarBtn();
		prestarBtn.addActionListener(new AnadirPrestamoListener());

		System.out.println("Prestamo controller inicializado y listener incluido");
	}
	
	public PrestamoController(ListaPrestamosVista listaPrestamosVista) {
		this.listaPrestamosVista = listaPrestamosVista;
		this.prestamoDAO = new PrestamoDAO();
		cargarPrestamosEnTabla();
	}

	class AnadirPrestamoListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("Prestar Botón pulsado. Class AnadirPrestamoListener");
			String libroIDTexto = prestamoVista.getIdField().getText();
			String usuarioIDTexto = prestamoVista.getUserField().getText();
			String fechaPrestamoTexto = prestamoVista.getFechaPrestamoField().getText();
			boolean estadoDevuelto = false;

			int libroID = 0;
			int usuarioID = 0;

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

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			java.util.Date fechaPrestamo = null;
			java.util.Date fechaDevolucion = null;

			// Verifica y convierte la fecha de préstamo si no está vacía
			if (!fechaPrestamoTexto.isEmpty()) {
				try {
					fechaPrestamo = sdf.parse(fechaPrestamoTexto);
				} catch (ParseException ex) {
					JOptionPane.showMessageDialog(null, "La fecha debe tener un formato yyyy-MM-dd");
					return;
				}
			} else {
				fechaPrestamo = new java.util.Date(); // Usa la fecha actual si no se proporciona una
			}

			// Verifica y convierte la fecha de devolución si no está vacía
			String fechaDevolucionTexto = prestamoVista.getFechaDevolucionField().getText();
			if (!fechaDevolucionTexto.isEmpty()) {
				try {
					fechaDevolucion = sdf.parse(fechaDevolucionTexto);
				} catch (ParseException ex) {
					JOptionPane.showMessageDialog(null, "La fecha debe tener un formato yyyy-MM-dd");
					return;
				}
			}

			String libroTitulo = prestamoDAO.obtenerTituloLibro(libroID);
			String usuarioNombre = prestamoDAO.obtenerNombreUsuario(usuarioID);

			int confirmacion = JOptionPane.showConfirmDialog(null, "Se va a prestar el libro ID: " + libroID + " "
					+ "con título: " + libroTitulo +
					" al usuario: " + usuarioNombre + ".\n¿Confirmar o cancelar?",
					"Confirmación de préstamo", JOptionPane.YES_NO_OPTION);

			if(confirmacion == JOptionPane.YES_OPTION) {

				// Crea un nuevo objeto Prestamo
				Prestamo prestamo = new Prestamo(usuarioID, libroID, fechaPrestamo, fechaDevolucion, estadoDevuelto);

				try {
					// Añade el préstamo usando PrestamoDAO y verifica el éxito
					boolean exito = prestamoDAO.anadirPrestamo(prestamo);
					if (exito) {
						JOptionPane.showMessageDialog(null, "Préstamo realizado con éxito");
					} else {
						JOptionPane.showMessageDialog(null, "No se pudo realizar el préstamo");
					}
				} catch (SQLException ex) {
					ex.printStackTrace();
					JOptionPane.showMessageDialog(null, "Error al realizar el préstamo");
				}
				
				cargarPrestamosEnTabla();
			}
		}
		
		}
	public void cargarPrestamosEnTabla() {
		try {
			List<Prestamo> prestamos = prestamoDAO.getTodosLosPrestamos();
			listaPrestamosVista.actualizarTabla(prestamos);
		} catch(SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error al cargar los libros en la tabla");
		}
	
	}
	
	public void cargarMisPrestamosEnTabla() {
		int usuarioID = LoginController.usuarioID;
		try {
			List<Prestamo> prestamos = prestamoDAO.getMisPrestamos(usuarioID);
			listaPrestamosVista.actualizarTabla(prestamos);
		} catch(SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error al cargar los libros en la tabla");
		}
	}
	
	
}
