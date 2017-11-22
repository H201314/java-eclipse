package com.feicuiedu.store.controller;

import java.util.Scanner;

import com.feicuiedu.store.common.exception.ServiceException;

/**
 * 公共Controller
 * @author 陈严
 *
 */
public abstract class BaseController {

	public abstract String execute(Scanner scanner) throws ServiceException;
	
	
}
