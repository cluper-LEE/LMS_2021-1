package dataAccessObject;

import java.io.File;
import java.util.Scanner;
import java.util.Vector;

import model.MIndex;
import valueObject.OIndex;

public class DIndex {
	
	public static final String LECTURE_PATH = "lectures/";
	
	protected OIndex oIndex;
	protected MIndex mIndex;
	
	public DIndex() {
		this.oIndex = new OIndex();
		this.mIndex = new MIndex();
	}

	public Vector<OIndex> readAll(String fileName) {
		Vector<OIndex> indices = new Vector<>();
		try {
			File file = new File(LECTURE_PATH + fileName);
			Scanner scanner = new Scanner(file);
			while (mIndex.read(scanner)) {
				oIndex = oIndex.getInstance();
				oIndex.set(mIndex);
				indices.add(oIndex);
			}
			scanner.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return indices;
	}

}
