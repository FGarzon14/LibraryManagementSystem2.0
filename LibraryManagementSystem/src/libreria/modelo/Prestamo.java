package libreria.modelo;

import java.util.Date;

public class Prestamo {
	private int idPrestamo;
	private int usuarioId;
	private int libroId;
	private Date fechaPrestamo;
	private Date fechaDevolucion;
	private boolean estadoDevuelto;

	// Constructor completo
	public Prestamo(int idPrestamo, int usuarioId, int libroId, Date fechaPrestamo, Date fechaDevolucion,
			boolean estadoDevuelto) {
		this.idPrestamo = idPrestamo;
		this.usuarioId = usuarioId;
		this.libroId = libroId;
		this.fechaPrestamo = fechaPrestamo;
		this.fechaDevolucion = fechaDevolucion;
		this.estadoDevuelto = estadoDevuelto;
	}

	// Constructor sin idPrestamo (para nuevos préstamos)
	public Prestamo(int usuarioId, int libroId, Date fechaPrestamo, Date fechaDevolucion, boolean estadoDevuelto) {
		this.usuarioId = usuarioId;
		this.libroId = libroId;
		this.fechaPrestamo = fechaPrestamo;
		this.fechaDevolucion = fechaDevolucion;
		this.estadoDevuelto = estadoDevuelto;
	}

	// Constructor con solo usuarioId y libroId (para crear préstamo sin fechas ni
	// estado)
	public Prestamo(int usuarioId, int libroId) {
		this.usuarioId = usuarioId;
		this.libroId = libroId;
		this.fechaPrestamo = new Date(); // Asume que el préstamo se realiza hoy
		this.estadoDevuelto = false; // Asume que el préstamo no está devuelto inicialmente
	}

	// Constructor con usuarioId, libroId y fechaPrestamo (sin fechaDevolucion y
	// estado)
	public Prestamo(int usuarioId, int libroId, Date fechaPrestamo) {
		this.usuarioId = usuarioId;
		this.libroId = libroId;
		this.fechaPrestamo = fechaPrestamo;
		this.estadoDevuelto = false; // Asume que el préstamo no está devuelto inicialmente
	}

	// Constructor con usuarioId, libroId y estadoDevuelto (sin fechas)
	public Prestamo(int usuarioId, int libroId, boolean estadoDevuelto) {
		this.usuarioId = usuarioId;
		this.libroId = libroId;
		this.fechaPrestamo = new Date(); // Asume que el préstamo se realiza hoy
		this.estadoDevuelto = estadoDevuelto;
	}

	public int getIdPrestamo() {
		return idPrestamo;
	}

	public void setIdPrestamo(int idPrestamo) {
		this.idPrestamo = idPrestamo;
	}

	public int getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(int usuarioId) {
		this.usuarioId = usuarioId;
	}

	public int getLibroId() {
		return libroId;
	}

	public void setLibroId(int libroId) {
		this.libroId = libroId;
	}

	public Date getFechaPrestamo() {
		return fechaPrestamo;
	}

	public void setFechaPrestamo(Date fechaPrestamo) {
		this.fechaPrestamo = fechaPrestamo;
	}

	public Date getFechaDevolucion() {
		return fechaDevolucion;
	}

	public void setFechaDevolucion(Date fechaDevolucion) {
		this.fechaDevolucion = fechaDevolucion;
	}

	public boolean isEstadoDevuelto() {
		return estadoDevuelto;
	}

	public void setEstadoDevuelto(boolean estadoDevuelto) {
		this.estadoDevuelto = estadoDevuelto;
	}

	@Override
	public String toString() {
		return "Prestamo [idPrestamo=" + idPrestamo + ", usuarioId=" + usuarioId + ", libroId=" + libroId
				+ ", fechaPrestamo=" + fechaPrestamo + ", fechaDevolucion=" + fechaDevolucion + ", estadoDevuelto="
				+ estadoDevuelto + "]";
	}
}
