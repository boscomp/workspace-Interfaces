package examen.gui;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import examen.modelo.Coche;

public class TableModel extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Coche> coches;

	public TableModel() {
		coches = new ArrayList<Coche>();
	}

	@Override
	public int getRowCount() {

		return coches.size();
	}

	@Override
	public int getColumnCount() {

		return 4;
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
			return "Última revisión";
		}
		return "Antigüedad";
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Coche filaCoches = coches.get(rowIndex);
		if (columnIndex == 0) {
			return filaCoches.getMarca();
		}
		else if (columnIndex==1) {
			return filaCoches.getModelo();
		}
		else if (columnIndex==2) {
			return filaCoches.getFechaUltimaRevision();
		}
		return filaCoches.getAntiguedad();
	}
	public void setCoche(List<Coche> coche) {

		this.coches = coche;
	}

}
