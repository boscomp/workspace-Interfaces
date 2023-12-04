package examen.ejercicio1.gui;

import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import examen.ejercicio1.modelo.Coche;

public class ConsultarView extends View {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable table;
	private TableModel model;

	public ConsultarView(App appController) {
		super(appController);
		setLayout(null);
		model = new TableModel();

		JLabel lblDisp = new JLabel("Sólo disponibles:");
		lblDisp.setBounds(98, 104, 105, 14);
		add(lblDisp);

		JRadioButton rdbtnSi = new JRadioButton("Sí");
		rdbtnSi.setBounds(209, 100, 54, 23);
		add(rdbtnSi);

		JRadioButton rdbtnNo = new JRadioButton("No");
		rdbtnNo.setBounds(265, 100, 54, 23);
		add(rdbtnNo);

		JRadioButton rdbtnTodos = new JRadioButton("Todos");
		rdbtnTodos.setSelected(true);
		rdbtnTodos.setBounds(321, 100, 76, 23);
		add(rdbtnTodos);

		// Group the radio buttons.
		ButtonGroup group = new ButtonGroup();
		group.add(rdbtnSi);
		group.add(rdbtnNo);
		group.add(rdbtnTodos);

		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnConsultar.setBounds(403, 100, 89, 23);
		add(btnConsultar);

		JScrollPane scrollCoche = new JScrollPane();
		scrollCoche.setBounds(98, 148, 395, 170);
		add(scrollCoche);

		table = new JTable();
		scrollCoche.setViewportView(table);

		table.setModel(model);

		ActionListener al = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource().equals(btnConsultar)) {
					if (rdbtnTodos.isSelected()) {
						List<Coche> coches = appController.consultarCoche();

						model.setCoche(coches);
					} else if (rdbtnSi.isSelected()) {
						List<Coche> coches = appController.consultarCocheDisp(true);

						model.setCoche(coches);
					} else {
						List<Coche> coches = appController.consultarCocheDisp(false);

						model.setCoche(coches);
					}
				}

				model.fireTableDataChanged();

			}
		};

		btnConsultar.addActionListener(al);

	}
}
