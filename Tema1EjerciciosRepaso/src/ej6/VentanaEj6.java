package ej6;

import java.awt.EventQueue;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaEj6 {

	private JFrame frame;
	private JTextField texto;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaEj6 window = new VentanaEj6();
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
	public VentanaEj6() {
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
		
		texto = new JTextField();
		texto.setBounds(10, 57, 156, 37);
		frame.getContentPane().add(texto);
		texto.setColumns(10);
		
		JLabel nuevaCiudad = new JLabel("Nueva Ciudad");
		nuevaCiudad.setBounds(196, 68, 89, 14);
		frame.getContentPane().add(nuevaCiudad);
		
		JComboBox <String> comboBox = new JComboBox<>();
		comboBox.setToolTipText("");
		comboBox.setBounds(10, 137, 119, 22);
		frame.getContentPane().add(comboBox);
		
		JLabel disponibles = new JLabel("Destinos disponibles");
		disponibles.setLabelFor(comboBox);
		disponibles.setBounds(20, 112, 146, 14);
		frame.getContentPane().add(disponibles);
		
		JButton botonLimpiar = new JButton("Limpiar");
		botonLimpiar.setBounds(40, 23, 89, 23);
		frame.getContentPane().add(botonLimpiar);
		
		JLabel etiCiudad = new JLabel("");
		etiCiudad.setBounds(244, 112, 180, 14);
		frame.getContentPane().add(etiCiudad);
		
		JButton botonSelect = new JButton("Seleccionar");
		botonSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		botonSelect.setBounds(312, 64, 89, 23);
		frame.getContentPane().add(botonSelect);
		
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
				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					comboBox.addItem(texto.getText());
					texto.setText("");
					comboBox.setSelectedItem(null);
				}
				
			}
		};
		MouseListener ml = new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getSource()==botonLimpiar) {
					
					comboBox.removeAllItems();
				}
				if (e.getSource()==botonSelect) {
					etiCiudad.setText("Ciudad Seleccionada: "+comboBox.getSelectedItem().toString());
				}
				
			}
		};
		
		botonLimpiar.addMouseListener(ml);
		botonSelect.addMouseListener(ml);
		texto.addKeyListener(kl);
	}
}
