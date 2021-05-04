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
		System.out.println("로그인 화면입니다.");
		while (true) {
			System.out.print("아이디(학번) : ");
			String id = this.scanner.next();

			System.out.print("비밀번호 : ");
			String pswd = this.scanner.next();

			OLogin oLogin = new OLogin(id, pswd);
			OMember oMember = this.cLogin.validate(oLogin);
			
			if (oMember == null) {
				System.out.println("회원 정보를 찾지 못했습니다. 입력을 확인해주세요.");
			} else {
				if (pswd.equals(oMember.getPswd())) {
					System.out.println(oMember.getName() + "님 환영합니다.");
					System.out.println("로그인 정보 : " + oMember.toString() + " 비밀번호는 표시하지 않습니다.");
					break;
				} else {
					System.out.println("비밀번호가 일치하지 않습니다.");
				}
			}
		}
	}

}
