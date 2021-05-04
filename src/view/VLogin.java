package view;

import java.util.Scanner;

import control.CLogin;
import valueObject.OLogin;
import valueObject.OMember;

public class VLogin {
	private Scanner scanner;
	private CLogin cLogin;

	public VLogin(Scanner scanner) {
		this.scanner = scanner;
		this.cLogin = new CLogin();
	}

	public void show() {
		System.out.println("�α��� ȭ���Դϴ�.");
		while (true) {
			System.out.print("���̵�(�й�) : ");
			String id = this.scanner.next();

			System.out.print("��й�ȣ : ");
			String pswd = this.scanner.next();

			OLogin oLogin = new OLogin(id, pswd);
			OMember oMember = this.cLogin.validate(oLogin);
			
			if (oMember == null) {
				System.out.println("ȸ�� ������ ã�� ���߽��ϴ�. �Է��� Ȯ�����ּ���.");
			} else {
				if (pswd.equals(oMember.getPswd())) {
					System.out.println(oMember.getName() + "�� ȯ���մϴ�.");
					System.out.println("�α��� ���� : " + oMember.toString() + " ��й�ȣ�� ǥ������ �ʽ��ϴ�.");
					break;
				} else {
					System.out.println("��й�ȣ�� ��ġ���� �ʽ��ϴ�.");
				}
			}
		}
	}

}
