package app.gui.login;

import app.gui.AppController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;

public class RegistroController extends AppController{

    @FXML
    private Label lbllPass;

    @FXML
    private PasswordField pfPass;

    @FXML
    private PasswordField repetirPass;

    @FXML
    void continuar(ActionEvent event) {
    	cambiarVista(FXML_TABLA);
    }
}
