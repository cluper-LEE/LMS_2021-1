package view;

import java.util.Scanner;

import control.CRegistration;
import valueObject.OMember;

public class VRegistration {
	private CRegistration cRegistration;
	
	public VRegistration() {
		this.cRegistration = new CRegistration();
	}

	public void show() {
		System.out.println("ȸ������� �����մϴ�. VRegistration::show");
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("�̸� : ");
		String name = scanner.next();
		
		System.out.print("�й� : ");
		String id = scanner.next();
		
		System.out.print("�а� : ");
		String department = scanner.next();
		
		System.out.print("�ּ� : ");
		scanner.nextLine();
		String address = scanner.nextLine();
		
		String pswd;
		while(true) {
			System.out.print("��й�ȣ : ");
			pswd = scanner.next();
			System.out.print("��й�ȣ Ȯ�� : ");
			if(pswd.equals(scanner.next())) {
				break;
			}else {
				System.out.println("��ġ���� �ʽ��ϴ�. �ٽ� �Է��ϼ���.");
			}
		}
		
		
		
		
		OMember oMember = new OMember(id, name, address, department, pswd);
		// ������ �Է� �޾� oMember�� ����
		
		
		this.cRegistration.saveMember(oMember);
	}
	
	
}
