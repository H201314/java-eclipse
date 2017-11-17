package com.feicuiedu.store.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import com.feicuiedu.store.entity.Goods;
import com.feicuiedu.store.exception.ServiceException;
import com.feicuiedu.store.util.CommonUtils;

/**
 * 
 * 商品操作文件
 * 
 * @author 陈严
 */
public class GoodsDao {

	private List<Goods> list;

	private File file;

	private ObjectOutputStream oos;

	private String message;

	private ObjectInputStream ois;

	public List<Goods> getList() {
		return list;
	}

	public GoodsDao() {

		this.file = new File("goods.data");
		try {
			if (file.length() != 0) {

				ois = new ObjectInputStream(new FileInputStream(file));

				list = (List<Goods>) ois.readObject();

				ois.close();
			}
			else {
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
	 * 
	 * 新增保存一个Goods对象到文件
	 * 
	 * @param goods
	 */
	public void save(Goods goods) {

		this.list.add(goods);

		this.update(goods);
	}
	
	public void update(Goods goods) {

		

		try {
			oos = new ObjectOutputStream(new FileOutputStream(file));
			oos.writeObject(list);
			oos.close();
		} catch (IOException e) {
			e.printStackTrace();
			message = CommonUtils.getPropValue("E003") + "|" + e.getMessage();
			throw new ServiceException(message);
		} finally {
			try {

				if (oos != null) {

					oos.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * 删除一个goods对象
	 * @param goods
	 */
	public void delete(Goods goods) {

		Goods delGoods = findById(goods.getId());
		
		if (delGoods!=null) {
			
			list.remove(delGoods);
		}

		try {
			oos = new ObjectOutputStream(new FileOutputStream(file));
			oos.writeObject(list);
			oos.close();
		} catch (IOException e) {
			e.printStackTrace();
			message = CommonUtils.getPropValue("E003") + "|" + e.getMessage();
			throw new ServiceException(message);
		} finally {
			try {
				if (oos != null) {

					oos.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * 查询出全部的goods对象
	 * @return
	 */
	public List<Goods> query() {

		return this.list;
	}

	/**
	 * 查询商品id值为传入id值的那个goods对象
	 * @param id
	 * @return
	 */
	public Goods findById(Integer id) {

		if (list != null) {
			
			for (Goods goods : list) {
				if (id.equals(goods.getId())) {
					return goods;
				}
			}
		}
		return null;
	}
}
