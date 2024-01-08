package examen.gui;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import examen.modelo.Coche;

public class TableModel extends AbstractTableModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List <Coche> coches;
	
	public TableModel() {
		coches = new ArrayList<Coche>();
		
	}
	@Override
	public int getRowCount() {
		return coches.size();
	}

	@Override
	public int getColumnCount() {

		return 5;
	}
	@Override
	public String getColumnName(int column) {
		if (column == 0) {
			return "Marca";
		}
		else if (column==1) {
			return "Modelo";
		}
		else if (column==2) {
			return "Año";
		}
		else if (column==3) {
			return "F.Matrícula";
		}
		return "Precio";
	}
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Coche c = coches.get(rowIndex);
		Coche filaCoches = coches.get(rowIndex);
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String fechaMat = formato.format(c.getFechaMatricula());
		
		if (columnIndex==0) {
			return filaCoches.getMarca();
		}
		if (columnIndex==1) {
			return filaCoches.getModelo();
		}
		if (columnIndex==2) {
			return filaCoches.getAño();
		}
		if (columnIndex==3) {
			return fechaMat;
		}
		return filaCoches.getPrecio()+" €";
	}
	public void setCoches(List<Coche> coche) {

		this.coches = coche;
	}

}
