package eje15;



import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class Pantalla1 extends View {

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
	public Pantalla1(AppEje15 appController) {
		super (appController);
		setLayout(null);
		
	
		
		texto = new JTextField();
		texto.setBounds(164, 40, 86, 20);
		add(texto);
		texto.setColumns(10);
		
		JButton btnIrP1 = new JButton("PANTALLA 1");
		btnIrP1.setEnabled(false);
		btnIrP1.setBounds(147, 89, 124, 23);
		add(btnIrP1);
		
		JButton btnIrP2 = new JButton("PANTALLA 2");
		btnIrP2.setBounds(147, 126, 124, 23);
		add(btnIrP2);
		btnIrP2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				appController.irAPantalla2(texto.getText());
				
			}
		});
		
		JButton btnIrP3 = new JButton("PANTALLA 3");
		btnIrP3.setBounds(147, 160, 124, 23);
		add(btnIrP3);
		btnIrP3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				appController.irAPantalla3(texto.getText());
				
			}
		});
	}
	public void cambiarTexto(String t) {
		texto.setText(t);
	}
}
