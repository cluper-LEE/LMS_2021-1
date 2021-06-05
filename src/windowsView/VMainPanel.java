package windowsView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import constants.Config.FCLectureControl;
import constants.Config.FVLectureControl;
import constants.Config.FVMainPanel;
import control.CLecture;
import valueObject.OMember;

public class VMainPanel extends JPanel{
	// attributes
	private static final long serialVersionUID = 1L;
	private OMember oMember;

	// components
	private VLectureSearchPanel vLectureSearch;
	private VBasketListPanel vBasketList;
	
	private CLecture cLecture;
	
	public VMainPanel(OMember oMember) {
		super();
		// attributes
		this.setBackground(FVMainPanel.backgroundColor);
		this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		this.oMember = oMember;
		this.cLecture = new CLecture();

		ActionListener lectureHandler = new LectureHandler();
		this.vLectureSearch = new VLectureSearchPanel(lectureHandler);
		this.add(this.vLectureSearch);
		
		this.vBasketList = new VBasketListPanel(lectureHandler, oMember);
		this.add(this.vBasketList);
		
	}
	
	private class LectureHandler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			String buttonText = e.getActionCommand();
			if(buttonText.equals(FVLectureControl.addToBasketButtonText)) {
				addToBasket();
				vBasketList.refresh(oMember);
			} else if(buttonText.equals(FVLectureControl.addToEnrollmentListText)) {
				addToEnrollmentList();
				vBasketList.refresh(oMember);
			}
		}
		
		private void addToEnrollmentList() {
			FCLectureControl result = 
					cLecture.saveInEnrollmentList(oMember.getId(), vLectureSearch.getSelectedLecture());
			validResult(result);
		}

		private void addToBasket() {
			FCLectureControl result = 
					cLecture.saveInBasket(oMember.getId(), vLectureSearch.getSelectedLecture());
			validResult(result);
		}
		
		private void validResult(FCLectureControl result) {
			if(result == FCLectureControl.EXIST_IN_BASKET) {
				JOptionPane.showMessageDialog(null, FVLectureControl.existInBasketMessage);
			} else if(result == FCLectureControl.EXIST_IN_ENROLLMENT_LIST){
				JOptionPane.showMessageDialog(null, FVLectureControl.existInEnrollmentListMessage);
			} else if(result == FCLectureControl.TIME_OVERlAP) {
				JOptionPane.showMessageDialog(null, FVLectureControl.timeOverlapMessage);
			}
		}
	}

}
