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
			// oMember에서 mMember로 데이터를 이동
			// mMember를 통해서 파일에 저장
			MMember mMember = new MMember();
			mMember.save(bufferedWriter, oMember);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public OMember read(String id) {
		// mMember를 통해 Data read
		// oMember 생성
		// mMember에서 oMember로 데이터 이동
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
