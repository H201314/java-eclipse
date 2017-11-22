package com.feicuiedu.store.service;

import java.util.List;

import com.feicuiedu.store.common.exception.ServiceException;
import com.feicuiedu.store.entity.Goods;


public interface GoodsService {

	public void saveGoods(Goods goods) throws ServiceException;
	public void updateGoods(Goods goods) throws ServiceException ;
	
	public void deleteGoods(Goods goods) throws ServiceException;
	public List<Goods> queryGoods() throws ServiceException;
	public Goods findById(String id) throws ServiceException;
}
