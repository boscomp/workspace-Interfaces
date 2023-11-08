package eje15;
import javax.swing.JLabel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;




public class PantallaBienvenida extends View{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public PantallaBienvenida(AppEje15 appController) {
		super (appController);
		
		
		JLabel lblBienvenida = new JLabel("Bienvenido a mi aplicación");
		lblBienvenida.setBounds(110, 108, 193, 14);
		add(lblBienvenida);
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.setBounds(147, 187, 89, 23);
		add(btnEntrar);
		btnEntrar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				appController.irAPantalla1("");
				
			}
		});
		}
}
