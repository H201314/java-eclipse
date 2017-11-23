package com.feicuiedu.store.dao.impl;

import java.util.List;

import com.feicuiedu.store.common.dao.BaseDao;
import com.feicuiedu.store.entity.User;
import com.feiduiedu.store.dao.UserDao;

public class UserDaoImpl extends BaseDao<User> implements UserDao<User> {

	public UserDaoImpl(String fileName) {
		super(fileName);
	}

	@Override
	public void save(User object) {
		
	}

	@Override
	public void update(User object) {
		
	}

	@Override
	public void delete(User object) {
		
	}

	@Override
	public List<User> query() {
		return null;
	}

	@Override
	public User findById(User Object) {
		return null;
	}

}
