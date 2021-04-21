package model;

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
	
	public String toString() {
		return "[�̸� : " + this.name 
				+ ", �й� : " + this.id 
				+ ", �ּ� : "+ this.address
				+ ", �а� : " + this.department
				+ "]";
	}
}
