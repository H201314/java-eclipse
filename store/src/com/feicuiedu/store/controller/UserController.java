package com.feicuiedu.store.controller;

import java.util.List;
import java.util.Scanner;

import com.feicuiedu.store.common.exception.ServiceException;
import com.feicuiedu.store.common.util.CommonUtils;
import com.feicuiedu.store.entity.User;
import com.feicuiedu.store.service.UserService;
import com.feicuiedu.store.service.impl.UserServiceImpl;
import com.feicuiedu.store.view.UserView;

public class UserController extends BaseController {

	private UserView userView;
	private UserService userService;

	@Override
	public String execute(Scanner scanner) throws ServiceException {
		userService = new UserServiceImpl();
		userView = new UserView();
		//userService = new UserService();
		while (true) {
			
			// 获取所有商品对象集合
			List<User> listUser = userService.queryUser();
			
			// 如果集合中有商品
			if (listUser != null && !listUser.isEmpty()) {
				
				// 按照格式显示商品清单
				userView.showUserList(listUser);
			}
			
			// 显示 1.新增商品 * 2.修改商品 * 3.删除商品 * 4.查看商品详情 5.返回上一级 6.退出
			userView.showUserFunction();
			int loginSelected = scanner.nextInt();
			
			try {
				
				
				if (1 == loginSelected) {
					
					while (true) {
						
						// 请输入新的商品信息(价格#库存#名称)
						System.out.print(CommonUtils.getPropValue("T003"));
						
						
						
						try {
							String name = scanner.next();
							
							User user  = new User();
							user.setName(name);
							userService.saveUser(user);
							break;
						} catch (ServiceException e) {
							System.out.println(e.getMessage());
							continue;
						}
						
					}
					
					System.out.println(CommonUtils.getPropValue("M002"));
					
				}
				
				
			} catch (ServiceException e) {
				System.out.println(e.getMessage());
				continue;
			}
		}
		
	}

}
