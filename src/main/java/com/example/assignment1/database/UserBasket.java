package com.example.assignment1.database;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class UserBasket {

    @Id
    @GeneratedValue
    @Column(nullable = false)
    private long id;

    @Column(nullable = false)
    private long userId;

    @Column(nullable = false)
    private long productId;

    @Column(nullable = false)
    private int amount;

    public UserBasket() {
    }

    public UserBasket(long userId, long productId, int amount) {
        this.userId = userId;
        this.productId = productId;
        this.amount = amount;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
