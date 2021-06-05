package windowsView;

import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import constants.Config.FVLectureSearch;

public class VLectureControlPanel extends JPanel{
	private static final long serialVersionUID = 1L;
	JPanel tablePanel;
	JPanel buttonPanel;
	ActionListener lectureHadler;
	
	public VLectureControlPanel(ActionListener lectureHandler) {
		this.lectureHadler = lectureHandler;
		
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		tablePanel = new JPanel();
		tablePanel.setLayout(new BoxLayout(tablePanel, BoxLayout.Y_AXIS));
		this.add(tablePanel);
		
		buttonPanel = new JPanel();
		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
		this.add(buttonPanel);
	}
	
	public void addTable(VSearchTable table) {
		JScrollPane scrollPane = new JScrollPane(table);
		tablePanel.add(scrollPane);
	}
	
	public void addTable(VSearchTable table, Dimension paneSize) {
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setPreferredSize(FVLectureSearch.tableSize);
		tablePanel.add(scrollPane);
	}
	
	public void addButtons(JButton...buttons) {
		for(int i = 0; i < buttons.length; i++) {
			buttons[i].addActionListener(lectureHadler);
			buttonPanel.add(buttons[i]);
		}
	}

}
