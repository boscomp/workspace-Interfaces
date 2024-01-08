package examen.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;

public class BienvenidaView extends View {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton btnEntrar;
	private JButton btnSalir;
	private JPasswordField textPass;
	private JComboBox<String> comboBox;

	public BienvenidaView(App appController) {
		super(appController);
		setLayout(null);

		JLabel lblTitle = new JLabel("CarSelection");
		lblTitle.setForeground(new Color(128, 0, 255));
		lblTitle.setFont(new Font("Freestyle Scrip", Font.PLAIN, 80));
		lblTitle.setBounds(226, 71, 512, 89);
		add(lblTitle);

		JLabel lblLogin = new JLabel("Tipo de login");
		lblLogin.setBounds(315, 224, 85, 14);
		add(lblLogin);

		JLabel lblAcceso = new JLabel("Código acceso");
		lblAcceso.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAcceso.setBounds(283, 262, 95, 14);
		add(lblAcceso);

		comboBox = new JComboBox<String>();
		comboBox.setBounds(405, 220, 85, 22);
		add(comboBox);
		comboBox.addItem("Anónimo");
		comboBox.addItem("Identificado");

		btnEntrar = new JButton("Entrar");
		btnEntrar.setBounds(733, 281, 89, 23);
		add(btnEntrar);

		btnSalir = new JButton("Salir");
		btnSalir.setBounds(733, 318, 89, 23);
		add(btnSalir);

		textPass = new JPasswordField();
		textPass.setBounds(405, 259, 85, 20);
		add(textPass);
		textPass.setEnabled(false);



		actionList();


	}

	public void actionList() {
		ActionListener al = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (comboBox.getSelectedItem().toString().equals("Identificado")) {
					textPass.setEnabled(true);
					if (e.getSource().equals(btnEntrar)) {
						char[] arrayC = textPass.getPassword();
						String pass = new String(arrayC);
						appController.login(pass);
						
						
					}

				}
				if (comboBox.getSelectedItem().toString().equals("Anónimo")) {
					textPass.setEnabled(false);
					if (e.getSource().equals(btnEntrar)) {
						entrar();
					}
				}
				if (e.getSource().equals(btnSalir)) {
					appController.salirApp();
				}

			}
		};
		textPass.addActionListener(al);
		comboBox.addActionListener(al);
		btnSalir.addActionListener(al);
		btnEntrar.addActionListener(al);

	}

	public void limpiarPantalla() {
		textPass.setText("");

	}
	public void entrar() {
		int i = JOptionPane.showConfirmDialog(null, "¿Desea empezar creando un nuevo coche?", "INICIO",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		if (i == 0) {
			appController.irACrearV();
		} else {
			appController.irAConsultarV();
		}
	}
}
