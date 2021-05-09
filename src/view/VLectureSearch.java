package view;

import java.util.Scanner;
import java.util.Vector;

import control.CIndex;
import valueObject.OIndex;

public class VLectureSearch {
	private Scanner scanner;
	private CIndex cIndex;
	
	public VLectureSearch(Scanner scanner) {
		this.cIndex = new CIndex();
		this.scanner = scanner;
	}

	public String show(String fileName, String level) {
		System.out.println(level + " º±≈√");
		String id = this.scanner.next();
		fileName = "data/" + fileName;
		Vector<OIndex> indices = cIndex.getAll(fileName);
		for(OIndex index : indices) {
			System.out.println(index.getId() + " " + index.getName());
		}
		for(OIndex index : indices) {
			if(index.getId().equals(id)) {
				return index.getFileName();
			}
		}
		return null;
	}

}
