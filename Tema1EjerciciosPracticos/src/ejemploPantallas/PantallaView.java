package ejemploPantallas;
import javax.swing.JLabel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class PantallaView extends View{
	public PantallaView(App appController) {
		super (appController);
		
		JLabel labelNombre = new JLabel("Pantalla 1");
		labelNombre.setBounds(138, 58, 140, 14);
		add(labelNombre);
		
		JButton irAP2 = new JButton("Ir a Pantalla 2");
		irAP2.setBounds(291, 200, 149, 23);
		
		irAP2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				appController.irAPantalla2();
				
			}
		});
		add(irAP2);
	}
	public void cambiarMensaje() {}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
}
