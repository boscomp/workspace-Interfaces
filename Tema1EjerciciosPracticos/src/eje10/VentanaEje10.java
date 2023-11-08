package eje10;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class VentanaEje10 {

	private JFrame frame;
	public JTextField campo1;
	public JTextField campo3;
	public JTextField campo4;
	public JTextField campo2;
	private JComboBox<String> combo1;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaEje10 window = new VentanaEje10();
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
	public VentanaEje10() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		campo1 = new JTextField();
		campo1.setBounds(79, 37, 283, 39);
		frame.getContentPane().add(campo1);
		campo1.setColumns(10);

		campo2 = new JTextField();
		campo2.setBounds(79, 87, 283, 39);
		frame.getContentPane().add(campo2);
		campo2.setColumns(10);

		campo3 = new JTextField();
		campo3.setColumns(10);
		campo3.setBounds(79, 137, 283, 39);
		frame.getContentPane().add(campo3);

		campo4 = new JTextField();
		campo4.setColumns(10);
		campo4.setBounds(79, 187, 283, 39);
		frame.getContentPane().add(campo4);
		
		combo1=new JComboBox<String>();
		combo1.setBounds(10,10,80,20);
		frame.add(combo1);
		combo1.addItem("rojo");
		combo1.addItem("verde");
		combo1.addItem("azul");
		combo1.setFocusable(false);
		JButton botonOrigen=new JButton();
		
		ItemListener iL=new ItemListener() {
		
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getSource()==combo1) {
					String color =(String)combo1.getSelectedItem();
					
					botonOrigen.setText(color);
				}
				
			}
		};
		combo1.addItemListener(iL);
		
		KeyListener kl = new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {

			}

			@Override
			public void keyReleased(KeyEvent e) {
				
				if (botonOrigen.getText()=="rojo") {
					e.getComponent().setBackground(Color.red);
				}
				if (botonOrigen.getText()=="verde") {
					e.getComponent().setBackground(Color.green);
				}
				if (botonOrigen.getText()=="azul") {
					e.getComponent().setBackground(Color.blue);
				}
			}

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_DOWN||e.getKeyCode()==KeyEvent.VK_ENTER) {
					e.getComponent().transferFocus();
					e.getComponent().setBackground(Color.white);
					
				}

				if (e.getKeyCode() == KeyEvent.VK_UP) {
					e.getComponent().transferFocusBackward();
					e.getComponent().setBackground(Color.white);
				}

			}
		};
		
		campo1.addKeyListener(kl);
		campo2.addKeyListener(kl);
		campo3.addKeyListener(kl);
		campo4.addKeyListener(kl);
		

	}

}
