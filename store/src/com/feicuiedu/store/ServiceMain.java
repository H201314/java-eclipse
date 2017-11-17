package com.feicuiedu.store;

import java.util.Scanner;

import com.feicuiedu.store.controller.AdminController;
import com.feicuiedu.store.controller.GoodsController;
import com.feicuiedu.store.controller.LoginController;

public class ServiceMain {

	public static void main(String[] args) {
		ServiceMain serviceMain = new ServiceMain();
		serviceMain.runService();

	}

	public void runService() {
		LoginController loginController = new LoginController();
		Scanner scanner = new Scanner(System.in);
		
		String result = null;
			
		result = loginController.login(scanner);
		
		
		if ("register".equals(result)) {
			
		}
		else if ("admin".equals(result)) {
			
			result = new AdminController().chooseFunction(scanner);
		}
		
		if ("goodsMaintain".equals(result)) {
			new GoodsController().chooseGoodsFunction(scanner);
		}
		else if ("userMaintain".equals(result)) {
			
		}
		
		scanner.close();

	}

}
