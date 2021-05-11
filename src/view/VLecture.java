package view;

import java.util.Scanner;

import control.CLecture;
import valueObject.OIndex;
import valueObject.OLecture;

public class VLecture extends VIndex {

	CLecture cLecture;
	
	public VLecture(Scanner scanner) {
		this.scanner = scanner;
		this.cIndex = this.cLecture = new CLecture();
	}

	public OIndex show(String id, String fileName, String message) {
		OLecture oLecture = (OLecture)super.show(fileName, message);
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
