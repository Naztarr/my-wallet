package com.naz.walletSystemApi.entity;


import jakarta.persistence.*;
import org.hibernate.annotations.UuidGenerator;

import java.math.BigDecimal;
import java.util.UUID;


@Entity
public class Wallet {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @UuidGenerator(style = UuidGenerator.Style.TIME)
    private UUID id;
    @Column(nullable = false, unique = true)
    private UUID userId;
    private BigDecimal balance;

    public Wallet(UUID userId, BigDecimal balance) {
        this.userId = userId;
        this.balance = balance;
    }
    public Wallet(){}

    public UUID getId() {
        return id;
    }

    public UUID getUserId() {
        return userId;
    }

    public BigDecimal getBalance() {
        return balance;
    }


    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}
