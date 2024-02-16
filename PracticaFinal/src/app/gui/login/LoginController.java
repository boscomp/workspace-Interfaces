package app.gui.login;

import app.gui.modelo.Usuario;
import app.gui.services.LoginService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;

public class LoginController extends AppController {
	@FXML
	private BorderPane panel;
	@FXML
	private Label lblError;
	@FXML
	private PasswordField pfPass;

	@FXML
	private TextField tfNombre;
	@FXML
	private Label lblRegistro;

	@FXML
	void entrar(ActionEvent event) {
		if (tfNombre.getText().isEmpty() || pfPass.getText().isEmpty()) {
			lblError.setText("Ningún campo puede estar vacío");
			limpiarCampos();
		} else {
			LoginService ls = new LoginService();
			Usuario u = ls.verificarLogin(tfNombre.getText(), pfPass.getText());
			if (u == null) {
				mostrarAlerta("Nombre o contraseña incorrectos");
				limpiarCampos();
			} else {
				putUserDataObject("usuarioActivo", u);
				cambiarVista(FXML_FAVS);
			}
		}

	}

	@FXML
	void irARegistro(MouseEvent event) {

		cambiarVista(FXML_REGISTRO);
	}

	public void limpiarCampos() {
		tfNombre.setText("");
		pfPass.setText("");
	}

}
