package examen.ejercicio1.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

import examen.ejercicio1.modelo.Coche;
import examen.ejercicio1.services.ExamenService;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public class App {

	private JFrame frame;
	private BienvenidaView bvView;
	private ConsultarView consultarView;
	private AltaView altaView;
	private JMenuBar menuBar;
	private JMenuItem mnItmAlta;
	private JMenuItem mnItmConsultar;

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
		frame.setBounds(100, 100, 601, 397);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		bvView = new BienvenidaView(this);
		consultarView = new ConsultarView(this);
		altaView = new AltaView(this);
		frame.setLocationRelativeTo(null);

		menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);

		JMenu mnMen = new JMenu("Menú");
		menuBar.add(mnMen);

		mnItmAlta = new JMenuItem("Alta");
		mnItmAlta.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F8, 0));
		mnMen.add(mnItmAlta);

		mnItmConsultar = new JMenuItem("Consultar");
		mnItmConsultar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F8, 0));
		mnMen.add(mnItmConsultar);

		JMenuItem mnItmCerrarSes = new JMenuItem("Cerrar Sesión");
		mnItmCerrarSes.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F10, 0));
		mnMen.add(mnItmCerrarSes);

		JMenuItem mnItmSalir = new JMenuItem("Salir");
		mnItmSalir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F12, 0));
		mnMen.add(mnItmSalir);
		frame.getContentPane().setLayout(null);

		irABvView();
		ActionListener al = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource().equals(mnItmSalir)) {
					salirApp();
				}
				if (e.getSource().equals(mnItmAlta)) {
					irAAltaView();
				}
				if (e.getSource().equals(mnItmConsultar)) {
					irAConsultarView();
				}
				if (e.getSource().equals(mnItmCerrarSes)) {
					irABvView();
				}

			}
		};
		mnItmSalir.addActionListener(al);
		mnItmAlta.addActionListener(al);
		mnItmCerrarSes.addActionListener(al);
		mnItmConsultar.addActionListener(al);
	}

	public void irABvView() {
		menuBar.setVisible(false);
		frame.setContentPane(bvView);
		frame.revalidate();

	}

	public void irAConsultarView() {
		menuBar.setVisible(true);
		mnItmAlta.setVisible(true);
		mnItmConsultar.setVisible(false);
		frame.setContentPane(consultarView);
		frame.revalidate();

	}

	public void irAAltaView() {
		menuBar.setVisible(true);
		mnItmAlta.setVisible(false);
		mnItmConsultar.setVisible(true);
		frame.setContentPane(altaView);
		frame.revalidate();

	}

	// Salir de la App
	public void salirApp() {
		int i = JOptionPane.showConfirmDialog(frame, "¿Desea salir de la aplicación?", "SALIR",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		if (i == 0) {
			System.exit(0);
		}
	}

	public List<Coche> consultarCoche() {
		ExamenService es = new ExamenService();
		List<Coche> coches = new ArrayList<>();

		coches = es.consultarCoches();

		return coches;
	}

	public List<Coche> consultarCocheDisp(Boolean d) {
		ExamenService es = new ExamenService();
		List<Coche> coches = new ArrayList<>();

		coches = es.consultarCochesDisponibles(d);

		return coches;
	}

	public List<String> consultarMarcas() {
		ExamenService es = new ExamenService();
		List<String> marcas = new ArrayList<>();
		marcas = es.consultarMarcas();

		return marcas;

	}

	public String addMarca(String marca) {
		ExamenService es = new ExamenService();
		es.añadirMarca(marca);
		return marca;

	}
}
