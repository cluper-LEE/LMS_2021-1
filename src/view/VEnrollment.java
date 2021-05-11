package view;

import java.util.Scanner;

import control.CEnrollment;
import valueObject.OLecture;
import valueObject.OMember;

public class VEnrollment {

	private Scanner scanner;

	private VIndex vCampus;
	private VIndex vCollege;
	private VIndex vDepartment;
	private VLecture vLecture;

	private CEnrollment cEnrollment;

	public VEnrollment(Scanner scanner) {
		this.scanner = scanner;
		this.vCampus = new VIndex(this.scanner);
		this.vCollege = new VIndex(this.scanner);
		this.vDepartment = new VIndex(this.scanner);
		this.vLecture = new VLecture(this.scanner);
		this.cEnrollment = new CEnrollment();
	}

	public boolean show(OMember oMember) {
		System.out.println(oMember.getName() + "�� ȯ���մϴ�.");
		System.out.println("������û ȭ���Դϴ�.");

		String campusFileName = this.vCampus.show("root", "ķ�۽���");
		if (campusFileName != null) {
			String collegeFileName = this.vCollege.show(campusFileName, "������");
			if (collegeFileName != null) {
				String departmentFileName = this.vDepartment.show(collegeFileName, "�а���");
				if (departmentFileName != null) {
					OLecture oLecture = this.vLecture.show(departmentFileName, "���¸�");
				}
			}
		}
		return true;

	}

}
