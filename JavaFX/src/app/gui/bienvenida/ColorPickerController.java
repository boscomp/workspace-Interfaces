package app.gui.bienvenida;

import app.gui.AppController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;

public class ColorPickerController extends AppController{

    @FXML
    private Button btnAplicar;

    @FXML
    private ColorPicker colorPick;

    @FXML
    private Label lblResultado;
    @FXML
    void aplicarColor(ActionEvent event) {
  
    
//    	String color1[]=color.split("x");
//    	lblResultado.setStyle("-fx-text-fill:"+color1[1]);
    	lblResultado.setTextFill(colorPick.getValue());
    }
}
