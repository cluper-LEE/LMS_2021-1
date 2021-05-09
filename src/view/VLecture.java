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

	public OLecture show(String fileName, String level) {
		System.out.println(level + " º±≈√");
		fileName = "data/" + fileName;
		Vector<OLecture> lectures = cEnrollment.getAll(fileName);
		for(OLecture lecture : lectures) {
			System.out.println(lecture.toString());
		}
		String id = this.scanner.next();
		OLecture selected = null;
		for(OLecture lecture : lectures) {
			if(lecture.getId().equals(id)) {
				selected = lecture;
				break;
			}
		}
		return selected;
	}

}
