package com.feicuiedu.store.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import com.feicuiedu.store.exception.ServiceException;
import com.feicuiedu.store.util.CommonUtils;

/**
 * 
 * 所有DAO的基类
 * @author 陈严
 *
 * @param <T> 操作的实体类型
 */
public abstract class BaseDao<T> {

	protected List<T> list;

	protected File file;

	protected ObjectOutputStream oos;

	protected String message;

	protected ObjectInputStream ois;

	public BaseDao(String fileName) {
		// 初始化数据文件对象
		this.file = new File(fileName);
		try {

			// 判断数据文件是否为空，如果为空，则初始化list对象，如果不为空，则从数据文件中读取对象到list中
			if (file.length() != 0) {

				ois = new ObjectInputStream(new FileInputStream(file));

				list = (List<T>) ois.readObject();

				ois.close();
			} else {
				list = new ArrayList<>();
			}
		} catch (IOException e) {
			e.printStackTrace();
			message = CommonUtils.getPropValue("E003") + "|" + e.getMessage();
			throw new ServiceException(message);
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
			message = CommonUtils.getPropValue("E004") + "|" + e.getMessage();

			throw new ServiceException(message);
		} finally {
			try {

				if (ois != null) {

					ois.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * 返回list资料清单
	 * 
	 * @return
	 */
	public List<T> getList() {
		return list;
	}
	
	/**
	 * 保存T类型对象
	 * @param object
	 */
	public abstract void save(T object);
	
	public abstract void update(T object);
	
	public abstract void delete(T object);
	
	public abstract List<T> query();
	
	public abstract T findById(T Object);
}
