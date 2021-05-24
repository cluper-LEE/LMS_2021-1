package windowsView;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class VEnrollment extends JPanel {
	// attributes
	private static final long serialVersionUID = 1L;

	// components
	private VLectureSearch vLectureSearch;
	private VMiridamgi vMiridamgi;
	private VSincheong vSinchong;
	
	public VEnrollment() {
		super();
		
		this.vLectureSearch = new VLectureSearch();
		this.add(this.vLectureSearch);
		
		this.vMiridamgi = new VMiridamgi();		
		JScrollPane pane = new JScrollPane(this.vMiridamgi);
		this.add(pane);
		
		this.vSinchong = new VSincheong();		
		pane = new JScrollPane(this.vSinchong);
		this.add(pane);
	}

	
}
