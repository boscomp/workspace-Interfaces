package app.gui.tabla;

import java.util.List;
import java.util.Optional;

import app.gui.AppController;
import app.gui.modelo.Animal;
import app.gui.service.AnimalesServices;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.effect.BoxBlur;
import javafx.scene.layout.BorderPane;

public class TablaController extends AppController {
    @FXML
    private ProgressBar progressBar;

	@FXML
	private TableColumn<Animal, Integer> colEdad;

	@FXML
	private TableColumn<Animal, String> colName;
    @FXML
    private BorderPane panel;
	@FXML
	private TableColumn<Animal, String> colTipo;
    @FXML
    private TextField tfAnimal;
	@FXML
	private TableView<Animal> tabla;
	 private ObservableList<Animal> datos;
	 private BoxBlur bb;
	    
	    public void initialize() {

	    	colName.setCellValueFactory(new PropertyValueFactory<Animal, String>("nombre"));
	    	colEdad.setCellValueFactory(new PropertyValueFactory<Animal, Integer>("edad"));
	    	colTipo.setCellValueFactory(new PropertyValueFactory<Animal, String>("tipo"));
	    	
	    	datos = FXCollections.observableArrayList();
	    	tabla.setItems(datos);
	    	bb=new BoxBlur();
	    }
	@FXML
	void añadirAnimales(ActionEvent event) {

		Task<Void> task = new Task<Void>() {
			List<Animal> resultados;
			AnimalesServices as = new AnimalesServices();
			

			@Override
			protected Void call() throws Exception {
				resultados = as.consultarAnimales(tfAnimal.getText());
				
				tabla.setEffect(null);
				return null;
			}

			@Override
			protected void succeeded() {
				datos.setAll(resultados);
				super.succeeded();
				updateProgress(100,100);
			}

			@Override
			protected void failed() {
				datos.clear();
				super.failed();
				Alert a = new Alert(AlertType.ERROR);
				a.setHeaderText(null);
				a.setContentText("No hay registros en la bbdd con ese filtro");
				a.setTitle("Error");
				a.showAndWait();
				updateProgress(100,100);
				tabla.setEffect(null);
				
			}
		};
		new Thread(task).start();
		tabla.setEffect(bb);
		progressBar.progressProperty().bind(task.progressProperty());
	
		
	}
	

    @FXML
    void nuevoAnimal(ActionEvent event) {
    	panel.setCenter(cargarVista(AppController.FXML_TIPO));
    }
    
    public void irANombre() {
    	panel.setCenter(cargarVista(AppController.FXML_NOMBRE));
    }
}
