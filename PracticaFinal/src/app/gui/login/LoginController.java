package app.gui.login;

import app.gui.AppController;
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
	    private PasswordField pfPass;

	    @FXML
	    private TextField tfNombre;
	    @FXML
	    private Label lblRegistro;
	    @FXML
	    void entrar(ActionEvent event) {

	    }
	   
	    @FXML
	    void irARegistro(MouseEvent event) {
	    	
	    	cambiarVista(FXML_REGISTRO);
	    }

}
