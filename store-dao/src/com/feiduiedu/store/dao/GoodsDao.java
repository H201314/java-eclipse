package com.feiduiedu.store.dao;

import java.util.List;

public interface GoodsDao<T> {

	/**
	 * 保存T类型对象
	 * @param object
	 */
	void save(T object);
	
	void update(T object);
	
	void delete(T object);
	
	List<T> query();
	
	T findById(String id);
}
