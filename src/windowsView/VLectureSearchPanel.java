package windowsView;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

import constants.Config.FPath;
import constants.Config.FVLectureControl;
import constants.Config.FVLectureSearch;
import valueObject.OIndex;
import valueObject.OLecture;

public class VLectureSearchPanel extends JPanel {
	// attributes
	private static final long serialVersionUID = 1L;

	// components
	private VSearchTable vCampusTable;
	private VSearchTable vCollegeTable;
	private VSearchTable vDepartmentTable;
	private VLectureTable vLectrueTable;
	public VLectureSearchPanel(ActionListener lectureHandler) {
		super();
		
		
		// 최상위 레이아웃이 두 개의 패널을 가짐(좌, 우) 좌 패널은 소속 선택, 우 패널은 강좌 선택.
		this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

		VLectureControlPanel westPanel = new VLectureControlPanel(null);
		this.add(westPanel);

		this.vCampusTable = new VSearchTable("root", FPath.lecturesPath, FVLectureSearch.campusColName);
		westPanel.addTable(vCampusTable, FVLectureSearch.tableSize);
		OIndex campus = this.vCampusTable.getSelected();

		
		this.vCollegeTable = new VSearchTable(campus.getFileName(), FPath.lecturesPath, FVLectureSearch.collegeColName);
		westPanel.addTable(vCollegeTable, FVLectureSearch.tableSize);
		OIndex college = this.vCollegeTable.getSelected();

		this.vDepartmentTable = new VSearchTable(college.getFileName(), FPath.lecturesPath, FVLectureSearch.departmentColName);
		westPanel.addTable(vDepartmentTable, FVLectureSearch.tableSize);
		OIndex department = this.vDepartmentTable.getSelected();

		VLectureControlPanel eastPanel = new VLectureControlPanel(lectureHandler);
		this.add(eastPanel);
		
		this.vLectrueTable = new VLectureTable(department.getFileName(), FPath.lecturesPath, FVLectureSearch.lectureColName);
		eastPanel.addTable(vLectrueTable);
		this.vLectrueTable.getSelected();
		
		JButton addToBasketButton = new JButton(FVLectureControl.addToBasketButtonText);
		JButton addToEnrollmentButton = new JButton(FVLectureControl.addToEnrollmentListText);
		eastPanel.addButtons(addToBasketButton, addToEnrollmentButton);


		// Search Table 사이의 관계 지정
		this.vCampusTable.setNextTable(
				this.vCollegeTable.setNextTable(
						this.vDepartmentTable.setNextTable(
								this.vLectrueTable)));
		
		
	}

	public OLecture getSelectedLecture() {
		return this.vLectrueTable.getSelected();
	}
}
