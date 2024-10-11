package libreria.modelo;

import java.sql.Date;

public class Usuario {
	
	private int id;
	private String nombre;
	private String contrasena;
	private java.util.Date fechaNacimiento;
	private String correo;
	private int tipo;

    // Constructor completo
    public Usuario(int id, String nombre, String password, Date fechaNacimiento, String correo, int tipo) {
        this.id = id;
        this.nombre = nombre;
        this.contrasena = password;
        this.fechaNacimiento = fechaNacimiento;
        this.correo = correo;
        this.tipo = tipo;
    }

    // Constructor sin id (para nuevos usuarios)
    public Usuario(String nombre, String password, java.util.Date fechaNacimiento, String correo, int tipo) {
        this.nombre = nombre;
        this.contrasena = password;
        this.fechaNacimiento = fechaNacimiento;
        this.correo = correo;
        this.tipo = tipo;
    }

    // Constructor sin fechaNacimiento y correo
    public Usuario(int id, String nombre, String password, int tipo) {
        this.id = id;
        this.nombre = nombre;
        this.contrasena = password;
        this.tipo = tipo;
    }

    // Constructor sin id, fechaNacimiento y correo (para nuevos usuarios)
    public Usuario(String nombre, String password, int tipo) {
        this.nombre = nombre;
        this.contrasena = password;
        this.tipo = tipo;
    }
    
    public Usuario(int ID, String nombre) {
        this.id = ID;
    	this.nombre = nombre;
        
    }
    
	public Usuario(int id, String nombre, java.util.Date fechaNacimiento, String correo, int tipo) {
		this.id = id;
		this.nombre = nombre;
		this.fechaNacimiento = fechaNacimiento;
		this.correo = correo;
		this.tipo = tipo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public java.util.Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	
	

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", contrasena=" + contrasena + ", fechaNacimiento="
				+ fechaNacimiento + ", correo=" + correo + ", tipo=" + tipo + "]";
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
