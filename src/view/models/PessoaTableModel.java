package view.models;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;


public class PessoaTableModel extends AbstractTableModel{
	
	private String[] columnNames = {"Pessoa"};
	private ArrayList<Pessoa> data;
	
	public PessoaTableModel() {
		data = new ArrayList<Pessoa>();
	}
	
	public String getColumnName(int col) {
		return columnNames[col].toString();
	}
	public int getColumnCount() {
		return columnNames.length;
	}
	
	public int getRowCount() {
		return data.size();
	}
	
	public Object getValueAt(int row, int col) {
		Pessoa e = data.get(row);
		switch(col) {
		case 0:
			return e.getNome();
		default:
			return null;
		}		
	}
	
	public void addPessoa(Pessoa e) {
		data.add(e);
	}
		
	public void deletePessoa(int i) {
		data.remove(i);
	}
	
	public Pessoa getPessoa(int row) {
		return data.get(row);
	}
	
	public boolean isCellEditable(int row, int column) {
		return true;
	}
	
	public void setValueAt(Object s, int row, int column) {
		Pessoa e = data.get(row);
		switch(column) {
			case 0:
			{
				e.setNome((String)s);
				break;
			}
		}
		
		fireTableCellUpdated(row,column);
	}
	
	public ArrayList<Pessoa> getData() {
		return data;
	}
	
	public void setData(ArrayList<Pessoa> e) {
		data.addAll(e);
	}
	

}
