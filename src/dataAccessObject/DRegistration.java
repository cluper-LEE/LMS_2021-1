package dataAccessObject;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import model.MMember;
import valueObject.OMember;

public class DRegistration {

	public static final String USER_PATH = "members.txt";

	public DRegistration() {
	}

	public void save(OMember oMember) {
		File file = new File(DRegistration.USER_PATH);
		try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, true))) {
			// oMember에서 mMember로 데이터를 이동
			// mMember를 통해서 파일에 저장
			MMember mMember = new MMember();
			mMember.save(bufferedWriter, oMember);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public OMember read(String id) {
		File file = new File(DRegistration.USER_PATH);
		try(Scanner scanner = new Scanner(file)) {
			MMember mMember = new MMember();
			while (mMember.read(scanner)) {
				if (mMember.getId().equals(id)) {
					OMember oMember = new OMember();
					oMember.set(mMember);
					return oMember;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
