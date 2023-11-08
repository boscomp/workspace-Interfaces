package ej1;

import java.awt.EventQueue;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


import javax.swing.JFrame;
import javax.swing.JTextField;

import javax.swing.JLabel;

public class VentanaEj1 {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaEj1 window = new VentanaEj1();
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
	public VentanaEj1() {
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
		
		textField = new JTextField();
		textField.setBounds(139, 76, 146, 27);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel label = new JLabel("EDAD");
		label.setBounds(191, 128, 69, 27);
		frame.getContentPane().add(label);
		
		
		KeyListener kl = new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				Character c =e.getKeyChar();
				
				if (!Character.isDigit(c)) {
					e.consume();
				}
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				String a="1";
				
				if (e.getKeyCode() == KeyEvent.VK_UP) {
					
					if (textField.getText().isEmpty()) {
						textField.setText(a);
					}
						Integer x= Integer.parseInt(textField.getText());
						x++;
						String texto=x.toString();
						
						textField.setText(texto);
					}
				
				if (e.getKeyCode() == KeyEvent.VK_DOWN) {
					if (textField.getText().isEmpty()) {
						textField.setText(a);
					}
					if (textField.getText().equals("1")) {
						
					}
					else {
						Integer x= Integer.parseInt(textField.getText());
						x--;
						String texto=x.toString();
						
						textField.setText(texto);
					}
				}
				
			}
		};
		textField.addKeyListener(kl);
		
		
		
		
	}
}
