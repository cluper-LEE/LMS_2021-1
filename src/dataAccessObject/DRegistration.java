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

		// oMember에서 mMember로 데이터를 이동
		// mMember를 통해서 파일에 저장
		MMember mMember = new MMember(oMember);
		this.saveToFile(mMember);

	}

	private void saveToFile(MMember mMember) {
		String path = "members.txt";
		String input = mMember.getId() + "/" + mMember.getName() + "/" + mMember.getAddress() + "/"
				+ mMember.getDepartment() + '\n';

		try (BufferedWriter bw = new BufferedWriter(new FileWriter(path, true))) {
			bw.write(input);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public OMember read(String id) {
		// mMember를 통해 Data read
		// oMember 생성
		// mMember에서 oMember로 데이터 이동
		String path = "members.txt";
		String output = "";
		String[] infos = new String[4];
		
		try(BufferedReader br = new BufferedReader(new FileReader(path))){
			while(!output.equals(id) && br.ready()) {
				output = br.readLine();
				infos = output.split("/");
				output = infos[0];
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		MMember mMember = new MMember(infos[0], infos[1], infos[2], infos[3]);
		return new OMember(mMember);
	}

}
