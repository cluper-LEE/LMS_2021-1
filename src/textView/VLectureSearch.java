package textView;

import java.util.Scanner;

import valueObject.OIndex;
import valueObject.OMember;

public class VLectureSearch {

	private Scanner scanner;

	private VIndex vCampus;
	private VIndex vCollege;
	private VIndex vDepartment;
	private VLecture vLecture;

	public VLectureSearch(Scanner scanner) {
		this.scanner = scanner;
		this.vCampus = new VIndex(this.scanner);
		this.vCollege = new VIndex(this.scanner);
		this.vDepartment = new VIndex(this.scanner);
		this.vLecture = new VLecture(this.scanner);
	}

	// 특정 강좌를 선택. 신청, 담기 분기.
	public void show(OMember oMember) {
		System.out.println(oMember.getName() + "님 환영합니다.");
		System.out.println("수강신청 화면입니다.");

		while (true) {
			OIndex campus = this.vCampus.show("root", "캠퍼스를");
			if (campus != null) {
				OIndex college = this.vCollege.show(campus.getFileName(), "대학을");
				if (college != null) {
					OIndex department = this.vDepartment.show(college.getFileName(), "학과를");
					if (department != null) {
						this.vLecture.show(oMember.getId(), department.getFileName(), "강좌를");
					}
				}
			}
			System.out.println("계속(1), 종료(0)");
			String input = this.scanner.next();
			if(input.equals("0")) {
				break;
			}
		}
	}

}
