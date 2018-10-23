package xyz.pigschool.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import xyz.pigschool.common.utils.XYZResult;
import xyz.pigschool.smk.search.service.SmkSearchService;

/**
 * 内容管理Controller
 * <p>Title: ItemCatController</p>
 * <p>Description: </p>
 * <p>Company: www.itcast.cn</p> 
 * @version 1.0
 */
@Controller
public class SmkSearchController {

	private final static Logger logger = LoggerFactory.getLogger(SmkSearchController.class);
	
	@Autowired
	private SmkSearchService searchService;
	
	@RequestMapping("/smk/search/init")
	public XYZResult initSearch() {
		XYZResult result = searchService.initSmkSearch();
		return result;
	}
}
