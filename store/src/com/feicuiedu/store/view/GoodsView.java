package com.feicuiedu.store.view;

import java.util.List;

import com.feicuiedu.store.common.util.CommonUtils;
import com.feicuiedu.store.entity.Goods;

public class GoodsView {
	
	/**
	 * 按照id:${id}|价格:${price}|名称:${name}|库存:${inventory} 格式显示一个商品的内容
	 * @param goods
	 */
	public void showGoods(Goods goods) {
		String str = CommonUtils.getStringFromText("goods_model.txt");
		
		str = str.replace("${id}", goods.getId()+"")
				.replace("${name}", goods.getName())
				.replace("${price}", goods.getPrice()+"")
				.replace("${inventory}", goods.getInventory()+"");
		
		System.out.println(str);
	}
	
	/**
	 * 按照规定格式显示List<Goods>中的商品内容
	 * @param list
	 */
	public void showGoodsList(List<Goods> list) {
		
		for (Goods goods : list) {
			showGoods(goods);
		}
	}
	
	/**
	 * 显示商品维护中功能清单
	 */
	public void showGoodsFunction() {
		CommonUtils.printText("goods_function.txt");
	}
	
	
}
