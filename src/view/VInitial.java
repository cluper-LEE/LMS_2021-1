package view;

import java.util.Scanner;

public class VInitial {
	private VRegistration registration;
	
	public VInitial() {
		this.registration = new VRegistration();
	}

	public void show() {
		System.out.println("���� ����� �����ϼ���");
		System.out.println("�α���(1), ȸ�����(2)");
		Scanner scanner = new Scanner(System.in);
		String input = scanner.next();
		if(input.equals("1")) {
			// login dialog
		} else if(input.equals("2")) {
			this.registration.show();
		} else {
			System.out.println("�߸� �Է��ϼ̽��ϴ�.");
		}
	}
}
