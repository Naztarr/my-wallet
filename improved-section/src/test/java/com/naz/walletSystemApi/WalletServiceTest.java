//package com.naz.walletSystemApi;
//
//import com.naz.walletSystemApi.dto.WalletResponseDto;
//import com.naz.walletSystemApi.service.WalletService;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.math.BigDecimal;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@SpringBootTest
//public class WalletServiceTest {
//    @Autowired
//    private WalletService walletService;
//
//    @Test
//    void testCreateAndFundWallet() {
//        // 1. Create
//        String walletId = walletService.createWallet("user1");
//        assertNotNull(walletId);
//
//        // 2. Fund
//        walletService.fundWallet(walletId, new BigDecimal("100.00"));
//
//        // 3. Verify
//        WalletResponseDto wallet = walletService.getWallet(walletId);
//        assertTrue(new BigDecimal("100.00").compareTo(wallet.getBalance()) == 0);
//    }
//
//    @Test
//    void testDebitInsufficientBalance() {
//        String walletId = walletService.createWallet("user2");
//
//        // Should throw IllegalArgumentException
//        assertThrows(IllegalArgumentException.class, () -> {
//            walletService.debitWallet(walletId, new BigDecimal("50.00"));
//        });
//    }
//}
