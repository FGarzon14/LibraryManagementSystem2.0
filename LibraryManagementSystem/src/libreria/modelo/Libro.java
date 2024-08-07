package libreria.modelo;

import java.sql.Date;

public class Libro {
    private int id;
    private String titulo;
    private String autor;
    private int ISBN;
    private java.util.Date fechaPublicacion;
    private String editorial;
    private String genero;
    private String sinopsis;

    // Constructor completo
    public Libro(int id, String titulo, String autor, int ISBN, java.util.Date fechaPublicacion, String editorial,
                 String genero, String sinopsis) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.ISBN = ISBN;
        this.fechaPublicacion = fechaPublicacion;
        this.editorial = editorial;
        this.genero = genero;
        this.sinopsis = sinopsis;
    }
    

    // Constructor sin id (para nuevos libros)
    public Libro(String titulo, String autor, int ISBN, java.util.Date fechaPublicacion, String editorial,
                 String genero, String sinopsis) {
        this.titulo = titulo;
        this.autor = autor;
        this.ISBN = ISBN;
        this.fechaPublicacion = fechaPublicacion;
        this.editorial = editorial;
        this.genero = genero;
        this.sinopsis = sinopsis;
    }


    // Constructor sin sinopsis
    public Libro(int id, String titulo, String autor, int ISBN, Date fechaPublicacion, String editorial,
                 String genero) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.ISBN = ISBN;
        this.fechaPublicacion = fechaPublicacion;
        this.editorial = editorial;
        this.genero = genero;
    }

    // Constructor sin id y sinopsis (para nuevos libros)
    public Libro(String titulo, String autor, int ISBN, Date fechaPublicacion, String editorial,
                 String genero) {
        this.titulo = titulo;
        this.autor = autor;
        this.ISBN = ISBN;
        this.fechaPublicacion = fechaPublicacion;
        this.editorial = editorial;
        this.genero = genero;
    }
    
  

	@Override
	public String toString() {
		return "Libro [id=" + id + ", titulo=" + titulo + ", autor=" + autor + ", ISBN=" + ISBN + ", fechaPublicacion="
				+ fechaPublicacion + ", editorial=" + editorial + ", genero=" + genero + ", sinopsis=" + sinopsis + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public int getISBN() {
		return ISBN;
	}

	public void setISBN(int iSBN) {
		ISBN = iSBN;
	}

	public java.util.Date getFechaPublicacion() {
		return fechaPublicacion;
	}

	public void setFechaPublicacion(java.util.Date fechaPublicacion) {
	    this.fechaPublicacion = fechaPublicacion;
	}


	public String getEditorial() {
		return editorial;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getSinopsis() {
		return sinopsis;
	}

	public void setSinopsis(String sinopsis) {
		this.sinopsis = sinopsis;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
