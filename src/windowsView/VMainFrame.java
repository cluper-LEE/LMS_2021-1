package windowsView;

import javax.swing.JFrame;

import constants.Config.FVMainFrame;
import valueObject.OMember;

public class VMainFrame extends JFrame {
	// attributes
	private static final long serialVersionUID = 100L;
	
	// components
	private VMainPanel vMainPanel;
	
	public VMainFrame(OMember oMember) {
		super();
		
		// attributes
		this.setTitle(FVMainFrame.frameName + " " + oMember.getName() + " " + oMember.getId());
		this.setLocation(FVMainFrame.location);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		this.vMainPanel = new VMainPanel(oMember);
		this.add(vMainPanel);
		
		this.pack();
		
	}
	
	
}
