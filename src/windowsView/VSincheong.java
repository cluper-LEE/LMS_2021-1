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
		String[] cols = { "���¸�", "��米��", "�ð�" };
		String[][] data = { { "hong", "Computer", "Java" }};
		// �� ����
		DefaultTableModel model = new DefaultTableModel(data, cols);
		this.setModel(model);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		// ��ũ�� �ҿ� ���̱�
		


	}

}
