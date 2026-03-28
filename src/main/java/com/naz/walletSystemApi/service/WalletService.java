package com.naz.walletSystemApi.service;


import com.naz.walletSystemApi.dto.WalletResponseDto;
import com.naz.walletSystemApi.entity.Wallet;

import java.math.BigDecimal;

public interface WalletService {
    String createWallet(String userId);
    String fundWallet(String id, BigDecimal amount);
    String debitWallet(String id, BigDecimal amount);
    WalletResponseDto getWallet(String id);
}
