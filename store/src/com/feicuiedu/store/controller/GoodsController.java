package com.feicuiedu.store.controller;

import java.util.List;
import java.util.Scanner;

import com.feicuiedu.store.entity.Goods;
import com.feicuiedu.store.exception.ServiceException;
import com.feicuiedu.store.service.GoodsService;
import com.feicuiedu.store.util.CommonUtils;
import com.feicuiedu.store.view.GoodsView;

/**
 * 商品维护功能controller
 * 
 * @author 陈严
 *
 */
public class GoodsController {

	private GoodsView goodsView;

	private GoodsService goodsService;

	/**
	 * 商品维护相关功能
	 */
	public void chooseGoodsFunction(Scanner scanner) {

		goodsService = new GoodsService();
		goodsView = new GoodsView();

		while (true) {
			List<Goods> listGoods = goodsService.queryGoods();
			
			if(listGoods != null && !listGoods.isEmpty()) {
				
				goodsView.showGoodsList(listGoods);
			}
			
			goodsView.showGoodsFunction();
			
			int loginSelected = scanner.nextInt();

			try {
				if (1 == loginSelected) {

					while (true) {

						// 请输入新的商品信息(商品id#价格#库存#名称)
						System.out.print(CommonUtils.getPropValue("T003"));

						String strGoods = scanner.next();

						Goods goods = stringToGoods(strGoods);

						try {

							goodsService.saveGoods(goods);
							break;
						} catch (ServiceException e) {
							System.out.println(e.getMessage());
							continue;
						}

					}

					System.out.println(CommonUtils.getPropValue("M002"));

				} else if (2 == loginSelected) {
					while (true) {
						System.out.print(CommonUtils.getPropValue("T004"));

						String strGoods = scanner.next();
						Goods goods = stringToGoods(strGoods);
						try {

							goodsService.updateGoods(goods);
							break;
						} catch (ServiceException e) {
							System.out.println(e.getMessage());
							continue;
						}

					}

					System.out.println(CommonUtils.getPropValue("M003"));

				} else if (3 == loginSelected) {

					while (true) {
						System.out.print(CommonUtils.getPropValue("T005"));
						Integer goodsId = scanner.nextInt();
						try {

							Goods goods = new Goods();
							goods.setId(goodsId);
							goodsService.deleteGoods(goods);
							break;
						} catch (ServiceException e) {
							System.out.println(e.getMessage());
							continue;
						}
					}

					System.out.println(CommonUtils.getPropValue("M004"));

				} else if (4 == loginSelected) {

					Goods goods = null;
					while (true) {
						System.out.print(CommonUtils.getPropValue("T005"));
						Integer goodsId = scanner.nextInt();
						try {

							goods = goodsService.findById(goodsId);
							
							goodsView.showGoods(goods);
							break;
						} catch (ServiceException e) {
							System.out.println(e.getMessage());
							continue;
						}
					}

				}

				
			} catch (ServiceException e) {
				System.out.println(e.getMessage());
				continue;
			}
		}

	}

	/**
	 * 把用户输入的商品字符串"商品id#价格#库存#名称"转变成商品对象
	 * 
	 * @param strGoods
	 * @return
	 */
	private Goods stringToGoods(String strGoods) {

		// 商品id#价格#库存#名称
		Integer id = Integer.valueOf(strGoods.split("#")[0]);
		Double price = Double.valueOf(strGoods.split("#")[1]);
		Integer inventory = Integer.valueOf(strGoods.split("#")[2]);
		String name = strGoods.split("#")[3];

		return new Goods(id, price, inventory, name);
	}
}
