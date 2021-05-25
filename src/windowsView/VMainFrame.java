package windowsView;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

import constants.Config.FVMainFrame;

public class VMainFrame extends JFrame {
	// attributes
	private static final long serialVersionUID = 100L;
	
	// components
	private VLogin vLogin;
	private VMainPanel vMainPanel;
	
	public VMainFrame() {
		super();
		
		// attributes
		this.setSize(FVMainFrame.size);
		this.setLocation(FVMainFrame.location);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		this.vLogin = new VLogin(this);
		this.pack();
		
	}
	
	public void setMainPanel(VMainPanel panel) {
		this.vMainPanel = panel;
	}

	public static void main(String[] args) {
		VMainFrame vMain = new VMainFrame();
	}

}
