package xyz.pigschool.secondMarket.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PathController {
	
	/**
	 * 	整个二手市场的父节点的cid
	 */
	@Value("${SMK_CONTENT_PARENT_CID}")
	private Integer SMK_CONTENT_PARENT_CID;
	
	@Autowired
	private ContentController contentController;
	
	@RequestMapping("/{path}")
	public String show(@PathVariable String path,HttpServletRequest request) {
		contentController.getAlllist(request,SMK_CONTENT_PARENT_CID);
		return path;
	}
	@RequestMapping("/")
	public String show(HttpServletRequest request) {
		contentController.getAlllist(request,SMK_CONTENT_PARENT_CID);
		return "index";
	}
}
