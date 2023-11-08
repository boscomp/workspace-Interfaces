package eje18;

import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import ej1.dao.PeliculasServicesException;

import ej1.services.PeliculasServices;
import javax.swing.JCheckBox;

public class App18 {

	private JFrame frame;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					App18 window = new App18();
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
	public App18() {
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
		scrollPane.setBounds(35, 66, 389, 162);
		frame.getContentPane().add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);

		
		TableModel18 model = new TableModel18();
		table.setModel(model);

		JButton botonConsultar = new JButton("CONSULTAR");
		botonConsultar.setBounds(149, 24, 117, 32);
		frame.getContentPane().add(botonConsultar);
		
		JCheckBox boxId = new JCheckBox("ID");
		boxId.setSelected(true);
		boxId.setBounds(45, 231, 97, 23);
		frame.getContentPane().add(boxId);
		
		JCheckBox boxTitulo = new JCheckBox("TITULO");
		boxTitulo.setSelected(true);
		boxTitulo.setBounds(167, 231, 97, 23);
		frame.getContentPane().add(boxTitulo);
		
		JCheckBox boxLd = new JCheckBox("LONGITUD");
		boxLd.setSelected(true);
		boxLd.setBounds(297, 231, 97, 23);
		frame.getContentPane().add(boxLd);
		botonConsultar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				PeliculasServices ps = new PeliculasServices();
				model.getColumnas().clear();
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
				if (boxId.isSelected()) {
					model.getColumnas().add("ID");
				}
				if (boxTitulo.isSelected()) {
					model.getColumnas().add("TITULO");
				}
				if (boxLd.isSelected()) {
					model.getColumnas().add("LONGITUD");
				}
				try {
					model.setPelis(ps.nuevaLista());
				} catch (PeliculasServicesException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				model.fireTableStructureChanged();
				model.fireTableDataChanged();

			}
		});

	}
}
