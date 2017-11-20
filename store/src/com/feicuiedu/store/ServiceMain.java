package com.feicuiedu.store;

import java.util.Scanner;

import com.feicuiedu.store.controller.BaseController;
import com.feicuiedu.store.controller.LoginController;
import com.feicuiedu.store.util.CommonUtils;

/**
 * 运行蕾
 * @author 陈严
 *
 */
public class ServiceMain {

	public static void main(String[] args) {
		ServiceMain serviceMain = new ServiceMain();
		serviceMain.runService();

	}

	/**
	 * 运行业务
	 */
	public void runService() {
		
		// 创建登录的contller
		LoginController loginController = new LoginController();
		
		// 定义人机交互的对象
		Scanner scanner = new Scanner(System.in);
		
		// 根据login字符串 处理登录业务
		BaseController controller = (BaseController) CommonUtils.getObjectFromProp("login");	
		String result = controller.execute(scanner);
		
		// 执行登录操作
		result = loginController.execute(scanner);
		
		//登录成功后选择的业务 商品维护  用户维护
		controller = (BaseController) CommonUtils.getObjectFromProp(result);
		result = controller.execute(scanner);
		
		
		// 商品维护 或者用户维护选择后的操作
		controller = (BaseController) CommonUtils.getObjectFromProp(result);
		result = controller.execute(scanner);
		
		scanner.close();

	}

}
