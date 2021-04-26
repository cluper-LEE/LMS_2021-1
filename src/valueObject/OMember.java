package valueObject;

import model.MMember;

public class OMember {
	private String id;
	private String name;
	private String department;
	private String address;
	private String pswd;

	public OMember() {

	}

	public OMember(String id, String name, String address, String department, String pswd) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.department = department;
		this.pswd = pswd;
	}

	public OMember(MMember mMember) {
		this.id = mMember.getId();
		this.name = mMember.getName();
		this.address = mMember.getAddress();
		this.department = mMember.getDepartment();
		this.pswd = mMember.getPswd();
	}

	public String toString() {
		return "[�̸� : " + this.name + ", �й� : " + this.id + ", �ּ� : " + this.address + ", �а� : " + this.department
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

	public String getPswd() {
		return pswd;
	}

}
