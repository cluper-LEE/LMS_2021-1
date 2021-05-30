package windowsView;

import java.util.Vector;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import control.CIndex;
import valueObject.OIndex;

public class VSearchTable extends JTable {
	// attributes
	private static final long serialVersionUID = 1L;
	private Vector<OIndex> indicies;
	private String[] colName;

	private CIndex cIndex;

	public VSearchTable(String fileName, String... colName) {
		super();

		this.cIndex = new CIndex();
		this.colName = colName;
		this.set(fileName);

	}

	public void set(String fileName) {
		this.indicies = this.cIndex.getAll(fileName);
		String[][] data = new String[indicies.size()][1];
		for (int i = 0; i < indicies.size(); i++) {
			OIndex oIndex = indicies.get(i);
			data[i][0] = oIndex.getName();
		}
		
		DefaultTableModel model = new DefaultTableModel(data, colName);
		this.setModel(model);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	}

	public void init() {
		DefaultTableModel model = new DefaultTableModel();
		this.setModel(model);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	}

	public OIndex getSelected() {
		if (this.getSelectedRow() == -1) {
			this.changeSelection(0, 0, false, false);
		}
		return indicies.get(this.getSelectedRow());
	}

	public String getColName() {
		return colName[0];
	}

}
