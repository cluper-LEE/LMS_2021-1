package dataAccessObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import model.MLecture;
import model.MTime;
import valueObject.OLecture;

public class DLecture extends DIndex {

	public static final String BASKET_PATH = "baskets/";
	public static final String ENROLLMENT_PATH = "enrollment_lists/";

	private MLecture mLecture;

	public DLecture() {
		super.oIndex = new OLecture();
		super.mIndex = new MLecture();
	}

	public void save(String id, OLecture oLecture) {
		this.saveInFile(DLecture.ENROLLMENT_PATH + id, oLecture);
	}

	public boolean saveInBasket(String id, OLecture oLecture) {
		String path = DLecture.BASKET_PATH + id;
		this.saveInFile(path, oLecture);
		return true;
	}

	public boolean saveInFile(String path, OLecture oLecture) {
		File file = new File(path);
		if (file.exists()) {
			if (this.lectureExists(path, oLecture)) {
				// 이미 신청한 강좌라면 false 반환.
				return false;
			}
		}
		try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, true))) {
			this.mLecture = new MLecture();
			mLecture.save(bufferedWriter, oLecture);
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean lectureExists(String path, OLecture oLecture) {
		File file = new File(path);
		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
			this.mLecture = new MLecture();
			Scanner scanner = new Scanner(file);
			while (mLecture.read(scanner)) {
				if (mLecture.getId().equals(oLecture.getId())) {
					return true;
				}
				if (new MTime(mLecture.getTime()).checkOverlap(new MTime(oLecture.getTime()))) {
					System.out.println("시간 중복");
					return true;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}

}
