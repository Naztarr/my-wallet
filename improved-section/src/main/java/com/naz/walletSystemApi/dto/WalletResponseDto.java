package com.naz.walletSystemApi.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;


public class WalletResponseDto {
    private UUID id;
    private UserResponseDto user;
    private BigDecimal balance;

    public void setId(UUID id) {
        this.id = id;
    }

    public void setUser(UserResponseDto user) {
        this.user = user;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}
