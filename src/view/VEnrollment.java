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
		System.out.println(oMember.getName() + "님 환영합니다.");
		System.out.println("수강신청 화면입니다.");

		String campusFileName = this.vCampus.show("root", "campus");
		String collegeFileName = this.vCollege.show(campusFileName, "college");
		String departmentFileName = this.vDepartment.show(collegeFileName, "department");
		OLecture oLecture = this.vLecture.show(departmentFileName, "lecture");
		if (oLecture != null) {
			cEnrollment.saveLecture(oLecture);
			System.out.println(oLecture.toString() + " 강좌를 신청 내역에 추가하였습니다.");
			return true;
		} else {
			System.out.println("신청에 실패하였습니다.");
			return false;
		}

	}

}
