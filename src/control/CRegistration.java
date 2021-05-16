package control;

import dataAccessObject.DRegistration;
import valueObject.OMember;

public class CRegistration {
	private DRegistration dRegistration;
	
	public CRegistration() {
		this.dRegistration = new DRegistration();
	}

	public boolean saveMember(OMember oMember) {
		// oMember를 DAO에 전달
		return this.dRegistration.save(oMember);
	}
	
	public OMember findMemberById(String id) {
		return this.dRegistration.read(id);
	}

}
