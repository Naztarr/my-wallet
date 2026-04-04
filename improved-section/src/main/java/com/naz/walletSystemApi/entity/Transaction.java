package com.naz.walletSystemApi.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.hibernate.annotations.UuidGenerator;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @UuidGenerator(style = UuidGenerator.Style.TIME)
    private UUID id;
    private UUID walletId;
    private String type; // "CREDIT" or "DEBIT"
    private BigDecimal amount;
    private LocalDateTime timestamp;

    public Transaction(UUID walletId, String type, BigDecimal amount, LocalDateTime timestamp) {
        this.walletId = walletId;
        this.type = type;
        this.amount = amount;
        this.timestamp = timestamp;
    }

    public UUID getId() {
        return id;
    }


    public UUID getWalletId() {
        return walletId;
    }

    public void setWalletId(UUID walletId) {
        this.walletId = walletId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public Transaction(){}
}
