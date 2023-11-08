package eje17;

import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import ej1.dao.PeliculasServicesException;

import ej1.services.PeliculasServices;

public class App17 {

	private JFrame frame;
	private JTable table;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					App17 window = new App17();
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
	public App17() {
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

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(77, 88, 293, 162);
		frame.getContentPane().add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);

		
		TableModel17 model = new TableModel17();
		table.setModel(model);

		JButton botonConsultar = new JButton("CONSULTAR");
		botonConsultar.setBounds(149, 35, 117, 32);
		frame.getContentPane().add(botonConsultar);
		botonConsultar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				PeliculasServices ps = new PeliculasServices();
//				List <Pelicula> listaPelis = new ArrayList<>();
//				try {
//					listaPelis = ps.nuevaLista();
//				} catch (PeliculasServicesException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
//				for (Pelicula pelicula : listaPelis) {
//					model.getPelis().add(pelicula);
//					model.fireTableDataChanged();
//				}
				try {
					model.setPelis(ps.nuevaLista());
				} catch (PeliculasServicesException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				model.fireTableDataChanged();

			}
		});

	}

}
