package app.gui.login;

import java.util.List;

import app.gui.modelo.Usuario;
import app.gui.services.PartidosServices;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;

public class FavoritosController extends AppController {

	@FXML
	private ComboBox<String> cbEquipos;
	@FXML
	private Button fav1;

	@FXML
	private Button fav2;

	@FXML
	private Button fav3;

	@FXML
	private Button fav4;

	@FXML
	private Button noFav;
	private Usuario usuarioActual;
	private List<String> listaDelUsuario;

	@FXML
	public void initialize() {
		// Traigo la lista de equipos para añadirlos al comboBox y elegir favorito
		usuarioActual = (Usuario) getUserDataObject("usuarioActivo");
		listaDelUsuario = usuarioActual.getEquiposFavoritos(); // TODO: usarlo cada vez que llame a
																// usuarioactualgetequipos
		if (usuarioActual.getEquiposFavoritos() != null) {
			cargarBotonesFavoritos(usuarioActual.getEquiposFavoritos());
		}
		cargarEquiposAElegir(usuarioActual.getEquiposFavoritos());
	}

	@FXML
	void agregarFavorito(ActionEvent event) {
		if (cbEquipos.getValue() == null) {
			// lanzarerror
		}
		// Añado nuevo equipo a la lista de equipos favoritos del usuario
		else {
			if (usuarioActual.getEquiposFavoritos() != null) {
				usuarioActual.getEquiposFavoritos().add(cbEquipos.getValue());
				cargarBotonesFavoritos(usuarioActual.getEquiposFavoritos());

				// Actualizo combo para eliminar equipos ya elegidos
				cargarEquiposAElegir(usuarioActual.getEquiposFavoritos());
			}
		}
	}

	@FXML
	void continuar(ActionEvent event) {
		if (event.getSource().equals(noFav)) {
			putUserDataObject("equipoFav", "");
		} else {
			Object node = event.getSource();

			Button b = (Button) node;

			putUserDataObject("equipoFav", b.getText());
			System.out.println();
		}
		System.err.println("equipo fav= " + getUserDataObject("equipoFav"));
		cambiarVista(FXML_TABLA);
	}

//Voy a cargar los equipos favoritos del usuario
	public void cargarBotonesFavoritos(List<String> listaDelUser) {
		if (listaDelUser != null) {
			for (String equipo : listaDelUser) {

				if (fav1.isDisable()) {
					fav1.setDisable(false);
					fav1.setText(equipo);
				} else if (fav2.isDisable()) {
					fav2.setDisable(false);
					fav2.setText(equipo);
				} else if (fav3.isDisable()) {
					fav3.setDisable(false);
					fav3.setText(equipo);
				} else if (fav4.isDisable()) {
					fav4.setDisable(false);
					fav4.setText(equipo);
				}
			}
		}
	}
	//TODO: ver bien esto

	public void cargarEquiposAElegir(List<String> listaDelUser) {
		PartidosServices ps = new PartidosServices();
		List<String> listaEquipos = ps.elegirEquipo();

		for (String string : listaEquipos) {
			if (listaDelUser != null) {
				for (String stringUser : listaDelUser) {
					
				}
				//if (cbEquipos.getItems().contains(listaEquipos.get));
			} else {
				cbEquipos.getItems().add(string);
			}
		}
	}

}
