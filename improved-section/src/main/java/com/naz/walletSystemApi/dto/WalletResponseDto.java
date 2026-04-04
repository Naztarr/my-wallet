package com.naz.walletSystemApi.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;


public class WalletResponseDto {
    private UUID id;
    private UUID userId;
    private BigDecimal balance;

    public void setId(UUID id) {
        this.id = id;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}
