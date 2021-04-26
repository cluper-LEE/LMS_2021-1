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
		if(this.isExist(mMember)) {
			System.out.println("이미 등록된 학번입니다.");
			return;
		}
		this.saveToFile(mMember);

	}

	private void saveToFile(MMember mMember) {
		String path = "members.txt";
		String input = mMember.getId() + "/" + mMember.getName() + "/" + mMember.getAddress() + "/"
				+ mMember.getDepartment() + "/" + mMember.getPswd() + '\n';

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
		if(!this.isExist(id)) {
			return null;
		}
		String path = "members.txt";
		String output = "";
		String[] infos = new String[5];
		
		try(BufferedReader br = new BufferedReader(new FileReader(path))){
			while(!output.equals(id) && br.ready()) {
				output = br.readLine();
				infos = output.split("/");
				output = infos[0];
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
		if(output.equals("")) {
			return null;
		}
		MMember mMember = new MMember(infos[0], infos[1], infos[2], infos[3], infos[4]);
		return new OMember(mMember);
	}
	
	public boolean isExist(MMember mMember) {
		return this.isExist(mMember.getId());
	}
	
	public boolean isExist(String id) {
		String path = "members.txt";
		try(BufferedReader br = new BufferedReader(new FileReader(path))){
			String idInFile;
			while(br.ready()) {
				idInFile = br.readLine().split("/")[0];
				if(idInFile.equals(id)) {
					return true;
				}
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
		return false;
	}
}
