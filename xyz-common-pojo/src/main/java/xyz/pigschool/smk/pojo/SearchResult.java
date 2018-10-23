package xyz.pigschool.smk.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * 二手市场查询结果 返回搜索集
 * @author 李延富
 *
 */
public class SearchResult implements Serializable {

	private long recordCount;
	private int totalPages;
	private List<SearchItem> itemList;
	public long getRecordCount() {
		return recordCount;
	}
	public void setRecordCount(long recordCount) {
		this.recordCount = recordCount;
	}
	public int getTotalPages() {
		return totalPages;
	}
	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}
	public List<SearchItem> getItemList() {
		return itemList;
	}
	public void setItemList(List<SearchItem> itemList) {
		this.itemList = itemList;
	}
	
}
