package dataAccessObject;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import model.MMember;
import valueObject.OMember;

public class DRegistration {

	public DRegistration() {
	}

	public void save(OMember oMember) {
		try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("members.txt", true))) {
			// oMember���� mMember�� �����͸� �̵�
			// mMember�� ���ؼ� ���Ͽ� ����
			MMember mMember = new MMember();
			mMember.save(bufferedWriter, oMember);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public OMember read(String id) {
		// mMember�� ���� Data read
		// oMember ����
		// mMember���� oMember�� ������ �̵�
		try {
		File file = new File("members.txt");
		Scanner scanner = new Scanner(file);
		MMember mMember = new MMember();
		while(mMember.read(scanner)) {
			if(mMember.getId().equals(id)) {
				OMember oMember = new OMember();
				oMember.set(mMember);
				return oMember;
			}
		}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
