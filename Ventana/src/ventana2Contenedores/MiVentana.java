package ventana2Contenedores;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MiVentana extends JFrame{
public void inicializar() {
//
//		
//
//		setSize(600, 4000);
//
//		
//
//		setTitle("HOLA");
//		setLocationRelativeTo(null);
//		setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
//		
//
//		//crear boton
//		JButton boton = new JButton();
//		boton.setText("Real");
//		JButton boton1 = new JButton();
//		boton1.setText("Betis");
//		
//		//crea un layout
//		FlowLayout layout = new FlowLayout();
//		setLayout(layout);
//		//
//		
//		//crear contenedor y añadir boton
//		Container contenedor = getContentPane();		
//		contenedor.add(boton);
//		contenedor.add(boton1);
//		//
//		
		
//		JPanel panelPrimCelda = new JPanel();
//		GridLayout layPrimCelda = new GridLayout(1, 2);
//		panelPrimCelda.setLayout(layPrimCelda);
//		
//		contenedor.add(panelPrimCelda);
//		GridLayout lay = new GridLayout(4, 4);
//		setLayout(lay);
//		int x=0;
//		while (x<10) {
//			JButton boton2 = new JButton();
//			boton2.setText("Botón "+(x+1));
//		contenedor.add(boton2);
//		x++; 
//		}
//		for (int i =1; i<3; i++) {
//			JButton boton2 = new JButton();
//			boton2.setText("Celda "+x);
//		panelPrimCelda.add(boton2);
//		}
		setTitle("Esto es una prueba");

		setSize(600, 400);

		setLocationRelativeTo(null);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

 

		// Creo un botón

		JButton boton = new JButton();

		boton.setText("Probando");

		JButton boton2 = new JButton();

		boton2.setText("CANCELANDO");

 

		// Obtengo el contenedor y añado el botón

		Container contenedor = getContentPane();

 

		GridLayout layout = new GridLayout(4, 2);

		setLayout(layout);

 
		// Creamos un panel para la primera celda y le establecemos su propio layout

				JPanel panelPrimeraCelda = new JPanel();

				GridLayout layoutPrimeraCelda = new GridLayout(1, 2);

				panelPrimeraCelda.setLayout(layoutPrimeraCelda);

		 

				contenedor.add(panelPrimeraCelda);

		 

				for (int i = 1; i <= 7; i++) {

					JButton b = new JButton();

					b.setText("Boton " + i);

					contenedor.add(b);

		 

				}

		 

				for (int i = 1; i <= 2; i++) {

					JButton b = new JButton();

					panelPrimeraCelda.add(b);

					b.setText("B. 1era celda " + i);

		 

				}
		setVisible(true);

	}
		
	
}
