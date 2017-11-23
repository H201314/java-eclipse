package com.feiduiedu.store.dao;

import java.util.List;

public interface UserDao<T> {

	void save(T object);
	
	void update(T object);
	
	void delete(T object);
	
	List<T> query();
	
	T findById(T Object);
}
