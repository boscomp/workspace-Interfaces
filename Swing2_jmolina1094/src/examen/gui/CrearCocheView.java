package examen.gui;

import javax.swing.JLabel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;

public class CrearCocheView extends View {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textoModelo;
	private JTextField textoPrecio;
	private JButton btnAceptar;
	private JLabel lblErrorPrecio;
	private JLabel lblErrorModelo;
	private JComboBox<String> comboBox;

	public CrearCocheView(App appController) {
		super(appController);
		setLayout(null);

		JLabel lblMarca = new JLabel("Marca:");
		lblMarca.setBounds(231, 159, 66, 14);
		add(lblMarca);

		JLabel lblModelo = new JLabel("Modelo:");
		lblModelo.setBounds(231, 195, 66, 14);
		add(lblModelo);

		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setBounds(231, 240, 66, 14);
		add(lblPrecio);

		comboBox = new JComboBox<String>();

		comboBox.setBounds(290, 155, 96, 22);
		add(comboBox);
		comboBox = appController.crearComboBox(comboBox);

		textoModelo = new JTextField();
		textoModelo.setBounds(290, 192, 96, 20);
		add(textoModelo);
		textoModelo.setColumns(10);

		textoPrecio = new JTextField();
		textoPrecio.setColumns(10);
		textoPrecio.setBounds(290, 237, 96, 20);
		add(textoPrecio);

		btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(336, 299, 89, 23);
		add(btnAceptar);

		lblErrorPrecio = new JLabel("");
		lblErrorPrecio.setForeground(new Color(255, 0, 0));
		lblErrorPrecio.setBounds(241, 268, 145, 14);
		add(lblErrorPrecio);

		lblErrorModelo = new JLabel("");
		lblErrorModelo.setForeground(Color.RED);
		lblErrorModelo.setBounds(241, 215, 145, 14);
		add(lblErrorModelo);

		KeyListener kl = new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {

				Character c = e.getKeyChar();

				if (!Character.isDigit(c)) {
					e.consume();
				}

			}

			@Override
			public void keyReleased(KeyEvent e) {

			}

			@Override
			public void keyPressed(KeyEvent e) {

			}
		};
		textoPrecio.addKeyListener(kl);

		crearCoche();
		focusList();

	}

	public void crearCoche() {
		ActionListener al = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource().equals(btnAceptar)) {
					if (textoPrecio.getText().isEmpty() || textoModelo.getText().isEmpty()) {
						lblErrorPrecio.setText("Campo obligatorio");
						lblErrorModelo.setText("Campo obligatorio");
					} else {
						Integer precio = Integer.parseInt(textoPrecio.getText());
						appController.crearCoche(comboBox.getSelectedItem().toString(), textoModelo.getText(), precio);
					}
				}

			}
		};
		btnAceptar.addActionListener(al);
	}

	public void focusList() {
		FocusListener fl = new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				if (e.getSource().equals(textoModelo)) {
					if (textoModelo.getText().isEmpty()) {
						lblErrorModelo.setText("Campo obligatorio");
					}
				} else if (e.getSource().equals(textoPrecio)) {
					if (textoPrecio.getText().isEmpty()) {
						lblErrorPrecio.setText("Campo obligatorio");

					}
				}

			}

			@Override
			public void focusGained(FocusEvent e) {

			}
		};
		textoModelo.addFocusListener(fl);
		textoPrecio.addFocusListener(fl);
	}

}
