package ej7;

import java.awt.EventQueue;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.BorderLayout;

public class VentanaEj7 {

	private JFrame frame;
	public JTextField campo1;
	public JTextField campo3;
	public JTextField campo4;
	public JTextField campo2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaEj7 window = new VentanaEj7();
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
	public VentanaEj7() {
		inicializar();

	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void inicializar() {
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

		KeyListener kl = new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {

			}

			@Override
			public void keyReleased(KeyEvent e) {

			}

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_DOWN) {
					e.getComponent().transferFocus();
				}

				if (e.getKeyCode() == KeyEvent.VK_UP) {
					e.getComponent().transferFocusBackward();
				}

			}
		};
		campo1.addKeyListener(kl);
		campo2.addKeyListener(kl);
		campo3.addKeyListener(kl);
		campo4.addKeyListener(kl);

	}

}
