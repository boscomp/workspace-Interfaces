package examen.ejercicio1.gui;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Color;
import javax.swing.JCheckBox;
import javax.swing.JButton;

public class BienvenidaView extends View {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BienvenidaView(App appController) {
		super(appController);
		setLayout(null);
		
		JLabel lblBienvenido = new JLabel("Bienvenido a CarShop");
		lblBienvenido.setForeground(new Color(128, 0, 255));
		lblBienvenido.setFont(new Font("Freestyle Script", Font.PLAIN, 80));
		lblBienvenido.setBounds(80, 47, 455, 80);
		add(lblBienvenido);

		JLabel lblTerms = new JLabel("Acepta los términos y condiciones");
		lblTerms.setBounds(121, 220, 208, 23);
		add(lblTerms);

		JCheckBox chckBxTerms = new JCheckBox("");
		chckBxTerms.setBounds(330, 220, 97, 23);
		add(chckBxTerms);

		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.setEnabled(false);
		btnEntrar.setBounds(222, 254, 89, 23);
		add(btnEntrar);
		JButton btnSalir = new JButton("Salir");
		btnSalir.setBounds(482, 309, 89, 23);
		add(btnSalir);
		ActionListener al = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (e.getSource().equals(chckBxTerms)) {
					if (!chckBxTerms.isSelected()) {
						btnEntrar.setEnabled(false);
					} else {
						btnEntrar.setEnabled(true);
					}
				}
				if (e.getSource().equals(btnSalir)) {
					appController.salirApp();
				}
				if (e.getSource().equals(btnEntrar)) {
					appController.irAConsultarView();
					chckBxTerms.setSelected(false);
					btnEntrar.setEnabled(false);
				}

			}
		};
		if (!chckBxTerms.isSelected()) {
			btnEntrar.setEnabled(false);
		}
		btnEntrar.addActionListener(al);
		btnSalir.addActionListener(al);

		chckBxTerms.addActionListener(al);

	}
}
