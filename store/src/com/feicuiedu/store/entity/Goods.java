package com.feicuiedu.store.entity;

import java.io.Serializable;

public class Goods implements Serializable{

	private static final long serialVersionUID = -5194140204917718400L;

	//商品id
	private Integer id;
	
	// 价格
	private Double price;
	
	// 库存
	private Integer inventory;
	
	// 名称
	private String name;
	
	// 图片
	private String picIndex;
	
}
