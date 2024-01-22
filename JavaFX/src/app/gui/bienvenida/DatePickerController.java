package app.gui.bienvenida;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import app.gui.AppController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class DatePickerController extends AppController{

    @FXML
    private Button btnLeer;

    @FXML
    private DatePicker fechasPick;

    @FXML
    private TextField fieldResultado;

    @FXML
    void leerDate(ActionEvent event) {
    	LocalDate fechas=fechasPick.getValue();
    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyy");
    	String fechaImprimir=fechas.format(formatter);
    	fieldResultado.setText(fechaImprimir);
    }
}
