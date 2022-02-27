package com.example.assignment1.models;

import java.util.List;

public class AddProductToBasketRequest{
	private List<AddProductInfoItem> addProductInfos;
	private long userId;

	public AddProductToBasketRequest() {
	}

	public AddProductToBasketRequest(List<AddProductInfoItem> addProductInfos, long userId) {
		this.addProductInfos = addProductInfos;
		this.userId = userId;
	}

	public void setAddProductInfos(List<AddProductInfoItem> addProductInfos){
		this.addProductInfos = addProductInfos;
	}

	public List<AddProductInfoItem> getAddProductInfos(){
		return addProductInfos;
	}

	public void setUserId(long userId){
		this.userId = userId;
	}

	public long getUserId(){
		return userId;
	}
}