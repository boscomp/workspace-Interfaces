package eje12;




import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class Pantalla2 extends View{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JTextField texto;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
	public Pantalla2(AppEje12 appController) {
		super (appController);
		setLayout(null);
	
		
		texto = new JTextField();
	
		texto.setBounds(164, 40, 86, 20);
		
		texto.setColumns(10);
		add(texto);
		JButton btnIrP1 = new JButton("PANTALLA 1");
		
		btnIrP1.setBounds(147, 89, 124, 23);
		add(btnIrP1);
		btnIrP1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				appController.irAPantalla1(texto.getText());
				
			}
		});
		
		JButton btnIrP2 = new JButton("PANTALLA 2");
		btnIrP2.setEnabled(false);
		btnIrP2.setBounds(147, 126, 124, 23);
		add(btnIrP2);
		
		JButton btnIrP3 = new JButton("PANTALLA 3");
		btnIrP3.setBounds(147, 160, 124, 23);
		btnIrP3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				appController.irAPantalla3(texto.getText());
				
			}
		});
		System.out.println();
		add(btnIrP3);
	}
	public void cambiarTexto(String t) {
		texto.setText(t);
	}
}
