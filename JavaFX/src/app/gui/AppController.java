package app.gui;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AppController {
	private static Stage stage;
	public static final String FXML_LOGIN ="/app/gui/login/login.fxml";
	public static final String FXML_BIENVENIDA ="/app/gui/bienvenida/bienvenida.fxml";
	public static final String FXML_PANTALLA1 ="/app/gui/bienvenida/pantalla1.fxml";
	public static final String FXML_PANTALLA2 ="/app/gui/bienvenida/pantalla2.fxml";
	public AppController() {

	}

	public AppController(Stage primaryStage) {
		stage = primaryStage;
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

}
