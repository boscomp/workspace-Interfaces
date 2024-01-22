package app.gui.bienvenida;

import app.gui.AppController;
import javafx.collections.FXCollections;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class ComboBoxController extends AppController{

    @FXML
    private Button btnImprimir;

    @FXML
    private Button btnLimpiar;

    @FXML
    private ComboBox<String> comboBoxNombres;

    @FXML
    private TextField textFieldResultado;

    public void initialize() {
    	comboBoxNombres.setItems(FXCollections.observableArrayList("Bosco", "Fekir", "Isco"));
    	
    }
    
    @FXML
    void imprimirCombo(ActionEvent event) {
    	if (comboBoxNombres.getValue()!=null) {
    	textFieldResultado.setText(comboBoxNombres.getValue());
    	}
    }

    @FXML
    void limpiarPantalla(ActionEvent event) {
    	
comboBoxNombres.getSelectionModel().clearSelection();
textFieldResultado.setText("");
textFieldResultado.setPromptText("resultado...");
    
    }
  
    
}
