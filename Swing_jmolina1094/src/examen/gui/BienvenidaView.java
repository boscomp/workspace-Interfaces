package examen.gui;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Color;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.JButton;

public class BienvenidaView extends View {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textoId;
	private JButton btnEntrar;
	private JButton btnSalir;
	private ButtonGroup grupo;
	private JRadioButton rdbtAnon;
	private JRadioButton rdbtId;
	private JLabel lblError;

	public BienvenidaView(App appController) {
		super(appController);
		setLayout(null);

		JLabel lblTitle = new JLabel("Bienvenido a CarCollection");
		lblTitle.setForeground(new Color(128, 0, 255));
		lblTitle.setFont(new Font("Playbill", Font.PLAIN, 70));
		lblTitle.setBounds(226, 71, 512, 89);
		add(lblTitle);

		JLabel lblAcceso = new JLabel("Elija el tipo de acceso");
		lblAcceso.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblAcceso.setBounds(370, 220, 177, 14);
		add(lblAcceso);

		rdbtAnon = new JRadioButton("Anónimo");
		rdbtAnon.setBounds(352, 255, 87, 23);
		add(rdbtAnon);

		rdbtId = new JRadioButton("Identificación:");
		rdbtId.setBounds(352, 281, 107, 23);
		add(rdbtId);
		grupo = new ButtonGroup();
		grupo.add(rdbtId);
		grupo.add(rdbtAnon);

		textoId = new JTextField();
		textoId.setEnabled(false);
		textoId.setBounds(465, 282, 86, 20);
		add(textoId);
		textoId.setColumns(10);

		btnEntrar = new JButton("Entrar");
		btnEntrar.setEnabled(false);
		btnEntrar.setBounds(733, 281, 89, 23);
		add(btnEntrar);

		btnSalir = new JButton("Salir");
		btnSalir.setBounds(733, 318, 89, 23);
		add(btnSalir);
		
		lblError = new JLabel("");
		lblError.setForeground(new Color(255, 0, 0));
		lblError.setBounds(384, 322, 167, 14);
		add(lblError);

		escucharBtn();
	}

	public void escucharBtn() {
		ActionListener al = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource().equals(rdbtId)) {
				
					textoId.setEnabled(true);
					btnEntrar.setEnabled(true);
					consumeLetra();
				} else if (e.getSource().equals(rdbtAnon)){
					limpiarPantalla();
					btnEntrar.setEnabled(true);
				} 
				if (e.getSource().equals(btnEntrar)) {
					if (rdbtId.isSelected()) {
					lblError.setText(appController.login(textoId.getText()));
					
					if (lblError.getText().isEmpty()) {
						appController.irAConsultar();
					}
					}
					else {
						appController.irAConsultar();
					}
					
				}
				if (e.getSource().equals(btnSalir)) {
					appController.salirApp();
				}
				
			}
		};
		rdbtId.addActionListener(al);
		rdbtAnon.addActionListener(al);
		btnEntrar.addActionListener(al);
		btnSalir.addActionListener(al);

	}
	public void consumeLetra() {
		textoId.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {

				Character c =e.getKeyChar();
				
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
		});
	}

	public void limpiarPantalla() {
		btnEntrar.setEnabled(false);
		textoId.setText("");
		textoId.setEnabled(false);
		rdbtId.setSelected(false);
		rdbtAnon.setSelected(false);
	}
}
