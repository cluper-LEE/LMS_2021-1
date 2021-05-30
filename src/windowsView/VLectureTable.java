package windowsView;

import java.util.Vector;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import control.CLecture;
import valueObject.OLecture;

public class VLectureTable extends JTable {
	// attributes
	private static final long serialVersionUID = 1L;
	private Vector<OLecture> lectures;
	private String[] header;
	
	private CLecture cLecture;

	public VLectureTable(String fileName, String... colName) {
		super();

		this.cLecture = new CLecture();
		this.header = colName;
		this.set(fileName);
		
	}
	
	public void set(String fileName) {
		this.lectures = this.cLecture.getAll(fileName);
		String[][] data = new String[lectures.size()][5];
		for (int i = 0; i < lectures.size(); i++) {
			OLecture oLecture = lectures.get(i);
			System.out.println(oLecture);
			data[i][0] = oLecture.getId();
			data[i][1] = oLecture.getName();
			data[i][2] = oLecture.getProfName();
			data[i][3] = oLecture.getCredit();
			data[i][4] = oLecture.getTime();
		}

		DefaultTableModel model = new DefaultTableModel(data, header);
		this.setModel(model);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	}
	
	public void init(String fileName) {
		this.lectures = this.cLecture.getAll(fileName);
		String[][] data = new String[lectures.size()][5];
		
		for (int i = 0; i < lectures.size(); i++) {
			OLecture oLecture = lectures.get(i);
			System.out.println(oLecture);
			data[i][0] = oLecture.getId();
			data[i][1] = oLecture.getName();
			data[i][2] = oLecture.getProfName();
			data[i][3] = oLecture.getCredit();
			data[i][4] = oLecture.getTime();
		}
		DefaultTableModel model = new DefaultTableModel(data, header);
		this.setModel(model);
		this.updateUI();
	}
	
	public OLecture getSelected() {
		if(this.getSelectedRow() == -1) {
			this.changeSelection(0, 0, false, false);
		}
		return lectures.get(this.getSelectedRow());
	}
	
	public String getHeader() {
		return header[0];
	}

	public void init() {
		// TODO Auto-generated method stub
		
	}


}
