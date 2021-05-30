package windowsView;

import javax.swing.JPanel;

import constants.Config.FVMainPanel;
import valueObject.OMember;

public class VMainPanel extends JPanel{
	// attributes
	private static final long serialVersionUID = 1L;
	private OMember oMember;

	// components
	private VLectureSearch vLectureSearch;
	
	public VMainPanel(OMember oMember) {
		super();
		// attributes
		this.setBackground(FVMainPanel.backgroundColor);
		this.oMember = oMember;
		// components
		this.vLectureSearch = new VLectureSearch();
		this.add(this.vLectureSearch);
	}

	public void init(OMember oMember) {
		this.vLectureSearch.init(this.oMember);
	}

}
