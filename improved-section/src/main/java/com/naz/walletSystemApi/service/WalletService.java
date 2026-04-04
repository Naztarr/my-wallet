package com.naz.walletSystemApi.service;


import com.naz.walletSystemApi.dto.WalletResponseDto;
import com.naz.walletSystemApi.entity.Wallet;

import java.math.BigDecimal;
import java.util.UUID;

public interface WalletService {
    String createWallet(UUID userId);
    String fundWallet(UUID id, BigDecimal amount);
    String debitWallet(UUID id, BigDecimal amount);
    WalletResponseDto getWallet(UUID id);
}
