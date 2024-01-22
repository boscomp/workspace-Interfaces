package app.gui.bienvenida;


import java.text.DecimalFormat;

import app.gui.AppController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;

public class SliderController extends AppController{
	   @FXML
	    private Button btnLeer;

	    @FXML
	    private TextField fieldSlider;

	    @FXML
	    private Slider slider;

	    @FXML
	    void leerSlider(ActionEvent event) {
//	    	Double num = slider.getValue();
//	    	DecimalFormat df = new DecimalFormat("#.00");
//	    	String nu=df.format(num);
//	    	fieldSlider.setText(nu);
	    	
	    	DecimalFormat df = new DecimalFormat("#.00");
//		    
	    	fieldSlider.setText(String.valueOf(df.format(slider.getValue())));
	    }

}
