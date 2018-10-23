package xyz.pigschool.content.service;

import xyz.pigschool.common.utils.XYZResult;
import xyz.pigschool.pojo.XyzContentCat;

public interface ContentCatService {
	/**
	 * 根据夫id查询子节点
	 * @param parentId 父id
	 * @return XYZResult类
	 */
	XYZResult getItemCatlist(long parentId);
	/**
	 * 插入菜单节点
	 * @param contentCat
	 * @return XYZResult类
	 */
	XYZResult insert(XyzContentCat contentCat);
	/**
	 * 修改菜单节点
	 * @param contentCat
	 * @return XYZResult类
	 */
	XYZResult edit(XyzContentCat contentCat);
	/**
	 * 删除节点 修改父类的字段
	 * @param parentId
	 * @param id
	 * @return
	 */
	XYZResult del(long parentId,long id);
}
