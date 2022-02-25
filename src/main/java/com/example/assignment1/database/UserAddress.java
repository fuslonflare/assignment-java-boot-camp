package com.example.assignment1.database;

import org.hibernate.annotations.Nationalized;

import javax.persistence.*;

public class UserAddress {

    @Id
    @GeneratedValue
    @Column(nullable = false)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(length = 1000)
    @Nationalized
    private String address;

    public UserAddress() {

    }

    public UserAddress(User user, String address) {
        this.user = user;
        this.address = address;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
