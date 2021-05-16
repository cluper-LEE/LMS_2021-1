package valueObject;

import model.MMember;

public class OMember extends OLogin {
	private String name;
	private String department;
	private String address;

	public OMember() {
		
	}

	public OMember(String id, String name, String address, String department, String pswd) {
		super(id, pswd);
		this.name = name;
		this.address = address;
		this.department = department;
	}

	public OMember(MMember mMember) {
		this.id = mMember.getId();
		this.name = mMember.getName();
		this.address = mMember.getAddress();
		this.department = mMember.getDepartment();
		this.pswd = mMember.getPswd();
	}

	public String toString() {
		return "[이름 : " + this.name + ", 학번 : " + this.id + ", 주소 : " + this.address + ", 학과 : " + this.department 
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

	
	public void set(MMember mMember) {
		this.id = mMember.getId();
		this.name = mMember.getName();
		this.address = mMember.getName();
		this.department = mMember.getDepartment();
		this.pswd = mMember.getPswd();
	}

}
