package xyz.pigschool.service;

import xyz.pigschool.common.utils.XYZResult;
import xyz.pigschool.pojo.XyzItemCat;

public interface ItemCatService {
	XYZResult getItemCatlist(long parentId);
	XYZResult insert(XyzItemCat itemCat);
	XYZResult edit(XyzItemCat itemCat);
	XYZResult del(long parentId,long id);
}
