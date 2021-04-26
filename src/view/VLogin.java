package view;

import java.util.Scanner;

import control.CRegistration;
import valueObject.OMember;

public class VLogin {
	private Scanner scanner;
	private CRegistration cRegistration;

	public VLogin(Scanner scanner) {
		this.scanner = scanner;
		this.cRegistration = new CRegistration();
	}

	public void show() {
		System.out.println("�α��� ȭ���Դϴ�.");
		
		System.out.print("���̵� : ");
		String id = this.scanner.next();
		
		System.out.print("��й�ȣ : ");
		String pswd = this.scanner.next();
		
		OMember oMember = cRegistration.findMemberById(id);
		if(oMember == null) {
			System.out.println("ȸ�� ������ ã�� ���߽��ϴ�. �Է��� Ȯ�����ּ���.");
		}else {
			
			if(pswd.equals(oMember.getPswd())) {			
				System.out.println(oMember.getName() + "�� ȯ���մϴ�.");
				System.out.println("�α��� ���� : " + oMember.toString() + " ��й�ȣ�� ǥ������ �ʽ��ϴ�.");
			}else {
				System.out.println("��й�ȣ�� ��ġ���� �ʽ��ϴ�.");
			}
		}
	}

}
