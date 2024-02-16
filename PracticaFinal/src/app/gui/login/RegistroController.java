package app.gui.login;

import app.gui.services.LoginService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class RegistroController extends AppController{

	 @FXML
	    private Label lbllPass;

	    @FXML
	    private PasswordField pfPass;

	    @FXML
	    private PasswordField repetirPass;

	    @FXML
	    private TextField tfNombre;


	    @FXML
	    void crearUsuario(ActionEvent event) {
	    	if (pfPass.getText().equals(repetirPass.getText())) {
	    		LoginService ls = new LoginService();
	    		ls.crearUsuario(tfNombre.getText(), pfPass.getText());
	    	} else {
	    		mostrarAlerta("Las contraseñas deben coincidir");
	    	}
	    }

    @FXML
    void continuar(ActionEvent event) {
    	cambiarVista(FXML_FAVS);
    }
}
