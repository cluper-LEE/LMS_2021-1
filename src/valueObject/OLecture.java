package valueObject;

import model.MIndex;
import model.MLecture;

public class OLecture extends OIndex {
	private String profName;
	private String credit;
	private String time;

	public OLecture() {

	}

	public OLecture(String id, String name, String profName, String credit, String time) {
		super(id, name, "");
		this.profName = profName;
		this.credit = credit;
		this.time = time;
	}
	
	

	@Override
	public OIndex getInstance() {
		return new OLecture();
	}

	@Override
	public void set(MIndex mIndex) {
		super.set(mIndex);
		MLecture mLecture = (MLecture)mIndex;
		this.profName = mLecture.getProfName();
		this.credit = mLecture.getCredit();
		this.time = mLecture.getTime();
	}
	
	@Override
	public String toString() {
		return super.getId() + " " + super.getName() + " " + profName + " " + credit + " " + time;
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

}
