package ejemploPantallas;
import javax.swing.JLabel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class Pantalla3View extends View{
	public Pantalla3View(App appController) {
		super (appController);
		
		JLabel lblNombre3 = new JLabel("Pantalla 3");
		lblNombre3.setBounds(113, 59, 115, 14);
		add(lblNombre3);
		
		JButton botonIrAP1 = new JButton("Ir a Pantalla 1");
		botonIrAP1.setBounds(324, 226, 116, 23);
		botonIrAP1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				appController.irAPantalla1();
				
			}
		});
		add(botonIrAP1);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
