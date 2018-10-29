package xyz.pigschool.smk.item.listener;

import java.io.FileWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import freemarker.template.Configuration;
import freemarker.template.Template;
import xyz.pigschool.secondMarket.service.ItemService;
import xyz.pigschool.smk.pojo.ItemDec;

public class ItemHtmlListener implements MessageListener{

	private final static Logger logger = LoggerFactory.getLogger(ItemHtmlListener.class);
	
	@Autowired
	private ItemService itemService;
	
	@Autowired
	private FreeMarkerConfigurer freeMarkerConfigurer;
	
	@Value("${XYZ_SMKITEM_HTML_PATH}")
	private String XYZ_SMKITEM_HTML_PATH;
	
	@Override
	public void onMessage(Message message) {
		try {
			TextMessage textMessage = (TextMessage) message;
			String text = textMessage.getText();
			Long itemId = new Long(text);
			//等待事务提交
			Thread.sleep(1000);
			//根据商品id查询商品信息
			ItemDec itemDec = (ItemDec) itemService.getItemById(itemId).getData();
			//创建一个数据集，把商品数据封装
			Map data = new HashMap<>();
			data.put("itemDec", itemDec);
			Configuration configuration = freeMarkerConfigurer.getConfiguration();
			Template template = configuration.getTemplate("item.ftl");
			//创建一个输出流，指定输出的目录及文件名。
			Writer out = new FileWriter(XYZ_SMKITEM_HTML_PATH + itemId + ".html");
			//生成静态页面。
			template.process(data, out);
			//关闭流
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
