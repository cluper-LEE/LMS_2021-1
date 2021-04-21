package view;

import control.CRegistration;
import valueObject.OMember;

public class VRegistration {
	private CRegistration cRegistration;
	
	public VRegistration() {
		this.cRegistration = new CRegistration();
	}

	public void show() {
		OMember oMember = new OMember();
		// 데이터 입력 받아 oMember에 저장
		
		
		this.cRegistration.saveMember(oMember);
	}
	
	
}
