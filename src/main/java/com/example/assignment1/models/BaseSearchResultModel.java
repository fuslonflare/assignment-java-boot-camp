package com.example.assignment1.models;

import java.util.List;

public class BaseSearchResultModel<T> {
	private int totalItems;
	private int itemPerPage;
	private int totalPage;
	private int page;
	private List<T> items;

	public void setTotalItems(int totalItems){
		this.totalItems = totalItems;
	}

	public int getTotalItems(){
		return totalItems;
	}

	public void setItemPerPage(int itemPerPage){
		this.itemPerPage = itemPerPage;
	}

	public int getItemPerPage(){
		return itemPerPage;
	}

	public void setTotalPage(int totalPage){
		this.totalPage = totalPage;
	}

	public int getTotalPage(){
		return totalPage;
	}

	public void setPage(int page){
		this.page = page;
	}

	public int getPage(){
		return page;
	}

	public void setItems(List<T> items){
		this.items = items;
	}

	public List<T> getItems(){
		return items;
	}
}