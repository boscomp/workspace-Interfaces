package eje19;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import ej1.modelo.Pelicula;

public class TableModel19 extends AbstractTableModel {

	private List<Pelicula> pelis;
	private List<String> columnas;
	private Comparator<Pelicula> comparadorId = new Comparator<Pelicula>() {
		
		@Override
		public int compare(Pelicula o1, Pelicula o2) {
			// TODO Auto-generated method stub
			return o1.getId().compareTo(o2.getId());
		}
	};
	private Comparator<Pelicula> comparadorTitulo = new Comparator<Pelicula>() {
		
		@Override
		public int compare(Pelicula o1, Pelicula o2) {
			// TODO Auto-generated method stub
			return o1.getTitulo().compareTo(o2.getTitulo());
		}
	};;
	private Comparator<Pelicula> comparadorLongitud = new Comparator<Pelicula>() {
		
		@Override
		public int compare(Pelicula o1, Pelicula o2) {
			// TODO Auto-generated method stub
			return o1.getLongitud().compareTo(o2.getLongitud());
		}
	};;
	private static final long serialVersionUID = 1L;

	public TableModel19() {
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

	public void ordenar(Integer column) {
		String nombreColumn = columnas.get(column);
		if (nombreColumn.equals("ID")) {
			pelis.sort(comparadorId);
		}
		if (nombreColumn.equals("TITULO")) {
			pelis.sort(comparadorTitulo);
		}
		if (nombreColumn.equals("LONGITUD")) {
			pelis.sort(comparadorLongitud);
		}
		
	}

}
