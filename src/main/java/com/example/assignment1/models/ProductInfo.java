package com.example.assignment1.models;

public class ProductInfo extends BaseInfo {
    private String name;
    private double originalPrice;
    private double price;
    private double discount;
    private double rate;
    private String thumbnail;
    private int stock;
    private int totalReview;

    public ProductInfo(long id, String name, double originalPrice, double price, double discount, double rate, String thumbnail, int stock, int totalReview) {
        this.setId(id);
        this.name = name;
        this.originalPrice = originalPrice;
        this.price = price;
        this.discount = discount;
        this.rate = rate;
        this.thumbnail = thumbnail;
        this.stock = stock;
        this.totalReview = totalReview;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(double originalPrice) {
        this.originalPrice = originalPrice;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getTotalReview() {
        return totalReview;
    }

    public void setTotalReview(int totalReview) {
        this.totalReview = totalReview;
    }
}