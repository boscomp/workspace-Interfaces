package app.gui.login;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

import app.gui.App;
import app.gui.modelo.Partido;
import app.mongo.MongoSession;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class AppController {

	private static Stage stage;
	public static final String FXML_LOGIN = "/app/gui/login/login.fxml";
	public static final String FXML_REGISTRO = "/app/gui/login/registro.fxml";
	public static final String FXML_TABLA = "/app/gui/login/tabla.fxml";
	public static final String FXML_FAVS = "/app/gui/login/favoritos.fxml";

	public AppController() {

	}

	public AppController(Stage primaryStage) {
		stage = primaryStage;
		stage.setUserData(new HashMap<String, Object>());
	}

	public AppController cambiarVista(String fxml) {
		try {
			// 1. cargar el fxml
			FXMLLoader loader = new FXMLLoader(App.class.getResource(fxml));
			// 2. creamos la escena
			Scene scene;
			scene = new Scene(loader.load());
			// 3. cargar la escena en el escenario
			stage.setScene(scene);
			// 4. devolvemos el controller
			return loader.getController();
		} catch (IOException e) {
			System.err.println("No se ha podido cambiar de vista");
			System.err.println("Vista destino: " + fxml);
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public Parent cargarVista(String fxml) {
		try {
			// 1. cargar el fxml
			FXMLLoader loader = new FXMLLoader(App.class.getResource(fxml));
			// 2. creamos la escena
			return loader.load();

		} catch (IOException e) {
			System.err.println("No se ha podido cambiar de vista");
			System.err.println("Vista destino: " + fxml);
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public Object getUserDataObject(String key) {
		@SuppressWarnings("unchecked")
		Map<String, Object> map = (Map<String, Object>) stage.getUserData();
		return map.get(key);
	}

	public void putUserDataObject(String key, Object data) {
		@SuppressWarnings("unchecked")
		Map<String, Object> map = (Map<String, Object>) stage.getUserData();
		map.put(key, data);
	}

	public void mostrarAlerta(String mensaje) {
		Alert a = new Alert(AlertType.ERROR);
		a.setHeaderText(null);
		a.setContentText(mensaje);
		a.setTitle("Error");
		a.showAndWait();

	}
	
	
}
