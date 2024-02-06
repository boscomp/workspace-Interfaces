package app.gui.tipo;

import app.gui.AppController;
import app.gui.modelo.Animal;
import app.gui.tabla.TablaController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class TipoController extends AppController {
	@FXML
	private AnchorPane anPanel;
	@FXML
	private TextField tfTipo;

	public void initialize() {
		if ((boolean) getUserDataObject("modoOscuro")) {
			anPanel.getStylesheets().add("/css/dark-theme.css");
		} else {
			anPanel.getStylesheets().clear();
		}
	}

	@FXML
	void continuar(ActionEvent event) {
		System.out.println("hola2");
		if (tfTipo.getText().isEmpty()) {
			mostrarAlerta("El tipo indicado no puede ser vacío");
		} else {
			Animal a = new Animal();
			a.setTipo(tfTipo.getText());
			putUserDataObject("animalCreado", a);
			cambiarVista(FXML_NOMBRE);

		}
	}

}
