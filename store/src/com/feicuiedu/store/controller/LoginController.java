package com.feicuiedu.store.controller;

import java.util.Scanner;

import com.feicuiedu.store.exception.ServiceException;
import com.feicuiedu.store.service.SystemService;
import com.feicuiedu.store.util.CommonUtils;
import com.feicuiedu.store.view.LoginView;

public class LoginController {

	private LoginView loginView;
	private SystemService systemService;

	public String login() throws ServiceException {
		Scanner scanner = new Scanner(System.in);
		systemService = new SystemService();
		loginView = new LoginView();
		loginView.showLogin();
		int loginSelected = scanner.nextInt();
		String result = null;
		
		while (true) {

			
			if (1 == loginSelected) {

				try {

					systemService.login(scanner);
				} catch (ServiceException e) {
					System.out.println(e.getMessage());
					continue;
				}

				System.out.print(CommonUtils.getPropValue("M001"));

				result = "admin";

			} else if (2 == loginSelected) {
				result = "register";

			}

			break;
		}

		scanner.close();
		return result;
	}

}
