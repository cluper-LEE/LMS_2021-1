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

	// Ư�� ���¸� ����. ��û, ��� �б�.
	public void show(OMember oMember) {
		System.out.println(oMember.getName() + "�� ȯ���մϴ�.");
		System.out.println("������û ȭ���Դϴ�.");

		while (true) {
			OIndex campus = this.vCampus.show("root", "ķ�۽���");
			if (campus != null) {
				OIndex college = this.vCollege.show(campus.getFileName(), "������");
				if (college != null) {
					OIndex department = this.vDepartment.show(college.getFileName(), "�а���");
					if (department != null) {
						this.vLecture.show(oMember.getId(), department.getFileName(), "���¸�");
					}
				}
			}
			System.out.println("���(1), ����(0)");
			String input = this.scanner.next();
			if(input.equals("0")) {
				break;
			}
		}
	}

}
