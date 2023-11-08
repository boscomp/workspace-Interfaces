package abrirVentana;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MiVentana extends JFrame {

	
	public void inicializar() {

		

		setSize(600, 4000);

		

		setTitle("HOLA");
		setLocationRelativeTo(null);
		setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		

		//crear boton
		JButton boton = new JButton();
		boton.setText("Real");
		JButton boton1 = new JButton();
		boton1.setText("Betis");
		
		//crea un layout
		FlowLayout layout = new FlowLayout();
		setLayout(layout);
		//
		GridLayout lay = new GridLayout(4, 3);
		setLayout(lay);
		//crear contenedor y añadir boton
		Container contenedor = getContentPane();
		
		contenedor.add(boton);
		contenedor.add(boton1);
		
		int x=0;
		while (x<10) {
			JButton boton2 = new JButton();
			boton2.setText("Botón "+(x+1));
		contenedor.add(boton2);
		x++; 
		}

		setVisible(true);

	}
		
	

}
