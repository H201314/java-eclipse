package com.feicuiedu.store.common.controller;

import java.util.Scanner;

import com.feicuiedu.store.common.exception.ServiceException;

public interface IController {

	public abstract String execute(Scanner scanner) throws ServiceException;
	
}
