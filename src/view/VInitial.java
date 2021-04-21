package view;

import java.util.Scanner;

public class VInitial {
	private VRegistration registration;
	private VMemberSearch memberSearch;
	
	public VInitial() {
		this.registration = new VRegistration();
		this.memberSearch = new VMemberSearch();
	}

	public void show() {
		System.out.println("���� ����� �����ϼ���");
		System.out.println("�α���(1), ȸ�����(2), ȸ���˻�(3)");
		Scanner scanner = new Scanner(System.in);
		String input = scanner.next();
		if(input.equals("1")) {
			// login dialog
		} else if(input.equals("2")) {
			this.registration.show();
		} else if(input.equals("3")){
			this.memberSearch.show();
		}else {
		
			System.out.println("�߸� �Է��ϼ̽��ϴ�.");
		}
	}
}
