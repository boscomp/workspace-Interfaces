package app.gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		//1. cargar el fxml
		FXMLLoader loader= new FXMLLoader(App.class.getResource("/app/gui/bienvenida/bienvenida.fxml"));
		//creamos la escena
		Scene scene= new Scene(loader.load());
		//cargar la escena en el escenario
		primaryStage.setScene(scene);
		//mostrar escenario
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch();
	}

}
