package control;

import dataAccessObject.DLecture;
import valueObject.OLecture;

public class CLecture extends CIndex {
	
	DLecture dLecture;
	
	public CLecture() {
		this.dIndex = this.dLecture = new DLecture();
	}

	public void saveLecture(String id, OLecture oLecture) {
		this.dLecture.save(id, oLecture);
	}

	public void saveLectureInBasket(String id, OLecture oLecture) {
		this.dLecture.saveInBasket(id, oLecture);
	}

}
