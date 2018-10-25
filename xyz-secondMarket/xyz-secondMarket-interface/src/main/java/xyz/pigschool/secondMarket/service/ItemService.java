package xyz.pigschool.secondMarket.service;

import xyz.pigschool.common.utils.XYZResult;
import xyz.pigschool.pojo.XyzItem;

public interface ItemService {
	/**
	 * 添加商品
	 * @param item
	 * @return
	 */
	XYZResult insert(XyzItem item);
	/**
	 * 通过id删除商品
	 * @param id
	 * @return
	 */
	XYZResult del(Long[] id);
	/**
	 * 查询数据 返回 List<XyzItem>
	 * @param page
	 * @param rows
	 * @param param
	 * @return
	 */
	XYZResult getItemlist(int page, int rows, String param);
	/**
	 * 通过商品id返回 itemDec类
	 * itemDec为xyzitem的子类
	 * @param itemId id
	 * @return
	 */
	XYZResult getItemById(long itemId);
}
