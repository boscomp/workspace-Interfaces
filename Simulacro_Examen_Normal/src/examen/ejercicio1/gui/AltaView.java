package examen.ejercicio1.gui;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JButton;

public class AltaView extends View{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textoMarca;

	public AltaView(App appController) {
		super(appController);
		setLayout(null);
		
		JLabel lblNuevaMarca = new JLabel("Nueva marca:");
		lblNuevaMarca.setBounds(79, 131, 85, 14);
		add(lblNuevaMarca);
		
		textoMarca = new JTextField();
		textoMarca.setBounds(158, 128, 86, 20);
		add(textoMarca);
		textoMarca.setColumns(10);
		
		JLabel lblMarcas = new JLabel("Marcas:");
		lblMarcas.setBounds(79, 194, 85, 14);
		add(lblMarcas);
		
		JComboBox <String> comboMarcas = new JComboBox<String>();
		comboMarcas.setBounds(158, 190, 86, 22);
		add(comboMarcas);
		
		JButton btnAdd = new JButton("Añadir");
		btnAdd.setBounds(293, 127, 89, 23);
		add(btnAdd);
		
		ActionListener al = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource().equals(btnAdd)) {
					if (!textoMarca.getText().isBlank()) {
					comboMarcas.addItem(appController.addMarca(textoMarca.getText()));
					textoMarca.setText("");
					}
				}
				
			}
		};
		
		btnAdd.addActionListener(al);
		comboMarcas.addActionListener(al);
		
		
		List <String> listaMarca=appController.consultarMarcas();
		for (String string : listaMarca) {
			comboMarcas.addItem(string);
		}
		
	}
}
