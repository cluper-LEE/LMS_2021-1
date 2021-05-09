package view;

import java.util.Scanner;

import control.CEnrollment;
import valueObject.OLecture;
import valueObject.OMember;

public class VEnrollment {

	private Scanner scanner;

	private VLectureSearch vCampus;
	private VLectureSearch vCollege;
	private VLectureSearch vDepartment;
	private VLecture vLecture;

	private CEnrollment cEnrollment;

	public VEnrollment(Scanner scanner) {
		this.scanner = scanner;
		this.vCampus = new VLectureSearch(this.scanner);
		this.vCollege = new VLectureSearch(this.scanner);
		this.vDepartment = new VLectureSearch(this.scanner);
		this.vLecture = new VLecture(this.scanner);
		this.cEnrollment = new CEnrollment();
	}

	public boolean show(OMember oMember) {
		System.out.println(oMember.getName() + "�� ȯ���մϴ�.");
		System.out.println("������û ȭ���Դϴ�.");

		String campusFileName = this.vCampus.show("root", "campus");
		String collegeFileName = this.vCollege.show(campusFileName, "college");
		String departmentFileName = this.vDepartment.show(collegeFileName, "department");
		OLecture oLecture = this.vLecture.show(departmentFileName, "lecture");
		if (oLecture != null) {
			cEnrollment.saveLecture(oLecture);
			System.out.println(oLecture.toString() + " ���¸� ��û ������ �߰��Ͽ����ϴ�.");
			return true;
		} else {
			System.out.println("��û�� �����Ͽ����ϴ�.");
			return false;
		}

	}

}
