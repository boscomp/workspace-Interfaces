package examen.gui;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

public class NuevoCocheView extends View {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textoModelo;
	private JTextField textoAntig;
	private JButton btnSuma;
	private JButton btnResta;
	private JButton btnCancelar;
	private JButton btnAceptar;
	private JComboBox<String> comboBoxMarcas;

	public NuevoCocheView(App appController) {
		super(appController);
		setLayout(null);

		JLabel lblMarca = new JLabel("Marca:");
		lblMarca.setBounds(275, 117, 70, 14);
		add(lblMarca);

		comboBoxMarcas = new JComboBox<String>();
		comboBoxMarcas.setBounds(379, 117, 124, 22);
		add(comboBoxMarcas);
		comboBoxMarcas = appController.crearComboBox(comboBoxMarcas);
		comboBoxMarcas.setSelectedIndex(-1);

		JLabel lblModelo = new JLabel("Modelo:");
		lblModelo.setBounds(275, 167, 70, 14);
		add(lblModelo);

		textoModelo = new JTextField();
		textoModelo.setText("");
		textoModelo.setBounds(379, 164, 124, 20);
		add(textoModelo);
		textoModelo.setColumns(10);

		JLabel lblAntiguedad = new JLabel("Antigüedad:");
		lblAntiguedad.setBounds(275, 214, 70, 14);
		add(lblAntiguedad);

		textoAntig = new JTextField();
		textoAntig.setEditable(false);
		textoAntig.setText("");
		textoAntig.setColumns(10);
		textoAntig.setBounds(414, 207, 36, 20);
		add(textoAntig);
		textoAntig.setText("1");
		btnResta = new JButton("-");
		btnResta.setBounds(378, 205, 39, 23);
		add(btnResta);

		btnSuma = new JButton("+");
		btnSuma.setBounds(447, 205, 47, 23);
		add(btnSuma);

		btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(287, 265, 110, 23);
		add(btnAceptar);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(428, 265, 110, 23);
		add(btnCancelar);

		cambiarAntiguedad();
	}

	public void cambiarAntiguedad() {
		MouseListener ml = new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {

			}

			@Override
			public void mousePressed(MouseEvent e) {
				if (e.getSource().equals(btnSuma)) {
					int x = Integer.parseInt(textoAntig.getText());
					x++;
					textoAntig.setText(x + "");
				}
				if (e.getSource().equals(btnResta)) {
					int x = Integer.parseInt(textoAntig.getText());
					if (x > 1) {
						x--;
						textoAntig.setText(x + "");
					}
				}

				if (e.getSource().equals(btnCancelar)) {
					appController.irAConsultar();
				}
				if (e.getSource().equals(btnAceptar)) {
					if (textoModelo.getText().isBlank() || comboBoxMarcas.getSelectedItem().equals(-1)) {

					} else {
						int x = Integer.parseInt(textoAntig.getText());
						String marca = comboBoxMarcas.getSelectedItem().toString();
						appController.addCoche(marca, textoModelo.getText(), x);
						appController.irAConsultar();
					}
				}
			}

			@Override
			public void mouseExited(MouseEvent e) {

			}

			@Override
			public void mouseEntered(MouseEvent e) {

			}

			@Override
			public void mouseClicked(MouseEvent e) {

			}
		};

		textoAntig.addMouseListener(ml);
		btnSuma.addMouseListener(ml);
		btnResta.addMouseListener(ml);
		btnAceptar.addMouseListener(ml);
		btnCancelar.addMouseListener(ml);
	}

	public void limpiarPantalla() {
		textoAntig.setText("1");
		comboBoxMarcas.setSelectedIndex(-1);
		textoModelo.setText("");
	}

}
