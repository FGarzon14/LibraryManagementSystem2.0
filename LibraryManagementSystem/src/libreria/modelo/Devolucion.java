package libreria.modelo;

import java.util.Date;

public class Devolucion {
    private int idDevolucion;
    private int usuarioId;
    private String usuarioNombre;
    private int libroId;
    private String libroTitulo;
    private Date fechaDevolucion;

    // Constructor completo
    public Devolucion(int usuarioId, int libroId, Date fechaDevolucion) {
        
        this.usuarioId = usuarioId;
        this.libroId = libroId;
        this.fechaDevolucion = fechaDevolucion;
    }

    // Constructor sin idDevolucion (para nuevas devoluciones)
    public Devolucion(int usuarioId, String usuarioNombre, int libroId, String libroTitulo, Date fechaDevolucion) {
        this.usuarioId = usuarioId;
        this.usuarioNombre = usuarioNombre;
        this.libroId = libroId;
        this.libroTitulo = libroTitulo;
        this.fechaDevolucion = fechaDevolucion;
    }
    
    public Devolucion(int idDevolucion, int usuarioId, String usuarioNombre, int libroId, String libroTitulo, Date fechaDevolucion) {
        this.idDevolucion = idDevolucion;
        this.usuarioId = usuarioId;
        this.usuarioNombre = usuarioNombre;
        this.libroId = libroId;
        this.libroTitulo = libroTitulo;
        this.fechaDevolucion = fechaDevolucion;
    }
    
    public Devolucion(int idDevolucion, int usuarioId, int libroId,  Date fechaDevolucion) {
        this.idDevolucion = idDevolucion;
        this.usuarioId = usuarioId;
        this.libroId = libroId;
        this.fechaDevolucion = fechaDevolucion;
    }

	public int getIdDevolucion() {
		return idDevolucion;
	}

	public void setIdDevolucion(int idDevolucion) {
		this.idDevolucion = idDevolucion;
	}

	public int getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(int usuarioId) {
		this.usuarioId = usuarioId;
	}

	public String getUsuarioNombre() {
		return usuarioNombre;
	}

	public void setUsuarioNombre(String usuarioNombre) {
		this.usuarioNombre = usuarioNombre;
	}

	public int getLibroId() {
		return libroId;
	}

	public void setLibroId(int libroId) {
		this.libroId = libroId;
	}

	public String getLibroTitulo() {
		return libroTitulo;
	}

	public void setLibroTitulo(String libroTitulo) {
		this.libroTitulo = libroTitulo;
	}

	public Date getFechaDevolucion() {
		return fechaDevolucion;
	}

	public void setFechaDevolucion(Date fechaDevolucion) {
		this.fechaDevolucion = fechaDevolucion;
	}

	@Override
	public String toString() {
		return "Devolucion [idDevolucion=" + idDevolucion + ", usuarioId=" + usuarioId + ", usuarioNombre="
				+ usuarioNombre + ", libroId=" + libroId + ", libroTitulo=" + libroTitulo + ", fechaDevolucion="
				+ fechaDevolucion + "]";
	}


}
