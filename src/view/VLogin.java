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
		System.out.println("로그인 화면입니다.");
		
		System.out.print("아이디 : ");
		String id = this.scanner.next();
		
		System.out.print("비밀번호 : ");
		String pswd = this.scanner.next();
		
		OMember oMember = cRegistration.findMemberById(id);
		if(oMember == null) {
			System.out.println("회원 정보를 찾지 못했습니다. 입력을 확인해주세요.");
		}else {
			
			if(pswd.equals(oMember.getPswd())) {			
				System.out.println(oMember.getName() + "님 환영합니다.");
				System.out.println("로그인 정보 : " + oMember.toString() + " 비밀번호는 표시하지 않습니다.");
			}else {
				System.out.println("비밀번호가 일치하지 않습니다.");
			}
		}
	}

}
