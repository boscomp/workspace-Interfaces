package ejemploPantallas;
import javax.swing.JLabel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class Pantalla2View extends View{
	public Pantalla2View(App appController) {
		super (appController);
		JLabel labelNombre2 = new JLabel("Pantalla 2");
		labelNombre2.setBounds(105, 70, 122, 14);
		add(labelNombre2);
		
		JButton irAP3 = new JButton("Ir a Pantalla 3");
		irAP3.setBounds(279, 200, 134, 23);
		irAP3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				appController.irAPantalla3();
				
			}
		});
		
		add(irAP3);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
