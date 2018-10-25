package xyz.pigschool.smk.search.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xyz.pigschool.common.utils.XYZResult;
import xyz.pigschool.smk.pojo.SearchItem;
import xyz.pigschool.smk.pojo.SearchResult;
import xyz.pigschool.smk.search.service.SmkSearchService;
import xyz.pigschool.smk.search.service.mapper.SmkSearchMapper;

@Service
public class SmkSearchServiceImpl implements SmkSearchService{

	@Autowired
	private SmkSearchMapper smkSearchMapper;
	
	@Autowired
	private SolrServer solrServer;
	/**
	 * 根据数据库的xyz_item初始化solr索引库  collection1
	 * @return
	 * @author lyf
	 */
	public XYZResult initSmkSearch() {
		try {
			//查询商品列表
			List<SearchItem> itemList = smkSearchMapper.getItemList();
			for (SearchItem searchItem : itemList) {
				//创建文档对象
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
			}
			//提交
			solrServer.commit();
			//返回导入成功
			return XYZResult.ok();
		} catch (Exception e) {
			e.printStackTrace();
			return XYZResult.build(500, "数据导入是发生异常!");
		}
	}

	/**
	 * 通过key查询
	 * @return
	 * @author lyf
	 */
	public XYZResult searchByKeys(String keyword, int page, int rows) throws Exception {
		//创建一个SolrQuery对象
		SolrQuery query = new SolrQuery();
		//设置查询条件
		query.setQuery(keyword);
		//设置分页条件
		if (page <=0 ) page =1;
		query.setStart((page - 1) * rows);
		query.setRows(rows);
		//设置默认搜索域
		query.set("df", "smk_keywords");
		//开启高亮显示
		query.setHighlight(true);
		query.addHighlightField("smk_title");
		query.addHighlightField("smk_sell_point");
		query.addHighlightField("smk_cname");
		query.addHighlightField("smk_location");
		query.addHighlightField("smk_contact_info");
		query.setHighlightSimplePre("<em style=\"color:red\">");
		query.setHighlightSimplePost("</em>");
		//执行查询结果
		SearchResult searchResult = searchByKeys(query);
		//计算总页数 添加到返回结果
		long recordCount = searchResult.getRecordCount();
		int totalPage = (int) (recordCount / rows);
		if (recordCount % rows > 0) {
			totalPage ++;
		}
		searchResult.setTotalPages(totalPage);
		return XYZResult.ok(searchResult);
	}

	/**
	 * 根据查询条件查询索引库
	 * @param query
	 * @return
	 * @author lyf
	 */
	private SearchResult searchByKeys(SolrQuery query) throws Exception {
		//根据query查询索引库
		QueryResponse queryResponse = solrServer.query(query);
		//取查询结果。
		SolrDocumentList solrDocumentList = queryResponse.getResults();
		//取查询结果总记录数
		long numFound = solrDocumentList.getNumFound();
		SearchResult result = new SearchResult();
		result.setRecordCount(numFound);
		//取商品列表，需要取高亮显示
		Map<String, Map<String, List<String>>> highlighting = queryResponse.getHighlighting();
		List<SearchItem> itemList = new ArrayList<>();
		for (SolrDocument solrDocument : solrDocumentList) {
			SearchItem item = new SearchItem();
			item.setId((String) solrDocument.get("id"));
			item.setCname((String) solrDocument.get("smk_cname"));
			//只取第一张图片
			String image = (String) solrDocument.get("smk_image");
			if (image != null && !"".equals(image)) {
				String[] images = image.split(",");
				item.setImage(images[0]);
			}else {
				item.setImage("");
			}
			item.setPrice((long) solrDocument.get("smk_price"));
			item.setNum((long)solrDocument.get("smk_num"));
			item.setSellPoint((String) solrDocument.get("smk_sell_point"));
			item.setLocation((String) solrDocument.get("smk_location"));
			item.setContactInfo((String) solrDocument.get("smk_contact_info"));
			//取高亮显示 smk_title sell_point location contact_info cname
			List<String> listTitle = highlighting.get(solrDocument.get("id")).get("smk_title");
			if (listTitle != null && listTitle.size() > 0) {
				item.setTitle(listTitle.get(0));
			} else {
				item.setTitle((String) solrDocument.get("smk_title"));
			}
			//smk_sell_point
			List<String> listSP = highlighting.get(solrDocument.get("id")).get("smk_sell_point");
			if (listSP != null && listSP.size() > 0) {
				item.setSellPoint(listSP.get(0));
			} else {
				item.setSellPoint((String) solrDocument.get("smk_sell_point"));
			}
			//smk_location
			List<String> listLocation = highlighting.get(solrDocument.get("id")).get("smk_location");
			if (listLocation != null && listLocation.size() > 0) {
				item.setLocation(listLocation.get(0));
			} else {
				item.setLocation((String) solrDocument.get("smk_location"));
			}
			//smk_contact_info
			List<String> listCI = highlighting.get(solrDocument.get("id")).get("smk_contact_info");
			if (listCI != null && listCI.size() > 0) {
				item.setContactInfo(listCI.get(0));
			} else {
				item.setContactInfo((String) solrDocument.get("smk_contact_info"));
			}
			//smk_cname
			List<String> listCName = highlighting.get(solrDocument.get("id")).get("smk_cname");
			if (listCName != null && listCName.size() > 0) {
				item.setCname(listCName.get(0));
			} else {
				item.setCname((String) solrDocument.get("smk_cname"));
			}
			//添加到商品列表
			itemList.add(item);
		}
		result.setItemList(itemList);
		return result;
	}
	
}
