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
public class ItemDelMessageListener implements MessageListener{

	private final static Logger logger = LoggerFactory.getLogger(ItemDelMessageListener.class);
	
	@Autowired
	private SolrServer solrServer;
	@Override
	public void onMessage(Message message) {
		
		try {
			//从消息中取商品id
			TextMessage textMessage = (TextMessage) message;
			String itemId = textMessage.getText();
			logger.debug("传过来的id"+itemId);
			//通过id删除索引库中的信息
			solrServer.deleteById(itemId);
			//提交
			solrServer.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
