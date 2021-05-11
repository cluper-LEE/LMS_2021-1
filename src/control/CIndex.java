package control;

import java.util.Vector;

import dataAccessObject.DIndex;
import valueObject.OIndex;

public class CIndex {
	protected DIndex dIndex;
	
	public CIndex() {
		this.dIndex = new DIndex();
	}

	public Vector<OIndex> getAll(String fileName) {
		Vector<OIndex> indeices = this.dIndex.readAll(fileName);
		return indeices;
	}

}
