package app.gui.tabla;

import java.util.List;

import org.bson.Document;

import com.mongodb.client.MongoCursor;

import app.gui.AppController;
import app.gui.modelo.Partido;
import app.gui.services.PartidosServices;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class TablaController extends AppController {
	@FXML
	private TableColumn<Partido, String> colLocal;

	@FXML
	private TableColumn<Partido, String> colTemp;

	@FXML
	private TableColumn<Partido, String> colVisitante;

	@FXML
	private TableView<Partido> tablaResultados;
	private ObservableList<Partido> datos;
	
	public void initialize() {


		colTemp.setCellValueFactory(new PropertyValueFactory<Partido, String>("Season"));
		colLocal.setCellValueFactory(new PropertyValueFactory<Partido, String>("HomeTeam"));
		colVisitante.setCellValueFactory(new PropertyValueFactory<Partido, String>("AwayTeam"));
		datos=FXCollections.observableArrayList();
		tablaResultados.setItems(datos);

	}
	@FXML
	void consultar(ActionEvent event) {

		
		Task<Void> task = new Task<Void>() {
			List <Partido> resultados;
			PartidosServices ps = new PartidosServices();
			@Override
			protected Void call() throws Exception {

				resultados = ps.obtenerListaPartidos();

				tablaResultados.setEffect(null);
				return null;

				
			}

			@Override
			protected void succeeded() {
				datos.setAll(resultados);
				super.succeeded();
				updateProgress(100, 100);
			}

			@Override
			protected void failed() {
//				datos.clear();
				super.failed();
				mostrarAlerta("No hay registros en la bbdd con ese filtro");
				updateProgress(100, 100);
				tablaResultados.setEffect(null);

			}
		};
		new Thread(task).start();
	}
}
