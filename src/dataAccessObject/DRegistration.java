package dataAccessObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

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
		try(BufferedReader bufferedReader = new BufferedReader(new FileReader("members.txt"))){
			MMember mMember = new MMember();
			mMember.read(bufferedReader, id);
			return new OMember(mMember);
		}catch(IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
