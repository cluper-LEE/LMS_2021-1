package valueObject;

public class OMember {
	private String id;
	private String name;
	private String address;
	private String department;
	
	public OMember() {
		
	}
	
	public OMember(String id, String name, String address, String department) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.department = department;
	}
	
	public String toString() {
		return "[이름 : " + this.name 
				+ ", 학번 : " + this.id 
				+ ", 주소 : "+ this.address
				+ ", 학과 : " + this.department
				+ "]";
	}
}
