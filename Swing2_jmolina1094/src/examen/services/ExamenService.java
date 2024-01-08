package examen.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import examen.modelo.Coche;

public class ExamenService{

	/** Hace login con el código de acceso indicado. Si todo va bien, no devuelve nada. Si el código no es correcto,
	 * lanza AutenticationException con el mensaje de error.
	 * @param codigo
	 * @throws AutenticacionException 
	 */
	public void login(String user) throws AccesoDenegadoException {
		if (user==null || user.isEmpty()) {
			throw new AccesoDenegadoException("El código indicado es vacío");
		}
		if (user.equals("dam")) {
			return;
		}
		if (user.length()<=3) {
			throw new AccesoDenegadoException("Código incorrecto");
		}
		throw new AccesoDenegadoException("Acceso no permitido");
	}
	
	/** Crea un coche en la base de datos con la marca, modelo y antigüedad indicados. Por defecto se pondrá
	 * como fecha de última revisión la fecha actual.
	 * Si hay algún error, el servicio lanzará un ErrorCocheException
	 * @param marca
	 * @param modelo
	 * @param antiguedad
	 */
	public void crearCoche(String marca, String modelo, Integer precio) throws ErrorCocheException{
		if (precio < 100) {
			throw new ErrorCocheException("Se ha producido un error controlado al guardar el coche");
		}
		if (precio > 999999) {
			throw new ErrorCocheException("No se ha podido registrar el coche en BBDD");
		}
		List<Coche> coches = bbdd.get(marca.toUpperCase().trim());
		if (coches==null) {
			coches = new ArrayList<>();
			bbdd.put(marca.toUpperCase().trim(), coches);
		}
		coches.add(new Coche(marca, modelo, LocalDate.now(), precio));
	}
	
	/** Devuelve la lista de coches de la marca indicada que estén registrados en la "base de datos" simulada.
	 * Si no hay coches para la marca indicada, devolveró una lista vacía 
	 * @param marca
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Coche> consultarCoches(String marca){
		if (marca == null) {
			return new ArrayList<Coche>();
		}
		marca = marca.toUpperCase().trim();
		if (!bbdd.containsKey(marca)) {
			return new ArrayList<Coche>();
		}
		ArrayList<Coche> coches = (ArrayList<Coche>) bbdd.get(marca);
		return (List<Coche>) coches.clone();
		
	}
	
	
	// Ignorar este c�digo...
	private static Map<String, List<Coche>> bbdd = new HashMap<String, List<Coche>>();
	static {
		List<Coche> toyota = new ArrayList<Coche>();
		toyota.add(new Coche("Toyota", "Auris", "2010", "1521FFD", 8532));
		toyota.add(new Coche("Toyota", "Auris", "2013", "4862DDD", 7896));
		toyota.add(new Coche("Toyota", "Rav4", "", "4862BRT", 15000));
		toyota.add(new Coche("Toyota", "Corolla", "2020", "8761DQT", 16100));
		toyota.add(new Coche("Toyota", "Yaris", "2012", "9661JKK", 4350));
		toyota.add(new Coche("Toyota", "Rav4", "", "4134NBV", 17211));
		List<Coche> seat = new ArrayList<Coche>();
		seat.add(new Coche("Seat", "Córdoba", "2005", "2521RFD", 8000));
		seat.add(new Coche("Seat", "Ibiza", "2010", "4522RTD", 6000));
		seat.add(new Coche("Seat", "León", "2011", "0114BRT", 15500));
		seat.add(new Coche("Seat", "Córdoba", "2019", "8761DQT", 17100));
		seat.add(new Coche("Seat", "León", "", "9661JKK", 4200));
		seat.add(new Coche("Seat", "Ibiza", "2019", "4134BBV", 17211));
		seat.add(new Coche("Seat", "Córdoba", "2011", "1521FFD", 8532));
		seat.add(new Coche("Seat", "Ibiza", "2013", "4862DDD", 7896));
		seat.add(new Coche("Seat", "León", "2016", "4862BRT", 15000));
		seat.add(new Coche("Seat", "Toledo", "", "2521RFD", 8000));
		seat.add(new Coche("Seat", "Ibiza", "2010", "4522RTD", 6000));
		seat.add(new Coche("Seat", "Toledo", "2011", "0114BRT", 15500));
		seat.add(new Coche("Seat", "Córdoba", "2019", "8761DQT", 17100));
		seat.add(new Coche("Seat", "Toledo", "2020", "9661JKK", 4200));
		seat.add(new Coche("Seat", "Ibiza", "2019", "4134BBV", 17211));
		seat.add(new Coche("Seat", "Córdoba", "2011", "1521FFD", 8532));
		seat.add(new Coche("Seat", "León", "2016", "4862BRT", 15000));
		seat.add(new Coche("Seat", "Ibiza", "2013", "4862DDD", 7896));
		List<Coche> renault = new ArrayList<Coche>();
		renault.add(new Coche("Renault", "Laguna", "2017", "5562CRT", 3245));
		renault.add(new Coche("Renault", "Clío", "2020", "8551CQC", 11500));
		renault.add(new Coche("Renault", "Megane", "2008", "1555FPD", 12000));
		renault.add(new Coche("Renault", "Megane", "2003", "4662RWD", 10012));
		renault.add(new Coche("Renault", "Megane", "2010", "9001VVF", 6588));
		renault.add(new Coche("Renault", "Clío", "2009", "0034BWW", 1500));
		bbdd.put("TOYOTA", toyota);
		bbdd.put("SEAT", seat);
		bbdd.put("RENAULT", renault);
		
	}
	
	

	
}
