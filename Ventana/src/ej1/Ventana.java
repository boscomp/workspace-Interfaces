package ej1;

import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Ventana extends JFrame{
	
	public void inicializar() {
		setTitle("Título");

		setSize(600, 400);

		setLocationRelativeTo(null);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
		Container contenedor = getContentPane();

		JPanel panelPrimeraCelda = new JPanel();
		
		GridLayout layoutPrimeraCelda = new GridLayout(2, 2);
		
		panelPrimeraCelda.setLayout(layoutPrimeraCelda);
		
		
		
		contenedor.add(panelPrimeraCelda);
		 for (int x=1; x<=6; x++) {
			 if (x<6) {
			 JLabel etiqueta = new JLabel("Texto"+x);
			
			 contenedor.add(etiqueta);}
			 else {

					 for (int i=1; i<5; i++) {
						 JLabel etiqueta = new JLabel("Texto"+x+i);
						
						 panelPrimeraCelda.add(etiqueta);
					 }
			 }
		 }

		GridLayout layout = new GridLayout(3, 3);

		setLayout(layout);
		
		setVisible(true);
	}
}
