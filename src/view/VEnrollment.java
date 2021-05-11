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
		System.out.println(oMember.getName() + "님 환영합니다.");
		System.out.println("수강신청 화면입니다.");

		String campusFileName = this.vCampus.show("root", "캠퍼스를");
		if (campusFileName != null) {
			String collegeFileName = this.vCollege.show(campusFileName, "대학을");
			if (collegeFileName != null) {
				String departmentFileName = this.vDepartment.show(collegeFileName, "학과를");
				if (departmentFileName != null) {
					OLecture oLecture = this.vLecture.show(departmentFileName, "강좌를");
				}
			}
		}
		return true;

	}

}
