package com.example.assignment1.database;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Nationalized;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
public class Product {

    @Id
    @GeneratedValue
    @Column(nullable = false)
    private long id;

    @Basic(optional = false)
    @Column(nullable = false)
    private String name;

    @Basic(optional = false)
    @Column(nullable = false)
    private String thumbnail;

    private double originalPrice;

    @Basic(optional = false)
    @Column(nullable = false)
    private double price;

    private double rate;

    @Column(length = 5000)
    @Nationalized
    private String detail;

    private int totalReviewer;
    private int stock;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime createDate;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime updateDate;

    public Product(String name,
                   String thumbnail,
                   double originalPrice,
                   double price,
                   double rate,
                   String detail,
                   int totalReviewer,
                   int stock,
                   LocalDateTime createDate,
                   LocalDateTime updateDate) {
        this.name = name;
        this.thumbnail = thumbnail;
        this.originalPrice = originalPrice;
        this.price = price;
        this.rate = rate;
        this.detail = detail;
        this.totalReviewer = totalReviewer;
        this.stock = stock;
        this.createDate = createDate;
        this.updateDate = updateDate;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
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

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public int getTotalReviewer() {
        return totalReviewer;
    }

    public void setTotalReviewer(int totalReviewer) {
        this.totalReviewer = totalReviewer;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public LocalDateTime getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(LocalDateTime updateDate) {
        this.updateDate = updateDate;
    }

    public double getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(double originalPrice) {
        this.originalPrice = originalPrice;
    }
}
