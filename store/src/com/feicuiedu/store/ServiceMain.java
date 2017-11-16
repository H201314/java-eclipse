package com.feicuiedu.store;

import java.util.Scanner;

import com.feicuiedu.store.controller.LoginController;
import com.feicuiedu.store.exception.ServiceException;
import com.feicuiedu.store.view.LoginView;

public class ServiceMain {

	public static void main(String[] args) {
		ServiceMain serviceMain = new ServiceMain();
		serviceMain.runService();

	}

	public void runService() {
		Scanner scanner = new Scanner(System.in);

		while (true) {
			LoginView loginView = new LoginView();

			loginView.showLogin();

			int loginSelected = scanner.nextInt();
			if (1 == loginSelected) {
				LoginController loginController = new LoginController();

				try {

					loginController.login(scanner);
					
					
				} catch (ServiceException e) {
					System.out.println(e.getMessage());
					continue;
				}
			} else if (2 == loginSelected) {
				continue;
			}
		}

		// scanner.close();
	}

}
