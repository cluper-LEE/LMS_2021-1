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
		System.out.println("다음 기능을 선택하세요");
		System.out.println("로그인(1), 회원등록(2), 회원검색(3)");
		Scanner scanner = new Scanner(System.in);
		String input = scanner.next();
		if(input.equals("1")) {
			// login dialog
		} else if(input.equals("2")) {
			this.registration.show();
		} else if(input.equals("3")){
			this.memberSearch.show();
		}else {
		
			System.out.println("잘못 입력하셨습니다.");
		}
	}
}
