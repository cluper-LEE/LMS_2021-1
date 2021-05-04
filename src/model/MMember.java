package model;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Scanner;

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
			input += "\n";
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

	
	public boolean read(Scanner scanner) {
		while(scanner.hasNext()) {
			this.id = scanner.nextLine();
			this.name = scanner.nextLine();
			this.address = scanner.nextLine();
			this.department = scanner.nextLine();
			this.pswd = scanner.nextLine();
			return true;
		}
		return false;
	}
}
