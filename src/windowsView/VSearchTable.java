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
	protected String[] header;
	protected VSearchTable nextTable;
	protected String path;
	
	private CIndex cIndex;

	public VSearchTable() {
		super();
	}
	public VSearchTable(String fileName, String path, String... colName) {
		super();

		this.cIndex = new CIndex();
		this.header = colName;
		this.path = path;
		this.indicies = this.cIndex.getAll(path + fileName);
		
		String[][] data = new String[indicies.size()][1];
		for (int i = 0; i < indicies.size(); i++) {
			OIndex oIndex = indicies.get(i);
			data[i][0] = oIndex.getName();
		}
		DefaultTableModel model = new DefaultTableModel(data, header);
		this.setModel(model);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		this.getSelectionModel().addListSelectionListener((e) -> {
			if(e.getValueIsAdjusting()) {
				return;
			}
			this.nextTable.getData(this.indicies.get(this.getSelectedRow()).getFileName());
		});
	}

	private void getData(String fileName) {
		if(this instanceof VLectureTable) {
			set(fileName);
			return;
		}
		this.set(fileName);
		this.nextTable.getData(this.indicies.get(this.getSelectedRow()).getFileName());
	}
	
	public void set(String fileName) {
		this.indicies = this.cIndex.getAll(path + fileName);
		DefaultTableModel model = (DefaultTableModel) this.getModel();
		String[][] data = new String[indicies.size()][1];
		for (int i = 0; i < indicies.size(); i++) {
			OIndex oIndex = indicies.get(i);
			data[i][0] = oIndex.getName();
		}
		model.setDataVector(data, header);
	}
	
	public OIndex getSelected() {
		if (this.getSelectedRow() == -1) {
			return indicies.get(0);
		}
		return indicies.get(this.getSelectedRow());
	}

	
	public VSearchTable setNextTable(VSearchTable nextTable) {
		this.nextTable = nextTable;
		return this;
	}
	
	@Override
	public int getSelectedRow() {
		if(super.getSelectedRow() > -1) {
			return super.getSelectedRow();
		}
		return 0; 
	}

}
