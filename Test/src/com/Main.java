package com;

public class Main {

	public static void main(String[] args) {
		ISon son = new Son();
		
		IParent proxy = new SonProxy(son);
		proxy.execute();
	}
}
