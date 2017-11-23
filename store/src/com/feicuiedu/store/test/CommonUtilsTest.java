package com.feicuiedu.store.test;

import com.feicuiedu.store.common.util.CommonUtils;
import com.feicuiedu.store.service.GoodsService;

public class CommonUtilsTest {

	public static void main(String[] args) {
		
				String className =CommonUtilsTest.class.getSimpleName();
				String packName= CommonUtils.getPropValue("servicePackage");
				Object obj = null;
				System.out.println(packName+className);
				/*try {
					
					// 通过类的全名(含有包名)创建类的一个实例对象
					obj = Class.forName(packName+className).newInstance();
					
				} catch (InstantiationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}*/
	}
	
	public void test(Class objClass) {
		System.out.println(this.getClass().getSimpleName());
	}
	
}
