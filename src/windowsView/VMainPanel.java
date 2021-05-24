package windowsView;

import javax.swing.JPanel;

import constants.Config.FVMainPanel;

public class VMainPanel extends JPanel{
	// attributes
	private static final long serialVersionUID = 1L;

	// components
	private VEnrollment vEnrollment;
	
	public VMainPanel() {
		super();
		// attributes
		this.setBackground(FVMainPanel.backgroundColor);
		
		// components
		this.vEnrollment = new VEnrollment();
		this.add(this.vEnrollment);
	}

}
