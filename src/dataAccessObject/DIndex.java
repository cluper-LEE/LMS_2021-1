package dataAccessObject;

import java.io.File;
import java.util.Scanner;
import java.util.Vector;

import model.MIndex;
import valueObject.OIndex;

public class DIndex {
	
	private static final String PATHNAME = "data/";
	
	public DIndex() {
		// TODO Auto-generated constructor stub
	}

	public Vector<OIndex> readAll(String fileName) {
		// mMember를 통해 Data read
		// oMember 생성
		// mMember에서 oMember로 데이터 이동
		Vector<OIndex> indices = new Vector<>();
		try {
			File file = new File(PATHNAME + fileName);
			Scanner scanner = new Scanner(file);
			MIndex mIndex = new MIndex();
			while (mIndex.read(scanner)) {
				OIndex oIndex = new OIndex();
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
