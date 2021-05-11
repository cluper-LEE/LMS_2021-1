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
	private String time;

	public MLecture() {

	}
	
	public MLecture(String id, String name, String profName, String credit, String hours) {
		this.id = id;
		this.name = name;
		this.profName = profName;
		this.credit = credit;
		this.time = hours;
	}

	public boolean read(Scanner scanner) {
		if(scanner.hasNext()) {
			this.id = scanner.next();
			this.name = scanner.next();
			this.profName = scanner.next();
			this.credit = scanner.next();
			this.time = scanner.next();
			return true;
		}
		return false;
	}

	public void save(BufferedWriter bufferedWriter, OLecture oLecture) {
		try {
			String s = String.join("\n", oLecture.toString().split(" "));
			bufferedWriter.write(s);
		} catch (IOException e) {
			e.printStackTrace();
		}
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
		return time;
	}


	
	

}
