package control;

import dataAccessObject.DMember;
import valueObject.OMember;

public class CRegistration {
	private DMember dMember;
	
	public CRegistration() {
		this.dMember = new DMember();
	}

	public void saveMember(OMember oMember) {
		this.dMember.save(oMember);
	}
	
	public void readMember() {
		OMember oMember =  this.dMember.read();
	}

}
