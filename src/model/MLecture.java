package model;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Scanner;

import valueObject.OLecture;

public class MLecture extends MIndex {
	private String profName;
	private String credit;
	private String time;

	public MLecture() {

	}

	public MLecture(String id, String name, String profName, String credit, String time) {
		super(id, name, "");
		this.profName = profName;
		this.credit = credit;
		this.time = time;
	}

	@Override
	public boolean read(Scanner scanner) {
		if (scanner.hasNext()) {
			super.setId(scanner.next());
			super.setName(scanner.next());
			this.profName = scanner.next();
			this.credit = scanner.next();
			this.time = MTime.getNormalizedTime(scanner.next());
			
			// 강좌 데이터 순서가 다른 경우가 있음.
			if(this.credit.contains("-")) {
				String temp = this.credit;
				this.credit = this.profName;
				this.profName = this.time;
				this.time = temp;
			}
			
			return true;
		}
		return false;
	}

	public void save(BufferedWriter bufferedWriter, OLecture oLecture) {
		try {
			String s = String.join("\n", oLecture.toString().split(" "));
			s += "\n";
			bufferedWriter.write(s);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return super.getId();
	}

	@Override
	public void setId(String id) {
		// TODO Auto-generated method stub
		super.setId(id);
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return super.getName();
	}

	@Override
	public void setName(String name) {
		// TODO Auto-generated method stub
		super.setName(name);
	}

	public String getProfName() {
		return profName;
	}

	public void setProfName(String profName) {
		this.profName = profName;
	}

	public String getCredit() {
		return credit;
	}

	public void setCredit(String credit) {
		this.credit = credit;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

}
