package control;

import dataAccessObject.DRegistration;
import valueObject.OMember;

public class CRegistration {
	private DRegistration dRegistration;
	
	public CRegistration() {
		this.dRegistration = new DRegistration();
	}

	public void saveMember(OMember oMember) {
		// oMember�� DAO�� ����
		this.dRegistration.save(oMember);
	}
	
	public OMember findMemberById(String id) {
		OMember oMember =  this.dRegistration.read(id);
		return oMember;
	}

}
