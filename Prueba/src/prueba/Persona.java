package prueba;

public class Persona {
	private String dni;
	private String nombre;
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	@Override
	public String toString() {
		return "dni=" + dni + ", nombre=" + nombre;
	}
	

}
