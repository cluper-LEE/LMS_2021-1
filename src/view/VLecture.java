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
			System.out.println("즉시 신청(1), 미리 담기(2), 취소(0)");
			String input = scanner.next();
			if (input.equals("0")) {
				break;
			} else if (input.equals("1")) {
				// 수강 신청 내역에 추가
				this.cLecture.saveLecture(id, oLecture);
				break;
			} else if (input.equals("2")) {
				// 미리 담기 내역에 추가
				this.cLecture.saveLectureInBasket(id, oLecture);
				break;
			} else {
				System.out.println("잘못된 입력입니다.");
			}
		}
		return oLecture;
	}
	
	
}
