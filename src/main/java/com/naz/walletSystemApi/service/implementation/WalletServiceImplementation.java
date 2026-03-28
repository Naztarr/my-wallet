package com.naz.walletSystemApi.service.implementation;

import com.naz.walletSystemApi.dto.WalletResponseDto;
import com.naz.walletSystemApi.entity.Transaction;
import com.naz.walletSystemApi.entity.Wallet;
import com.naz.walletSystemApi.exception.ResourceNotFoundException;
import com.naz.walletSystemApi.mapper.WalletMapper;
import com.naz.walletSystemApi.service.WalletService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

@Service
public class WalletServiceImplementation implements WalletService {
    private final Map<String, Wallet> walletStore = new ConcurrentHashMap<>();
    private final List<Transaction> transactions = new CopyOnWriteArrayList<>();

    public String createWallet(String userId) {
        String id = UUID.randomUUID().toString();
        Wallet wallet = new Wallet(id, userId, BigDecimal.ZERO);
        walletStore.put(id, wallet);
        return id;
    }

    public String fundWallet(String id, BigDecimal amount) {
        getWallet(id);

        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Amount must be greater than zero");
        }

        walletStore.computeIfPresent(id, (key, w) -> {
            w.setBalance(w.getBalance().add(amount));
            return w;
        });

        transactions.add(new Transaction(
                UUID.randomUUID().toString(),
                id,
                "CREDIT",
                amount,
                LocalDateTime.now()
        ));
        return "Wallet funded successfully";
    }

    public String debitWallet(String id, BigDecimal amount) {
        getWallet(id);

        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Amount must be greater than zero");
        }

        walletStore.computeIfPresent(id, (key, w) -> {
            if (w.getBalance().compareTo(amount) < 0) {
                throw new IllegalArgumentException("Insufficient balance");
            }

            w.setBalance(w.getBalance().subtract(amount));
            return w;
        });

        transactions.add(new Transaction(
                UUID.randomUUID().toString(),
                id,
                "DEBIT",
                amount,
                LocalDateTime.now()
        ));
        return String.format("Wallet has been debited with amount: %s", amount);
    }

    public WalletResponseDto getWallet(String id) {
        Wallet wallet = walletStore.get(id);
        if (wallet == null) {
            throw new ResourceNotFoundException("Wallet", "wallet id", id);
        }
        return WalletMapper.mapToWalletDto(wallet);
    }
}
