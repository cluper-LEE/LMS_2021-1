package control;

import dataAccessObject.DRegistration;
import valueObject.OLogin;
import valueObject.OMember;

public class CLogin {
	private DRegistration dRegistration;

	public CLogin() {
		this.dRegistration = new DRegistration();
	}

	public OMember validate(OLogin oLogin) {
		OMember oMember = this.dRegistration.read(oLogin.getId());
		if(oMember != null) {
			if(oLogin.getPswd().equals(oMember.getPswd())) {
				return oMember;
			}
		}
		return null;
	}

	
}
