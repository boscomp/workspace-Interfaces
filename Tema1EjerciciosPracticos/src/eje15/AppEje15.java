package eje15;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;

public class AppEje15 {

	private JFrame frame;
	private Pantalla1 pantalla1;
	private Pantalla2 pantalla2;
	private Pantalla3 pantalla3;
	private PantallaBienvenida pantallaBv;
	private JMenuBar menuBar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppEje15 window = new AppEje15();
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
	public AppEje15() {
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
		
		 menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 434, 22);
//		frame.getContentPane().add(menuBar);
		frame.setJMenuBar(menuBar);
		
		JMenu menuNavegar = new JMenu("Navegar");
		menuBar.add(menuNavegar);
		
		JMenuItem itemIrAP1 = new JMenuItem("Ir a Pantalla 1");
		itemIrAP1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1, InputEvent.CTRL_DOWN_MASK));
		itemIrAP1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				irAPantalla1("");
				
			}
		});
		
		menuNavegar.add(itemIrAP1);
		
				
		
		JMenuItem itemIrAP2 = new JMenuItem("Ir a Pantalla 2");
		itemIrAP2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_2, InputEvent.CTRL_DOWN_MASK));
		itemIrAP2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				irAPantalla2("");
				
			}
		});
		menuNavegar.add(itemIrAP2);
		JMenuItem itemIrAP3 = new JMenuItem("Ir a Pantalla 3");
		itemIrAP3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_3, InputEvent.CTRL_DOWN_MASK));
		itemIrAP3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				irAPantalla3("");
				
			}
		});
		menuNavegar.add(itemIrAP3);
		
		JMenu menuSalir = new JMenu("Salir");
		menuBar.add(menuSalir);
		
		JMenuItem itemSalir = new JMenuItem("Salir");
		itemSalir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK));
		menuSalir.add(itemSalir);
		
		
		itemSalir.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				
			}
		});
		JMenuItem itemInicio = new JMenuItem("Volver a inicio");
		menuSalir.add(itemInicio);
		itemInicio.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				inicio();
				
			}
		});
		pantalla1 = new Pantalla1(this);
		pantalla2 = new Pantalla2(this);
		pantalla3 = new Pantalla3(this);
		pantallaBv = new PantallaBienvenida(this);
		inicio();
		
	}
	public void inicio() {
		frame.setContentPane(pantallaBv);
		menuBar.setVisible(false);
		frame.revalidate();
	}
	public void irAPantalla1(String t) {
		frame.setContentPane(pantalla1);
		pantalla1.cambiarTexto(t);
		menuBar.setVisible(true);
		frame.revalidate();
	}

	public void irAPantalla2(String t) {
		frame.setContentPane(pantalla2);
		menuBar.setVisible(true);
		pantalla2.cambiarTexto(t);
		frame.revalidate();
	}

	public void irAPantalla3(String t) {
		frame.setContentPane(pantalla3);
		menuBar.setVisible(true);
		pantalla3.cambiarTexto(t);		
		
		frame.revalidate();
	}


}
