package com.feicuiedu.store.dao;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
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
public class GoodsDao extends BaseDao<Goods>{


	/**
	 * 构造方法
	 * 
	 */
	public GoodsDao() {
		super("goods.data");
	}

	/**
	 * 
	 * 新增保存一个Goods对象到文件
	 * 
	 * @param goods
	 */
	@Override
	public void save(Goods goods) {
		goods.setId(CommonUtils.getUUID());
		this.list.add(goods);

		this.update(goods);
	}
	
	/**
	 * 更新数据文件中的goods对象 
	 * @param goods
	 */
	@Override
	public void update(Goods goods) {
		
		// 根据id取出旧的goods对象，把用户输入的数据更换到旧的goods对象中去
		for (Goods tmpGoods : list) {
			if (tmpGoods.getId().equals(goods.getId())) {
				tmpGoods.setInventory(goods.getInventory());
				tmpGoods.setName(goods.getName());
				tmpGoods.setPrice(goods.getPrice());
				
				break;
			}
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
	 * 删除一个goods对象
	 * @param goods
	 */
	@Override
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
	 * 查询出全部的goods对象集合
	 * @return List<Goods>
	 */
	@Override
	public List<Goods> query() {

		return this.list;
	}

	/**
	 * 查询商品id值为传入id值的那个goods对象
	 * @param id
	 * @return
	 */
	public Goods findById(String id) {

		if (list != null) {
			
			for (Goods goods : list) {
				if (id.equals(goods.getId())) {
					return goods;
				}
			}
		}
		return null;
	}
	
	/**
	 * 根据给定的Goods对象，根据它的id来判断是不是在数据文件中存在，如果存在，则返回数据文件的对象
	 * @param goods
	 * @return
	 */
	@Override
	public Goods findById(Goods goods) {

		if (list != null) {
			
			for (Goods tmpGoods : list) {
				if (goods.getId().equals(tmpGoods.getId())) {
					return tmpGoods;
				}
			}
		}
		return null;
	}

}
