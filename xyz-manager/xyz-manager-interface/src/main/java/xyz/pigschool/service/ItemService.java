package xyz.pigschool.service;

import xyz.pigschool.common.utils.XYZResult;
import xyz.pigschool.pojo.XyzItem;

public interface ItemService {
	XYZResult insert(XyzItem item);
	XYZResult del(Long[] id);
	XYZResult getItemlist(int page, int rows, String param);
}
