package app.gui.tipo;

import app.gui.AppController;
import app.gui.modelo.Animal;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class TipoController extends AppController{

    @FXML
    private TextField tfTipo;

    @FXML
    void continuar(ActionEvent event) {
    	Animal a = new Animal();
    	putUserDataObject(tfTipo.getText(), a);
    }

}
