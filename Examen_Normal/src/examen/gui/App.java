package examen.gui;

import java.awt.EventQueue;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import examen.modelo.Coche;
import examen.services.AutenticacionException;
import examen.services.ExamenService;

public class App {

	private JFrame frame;
	private BienvenidaView bvView;
	private ConsultarView consultarView;
	private NuevoCocheView nuevoView;

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
		frame.setBounds(100, 100, 850, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		bvView = new BienvenidaView(this);
		consultarView = new ConsultarView(this);
		nuevoView = new NuevoCocheView(this);

		irABv();
	}

	public void irABv() {

		frame.setContentPane(bvView);
		bvView.limpiarPantalla();
		frame.revalidate();

	}

	public void irAConsultar() {
		frame.setContentPane(consultarView);
		consultarView.limpiarPantalla();
		frame.revalidate();
	}

	public void irANuevoCoche() {
		frame.setContentPane(nuevoView);
		nuevoView.limpiarPantalla();
		frame.revalidate();
	}

	// Método para alir de la App
	public void salirApp() {
		int i = JOptionPane.showConfirmDialog(frame, "¿Desea salir de la aplicación?", "SALIR",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		if (i == 0) {
			System.exit(0);
		}
	}

	// Llamo al login del servicio para comprobar id
	public String login(String id) {
		ExamenService es = new ExamenService();
		try {
			es.login(id);
		} catch (AutenticacionException e) {

			return e.getMessage();
		}
		return "";
	}

	// Devuelve la lista de coches de la marca enviada
	public List<Coche> cochesPorMarca(String marca) {
		ExamenService es = new ExamenService();
		List<Coche> listaCoches = es.consultarCoches(marca);
		return listaCoches;

	}

	public JComboBox<String> crearComboBox(JComboBox<String> combo) {
		combo.addItem("Peugeot");
		combo.addItem("Renault");
		combo.addItem("Seat");
		combo.addItem("Toyota");
		return combo;

	}

	public void addCoche(String marca, String modelo, Integer antiguedad) {
		ExamenService es = new ExamenService();
		es.crearCoche(marca, modelo, antiguedad);
	}
}
