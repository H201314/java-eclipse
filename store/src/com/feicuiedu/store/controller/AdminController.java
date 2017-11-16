package com.feicuiedu.store.controller;

import java.util.Scanner;

import com.feicuiedu.store.view.AdminView;

public class AdminController {

	private AdminView adminView;

	public String chooseFunction() {
		
		adminView = new AdminView();
		adminView.showAdminFunction();
		
		Scanner scanner = new Scanner(System.in);
		
		int loginSelected = scanner.nextInt();
		
		String result = null;
		if (1 == loginSelected) {
			result = "goodsMaintain";
		}
		else if (1 == loginSelected) {
			result = "userMaintain";
		}
		return result;
	}
}
