package app.gui.services;




import java.util.Date;

import app.gui.modelo.Usuario;

public class LoginService {
	public Usuario login(String username, String password) throws LoginDenegadoException {
		
		
		
		Usuario usuario = new Usuario("Laura Santos Rioja", "Sevilla", new Date());
		if ("a".equals(username) && "a".equals(password)) {
			return usuario;
		}
		throw new LoginDenegadoException("Usuario/Password incorrectos");
	}
	
}
