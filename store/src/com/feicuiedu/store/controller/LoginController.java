package com.feicuiedu.store.controller;

import java.util.Scanner;

import com.feicuiedu.store.exception.ServiceException;
import com.feicuiedu.store.util.CommonUtils;

public class LoginController {
	
	private String message;
	
	public void login(Scanner scanner) throws ServiceException{
		
		System.out.print("请输入用户名:");
		String userName = scanner.nextLine();
		if (!"admin".equals(userName)) {
			message = CommonUtils.getPropValue("E001");
			throw new ServiceException(message);
		}
		
		System.out.print("请输入密码:");
		String password = scanner.nextLine();
		if (!"123456".equals(password)) {
			message = CommonUtils.getPropValue("E002");
			throw new ServiceException(message);
		}
		
		System.out.print(CommonUtils.getPropValue("M001"));
	}
	
}
