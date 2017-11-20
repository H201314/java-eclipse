package com.feicuiedu.store.controller;

import java.util.Scanner;

import com.feicuiedu.store.exception.ServiceException;
import com.feicuiedu.store.service.SystemService;
import com.feicuiedu.store.util.CommonUtils;
import com.feicuiedu.store.view.LoginView;

/**
 * 登录controller
 * 
 * @author 陈严
 *
 */
public class LoginController extends BaseController{

	private LoginView loginView;
	private SystemService systemService;

	/**
	 * 登录的相关流程
	 * 
	 * @return
	 * @throws ServiceException
	 */
	@Override
	public String execute(Scanner scanner) throws ServiceException {
		

		systemService = new SystemService();

		loginView = new LoginView();
		loginView.showLogin();
		int loginSelected = scanner.nextInt();
		String result = null;

		// 选择了登录
		if (1 == loginSelected) {

			while (true) {

				try {

					systemService.login(scanner);
					
					// 显示 “登录成功!”信息
					System.out.println(CommonUtils.getPropValue("M001"));
					break;
				} catch (ServiceException e) {
					System.out.println(e.getMessage());
					continue;
				}

			}
			
			result = "admin";
		}
		// 选择了注册
		else if (2 == loginSelected) {
			result = "register";

		}
		// 选择了退出
		else if (3 == loginSelected) {
			System.exit(0);
		}

		return result;
	}

}
