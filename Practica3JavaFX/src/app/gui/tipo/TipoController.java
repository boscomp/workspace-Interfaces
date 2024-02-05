package app.gui.tipo;

import app.gui.AppController;
import app.gui.modelo.Animal;
import app.gui.tabla.TablaController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class TipoController extends AppController{

    @FXML
    private TextField tfTipo;

    @FXML
    void continuar(ActionEvent event) {
    	if (tfTipo.getText().isEmpty()) {
    		Alert a = new Alert(AlertType.ERROR);
			a.setHeaderText(null);
			a.setContentText("El tipo indicado no puede ser vacío");
			a.setTitle("Error");
			a.showAndWait();
    	}
    	else {
    	Animal a = new Animal();
    	a.setTipo(tfTipo.getText());
    	putUserDataObject(tfTipo.getText(), a);
    	TablaController tc = new TablaController();
    	tc.irANombre();
    	}
    }

}
