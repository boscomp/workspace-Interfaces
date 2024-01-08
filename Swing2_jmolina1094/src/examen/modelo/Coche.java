package examen.modelo;

import java.time.LocalDate;
import java.util.Random;

public class Coche {

	private String marca;
	private String modelo;
	private String año;
	private String matricula;
	private Integer precio;
	private LocalDate fechaMatricula;
	
	public Coche(String marca, String modelo, String año, String matricula, Integer precio, LocalDate fechaMatricula) {
		super();
		this.marca = marca;
		this.modelo = modelo;
		this.año = año;
		this.matricula = matricula;
		this.precio = precio;
		this.fechaMatricula = fechaMatricula;
	}
	public Coche(String marca, String modelo, String año, String matricula, Integer precio) {
		super();
		this.marca = marca;
		this.modelo = modelo;
		this.año = año;
		this.matricula = matricula;
		this.precio = precio;
		Random rd = new Random();
		this.fechaMatricula = LocalDate.of(rd.nextInt(23)+2000, rd.nextInt(12)+1, rd.nextInt(25)+1);
	}
	
	public Coche(String marca, String modelo, LocalDate fecha, Integer precio) {
		this.marca = marca;
		this.modelo = modelo;
		this.año = fecha.getYear()+"";
		this.matricula = "";
		this.precio = precio;
		this.fechaMatricula = fecha;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getAño() {
		return año;
	}
	public void setAño(String año) {
		this.año = año;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public Integer getPrecio() {
		return precio;
	}
	public void setPrecio(Integer precio) {
		this.precio = precio;
	}
	public LocalDate getFechaMatricula() {
		return fechaMatricula;
	}
	public void setFechaMatricula(LocalDate fechaMatricula) {
		this.fechaMatricula = fechaMatricula;
	}
	
	

}
