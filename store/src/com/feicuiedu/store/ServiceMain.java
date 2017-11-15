package com.feicuiedu.store;

import java.util.Scanner;

import com.feicuiedu.store.view.LoginView;

public class ServiceMain {

	public static void main(String[] args) {
		ServiceMain serviceMain = new ServiceMain();
		serviceMain.runService();
		
	}
	
	public void runService() {
		Scanner scanner = new Scanner(System.in);
		
		while(true) {
			LoginView loginView = new LoginView();
			loginView.showLogin();
			int loginSelected = scanner.nextInt();
			if (1 == loginSelected) {
				
			}
		}
	}

}
