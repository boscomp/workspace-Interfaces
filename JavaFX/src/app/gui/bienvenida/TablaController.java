package app.gui.bienvenida;

import java.util.ArrayList;
import java.util.List;

import app.gui.modelo.Persona;
import app.gui.services.PersonasService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class TablaController {

	
	 @FXML
	    private TableColumn<Persona, String> columnDNI;

	    @FXML
	    private TableColumn<Persona, Integer> columnEdad;

	    @FXML
	    private TableColumn<Persona, String> columnNombre;


	    @FXML
	    private TableView<Persona> tabla;
	    
	    @FXML
	    private Button btnAdd;
	    private ObservableList<Persona> datos;
	    
	    public void initialize() {

	    	columnDNI.setCellValueFactory(new PropertyValueFactory<Persona, String>("dni"));
	    	columnEdad.setCellValueFactory(new PropertyValueFactory<Persona, Integer>("edad"));
	    	columnNombre.setCellValueFactory(new PropertyValueFactory<Persona, String>("nombre"));
	    	
	    	datos = FXCollections.observableArrayList();
	    	tabla.setItems(datos);
	    }
	    

	

	    @FXML
	    void addPersona(ActionEvent event) {

	    	List <Persona> personas=new PersonasService().getPersonas();
	    	datos.setAll(personas);

	    }
}
