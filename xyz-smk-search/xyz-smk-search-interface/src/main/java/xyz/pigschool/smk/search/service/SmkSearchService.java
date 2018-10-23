package xyz.pigschool.smk.search.service;

import xyz.pigschool.common.utils.XYZResult;

public interface SmkSearchService {
	/**
	 * 根据数据库的xyz_item初始化solr索引库  collection1
	 * @return
	 */
	XYZResult initSmkSearch();
	
	/**
	 * 通过key查询
	 * @return
	 */
	XYZResult searchByKeys(String keyword, int page, int rows) throws Exception;
}
