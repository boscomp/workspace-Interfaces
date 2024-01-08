package app.gui.loguin;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class LoginController {
	@FXML
	private TextField tfNombre;

	public void escribirTexto() {
		System.out.println(tfNombre.getText());
		tfNombre.setText("");
	}
}
