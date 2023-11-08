package ej3;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class VentanaEj3 {

	private JFrame frame;
	private JTextField texto1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaEj3 window = new VentanaEj3();
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
	public VentanaEj3() {
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
		
		texto1 = new JTextField();
		texto1.setBounds(139, 76, 146, 27);
		frame.getContentPane().add(texto1);
		texto1.setColumns(10);
		
		JLabel label = new JLabel("EDAD");
		label.setBounds(191, 128, 69, 27);
		frame.getContentPane().add(label);
		
		JCheckBox checkBox = new JCheckBox("Acepto la política de privacidad");
		checkBox.setSelected(true);
		checkBox.setBounds(129, 174, 97, 23);
		frame.getContentPane().add(checkBox);
		
		JButton botonClean = new JButton("");
		botonClean.setIcon(new ImageIcon("C:\\Users\\jmolina1094\\Downloads\\eliminar.png"));
		botonClean.setBounds(312, 78, 89, 23);
		frame.getContentPane().add(botonClean);
		
		ActionListener alCheckBox =new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				texto1.setEditable(checkBox.isSelected());
			
				
			}
		};
		checkBox.addActionListener(alCheckBox);
		
		ActionListener alClean =new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource()==botonClean) {
					texto1.setText("");
					
					
				}
				
			}
		};
		botonClean.addActionListener(alClean);
		
		
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
					
					if (texto1.getText().isEmpty()) {
						texto1.setText(a);
					}
						Integer x= Integer.parseInt(texto1.getText());
						x++;
						String texto=x.toString();
						
						texto1.setText(texto);
					}
				
				if (e.getKeyCode() == KeyEvent.VK_DOWN) {
					if (texto1.getText().isEmpty()) {
						texto1.setText(a);
					}
					if (texto1.getText().equals("1")) {
						
					}
					else {
						Integer x= Integer.parseInt(texto1.getText());
						x--;
						String texto=x.toString();
						
						texto1.setText(texto);
					}
				}
				
			}
		};
		texto1.addKeyListener(kl);
		
		
	}
}
