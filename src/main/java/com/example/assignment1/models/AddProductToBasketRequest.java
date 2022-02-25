package com.example.assignment1.models;

import java.util.List;

public class AddProductToBasketRequest{
	private List<AddProductInfoItem> addProductInfos;
	private int userId;

	public AddProductToBasketRequest(List<AddProductInfoItem> addProductInfos, int userId) {
		this.addProductInfos = addProductInfos;
		this.userId = userId;
	}

	public void setAddProductInfos(List<AddProductInfoItem> addProductInfos){
		this.addProductInfos = addProductInfos;
	}

	public List<AddProductInfoItem> getAddProductInfos(){
		return addProductInfos;
	}

	public void setUserId(int userId){
		this.userId = userId;
	}

	public int getUserId(){
		return userId;
	}
}