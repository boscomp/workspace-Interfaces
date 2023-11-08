package ejemploTabla;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class TableModel extends AbstractTableModel{

	private List<Pais> paises;
	
	public TableModel() {
		paises = new ArrayList<Pais>();
	}
	
	@Override
	public int getRowCount() {
		return paises.size();
	}

	@Override
	public int getColumnCount() {
		return 3;
	}
	
	@Override
	public String getColumnName(int column) {
		if (column==0) {
			return "Código";
		}
		if (column==1) {
			return "Descripción";
		}
		return "Población";
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Pais paisFila = paises.get(rowIndex);
		if (columnIndex==0) {
			return paisFila.getCodigo();
		}
		if (columnIndex==1) {
			return paisFila.getNombre();
		}
		return paisFila.getPoblacion();
	}

	public List<Pais> getPaises() {
		return paises;
	}

	
	
}
