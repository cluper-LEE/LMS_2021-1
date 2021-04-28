package valueObject;

import java.util.Calendar;

import model.MMember;

public class OMember {
	private String id;
	private String name;
	private String department;
	private String address;
	int birthYear;
	private String pswd;

	public OMember() {

	}

	public OMember(String id, String name, String address, String department, int birthYear, String pswd) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.department = department;
		this.birthYear = birthYear;
		this.pswd = pswd;
	}

	public OMember(MMember mMember) {
		this.id = mMember.getId();
		this.name = mMember.getName();
		this.address = mMember.getAddress();
		this.department = mMember.getDepartment();
		this.birthYear = mMember.getBirthYear();
		this.pswd = mMember.getPswd();
	}

	public String toString() {
		return "[이름 : " + this.name + ", 학번 : " + this.id + ", 주소 : " + this.address + ", 학과 : " + this.department + ", 생년 : " + this.birthYear
				+ "]";
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

	public int getBirthYear() {
		return birthYear;
	}

	public String getPswd() {
		return pswd;
	}

}
