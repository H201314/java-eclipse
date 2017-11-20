package com.feicuiedu.store.service;

import java.util.Scanner;

import com.feicuiedu.store.exception.ServiceException;
import com.feicuiedu.store.util.CommonUtils;

/**
 * 系统业务逻辑处理
 * 
 * @author 陈严
 */
public class SystemService extends BaseService{


	/**
	 * 处理登录判断
	 * 
	 * @param scanner
	 */
	public void login(Scanner scanner) {

		// 显示操作提示"请输入用户名:(想直接退出就输入exit)"
		System.out.print(CommonUtils.getPropValue("T001"));

		String userName = scanner.next();
		
		if ("exit".equals(userName)) {
			System.exit(0);
		}
		
		if ((!"admin".equals(userName))&&(!"exit".equals(userName))) {
			message = CommonUtils.getPropValue("E001");
			throw new ServiceException(message);
		}
		
		System.out.print(CommonUtils.getPropValue("T002"));
		String password = scanner.next();
		
		if ("exit".equals(password)) {
			System.exit(0);
		}
		if ((!"123456".equals(password))&&(!"exit".equals(password))) {
			message = CommonUtils.getPropValue("E002");
			throw new ServiceException(message);
		}

	}
}
