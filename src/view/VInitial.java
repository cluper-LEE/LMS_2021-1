package view;

import java.util.Scanner;

public class VInitial {
	private VRegistration registration;
	
	public VInitial() {
		this.registration = new VRegistration();
	}

	public void show() {
		System.out.println("다음 기능을 선택하세요");
		System.out.println("로그인(1), 회원등록(2)");
		Scanner scanner = new Scanner(System.in);
		String input = scanner.next();
		if(input.equals("1")) {
			// login dialog
		} else if(input.equals("2")) {
			this.registration.show();
		} else {
			System.out.println("잘못 입력하셨습니다.");
		}
	}
}
