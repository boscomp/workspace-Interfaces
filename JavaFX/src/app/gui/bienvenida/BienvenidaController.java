package app.gui.bienvenida;

import app.gui.AppController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

public class BienvenidaController extends AppController{
	

    @FXML
    private Label lbBienvenida;

    @FXML
    private BorderPane panel;

    @FXML
    void irPantalla1(ActionEvent event) {
    	panel.setCenter(cargarVista(FXML_PANTALLA1));
    }

    @FXML
    void irPantalla2(ActionEvent event) {
    	panel.setCenter(cargarVista(FXML_PANTALLA2));
    }

    @FXML
    void salir(ActionEvent event) {
    	cambiarVista(AppController.FXML_LOGIN);
    }
	
	
    
    public void setNombreBienvenida(String nombre) {
    	lbBienvenida.setText("Bienvenido "+nombre);
    }
    
    

   
  
    
}
