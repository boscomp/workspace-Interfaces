package app.gui.login;

import app.gui.AppController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class FavoritosController extends AppController{


    @FXML
    void continuar(ActionEvent event) {
    	cambiarVista(FXML_TABLA);
    }


}
