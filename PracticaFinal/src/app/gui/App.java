package app.gui;

import app.gui.login.AppController;
import javafx.application.Application;
import javafx.stage.Stage;

public class App extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {
		AppController appController = new AppController(primaryStage);
		appController.cambiarVista(AppController.FXML_LOGIN);
		//mostrar escenario
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch();
	}
}
