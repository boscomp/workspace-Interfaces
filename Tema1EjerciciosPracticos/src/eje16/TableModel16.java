package eje16;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;



public class TableModel16 extends AbstractTableModel{

	private List <Personas16> personas;
	private static final long serialVersionUID = 1L;
	public TableModel16() {
		personas = new ArrayList<Personas16>();
	}

	@Override
	public int getRowCount() {
		
		return personas.size();
	}

	@Override
	public int getColumnCount() {
		
		return 2;
	}

	@Override
	public String getColumnName(int column) {
		if (column == 0) {
			return "Nombre";
		}
		return "Apellidos";
	}
	
	
	
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Personas16 filaPersona = personas.get(rowIndex);
		if (columnIndex==0) {
			return filaPersona.getNombre();
		}
		return filaPersona.getApellidos();
	}

	public List<Personas16> getPersonas() {
		return personas;
	}

	
	
	

}
