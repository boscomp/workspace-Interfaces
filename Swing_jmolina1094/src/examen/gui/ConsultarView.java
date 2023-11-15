package examen.gui;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import examen.modelo.Coche;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ConsultarView extends View {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable table;
	private TableModel modelo;
	private JLabel lblError;
	private JButton btnNuevo;
	private JComboBox<String> comboBoxMarcas;
	private JButton btnCerrarSesion;

	public ConsultarView(App appController) {
		super(appController);
		setLayout(null);

		modelo = new TableModel();
		JLabel lblIndicarMarca = new JLabel("Indique la marca que está buscando:");
		lblIndicarMarca.setBounds(148, 61, 234, 14);
		add(lblIndicarMarca);

		comboBoxMarcas = new JComboBox<String>();
		comboBoxMarcas.setBounds(386, 57, 89, 22);
		add(comboBoxMarcas);
		comboBoxMarcas = appController.crearComboBox(comboBoxMarcas);

		comboBoxMarcas.setSelectedIndex(-1);

		btnNuevo = new JButton("Nuevo");
		btnNuevo.setBounds(482, 57, 89, 23);
		add(btnNuevo);

		JScrollPane scrollCoches = new JScrollPane();
		scrollCoches.setBounds(148, 111, 423, 165);
		add(scrollCoches);

		table = new JTable();
		scrollCoches.setViewportView(table);
		table.setModel(modelo);

		lblError = new JLabel("");
		lblError.setForeground(new Color(0, 0, 0));
		lblError.setBounds(158, 86, 224, 14);
		add(lblError);

		btnCerrarSesion = new JButton("Cerrar sesión");
		btnCerrarSesion.setBounds(455, 287, 116, 23);
		add(btnCerrarSesion);

		escucharBtn();

	}

	public void escucharBtn() {
		ActionListener al = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource().equals(btnCerrarSesion)) {
					appController.irABv();
				}
				if (e.getSource().equals(btnNuevo)) {
					appController.irANuevoCoche();

				}
//				if (comboBoxMarcas.getSelectedItem().equals(-1)) {
//
//				} else {
//
//					String actionCommandOrigen = e.getActionCommand();
//					if (actionCommandOrigen.equals("Peugeot")) {
//						List<Coche> coches = appController.cochesPorMarca("Peugeot");
//						modelo.setCoche(coches);
//						modelo.fireTableDataChanged();
//					}
//					if (actionCommandOrigen.equals("Seat")) {
//						List<Coche> coches = appController.cochesPorMarca("Seat");
//						modelo.setCoche(coches);
//						modelo.fireTableDataChanged();
//					}
//					if (actionCommandOrigen.equals("Toyota")) {
//						List<Coche> coches = appController.cochesPorMarca("Toyota");
//						modelo.setCoche(coches);
//						modelo.fireTableDataChanged();
//					}
//					if (actionCommandOrigen.equals("Renault")) {
//						List<Coche> coches = appController.cochesPorMarca("Renault");
//						modelo.setCoche(coches);
//						modelo.fireTableDataChanged();
//					}
//
//				}

			}
		};
		comboBoxMarcas.addActionListener(al);
		btnNuevo.addActionListener(al);
		btnCerrarSesion.addActionListener(al);
	}

	public void limpiarPantalla() {
		lblError.setText("");
		comboBoxMarcas.setSelectedIndex(-1);
	}
}
