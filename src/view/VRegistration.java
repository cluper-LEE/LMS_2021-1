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
		// ������ �Է� �޾� oMember�� ����
		
		
		this.cRegistration.saveMember(oMember);
	}
	
	
}
