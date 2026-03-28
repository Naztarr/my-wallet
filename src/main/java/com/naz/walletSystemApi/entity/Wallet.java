package com.naz.walletSystemApi.entity;

import lombok.*;

import java.math.BigDecimal;




public class Wallet {
    private String id;
    private String userId;
    private BigDecimal balance;

    public Wallet(String id, String userId, BigDecimal balance) {
        this.id = id;
        this.userId = userId;
        this.balance = balance;
    }

    public String getId() {
        return id;
    }

    public String getUserId() {
        return userId;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}
