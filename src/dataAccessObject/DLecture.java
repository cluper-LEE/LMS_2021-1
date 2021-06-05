package dataAccessObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;

import constants.Config.FCLectureControl;
import model.MLecture;
import model.MTime;
import valueObject.OLecture;

public class DLecture{
	public static final String LECTURE_PATH = "lectures/";
	public static final String BASKET_PATH = "baskets/";
	public static final String ENROLLMENT_PATH = "enrollment_lists/";
	
	private MLecture mLecture;

	public DLecture() {
		this.mLecture = new MLecture();
	}

	public Vector<OLecture> readAll(String fileName) {
		Vector<OLecture> lectures = new Vector<>();
		File file = new File(fileName);
		try (Scanner scanner = new Scanner(file);) {
			while (mLecture.read(scanner)) {
				OLecture oLecture = new OLecture();
				oLecture.set(mLecture);
				lectures.add(oLecture);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lectures;
	}

	public FCLectureControl saveInEnrollmentList(String id, OLecture oLecture) {
		FCLectureControl result = this.saveInFile(DLecture.ENROLLMENT_PATH + id, oLecture);
		if(result == FCLectureControl.ALREADY_EXIST_LECTURE) {
			return FCLectureControl.EXIST_IN_ENROLLMENT_LIST;
		}
		return result; 
	}

	public FCLectureControl saveInBasket(String id, OLecture oLecture) {
		FCLectureControl result = this.saveInFile(DLecture.BASKET_PATH + id, oLecture);
		if(result == FCLectureControl.ALREADY_EXIST_LECTURE) {
			return FCLectureControl.EXIST_IN_BASKET;
		}
		return result; 
	}

	public FCLectureControl saveInFile(String path, OLecture oLecture) {
		File file = new File(path);
		if (file.exists()) {
			FCLectureControl result = this.validLecture(path, oLecture);
			if (result != null) {
				return result;
			}
		}
		try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, true))) {
			this.mLecture = new MLecture();
			mLecture.save(bufferedWriter, oLecture);
		} catch (IOException e) {
			e.printStackTrace();
			return FCLectureControl.FAIL_TO_SAVE_IN_FILE;
		}
		return FCLectureControl.SUCCESS;
	}

	public FCLectureControl validLecture(String path, OLecture oLecture) {
		File file = new File(path);
		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
			this.mLecture = new MLecture();
			Scanner scanner = new Scanner(file);
			while (mLecture.read(scanner)) {
				if (mLecture.getId().equals(oLecture.getId())) {
					return FCLectureControl.ALREADY_EXIST_LECTURE;
				}
				if (new MTime(mLecture.getTime()).checkOverlap(new MTime(oLecture.getTime()))) {
					return FCLectureControl.TIME_OVERlAP;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
