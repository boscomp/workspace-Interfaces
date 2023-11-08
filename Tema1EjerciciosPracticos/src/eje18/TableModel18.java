package eje18;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import ej1.modelo.Pelicula;

public class TableModel18 extends AbstractTableModel{

	private List<Pelicula> pelis;
	private List <String> columnas;
	private static final long serialVersionUID = 1L;
	public TableModel18() {
		pelis = new ArrayList<Pelicula>();
		columnas = new ArrayList<>();

	}
	public List<String> getColumnas() {
		return columnas;
	}
	public void addCol(String nombreCol) {
		columnas.add(nombreCol);
	}
	@Override
	public int getRowCount() {
		
		return pelis.size();
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
		Pelicula filaPelis = pelis.get(rowIndex);
		String nombreColumnas = columnas.get(columnIndex);
		if (nombreColumnas.equals("ID")) {
			return filaPelis.getId();
		}
		if (nombreColumnas.equals("TITULO")) {
			return filaPelis.getTitulo();
		}
		
		return filaPelis.getLongitud();
		
	}
	public List<Pelicula> getPelis() {
		return pelis;
	}
	public void setPelis(List<Pelicula> pelis) {
		this.pelis = pelis;
	}

}
