package app.gui.bienvenida;

import java.util.Optional;

import app.gui.AppController;
import app.gui.modelo.Persona;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;

public class BienvenidaController extends AppController{
   
    @FXML
    private Label lbBienvenida;

    @FXML
    private BorderPane panel;
    
   

    @FXML
    void irColorPicker(ActionEvent event) {
    	panel.setCenter(cargarVista(FXML_COLORPICKER));
    	
    }

    @FXML
    void irComboBox(ActionEvent event) {

    	panel.setCenter(cargarVista(AppController.FXML_COMBOBOX));
//		controller.setNombreBienvenida(nombreUsuario);
    }

    @FXML
    void irDatePicker(ActionEvent event) {
    	panel.setCenter(cargarVista(AppController.FXML_DATEPICKER));
    }

    @FXML
    void irLogin(ActionEvent event) {
    	panel.setCenter(cargarVista(AppController.FXML_LOGIN));
    }

    @FXML
    void irSlider(ActionEvent event) {
    	panel.setCenter(cargarVista(AppController.FXML_SLIDER));
    }
    @FXML
    void irTabla(ActionEvent event) {
    	panel.setCenter(cargarVista(AppController.FXML_TABLA));
    }
    @FXML
    void salir(ActionEvent event) {
    	Alert a = new Alert(AlertType.CONFIRMATION);
    	a.setHeaderText("");
    	a.setContentText("¿Estás seguro de querer cerrar?");
    	a.setTitle("Confirmación");
    	Optional <ButtonType> result=a.showAndWait();
    	if (result.get()==ButtonType.OK) {
    		System.exit(0);
    		
    	}
    	
    	
    }
    
	
	
    
    public void setNombreBienvenida(String nombre) {
    	lbBienvenida.setText("Bienvenido "+nombre);
    }
    
    

   
  
    
}
