package windowsView;

import javax.swing.JFrame;

import constants.Config.FVMainFrame;

public class VMainFrame extends JFrame {
	// attributes
	private static final long serialVersionUID = 100L;
	
	// components
	private VMainPanel vMainPanel;
	
//	private VLogin vLogin;
//	private VLectureSearch vLectureSearch;
	
	public VMainFrame() {
		super();
		
		// attributes
		this.setSize(FVMainFrame.size);
		this.setLocation(FVMainFrame.location);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		// components
		this.vMainPanel = new VMainPanel();
		this.add(this.vMainPanel);
//		this.vLogin = new VLogin();
//		this.vLectureSearch = new VLectureSearch();
	}

	public static void main(String[] args) {
		VMainFrame vMain = new VMainFrame();
		vMain.setVisible(true);
	}

}
