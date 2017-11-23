package com;

public class SonProxy implements IParent{

	private ISon son;
	
	
	public SonProxy(ISon son) {
		super();
		this.son = son;
	}


	
	@Override
	public void execute() {
		
		son.init();
		son.execute();
		son.destory();
	}

	

}
