package windowsView;

import javax.swing.JFrame;

import constants.Config.FVMainFrame;
import valueObject.OMember;

public class VMainFrame extends JFrame {
	// attributes
	private static final long serialVersionUID = 100L;
	private OMember oMember;
	
	// components
	private VMainPanel vMainPanel;
	
	public VMainFrame(OMember oMember) {
		super();
		
		// attributes
		this.setTitle(FVMainFrame.frameName + " " + oMember.getName() + " " + oMember.getId());
		this.setLocation(FVMainFrame.location);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.oMember = oMember;
		
		this.vMainPanel = new VMainPanel(oMember);
		this.add(vMainPanel);
		
		this.pack();
		
	}
	
	private void init() {
		// variable attributes
		
		// components initialize
		this.vMainPanel.init(oMember);
	}


//	public static void main(String[] args) {
//		VLogin vLogin = new VLogin();
//		
//		while(vLogin.getMember() == null) {
//			try {
//				Thread.sleep(300);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//		
//		VMainFrame vMainFrame = new VMainFrame(vLogin.getMember());
//		vMainFrame.setVisible(true);
//	}

	
}
