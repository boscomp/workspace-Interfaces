package app.gui.loguin;

import java.text.SimpleDateFormat;

import app.gui.modelo.Usuario;
import app.gui.services.LoginDenegadoException;
import app.gui.services.LoginService;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {
	@FXML
	private TextField tfNombre;

	@FXML
	private PasswordField passField;

	@FXML
	private Label labAcceso;

	@FXML
	private Label labNombre;

	public void borrarTexto() {
		
		tfNombre.setText("");
		passField.setText("");
		
	}

	public void login() {
		LoginService ls = new LoginService();
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			Usuario u = ls.login(tfNombre.getText(), passField.getText());
			labAcceso.setText("Acceso correcto");
		
			labNombre.setText(u.getNombre() + " -- " + sdf.format(u.getFechaRegistro()));
		} catch (LoginDenegadoException e) {

			labAcceso.setText("Acceso denegado");
			labNombre.setText("");
		}
	}
}
