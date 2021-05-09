package control;

import java.util.Vector;

import dataAccessObject.DEnrollment;
import valueObject.OLecture;

public class CEnrollment {
	private DEnrollment dEnrollment;
	
	public CEnrollment() {
		this.dEnrollment = new DEnrollment();
	}

	public Vector<OLecture> getAll(String fileName) {
		Vector<OLecture> lectures = this.dEnrollment.readAll(fileName);
		return lectures;
	}

	public void saveLecture(OLecture oLecture) {
		this.dEnrollment.save(oLecture);
	}

}
