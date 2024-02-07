package app.gui.tabla;

import java.util.List;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

import app.gui.AppController;

import app.mongo.MongoSession;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class TablaController extends AppController {
	@FXML
	private TableColumn<MongoCursor<Document>, String> colLocal;

	@FXML
	private TableColumn<MongoCursor<Document>, String> colTemp;

	@FXML
	private TableColumn<MongoCursor<Document>, String> colVisitante;

	@FXML
	private TableView<MongoCursor<Document>> tablaResultados;
	private ObservableList<MongoCursor<Document>> datos;
	
	public void initialize() {

		colTemp.setCellValueFactory(new PropertyValueFactory<MongoCursor<Document>, String>("Season"));
		colLocal.setCellValueFactory(new PropertyValueFactory<MongoCursor<Document>, String>("HomeTeam"));
		colVisitante.setCellValueFactory(new PropertyValueFactory<MongoCursor<Document>, String>("AwayTeam"));
	}
	@FXML
	void consultar(ActionEvent event) {

		
//		Task<Void> task = new Task<Void>() {
//			
//			FindIterable<Document> result;
//			MongoCursor<Document> cursor;
//			@Override
//			protected Void call() throws Exception {
//
//				MongoClient mc = MongoSession.getMongoClient();
//				MongoDatabase db = mc.getDatabase("futbol");
//				MongoCollection<Document> col = db.getCollection("partidos");
//				Bson filtro = Filters.or(Filters.regex("HomeTeam", ".*Val.*"), Filters.regex("AwayTeam", "Real Betis"));
//				result = col.find(filtro).limit(5);
//				 cursor= result.cursor();
//				
//
//				tablaResultados.setEffect(null);
//				return null;
//			}
//
//			@Override
//			protected void succeeded() {
//				datos.setAll(cursor);
//				super.succeeded();
//				updateProgress(100, 100);
//			}
//
//			@Override
//			protected void failed() {
//				datos.clear();
//				super.failed();
//				mostrarAlerta("No hay registros en la bbdd con ese filtro");
//				updateProgress(100, 100);
//				tablaResultados.setEffect(null);
//
//			}
//		};
//		new Thread(task).start();
	}
}
