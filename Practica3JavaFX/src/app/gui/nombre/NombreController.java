package app.gui.nombre;

import app.gui.AppController;
import app.gui.modelo.Animal;
import app.gui.service.AnimalesServices;
import app.gui.tabla.TablaController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class NombreController extends AppController {

	@FXML
	private TextField tfEdad;

	@FXML
	private TextField tfNombre;
	@FXML
	private AnchorPane anPanel;

	public void initialize() {
		if ((boolean) getUserDataObject("modoOscuro")) {
			anPanel.getStylesheets().add("/css/dark-theme.css");
		} else {
			anPanel.getStylesheets().clear();
		}
	}

	@FXML
	void guardarDatos(ActionEvent event) {

		if (tfEdad.getText().isEmpty() || !esDigito()) {
			mostrarAlerta("La edad no puede ser vacía y tiene que ser un número");
		} else if (tfNombre.getText().isEmpty()) {
			mostrarAlerta("El nombre no puede estar vacío");
		} else {
			Animal a = (Animal) getUserDataObject("animalCreado");
			a.setEdad(Integer.valueOf(tfEdad.getText()));
			a.setNombre(tfNombre.getText());
			putUserDataObject("animalCreado", a);
			AnimalesServices as = new AnimalesServices();
			as.addAnimal(a);
			cambiarVista(FXML_TABLA);

		}

	}

	public boolean esDigito() {
		char[] car = tfEdad.getText().toCharArray();
		for (char c : car) {
			if (!Character.isDigit(c)) {
				return false;
			}
		}
		return true;
	}
}
