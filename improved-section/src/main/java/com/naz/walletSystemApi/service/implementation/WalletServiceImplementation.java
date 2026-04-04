package com.naz.walletSystemApi.service.implementation;

import com.naz.walletSystemApi.dto.WalletResponseDto;
import com.naz.walletSystemApi.entity.Transaction;
import com.naz.walletSystemApi.entity.Wallet;
import com.naz.walletSystemApi.exception.ResourceNotFoundException;
import com.naz.walletSystemApi.mapper.WalletMapper;
import com.naz.walletSystemApi.repository.TransactionRepository;
import com.naz.walletSystemApi.repository.WalletRepository;
import com.naz.walletSystemApi.service.WalletService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class WalletServiceImplementation implements WalletService {
    private final WalletRepository walletRepository;
    private final TransactionRepository transactionRepository;

    public WalletServiceImplementation(WalletRepository walletRepository, TransactionRepository transactionRepository) {
        this.walletRepository = walletRepository;
        this.transactionRepository = transactionRepository;
    }

    // TODO: Refactor when User entity is added.
// 1. remove the UUID parameter.
// 2. extract the logged-in user from Security Context.
    public String createWallet(UUID userId) {
        Wallet wallet = new Wallet(userId, BigDecimal.ZERO);
        walletRepository.save(wallet);

        return "Wallet created successfully";
    }

    @Transactional
    public String fundWallet(UUID id, BigDecimal amount) {
        Wallet wallet = walletRepository.findById(id).orElseThrow( () -> new ResourceNotFoundException("Wallet", "Id",id.toString()));

        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Amount must be greater than zero");
        }


            wallet.setBalance(wallet.getBalance().add(amount));
        walletRepository.save(wallet);

        Transaction transaction = new Transaction();
        transaction.setWalletId(id);
        transaction.setType("CREDIT");
        transaction.setAmount(amount);
        transaction.setTimestamp(LocalDateTime.now());

        transactionRepository.save(transaction);

        return "Wallet funded successfully";
    }

    @Transactional
    public String debitWallet(UUID id, BigDecimal amount) {
        Wallet wallet = walletRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Wallet", "Id",id.toString()));


        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Amount must be greater than zero");
        }

        if (wallet.getBalance().compareTo(amount) < 0) {
            throw new IllegalArgumentException("Insufficient balance");
        }

        wallet.setBalance(wallet.getBalance().subtract(amount));
        walletRepository.save(wallet);

        Transaction transaction = new Transaction();
        transaction.setWalletId(id);
        transaction.setType("DEBIT");
        transaction.setAmount(amount);
        transaction.setTimestamp(LocalDateTime.now());

        transactionRepository.save(transaction);

        return String.format("Wallet has been debited with amount: %s", amount);
    }

    public WalletResponseDto getWallet(UUID id) {
        Wallet wallet = walletRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Wallet", "Id",id.toString()));

        return WalletMapper.mapToWalletDto(wallet);
    }
}
