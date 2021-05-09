package valueObject;

import model.MLecture;

public class OLecture {

	private String id;
	private String name;
	private String profName;
	private String credit;
	private String hours;

	public OLecture() {

	}

	public OLecture(String id, String name, String profName, String credit, String hours) {
		this.id = id;
		this.name = name;
		this.profName = profName;
		this.credit = credit;
		this.hours = hours;
	}

	public void set(MLecture mLecture) {
		this.id = mLecture.getId();
		this.name = mLecture.getName();
		this.profName = mLecture.getProfName();
		this.credit = mLecture.getCredit();
		this.hours = mLecture.getHours();
	}

	@Override
	public String toString() {
		return id + " " + name + " " + profName + " " + credit + " " + hours;
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

}
