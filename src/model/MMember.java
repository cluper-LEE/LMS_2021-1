package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

import valueObject.OMember;

public class MMember {
	private String id;
	private String name;
	private String address;
	private String department;
	private String pswd;

	public MMember() {

	}

	public MMember(String id, String name, String address, String department, String pswd) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.department = department;
		this.pswd = pswd;
	}

	public MMember(OMember oMember) {
		this.id = oMember.getId();
		this.name = oMember.getName();
		this.address = oMember.getAddress();
		this.department = oMember.getDepartment();
		this.pswd = oMember.getPswd();
	}

	public String getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getAddress() {
		return address;
	}
	public String getDepartment() {
		return department;
	}
	public String getPswd() {
		return pswd;
	}
	public String toString() {
		return "[이름 : " + this.name + ", 학번 : " + this.id + ", 주소 : " + this.address + ", 학과 : " + this.department
				+ "]";
	}

	public void save(BufferedWriter bufferedWriter, OMember oMember) {
		this.set(oMember);
		try {
			String input = String.join("\n", this.id, this.name, this.address, this.department, this.pswd);
			input += "\n\n";
			bufferedWriter.write(input);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void set(OMember oMember) {
		this.id = oMember.getId();
		this.pswd = oMember.getPswd();
		this.name = oMember.getName();
		this.department = oMember.getDepartment();
		this.address = oMember.getAddress();
	}

	public void read(BufferedReader bufferedReader, String id) {
		try {
			while (bufferedReader.ready()) {
				String output = bufferedReader.readLine();
				String ret = output + '\n';
				while (!output.equals("")) {
					output = bufferedReader.readLine();
					ret += output + '\n';
				}
				String[] attributes = ret.split("\n");
				if (attributes[0].equals(id)) {
					this.id = attributes[0];
					this.name = attributes[1];
					this.address = attributes[2];
					this.department = attributes[3];
					this.pswd = attributes[4];
					break;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
