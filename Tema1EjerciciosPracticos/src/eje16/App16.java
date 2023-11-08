package eje16;

import java.awt.EventQueue;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JTable;

import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class App16 {

	private JFrame frame;

	private JTextField textoNom;
	private JTextField textoApe;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					App16 window = new App16();
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
	public App16() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		textoNom = new JTextField();
		textoNom.setBounds(77, 42, 129, 27);
		frame.getContentPane().add(textoNom);
		textoNom.setColumns(10);

		textoApe = new JTextField();
		textoApe.setColumns(10);
		textoApe.setBounds(232, 41, 129, 27);
		frame.getContentPane().add(textoApe);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(88, 99, 284, 122);
		frame.getContentPane().add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);
		TableModel16 model = new TableModel16();

		table.setModel(model);

		KeyListener kl = new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					if (!textoNom.getText().isEmpty()) {
						textoNom.transferFocus();
					}
					if (!textoApe.getText().isEmpty()) {
						
								Personas16 persona = new Personas16();
								persona.setNombre(textoNom.getText());
								persona.setApellidos(textoApe.getText());
								model.getPersonas().add(persona);
								model.fireTableDataChanged();
								textoNom.setText("");
								textoApe.setText("");
								textoApe.transferFocusBackward();
					}
				}

			}
		};
		textoNom.addKeyListener(kl);
		textoApe.addKeyListener(kl);

	}

}
