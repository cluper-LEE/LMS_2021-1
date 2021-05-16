package dataAccessObject;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import model.MMember;
import valueObject.OMember;

public class DRegistration {

	public static final String USER_PATH = "members/";
	private MMember mMember;
	

	public DRegistration() {
	}

	public boolean save(OMember oMember) {
		File file = new File(DRegistration.USER_PATH + oMember.getId());
		if(file.exists()) { // �̹� ������ �����ϸ�
			return false;
		}
		try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, true))) {
			// oMember���� mMember�� �����͸� �̵�
			// mMember�� ���ؼ� ���Ͽ� ����
			this.mMember = new MMember();
			mMember.save(bufferedWriter, oMember);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return true;
	}

	public OMember read(String id) {
		File file = new File(DRegistration.USER_PATH + id);
		if(!file.exists()) {
			return null;
		}
		try(Scanner scanner = new Scanner(file)) {
			this.mMember = new MMember();
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
