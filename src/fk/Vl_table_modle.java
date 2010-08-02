package fk;

import javax.swing.table.AbstractTableModel;

public class Vl_table_modle extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4962872259388785988L;
	private String[] columnNames = new String[]{"Vorlesung", "Fachrichtung", "Studiengang", "Note", "Punkte"};

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 5;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return 35;
	}

	
	public String getColumnName(int col) {
	        return columnNames[col];
	}

	@Override
	public Object getValueAt(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return null;
	}

}
