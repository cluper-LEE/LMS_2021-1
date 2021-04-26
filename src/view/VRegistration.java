package view;

import java.util.Scanner;

import control.CRegistration;
import valueObject.OMember;

public class VRegistration {
	private Scanner scanner;
	private CRegistration cRegistration;
	
	public VRegistration(Scanner scanner) {
		this.scanner = scanner;
		this.cRegistration = new CRegistration();
	}

	public void show() {
		System.out.println("ȸ������� �����մϴ�.");
		
		System.out.print("�̸� : ");
		String name = this.scanner.next();
		
		System.out.print("�й� : ");
		String id = this.scanner.next();
		
		System.out.print("�а� : ");
		String department = this.scanner.next();
		
		System.out.print("�ּ� : ");
		this.scanner.nextLine();
		String address = this.scanner.nextLine();
		
		String pswd;
		while(true) {
			System.out.print("��й�ȣ : ");
			pswd = this.scanner.next();
			System.out.print("��й�ȣ Ȯ�� : ");
			if(pswd.equals(this.scanner.next())) {
				break;
			}else {
				System.out.println("��ġ���� �ʽ��ϴ�. �ٽ� �Է��ϼ���.");
			}
		}
		
		OMember oMember = new OMember(id, name, address, department, pswd);
		// ������ �Է� �޾� oMember�� ����
		// oMember�� ��Ʈ�ѷ��� ����.
		this.cRegistration.saveMember(oMember);
	}
	
	
}
