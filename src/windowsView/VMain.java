package windowsView;

import javax.swing.JFrame;

public class VMain extends JFrame {
	
	private VLogin vLogin;
	private VLectureSearch vLectureSearch;
	
	public VMain() {
		this.setSize(1000, 1000);
		this.setLocation(100, 100);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.vLogin = new VLogin();
		this.vLectureSearch = new VLectureSearch();
	}

	public static void main(String[] args) {
		VMain vMain = new VMain();
		
	}

}
