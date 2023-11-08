package eje17;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import ej1.modelo.Pelicula;

public class TableModel17 extends AbstractTableModel{

	private List<Pelicula> pelis;
	private static final long serialVersionUID = 1L;
	public TableModel17() {
		pelis = new ArrayList<Pelicula>();
	}
	@Override
	public int getRowCount() {
		
		return pelis.size();
	}

	@Override
	public int getColumnCount() {
		
		return 3;
	}
@Override
public String getColumnName(int column) {
	if (column == 0) {
		return "Id";
	}
	if (column == 1) {
		return "Titulo";
	}
	return "Longitud";
}
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Pelicula filaPelis = pelis.get(rowIndex);
		if (columnIndex == 0) {
			return filaPelis.getId();
		}
		if (columnIndex == 1) {
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
