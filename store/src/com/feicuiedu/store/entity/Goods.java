package com.feicuiedu.store.entity;

import java.io.Serializable;

/**
 * 商品
 * @author 陈严
 *
 */
public class Goods implements Serializable {

	public Goods() {
		super();
	}

	public Goods(Integer id, Double price, Integer inventory, String name, String picIndex) {
		super();
		this.id = id;
		this.price = price;
		this.inventory = inventory;
		this.name = name;
		this.picIndex = picIndex;
	}

	public Goods(Integer id, Double price, Integer inventory, String name) {
		super();
		this.id = id;
		this.price = price;
		this.inventory = inventory;
		this.name = name;
	}
	
	private static final long serialVersionUID = -5194140204917718400L;

	// 商品id
	private Integer id;

	// 价格
	private Double price;

	// 库存
	private Integer inventory;

	// 名称
	private String name;

	// 图片
	private String picIndex;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getInventory() {
		return inventory;
	}

	public void setInventory(Integer inventory) {
		this.inventory = inventory;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPicIndex() {
		return picIndex;
	}

	public void setPicIndex(String picIndex) {
		this.picIndex = picIndex;
	}

}
