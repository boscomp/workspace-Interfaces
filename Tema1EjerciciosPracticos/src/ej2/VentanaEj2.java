package ej2;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class VentanaEj2 extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void inicializar() {
		setTitle("Añadir usuario");

		setSize(400, 200);

		setLocationRelativeTo(null);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

 

		Container contenedor = getContentPane();

 

		GridLayout layout = new GridLayout(4, 2);

		setLayout(layout);

 

		// Nombre, dni, fecha

		JLabel lbNombre = new JLabel();

		lbNombre.setText("Nombre: ");

 

		JLabel lbDni = new JLabel();

		lbDni.setText("DNI: ");

 

		JLabel lbfecha = new JLabel();

		lbfecha.setText("Fecha de nacimiento: ");

 

		// FECHA

		JPanel panelFecha = new JPanel();

		FlowLayout LayoutPanelFecha = new FlowLayout();

		panelFecha.setLayout(LayoutPanelFecha);

		panelFecha.setLayout(new FlowLayout());

		panelFecha.add(new JTextField(2));

		panelFecha.add(new JLabel("/"));

		panelFecha.add(new JTextField(2));

		panelFecha.add(new JLabel("/"));

		panelFecha.add(new JTextField(2));

 

		// Text fields

		JTextField nombreField = new JTextField(2);

 

		JTextField dniField = new JTextField(2);

 

		// Aceptar y cancelar

		JButton aceptar = new JButton();

		aceptar.setText("Aceptar");

 

		JButton cancelar = new JButton();

		cancelar.setText("Cancelar");

 

		contenedor.add(lbNombre);

		contenedor.add(nombreField);

		contenedor.add(lbDni);

		contenedor.add(dniField);

		contenedor.add(lbfecha);

		contenedor.add(panelFecha);

		contenedor.add(aceptar);

		contenedor.add(cancelar);
	
	
		setVisible(true);
}

}
