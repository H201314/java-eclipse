package com.feicuiedu.store;

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
		String result = null;
		
			
		result = loginController.login();
		
		
		if ("register".equals(result)) {
			
		}
		else if ("admin".equals(result)) {
			
			result = new AdminController().chooseFunction();
		}
		
		if ("goodsMaintain".equals(result)) {
			new GoodsController().chooseGoodsFunction();
		}
		else if ("userMaintain".equals(result)) {
			
		}

	}

}
