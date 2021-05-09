package model;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Scanner;

import valueObject.OLecture;

public class MLecture {
	private String id;
	private String name;
	private String profName;
	private String credit;
	private String hours;

	public MLecture() {

	}
	
	public MLecture(String id, String name, String profName, String credit, String hours) {
		this.id = id;
		this.name = name;
		this.profName = profName;
		this.credit = credit;
		this.hours = hours;
	}

	public boolean read(Scanner scanner) {
		while(scanner.hasNext()) {
			this.id = scanner.next();
			this.name = scanner.next();
			this.profName = scanner.next();
			this.credit = scanner.next();
			this.hours = scanner.next();
			return true;
		}
		return false;
	}

	public void set(OLecture oLecture) {
		this.id = oLecture.getId();
		this.name = oLecture.getName();
		this.profName = oLecture.getProfName();
		this.credit = oLecture.getCredit();
		this.hours = oLecture.getHours();
	}


	public String getId() {
		return id;
	}



	public String getName() {
		return name;
	}



	public String getProfName() {
		return profName;
	}



	public String getCredit() {
		return credit;
	}



	public String getHours() {
		return hours;
	}

	public void save(BufferedWriter bufferedWriter, OLecture oLecture) {
		// TODO Auto-generated method stub
		try {
			String s = String.join("\n", oLecture.toString().split(" "));
			bufferedWriter.write(s);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	
	

}
