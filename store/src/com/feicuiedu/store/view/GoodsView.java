package com.feicuiedu.store.view;

import java.util.List;

import com.feicuiedu.store.entity.Goods;
import com.feicuiedu.store.util.CommonUtils;

public class GoodsView {
	
	public void showGoods(Goods goods) {
		String str = CommonUtils.getStringFromText("goods_model.txt");
		
		str = str.replace("${id}", goods.getId()+"")
				.replace("${name}", goods.getName())
				.replace("${price}", goods.getPrice()+"")
				.replace("${inventory}", goods.getInventory()+"");
		
		System.out.println(str);
	}
	
	public void showGoodsList(List<Goods> list) {
		
		for (Goods goods : list) {
			showGoods(goods);
		}
	}
	public void showGoodsFunction() {
		CommonUtils.printText("goods_function.txt");
	}
	
	
}
