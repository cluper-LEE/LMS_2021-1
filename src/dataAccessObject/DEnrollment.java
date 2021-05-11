package dataAccessObject;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;

import model.MLecture;
import valueObject.OLecture;

public class DEnrollment {

	private static final String PATHNAME = "data/";
	
	public DEnrollment() {
		// TODO Auto-generated constructor stub
	}

	public Vector<OLecture> readAll(String fileName) {
		// mMember를 통해 Data read
		// oMember 생성
		// mMember에서 oMember로 데이터 이동
		Vector<OLecture> lectures = new Vector<>();
		try {
			File file = new File(PATHNAME + fileName);
			Scanner scanner = new Scanner(file);
			MLecture mLecture = new MLecture();
			while (mLecture.read(scanner)) {
				OLecture oLecture = new OLecture();
				oLecture.set(mLecture);
				lectures.add(oLecture);
			}
			scanner.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lectures;
	}

	public void save(OLecture oLecture) {
		try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("registration_list.txt", true))) {
			MLecture mLecture = new MLecture();
			mLecture.save(bufferedWriter, oLecture);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
