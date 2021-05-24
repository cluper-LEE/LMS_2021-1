package windowsView;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

public class VSincheong extends JTable{
	// attributes
	private static final long serialVersionUID = 1L;	
	
	// components
	
	
	public VSincheong() {
		super();
		String[] cols = { "강좌명", "담당교수", "시간" };
		String[][] data = { { "hong", "Computer", "Java" }};
		// 모델 설정
		DefaultTableModel model = new DefaultTableModel(data, cols);
		this.setModel(model);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		// 스크롤 팬에 붙이기
		


	}

}
