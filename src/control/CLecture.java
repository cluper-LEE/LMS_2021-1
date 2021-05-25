package control;

import java.util.Vector;

import dataAccessObject.DLecture;
import valueObject.OLecture;

public class CLecture{
	
	DLecture dLecture;
	
	public CLecture() {
		this.dLecture = new DLecture();
	}

	public Vector<OLecture> getAll(String fileName) {
		Vector<OLecture> indeices = this.dLecture.readAll(fileName);
		return indeices;
	}
	public void saveLecture(String id, OLecture oLecture) {
		this.dLecture.save(id, oLecture);
	}

	public void saveLectureInBasket(String id, OLecture oLecture) {
		this.dLecture.saveInBasket(id, oLecture);
	}

}
