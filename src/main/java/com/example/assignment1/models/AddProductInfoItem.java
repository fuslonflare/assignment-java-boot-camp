package com.example.assignment1.models;

public class AddProductInfoItem {
	private int amount;
	private long productId;

	public AddProductInfoItem() {
	}

	public AddProductInfoItem(int amount, long productId) {
		this.amount = amount;
		this.productId = productId;
	}

	public void setAmount(int amount){
		this.amount = amount;
	}

	public int getAmount(){
		return amount;
	}

	public void setProductId(long productId){
		this.productId = productId;
	}

	public long getProductId(){
		return productId;
	}
}
