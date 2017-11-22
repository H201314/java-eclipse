package com.feicuiedu.store.view;

import java.util.List;

import com.feicuiedu.store.common.util.CommonUtils;
import com.feicuiedu.store.entity.Goods;
import com.feicuiedu.store.entity.User;

public class UserView {

	public void showUser(User user) {
		String str = CommonUtils.getStringFromText("user_model.txt");
		
		str = str.replace("${id}", user.getId()+"")
				.replace("${name}", user.getName());
		
		System.out.println(str);
	}
	
	/**
	 * 按照规定格式显示List<Goods>中的商品内容
	 * @param list
	 */
	public void showUserList(List<User> list) {
		
		for (User user : list) {
			showUser(user);
		}
	}
	
	/**
	 * 显示商品维护中功能清单
	 */
	public void showUserFunction() {
		CommonUtils.printText("user_function.txt");
	}
}
