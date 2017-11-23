package com.feicuiedu.store.controller;

import java.util.Scanner;

import com.feicuiedu.store.common.controller.impl.BaseController;
import com.feicuiedu.store.view.AdminView;

/**
 * 功能选择菜单
 * @author 陈严
 *
 */
public class AdminController extends BaseController{

	private AdminView adminView;

	/**
	 * 用户选择使用的功能 
	 * @param scanner
	 * @return String  goodsMaintain表示商品维护 userMaintain 用户维护
	 */
	@Override
	public String execute(Scanner scanner) {
		
		adminView = new AdminView();
		adminView.showAdminFunction();
		
		
		int loginSelected = scanner.nextInt();
		
		String result = null;
		if (1 == loginSelected) {
			result = "goodsMaintain";
		}
		else if (2 == loginSelected) {
			result = "userMaintain";
		}
		return result;
	}
}
