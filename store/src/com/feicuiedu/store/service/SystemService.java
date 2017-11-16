package com.feicuiedu.store.service;

import java.util.Scanner;

import com.feicuiedu.store.exception.ServiceException;
import com.feicuiedu.store.util.CommonUtils;

public class SystemService {
	private String message;
	
	public void login(Scanner scanner) {
		System.out.print(CommonUtils.getPropValue("T001"));
		String userName = scanner.next();
		if (!"admin".equals(userName)) {
			message = CommonUtils.getPropValue("E001");
			throw new ServiceException(message);
		}

		System.out.print(CommonUtils.getPropValue("T002"));
		String password = scanner.next();
		if (!"123456".equals(password)) {
			message = CommonUtils.getPropValue("E002");
			throw new ServiceException(message);
		}

	}
}
