package model;

import valueObject.OMember;

public class MMember {
	private String id;
	private String name;
	private String address;
	private String department;
	
	public MMember() {
		
	}
	
	public MMember(String id, String name, String address, String department) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.department = department;
	}
	
	
	public MMember(OMember oMember) {
		this.id = oMember.getId();
		this.name = oMember.getName();
		this.address = oMember.getAddress();
		this.department = oMember.getDepartment();
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

	public String toString() {
		return "[�̸� : " + this.name 
				+ ", �й� : " + this.id 
				+ ", �ּ� : "+ this.address
				+ ", �а� : " + this.department
				+ "]";
	}
}
