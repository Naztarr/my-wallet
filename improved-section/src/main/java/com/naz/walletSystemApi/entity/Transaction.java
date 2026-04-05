package com.naz.walletSystemApi.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UuidGenerator;
import org.springframework.data.annotation.CreatedDate;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "transactions")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @UuidGenerator(style = UuidGenerator.Style.TIME)
    private UUID id;
    @Column(name = "wallet_id")
    private UUID walletId;
    @Column(name = "transaction_type")
    private String type; // "CREDIT" or "DEBIT"
    @Column(name = "transaction_amount")
    private BigDecimal amount;
    @CreationTimestamp
    @CreatedDate
    @Column(name = "created_at", updatable = false)
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
