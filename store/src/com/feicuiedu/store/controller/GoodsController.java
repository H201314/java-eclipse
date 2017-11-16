package com.feicuiedu.store.controller;

import java.util.Scanner;

import com.feicuiedu.store.entity.Goods;
import com.feicuiedu.store.exception.ServiceException;
import com.feicuiedu.store.service.GoodsService;
import com.feicuiedu.store.util.CommonUtils;
import com.feicuiedu.store.view.GoodsView;

public class GoodsController {

	private GoodsView goodsView;

	private GoodsService goodsService;

	public void chooseGoodsFunction() {

		Scanner scanner = new Scanner(System.in);
		goodsService = new GoodsService();
		goodsView = new GoodsView();
		

		while (true) {
			
			goodsView.showGoodsFunction();

			int loginSelected = scanner.nextInt();
			
			try {
				if (1 == loginSelected) {

					System.out.print(CommonUtils.getPropValue("T003"));

					String strGoods = scanner.next();

					Goods goods = stringToGoods(strGoods);

					goodsService.saveOrUpdateGoods(goods);

					System.out.print(CommonUtils.getPropValue("M002"));


				} else if (2 == loginSelected) {
					
					System.out.print(CommonUtils.getPropValue("T004"));
					
					System.out.print(CommonUtils.getPropValue("M003"));

				} else if (3 == loginSelected) {
					
					System.out.print(CommonUtils.getPropValue("T004"));
					
					System.out.print(CommonUtils.getPropValue("M004"));

				} else if (4 == loginSelected) {
					
					System.out.print(CommonUtils.getPropValue("T004"));
					
				}
				
				break;
			} catch (ServiceException e) {
				System.out.println(e.getMessage());
				continue;
			}
		}
		
	}

	private Goods stringToGoods(String strGoods) {
		// 商品id#价格#库存#名称
		Integer id = Integer.valueOf(strGoods.split("#")[0]);
		Double price = Double.valueOf(strGoods.split("#")[1]);
		Integer inventory = Integer.valueOf(strGoods.split("#")[2]);
		String name = strGoods.split("#")[3];

		return new Goods(id, price, inventory, name);
	}
}
