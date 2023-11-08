package ej3y4;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class VentanaEj3 extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void inicializar () {
		setTitle("Ejercicios");
		setSize(300, 400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	public void cargarComponentes() {
		GridLayout layout = new GridLayout(4,1);
		Container contenedorPrincipal=getContentPane();
		contenedorPrincipal.setLayout(layout);
		JLabel label = new JLabel();
	
		MouseListener ml=new MouseListener()  {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				JButton botonOrigen = (JButton)e.getSource();
				botonOrigen.setText(botonOrigen.getText()+"!");
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				
				JButton botonOrigen = (JButton)e.getSource();
				botonOrigen.setBackground(null);
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				
				
				JButton botonOrigen = (JButton)e.getSource();
				Integer x = Integer.parseInt(botonOrigen.getText().substring(0,1));
				
				if (x==1 ){
					botonOrigen.setBackground(Color.green);
					}
					else {
						botonOrigen.setBackground(Color.blue);
					}
			
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		};
		ActionListener listenerBotones= new ActionListener() {
		
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				
//				
//				label.setText("HOLA");
//				
//			}
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				JButton botonOrigen = (JButton)e.getSource();
//				
//				label.setText("Has hecho click en el botón "+botonOrigen.getText());
//				
//			}
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String actionCommandOrigen =e.getActionCommand();
				
				label.setText("Has hecho click en el botón "+actionCommandOrigen);
				
			}
		};
		for (int i =1; i<=3; i++) {
			JButton boton=new JButton();
			
			boton.addActionListener(listenerBotones);
			
			boton.addMouseListener(ml);
			boton.setText(String.valueOf(i));
			
			boton.setActionCommand(String.valueOf(i));
			contenedorPrincipal.add(boton);
		}
		
		label.setText("¿Dónde has hecho click?");
		contenedorPrincipal.add(label);
	}
}
