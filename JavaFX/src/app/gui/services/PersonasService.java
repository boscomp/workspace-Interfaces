package app.gui.services;

import java.util.ArrayList;
import java.util.List;

import app.gui.modelo.Persona;

public class PersonasService {

	public List <Persona> getPersonas() {
		List <Persona> personas= new ArrayList<Persona>();
		for (int i=0; i<40;i++) {
			Persona p = new Persona();
			p.setDni(""+i);
			p.setNombre("Persona "+i);
			p.setEdad(i+10);
			personas.add(p);
		}
		return personas;
	}
}
