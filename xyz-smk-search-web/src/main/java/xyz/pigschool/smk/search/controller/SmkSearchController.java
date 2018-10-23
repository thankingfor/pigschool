package xyz.pigschool.smk.search.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import xyz.pigschool.smk.pojo.SearchResult;
import xyz.pigschool.smk.search.service.SmkSearchService;

@Controller
public class SmkSearchController {
	@Autowired
	private SmkSearchService searchService;
	
	@Value("${SEARCH_RESULT_ROWS}")
	private Integer SEARCH_RESULT_ROWS;
	
	@RequestMapping("/search")
	public String selectByKey(@RequestParam(value="keyword")String keyword,
			@RequestParam(name="page" ,defaultValue="1")int page,
			Model model) {
		
		try {
			//get请求会乱码  所以解决乱码问题
			keyword = new String(keyword.getBytes("iso-8859-1"), "utf-8");
			//查询商品列表
			SearchResult searchResult  = (SearchResult) searchService.searchByKeys(keyword, page, SEARCH_RESULT_ROWS).getData();
			if(searchResult.getItemList().size() <= 0) {
				model.addAttribute("msg", "查无结果！");
			}else {
				//把结果传递给页面
				model.addAttribute("keyword", keyword);
				model.addAttribute("totalPages", searchResult.getTotalPages());
				model.addAttribute("page", page);
				model.addAttribute("recourdCount", searchResult.getRecordCount());
				model.addAttribute("itemList", searchResult.getItemList());
			}
			return "search";
		} catch (Exception e) {
			e.printStackTrace();
			return "error/msg";
		}
	}
}
