package examen.gui;

import java.awt.EventQueue;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

import examen.modelo.Coche;
import examen.services.AccesoDenegadoException;
import examen.services.ErrorCocheException;
import examen.services.ExamenService;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;

public class App {

	private JFrame frame;
	private BienvenidaView bvView;
	private ConsultarView consView;
	private JMenu mnSesion;
	private JMenuItem mnItmCerrar;
	private JMenuItem mnItmSalir;
	private JMenuItem mnItmConsultar;
	private JMenuItem mnItmCrear;
	private JMenuBar menuBar;
	private CrearCocheView crearView;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					App window = new App();
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
	public App() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 850, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);

		bvView = new BienvenidaView(this);

		menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 834, 22);
		bvView.add(menuBar);

		JMenu mnCoches = new JMenu("Coches");
		menuBar.add(mnCoches);

		mnItmConsultar = new JMenuItem("Consultar");
		mnItmConsultar.setAccelerator(
				KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK | InputEvent.ALT_DOWN_MASK));
		mnCoches.add(mnItmConsultar);

		mnItmCrear = new JMenuItem("Crear");
		mnItmCrear.setAccelerator(
				KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_DOWN_MASK | InputEvent.ALT_DOWN_MASK));
		mnCoches.add(mnItmCrear);

		mnSesion = new JMenu("Sesión");
		menuBar.add(mnSesion);

		mnItmCerrar = new JMenuItem("Cerrar sesión");
		mnItmCerrar.setAccelerator(
				KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_DOWN_MASK | InputEvent.ALT_DOWN_MASK));
		mnSesion.add(mnItmCerrar);

		mnItmSalir = new JMenuItem("Salir");
		mnItmSalir.setAccelerator(
				KeyStroke.getKeyStroke(KeyEvent.VK_Q, InputEvent.CTRL_DOWN_MASK | InputEvent.ALT_DOWN_MASK));
		mnSesion.add(mnItmSalir);
		listenerMenu();
		irABV();
	}

	public void irABV() {
		frame.setContentPane(bvView);
		bvView.limpiarPantalla();
		frame.revalidate();
		menuBar.setVisible(false);

	}

	public void irAConsultarV() {
		consView = new ConsultarView(this);
		frame.setContentPane(consView);
		frame.revalidate();
		consView.add(menuBar);
		menuBar.setVisible(true);
	}
	public void irACrearV() {
		crearView = new CrearCocheView(this);
		frame.setContentPane(crearView);
		frame.revalidate();
		crearView.add(menuBar);
		menuBar.setVisible(true);
	}

	public void salirApp() {

		System.exit(0);

	}

	public void listenerMenu() {
		ActionListener al = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource().equals(mnItmConsultar)) {
					irAConsultarV();
				}
				if (e.getSource().equals(mnItmCerrar)) {
					irABV();
				}
				if (e.getSource().equals(mnItmCrear)) {
					irACrearV();
				}
				if (e.getSource().equals(mnItmSalir)) {
					salirApp();
				}

			}
		};
		mnItmConsultar.addActionListener(al);
		mnItmCerrar.addActionListener(al);
		mnItmCrear.addActionListener(al);
		mnItmSalir.addActionListener(al);
	}
	public void login(String user) {
		ExamenService es = new ExamenService();
		try {
			es.login(user);
			bvView.entrar();
		} catch (AccesoDenegadoException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR",
					JOptionPane.ERROR_MESSAGE);
		}
		
	}
	public JComboBox<String> crearComboBox(JComboBox<String> combo) {
		combo.addItem("Peugeot");
		combo.addItem("Renault");
		combo.addItem("Seat");
		combo.addItem("Toyota");
		return combo;

	}
	
	public List <Coche> consultarCoches(String marca) {
		ExamenService es = new ExamenService();
		List <Coche> listaCoches = es.consultarCoches(marca);
		
		return listaCoches;
		
	}
	
	public void crearCoche(String marca, String modelo, Integer precio) {
		ExamenService es = new ExamenService();
		try {
			es.crearCoche(marca, modelo, precio);
		} catch (ErrorCocheException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Guardado",
					JOptionPane.ERROR_MESSAGE);
		}
	}
}
