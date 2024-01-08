package examen.gui;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import examen.modelo.Coche;

public class ConsultarView extends View {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable tabla;
	private TableModel modelo;
	private JComboBox<String> comboBox;
	private JButton btnConsultar;
	private JButton btnCerrar;

	public ConsultarView(App appController) {
		super(appController);
		setLayout(null);
		modelo = new TableModel();
		JLabel lblMarca = new JLabel("Marca:");
		lblMarca.setBounds(168, 79, 46, 14);
		add(lblMarca);

		comboBox = new JComboBox<String>();
		comboBox.setBounds(224, 75, 114, 22);
		add(comboBox);
		comboBox = appController.crearComboBox(comboBox);
		comboBox.setSelectedIndex(-1);

		btnConsultar = new JButton("Consultar");
		btnConsultar.setEnabled(false);
		btnConsultar.setBounds(401, 75, 89, 23);
		add(btnConsultar);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(183, 142, 333, 196);
		add(scrollPane);

		tabla = new JTable();
		scrollPane.setViewportView(tabla);
		tabla.setModel(modelo);

		 btnCerrar = new JButton("Cerrar sesión");
		btnCerrar.setBounds(401, 349, 115, 23);
		add(btnCerrar);

		listenCombo();

	}

	public 	void listenCombo() {
		ActionListener al = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (comboBox.getSelectedIndex()!=-1) {
					btnConsultar.setEnabled(true);
				}
				if (e.getSource().equals(btnConsultar)) {
					List<Coche> coches = appController.consultarCoches(comboBox.getSelectedItem().toString());
					if (!coches.isEmpty()) {
						modelo.setCoches(coches);
						
					} else {
						modelo.setCoches(coches);
	
						JOptionPane.showMessageDialog(null, "No hay registros para la marca indicada", "Error",
								JOptionPane.WARNING_MESSAGE);
					}

					modelo.fireTableDataChanged();
				}
				if (e.getSource().equals(btnCerrar)) {
					appController.irABV();
				}
				
			}
			
		};
		comboBox.addActionListener(al);
		btnConsultar.addActionListener(al);
		btnCerrar.addActionListener(al);
	}
}
