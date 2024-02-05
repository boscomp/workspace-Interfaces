package app.gui;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AppController {
	private static Stage stage;
	public static final String FXML_TABLA ="/app/tabla.fxml";
	public static final String FXML_TIPO ="/app/tipo.fxml";
	public static final String FXML_NOMBRE ="/app/nombre.fxml";
	public AppController() {
		
	}
	public AppController(Stage primaryStage) {
		stage = primaryStage;
		stage.setUserData(new HashMap<String, Object>());
	}

	
	public AppController cambiarVista(String fxml) {
				try {
					//1. cargar el fxml
					FXMLLoader loader= new FXMLLoader(App.class.getResource(fxml));
					//2. creamos la escena
					Scene scene;
					scene = new Scene(loader.load());
					//3. cargar la escena en el escenario
					stage.setScene(scene);
					//4. devolvemos el controller
					return loader.getController();
				} catch (IOException e) {
					System.err.println("No se ha podido cambiar de vista");
					System.err.println("Vista destino: "+fxml);
					e.printStackTrace();
					throw new RuntimeException(e);
				}
	}
	
	public Parent cargarVista(String fxml) {
		try {
			//1. cargar el fxml
			FXMLLoader loader= new FXMLLoader(App.class.getResource(fxml));
			//2. creamos la escena
			return loader.load();
			
		} catch (IOException e) {
			System.err.println("No se ha podido cambiar de vista");
			System.err.println("Vista destino: "+fxml);
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
}
