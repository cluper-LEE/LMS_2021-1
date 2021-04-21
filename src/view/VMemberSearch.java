package view;

import java.util.Scanner;

import control.CRegistration;

public class VMemberSearch {
	private CRegistration cRegistration;

	public VMemberSearch() {
		this.cRegistration = new CRegistration();

	}
	
	public void show() {
		System.out.println("VMemberSearch::show");
		System.out.print("ÇÐ¹ø : ");
		Scanner scanner = new Scanner(System.in);
		String id = scanner.next();
		
		this.cRegistration.findMemberById(id);
	}

}
