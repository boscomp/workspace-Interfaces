package eje11;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


import javax.swing.ButtonGroup;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class VentanaEje11 {

	private static final String AZUL = "azul";
	private static final String VERDE = "verde";
	private static final String ROJO = "rojo";
	private JFrame frame;
	public JTextField campo1;
	public JTextField campo3;
	public JTextField campo4;
	public JTextField campo2;
	private JComboBox<String> combo1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaEje11 window = new VentanaEje11();
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
	public VentanaEje11() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		campo1 = new JTextField();
		campo1.setBounds(79, 37, 283, 39);
		frame.getContentPane().add(campo1);
		campo1.setColumns(10);

		campo2 = new JTextField();
		campo2.setBounds(79, 87, 283, 39);
		frame.getContentPane().add(campo2);
		campo2.setColumns(10);

		campo3 = new JTextField();
		campo3.setColumns(10);
		campo3.setBounds(79, 137, 283, 39);
		frame.getContentPane().add(campo3);

		campo4 = new JTextField();
		campo4.setColumns(10);
		campo4.setBounds(79, 187, 283, 39);
		frame.getContentPane().add(campo4);

		// RadioButton
		JRadioButton rbtn1 = new JRadioButton(ROJO, false);
		JRadioButton rbtn2 = new JRadioButton(VERDE, false);
		JRadioButton rbtn3 = new JRadioButton(AZUL, false);
		rbtn1.setFocusable(false);
		rbtn2.setFocusable(false);
		rbtn3.setFocusable(false);
		ButtonGroup grupo1 = new ButtonGroup();
		grupo1.add(rbtn3);
		grupo1.add(rbtn2);
		grupo1.add(rbtn1);

		rbtn1.setBounds(10, 50, 80, 20);
		rbtn2.setBounds(10, 75, 80, 20);
		rbtn3.setBounds(10, 100, 80, 20);

		frame.add(rbtn1);
		frame.add(rbtn2);
		frame.add(rbtn3);

		// ComboBox
		combo1 = new JComboBox<String>();
		combo1.setBounds(10, 10, 80, 20);
		frame.add(combo1);
		combo1.addItem(ROJO);
		combo1.addItem(VERDE);
		combo1.addItem(AZUL);
		combo1.setFocusable(false);

		ItemListener il = new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				rbtn1.setSelected(combo1.getSelectedItem().equals(ROJO));
				rbtn2.setSelected(combo1.getSelectedItem().equals(VERDE));
				rbtn3.setSelected(combo1.getSelectedItem().equals(AZUL));
			
//				if (combo1.getSelectedItem().equals(VERDE)) {
//
//					rbtn2.setSelected(true);
//				}
//				if (combo1.getSelectedItem().equals(AZUL)) {
//
//					rbtn3.setSelected(true);
//				}

			}
		};
		// condicion
		ActionListener al = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JRadioButton origen= (JRadioButton) e.getSource();
				combo1.setSelectedItem(origen.getText());
//				if (rbtn1.isSelected()) {
//					combo1.setSelectedItem(ROJO);
//				}
//				if (rbtn2.isSelected()) {
//					combo1.setSelectedItem(VERDE);
//				}
//				if (rbtn3.isSelected()) {
//					combo1.setSelectedItem(AZUL);
//				}

			}
		};

		combo1.addItemListener(il);
		rbtn1.addActionListener(al);
		rbtn2.addActionListener(al);
		rbtn3.addActionListener(al);

		KeyListener kl = new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {

			}

			@Override
			public void keyReleased(KeyEvent e) {

				if (combo1.getSelectedItem().equals(ROJO)) {
					e.getComponent().setBackground(Color.red);
				}
				if (combo1.getSelectedItem().equals(VERDE)) {
					e.getComponent().setBackground(Color.green);
				}
				if (combo1.getSelectedItem().equals(AZUL)) {
					e.getComponent().setBackground(Color.blue);
				}
			}

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_ENTER) {
//					if (botonCB.getText()!=botonRaB.getText()) {
//						System.err.println("error");
//					}

					e.getComponent().transferFocus();
					e.getComponent().setBackground(Color.white);

				}

				if (e.getKeyCode() == KeyEvent.VK_UP) {
					e.getComponent().transferFocusBackward();
					e.getComponent().setBackground(Color.white);
				}

			}
		};

		campo1.addKeyListener(kl);
		campo2.addKeyListener(kl);
		campo3.addKeyListener(kl);
		campo4.addKeyListener(kl);
	}

}
