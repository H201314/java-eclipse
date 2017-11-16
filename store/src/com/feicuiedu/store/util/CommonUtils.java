package com.feicuiedu.store.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

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

		File file = new File(fileName);
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));

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
			BufferedReader br = new BufferedReader(new FileReader(file));

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

		File file = new File("config.properties");

		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream(file));
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return prop.getProperty(key);
	}

	public static void main(String[] args) {
		CommonUtils.printText("login.txt");
	}
}
