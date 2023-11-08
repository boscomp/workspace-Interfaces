package ej6;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class VentanaEj6 extends JFrame {
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
		JButton boton = new JButton();
		JTextField label = new JTextField();
		label.setText("a");
		Container contenedor= getContentPane();
		GridLayout layout = new GridLayout(2,1);
		contenedor.setLayout(layout);
		MouseListener ml=new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				String a;
				try {
				if (label.getText().isEmpty()) {
					a="1";
					
				}
				else {
				Integer x=Integer.parseInt(label.getText())+1;
				a=x.toString();
				}
				label.setText(a);
				
			}
			catch (NumberFormatException er) {
				JOptionPane.showMessageDialog(null, "ERROR");
				label.setText("");
			}
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		};
		boton.setText("SUMAR");
		boton.addMouseListener(ml);
		contenedor.add(boton);
		contenedor.add(label);
	}
}
