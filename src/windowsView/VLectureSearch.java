package windowsView;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import constants.Config.FVLectureSearch;
import valueObject.OIndex;
import valueObject.OLecture;
import valueObject.OMember;

public class VLectureSearch extends JPanel {
	// attributes
	private static final long serialVersionUID = 1L;

	// components
	private VSearchTable vCampusTable;
	private VSearchTable vCollegeTable;
	private VSearchTable vDepartmentTable;
	private VLectureTable vLectrueTable;

	private OLecture oLecture;

	public VLectureSearch() {
		super();
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		JScrollPane pane;

		this.vCampusTable = new VSearchTable("root", FVLectureSearch.campusColName);
		pane = new JScrollPane(this.vCampusTable);
		pane.setPreferredSize(FVLectureSearch.tableSize);
		this.add(pane);
		OIndex campus = this.vCampusTable.getSelected();
		this.vCampusTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				vCollegeTable.set(vCampusTable.getSelected().getFileName());
				vDepartmentTable.set(vCollegeTable.getSelected().getFileName());
				vLectrueTable.set(vDepartmentTable.getSelected().getFileName());
			}
		});

		this.vCollegeTable = new VSearchTable(campus.getFileName(), FVLectureSearch.collegeColName);
		pane = new JScrollPane(this.vCollegeTable);
		pane.setPreferredSize(FVLectureSearch.tableSize);
		this.add(pane);
		OIndex college = this.vCollegeTable.getSelected();
		this.vCollegeTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				vDepartmentTable.set(vCollegeTable.getSelected().getFileName());
				vLectrueTable.set(vDepartmentTable.getSelected().getFileName());
			}
		});

		this.vDepartmentTable = new VSearchTable(college.getFileName(), FVLectureSearch.departmentColName);
		pane = new JScrollPane(this.vDepartmentTable);
		pane.setPreferredSize(FVLectureSearch.tableSize);
		this.add(pane);
		OIndex department = this.vDepartmentTable.getSelected();
		this.vDepartmentTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				vLectrueTable.set(vDepartmentTable.getSelected().getFileName());
			}
		});

		this.vLectrueTable = new VLectureTable(department.getFileName(), FVLectureSearch.lectureColName);
		pane = new JScrollPane(this.vLectrueTable);
		pane.setPreferredSize(FVLectureSearch.tableSize);
		this.add(pane);
		OIndex lecture = this.vLectrueTable.getSelected();
		this.vLectrueTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				oLecture = vLectrueTable.getSelected();
				System.out.println("최종선택 : " + oLecture);
			}
		});
		
	}

	public void init(OMember oMember) {
		this.vCampusTable.init();
		this.vCollegeTable.init();
		this.vDepartmentTable.init();
		this.vLectrueTable.init();
	}

}
