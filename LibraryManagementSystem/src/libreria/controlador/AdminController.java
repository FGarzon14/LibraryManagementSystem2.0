package libreria.controlador;

import libreria.modelo.ConexionDB;
import libreria.vista.AnadirLibroVista;

public class AdminController {

	AnadirLibroVista anadirLibroVista;
	ConexionDB conexionDB;
	
	public AdminController() {
		anadirLibroVista = new AnadirLibroVista();
		conexionDB = new ConexionDB();
		
	}

}
