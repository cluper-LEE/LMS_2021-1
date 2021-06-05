package windowsView;

import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

import constants.Config.FPath;
import constants.Config.FVLectureControl;
import constants.Config.FVLectureSearch;
import valueObject.OMember;

public class VBasketListPanel extends JPanel{
	private static final long serialVersionUID = 1L;
	
	VLectureTable vBasket;
	VLectureTable vEnrollmentList;
	
	public VBasketListPanel(ActionListener lectureHandler, OMember oMember) {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		this.setPreferredSize(FVLectureSearch.basketSize);
		
		VLectureControlPanel basketPanel = new VLectureControlPanel(lectureHandler);
		this.add(basketPanel);
		
		this.vBasket = new VLectureTable(oMember.getId(), FPath.basketPath, FVLectureSearch.lectureColName);
		basketPanel.addTable(this.vBasket, FVLectureSearch.basketSize);
		
		JButton addToEnrollmentListFromBasketButton = new JButton(FVLectureControl.addToEnrollmentListText);
		JButton deleteFromBasketButton = new JButton(FVLectureControl.deleteFromBasketButtonText);
		basketPanel.addButtons(addToEnrollmentListFromBasketButton, deleteFromBasketButton);
				
		
		VLectureControlPanel enrollmentListPanel = new VLectureControlPanel(lectureHandler);
		this.add(enrollmentListPanel);
		
		this.vEnrollmentList = new VLectureTable(oMember.getId(), FPath.enrollmentPath, FVLectureSearch.lectureColName);
		enrollmentListPanel.addTable(this.vEnrollmentList, FVLectureSearch.basketSize);
		
		JButton deleteFromEnrollmentListButton = new JButton(FVLectureControl.deleteFromEnrollmentListText);
		enrollmentListPanel.addButtons(deleteFromEnrollmentListButton);
	}

	public void refresh(OMember oMember) {
		this.vBasket.set(oMember.getId());
		this.vEnrollmentList.set(oMember.getId());
	}
}
