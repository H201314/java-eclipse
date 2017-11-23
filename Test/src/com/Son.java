package com;

public class Son implements ISon {

	@Override
	public void execute() {
		System.out.println("execute 方法运行中");

	}
	
	@Override
	public void init() {
		System.out.println("Init 方法运行中");

	}

	@Override
	public void destory() {
		System.out.println("destory 方法运行中");
		
	}

}
