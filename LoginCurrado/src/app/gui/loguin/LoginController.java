package app.gui.loguin;

import java.text.SimpleDateFormat;

import app.gui.modelo.Usuario;
import app.gui.services.LoginDenegadoException;
import app.gui.services.LoginService;
import javafx.application.Platform;
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
	@FXML
	private Label labAccesoDen;
	@FXML
	public void initialize() {
		Platform.runLater(new Runnable() {
			
			@Override
			public void run() {
				tfNombre.requestFocus();
			}
		});
	}
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
			labAcceso.setVisible(true);
			labAccesoDen.setVisible(false);
			labNombre.setText(u.getNombre() + " -- " + sdf.format(u.getFechaRegistro()));
		} catch (LoginDenegadoException e) {
			
			labAccesoDen.setText("Acceso denegado");
			labAcceso.setVisible(false);
			labAccesoDen.setVisible(true);
			labNombre.setText("");
		}
	}
	public void salirApp () {
		System.exit(0);
	}
}
