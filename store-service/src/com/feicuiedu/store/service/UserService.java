package com.feicuiedu.store.service;

import java.util.List;

import com.feicuiedu.store.common.exception.ServiceException;
import com.feicuiedu.store.entity.User;

public interface UserService {
	
	public void saveUser(User user) throws ServiceException;
	public void updateUser(User user) throws ServiceException;
	public void deleteUser(User user) throws ServiceException;
	public List<User> queryUser() throws ServiceException;
}
