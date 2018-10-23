package xyz.pigschool.smk.search.service.mapper;

import java.util.List;

import xyz.pigschool.smk.pojo.SearchItem;

public interface SmkSearchMapper {
	List<SearchItem> getItemList();
	SearchItem getItemById(long itemId);
}
