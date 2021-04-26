package model;

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
		return "[이름 : " + this.name 
				+ ", 학번 : " + this.id 
				+ ", 주소 : "+ this.address
				+ ", 학과 : " + this.department
				+ "]";
	}
}
