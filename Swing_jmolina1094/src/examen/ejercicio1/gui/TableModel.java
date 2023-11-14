package examen.ejercicio1.gui;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import examen.ejercicio1.modelo.Coche;

public class TableModel extends AbstractTableModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Coche> coches;
	private List<String> columnas;
	public TableModel() {
		coches = new ArrayList<Coche>();
		columnas = new ArrayList<>();
		columnas.add("Marca");
		columnas.add("Modelo");
		columnas.add("Matrícula");
		columnas.add("Año");
		columnas.add("Disponible");
	}
	@Override
	public int getRowCount() {
		return coches.size();
	}

	@Override
	public int getColumnCount() {
		return columnas.size();
	}
	@Override
	public String getColumnName(int column) {
		return columnas.get(column);
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Coche filaCoches=coches.get(rowIndex);
		String columna = columnas.get(columnIndex);
		if (columna.equals("Marca")) {
			return filaCoches.getMarca();
		}
		if (columna.equals("Modelo")) {
			return filaCoches.getModelo();
		}
		if (columna.equals("Matrícula")) {
			return filaCoches.getMatricula();
		}
		
		if (columna.equals("Disponible")) {
			if (filaCoches.getDisponible()) {
				return "Sí";
			}
			if (!filaCoches.getDisponible()) {
				
				return "No";
			}
		}
		return filaCoches.getAño();
	}
	public void setCoche(List<Coche> coche) {

		this.coches = coche;
	}

	public List<String> getColumnas() {
		return columnas;
	}

	public void setColumnas(List<String> columnas) {
		this.columnas = columnas;
	}

}
