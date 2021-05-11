package view;

import java.util.Scanner;
import java.util.Vector;

import control.CEnrollment;
import valueObject.OLecture;

public class VLecture {
	private Scanner scanner;
	private CEnrollment cEnrollment;
	
	public VLecture(Scanner scanner) {
		this.cEnrollment = new CEnrollment();
		this.scanner = scanner;
	}

	public OLecture show(String fileName, String message) {
		System.out.println(message + " 선택 하세요.");
		Vector<OLecture> lectures = this.cEnrollment.getAll(fileName);
		for(OLecture lecture : lectures) {
			System.out.println(lecture.toString());
		}
		String id = this.scanner.next();
		for(OLecture lecture : lectures) {
			if(lecture.getId().equals(id)) {
				return lecture;
			}
		}
		return null;
	}

}
