package windowsView;

import javax.swing.JPanel;

import constants.Config.FVMainPanel;

public class VMainPanel extends JPanel{
	// attributes
	private static final long serialVersionUID = 1L;

	// components
	private VLectureSearch vLectureSearch;
	
	public VMainPanel() {
		super();
		// attributes
		this.setBackground(FVMainPanel.backgroundColor);
		
		// components
		this.vLectureSearch = new VLectureSearch();
		this.add(this.vLectureSearch);
	}

}
