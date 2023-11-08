package ej5;

import java.awt.EventQueue;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JTextField;

import javax.swing.JLabel;
import javax.swing.JComboBox;

public class VentanaEj5 {

	private JFrame frame;
	private JTextField texto;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaEj5 window = new VentanaEj5();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VentanaEj5() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		texto = new JTextField();
		texto.setBounds(120, 57, 156, 37);
		frame.getContentPane().add(texto);
		texto.setColumns(10);
		
		JLabel nuevaCiudad = new JLabel("Nueva Ciudad");
		nuevaCiudad.setBounds(328, 68, 46, 14);
		frame.getContentPane().add(nuevaCiudad);
		
		JComboBox <String> comboBox = new JComboBox<>();
		comboBox.setToolTipText("");
		comboBox.setBounds(135, 137, 119, 22);
		frame.getContentPane().add(comboBox);
		
		JLabel disponibles = new JLabel("Destinos disponibles");
		disponibles.setLabelFor(comboBox);
		disponibles.setBounds(130, 112, 146, 14);
		frame.getContentPane().add(disponibles);
		
		KeyListener kl = new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					comboBox.addItem(texto.getText());
					texto.setText("");
					comboBox.setSelectedItem(null);
				}
				
			}
		};
		texto.addKeyListener(kl);
	}
}
