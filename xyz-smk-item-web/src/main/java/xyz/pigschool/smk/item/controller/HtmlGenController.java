package xyz.pigschool.smk.item.controller;

import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import freemarker.template.Configuration;
import freemarker.template.Template;

/**
 * 	生产静态页面的测试Controller
 * @author lyf
 */

public class HtmlGenController {
	
	@Autowired
	private FreeMarkerConfigurer freeMarkerConfigurer;
	
	@Value("${XYZ_SMKITEM_HTML_PATH}")
	private String XYZ_SMKITEM_HTML_PATH;
	
	@RequestMapping("/hello/sss")
	@ResponseBody
	public String genHtml() throws Exception {
		Configuration configuration = freeMarkerConfigurer.createConfiguration();
		//加载模板对象
		Template template = configuration.getTemplate("hello.ftl");
		//创建数据集
		Map data = new HashMap<>();
		data.put("hello", 123456);
		//制定输出路径以及文件名
//		Writer out = new FileWriter(new File("C:/Users/201/Desktop/项目群/测试/freemarker/item.html"));
		Writer out = new FileWriter(new File(XYZ_SMKITEM_HTML_PATH+"item.html"));
//		Writer out = new FileWriter(new File("D:/xyz/item/item.html"));
		//输出文件
		template.process(data, out);
		//关闭流
		out.close();
		
		return "ok";
	}
}
