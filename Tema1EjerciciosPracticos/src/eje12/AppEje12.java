package eje12;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class AppEje12 {

	private JFrame frame;
	private Pantalla1 pantalla1;
	private Pantalla2 pantalla2;
	private Pantalla3 pantalla3;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppEje12 window = new AppEje12();
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
	public AppEje12() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pantalla1 = new Pantalla1(this);
		pantalla2 = new Pantalla2(this);
		pantalla3 = new Pantalla3(this);
		irAPantalla1("");
	}

	public void irAPantalla1(String t) {
		frame.setContentPane(pantalla1);
		pantalla1.cambiarTexto(t);
		frame.revalidate();
	}

	public void irAPantalla2(String t) {
		frame.setContentPane(pantalla2);
		pantalla2.cambiarTexto(t);
		frame.revalidate();
	}

	public void irAPantalla3(String t) {
		frame.setContentPane(pantalla3);
		pantalla3.cambiarTexto(t);
		
		
		frame.revalidate();
	}


}
