package xyz.pigschool.smk.search.service.message;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.common.SolrInputDocument;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import xyz.pigschool.smk.pojo.SearchItem;
import xyz.pigschool.smk.search.service.mapper.SmkSearchMapper;
/**
 * 监听商品添加消息，接收消息后，将对应的商品信息同步到索引库
 * @version 1.0
 */
public class ItemAddMessageListener implements MessageListener{

	private final static Logger logger = LoggerFactory.getLogger(ItemAddMessageListener.class);
	
	@Autowired
	private SmkSearchMapper searchMapper;
	@Autowired
	private SolrServer solrServer;
	@Override
	public void onMessage(Message message) {
		
		try {
			//从消息中取商品id
			TextMessage textMessage = (TextMessage) message;
			String text = textMessage.getText();
			logger.debug("传过来的id"+text);
			Long itemId = new Long(text);
			//等待事务提交
			Thread.sleep(1000);
			//根据商品id查询商品信息
			SearchItem searchItem = searchMapper.getItemById(itemId);
			//创建一个文档对象
			SolrInputDocument document = new SolrInputDocument();
			//向文档对象中添加域
			document.addField("id", searchItem.getId());
			document.addField("smk_title", searchItem.getTitle());
			document.addField("smk_price", searchItem.getPrice());
			document.addField("smk_image", searchItem.getImage());
			document.addField("smk_num", searchItem.getNum());
			document.addField("smk_sell_point", searchItem.getSellPoint());
			document.addField("smk_cname", searchItem.getCname());
			document.addField("smk_location", searchItem.getLocation());
			document.addField("smk_contact_info", searchItem.getContactInfo());
			//把文档对象写入索引库
			solrServer.add(document);
			//提交
			solrServer.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
