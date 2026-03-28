package com.naz.walletSystemApi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;


public class Transaction {
    private String id;
    private String walletId;
    private String type; // "CREDIT" or "DEBIT"
    private BigDecimal amount;
    private LocalDateTime timestamp;

    public Transaction(String id, String walletId, String type, BigDecimal amount, LocalDateTime timestamp) {
        this.id = id;
        this.walletId = walletId;
        this.type = type;
        this.amount = amount;
        this.timestamp = timestamp;
    }
}
