package com.feicuiedu.store.controller;

import java.util.Scanner;

import com.feicuiedu.store.view.AdminView;

/**
 * 功能选择菜单
 * @author 陈严
 *
 */
public class AdminController {

	private AdminView adminView;

	public String chooseFunction(Scanner scanner) {
		
		adminView = new AdminView();
		adminView.showAdminFunction();
		
		
		int loginSelected = scanner.nextInt();
		
		String result = null;
		if (1 == loginSelected) {
			result = "goodsMaintain";
		}
		else if (2 == loginSelected) {
			result = "userMaintain";
		}
		return result;
	}
}
