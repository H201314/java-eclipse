package com.feicuiedu.store.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;
import java.util.UUID;

import com.feicuiedu.store.controller.BaseController;

/**
 * 工具类
 * @author 陈严
 *
 */
public class CommonUtils {

	
	/**
	 * 项目根目录下读取fileName名称的文件里的内容并println出来
	 * 
	 * @param fileName
	 *            文件名称
	 */
	public static void printText(String fileName) {

		try {
			InputStream is = CommonUtils.class.getClassLoader().getResourceAsStream(fileName);
			
			InputStreamReader isr = new InputStreamReader(is);
			
			BufferedReader br = new BufferedReader(isr);
			

			String strLine = null;
			while ((strLine = br.readLine()) != null) {
				System.out.println(strLine);
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 项目根目录下读取fileName名称的文件里的内容并把字符串返回
	 * @param fileName 文件名称
	 * @return String  fileName里面的字符串
	 */
	public static String getStringFromText(String fileName) {
		StringBuilder sb = new StringBuilder();
		File file = new File(fileName);
		try {
			
			InputStream is = CommonUtils.class.getClassLoader().getResourceAsStream(fileName);
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);

			String strLine = null;
			while ((strLine = br.readLine()) != null) {
				sb.append(strLine).append("\n");
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return sb.toString();
	}
	/**
	 * 根据键获取配置文件值
	 * @param key 键字符串
	 * @return
	 */
	public static String getPropValue(String key) {

		//File file = new File("config.properties");

		InputStream is = CommonUtils.class.getClassLoader().getResourceAsStream("config.properties");
		
		Properties prop = new Properties();
		try {
			prop.load(is);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return prop.getProperty(key);
	}
	
	/**
	 * 随机生成UUID字符串
	 * @return
	 */
	public static String getUUID() {
		UUID uuid = UUID.randomUUID();
		
		return uuid.toString();
	}
	
	/**
	 * 根据key读取config.properties文件中反射配置的部分获取类的字符串返回对象
	 * @param key
	 * @return
	 */
	public static Object getObjectFromProp(String key) {
		Object obj = null;
		try {
			obj = Class.forName("classStr").newInstance();
			
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return obj;
	}
		
	public static void main(String[] args) {
		System.out.println(getUUID());
	}

}
