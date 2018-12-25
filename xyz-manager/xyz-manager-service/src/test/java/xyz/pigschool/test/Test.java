package xyz.pigschool.test;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import xyz.pigschool.mapper.XyzContentMapper;
import xyz.pigschool.mapper.XyzItemMapper;
import xyz.pigschool.pojo.XyzContent;
import xyz.pigschool.pojo.XyzItem;

public class Test{

	/*@Autowired
	XyzItemMapper itemMapper ;*/
	
	@org.junit.Test
	public void test01() {
		ApplicationContext content = new  FileSystemXmlApplicationContext("classpath:/spring/applicationContext.xml");
		XyzItemMapper itemMapper = content.getBean(XyzItemMapper.class);
		List<XyzItem> list = itemMapper.selectByExample(null);
		for (XyzItem xyzItem : list) {
			System.out.println(xyzItem.getTitle());
		}
	}
	
	@org.junit.Test
	public void test02() {
		ApplicationContext content = new  FileSystemXmlApplicationContext("classpath:/spring/applicationContext.xml");
		XyzItemMapper itemMapper = content.getBean(XyzItemMapper.class);
		XyzItem item = new XyzItem();
		item.setId(999L);
		item.setTitle("李延富");
		item.setCid(1L);
		item.setPrice(99999999999L);
		item.setSellPoint("聪明爱学习");
		item.setLocation("十里铺");
		item.setContactInfo("110");
		itemMapper.insertSelective(item);//添加
		itemMapper.selectByPrimaryKey(999L);//查询
		System.out.println(item.getTitle()+","+item.getPrice()+","+
		item.getSellPoint()+","+item.getLocation()+","+item.getContactInfo());
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	@org.junit.Test
	public void zhangquandeTest01() {
		ApplicationContext content = new  FileSystemXmlApplicationContext("classpath:/spring/applicationContext.xml");
		XyzContentMapper contentMapper = content.getBean(XyzContentMapper.class);
		XyzContent xzyContent = contentMapper.selectByPrimaryKey(3L);
		System.out.println(xzyContent.getTitle());
		System.out.println(xzyContent.getSubTitle());
		System.out.println(xzyContent.getCategoryId());
		System.out.println(xzyContent.getCreated());
	}
	
	@org.junit.Test
	public void zhangquandeTest02() {
		ApplicationContext content = new  FileSystemXmlApplicationContext("classpath:/spring/applicationContext.xml");
		XyzContentMapper contentMapper = content.getBean(XyzContentMapper.class);
		XyzContent xzyContent = contentMapper.selectByPrimaryKey(12L);
		System.out.println(xzyContent.getTitle()+","+xzyContent.getSubTitle()+","+xzyContent.getCategoryId()+","+xzyContent.getCreated());
		int i = contentMapper.deleteByPrimaryKey(12L);
		XyzContent xzyContent2 = contentMapper.selectByPrimaryKey(12L);
		if(xzyContent2==null) {
			System.out.println("我已经被删除。。。好难过。。。");
		}
	}
	
	
	
	
	
	
	
	
}
