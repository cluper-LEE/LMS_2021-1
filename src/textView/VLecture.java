package textView;

import java.util.Scanner;
import java.util.Vector;

import control.CLecture;
import valueObject.OIndex;
import valueObject.OLecture;

public class VLecture{
	protected Scanner scanner;
	private CLecture cLecture;
	
	public VLecture() {}
	
	
	public VLecture(Scanner scanner) {
		this.scanner = scanner;
		this.cLecture = new CLecture();
	}

	public OIndex show(String id, String fileName, String message) {
		
		Vector<OLecture> lectures = cLecture.getAll(fileName);
		for(OLecture lecture : lectures) {
			System.out.println(lecture.toString());
		}
		OLecture oLecture = new OLecture();
		for(OLecture lecture : lectures) {
			if(lecture.getId().equals(id)) {
				oLecture = lecture;
			}
		}
		
		while (true) {
			System.out.println("��� ��û(1), �̸� ���(2), ���(0)");
			String input = scanner.next();
			if (input.equals("0")) {
				break;
			} else if (input.equals("1")) {
				// ���� ��û ������ �߰�
				this.cLecture.saveLecture(id, oLecture);
				break;
			} else if (input.equals("2")) {
				// �̸� ��� ������ �߰�
				this.cLecture.saveLectureInBasket(id, oLecture);
				break;
			} else {
				System.out.println("�߸��� �Է��Դϴ�.");
			}
		}
		return oLecture;
	}
	
	
}
