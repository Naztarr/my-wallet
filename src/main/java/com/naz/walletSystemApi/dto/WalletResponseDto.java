package com.naz.walletSystemApi.dto;

import lombok.Data;

import java.math.BigDecimal;


public class WalletResponseDto {
    private String id;
    private String userId;
    private BigDecimal balance;

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
