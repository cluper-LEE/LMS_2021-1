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
		System.out.println("회원등록을 시작합니다. VRegistration::show");
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("이름 : ");
		String name = scanner.next();
		
		System.out.print("학번 : ");
		String id = scanner.next();
		
		System.out.print("학과 : ");
		String department = scanner.next();
		
		System.out.print("주소 : ");
		scanner.nextLine();
		String address = scanner.nextLine();
		
		
		OMember oMember = new OMember(id, name, address, department);
		// 데이터 입력 받아 oMember에 저장
		
		
		this.cRegistration.saveMember(oMember);
	}
	
	
}
