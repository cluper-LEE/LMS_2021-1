package control;

import java.util.Vector;

import constants.Config.FCLectureControl;
import dataAccessObject.DLecture;
import valueObject.OLecture;

public class CLecture{
	
	DLecture dLecture;
	
	public CLecture() {
		this.dLecture = new DLecture();
	}

	public Vector<OLecture> getAll(String fileName) {
		Vector<OLecture> lectures = this.dLecture.readAll(fileName);
		return lectures;
	}
	
	public FCLectureControl saveInEnrollmentList(String id, OLecture oLecture) {
		return this.dLecture.saveInEnrollmentList(id, oLecture);
	}

	public FCLectureControl saveInBasket(String id, OLecture oLecture) {
		return this.dLecture.saveInBasket(id, oLecture);
	}

}
