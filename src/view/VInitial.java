package view;

import java.util.Scanner;

public class VInitial {
	private Scanner scanner;
	private VRegistration registration;
	private VLogin login;

	public VInitial(Scanner scanner) {
		this.scanner = scanner;
		this.registration = new VRegistration(scanner);
		this.login = new VLogin(scanner);

	}

	public void show() {
		System.out.println("다음 기능을 선택하세요");
		
		while (true) {
			System.out.println("로그인(1), 회원등록(2), 종료(0)");
			String input = this.scanner.next();
			if (input.equals("1")) {
				this.login.show();
				break;
			} else if (input.equals("2")) {
				this.registration.show();
				this.login.show();
				break;
			}else if(input.equals("0")){
				System.out.println("프로그램을 종료합니다.");
				break;
			} else {
				System.out.println("잘못된 입력입니다.");
			}
		}
	}
}
