package app.gui.login;

import java.util.List;

import app.gui.modelo.Partido;
import app.gui.services.PartidosServices;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
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

	@FXML
	private Label lblEntradas;
	@FXML
	private ComboBox<String> cbRival;

	@FXML
	private ComboBox<String> cbTemporadas;

	public void initialize() {

		colTemp.setCellValueFactory(new PropertyValueFactory<Partido, String>("temporada"));
		colLocal.setCellValueFactory(new PropertyValueFactory<Partido, String>("local"));
		colVisitante.setCellValueFactory(new PropertyValueFactory<Partido, String>("visitante"));
		datos = FXCollections.observableArrayList();
		tablaResultados.setItems(datos);

		iniciarComboBox();
		iniciarTabla();

	}

	@FXML
	void consultar(ActionEvent event) {

		Task<Void> task = new Task<Void>() {
			List<Partido> resultadosFiltrados;
			PartidosServices ps = new PartidosServices();

			@Override
			protected Void call() throws Exception {

				resultadosFiltrados = ps.partidosPorTemporada(listaPartidos(), cbTemporadas.getValue().toString());

				tablaResultados.setEffect(null);
				return null;

			}

			@Override
			protected void succeeded() {
				datos.setAll(resultadosFiltrados);
				lblEntradas.setText(datos.size() + " entradas");
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

	public void iniciarTabla() {
		Task<Void> task = new Task<Void>() {
			List<Partido> resultados;

			@Override
			protected Void call() throws Exception {

				resultados = listaPartidos();

				tablaResultados.setEffect(null);
				return null;

			}

			@Override
			protected void succeeded() {
				datos.setAll(resultados);
				lblEntradas.setText(datos.size() + " entradas");
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

	public void iniciarComboBox() {
		PartidosServices ps = new PartidosServices();
		List<String> listaEquipos = ps.elegirEquipo();

		for (String string : listaEquipos) {
			if (!string.equals(getUserDataObject("equipoFav"))) {
				cbRival.getItems().add(string);
			}
		}

		List<Partido> listaPartidos = ps.partidosEquipoFavorito((String) getUserDataObject("equipoFav"));
		for (Partido partido : listaPartidos) {
			if (!cbTemporadas.getItems().contains(partido.getTemporada())) {
				cbTemporadas.getItems().add(partido.getTemporada());
			}
		}

	}

	public List<Partido> listaPartidos() {

		PartidosServices ps = new PartidosServices();
		List<Partido> partidos = ps.partidosEquipoFavorito((String) getUserDataObject("equipoFav"));
		return partidos;

	}
}
