package com.naz.walletSystemApi.mapper;

import com.naz.walletSystemApi.dto.UserResponseDto;
import com.naz.walletSystemApi.dto.WalletResponseDto;
import com.naz.walletSystemApi.entity.Wallet;
import lombok.Data;

@Data
public class WalletMapper {
    public static WalletResponseDto mapToWalletDto(Wallet wallet) {
        if (wallet == null) return null;
        WalletResponseDto walletDto = new WalletResponseDto();
        walletDto.setId(wallet.getId());
        walletDto.setUser(new UserResponseDto(wallet.getUser().getFirstName(),
                wallet.getUser().getLastName(), wallet.getUser().getEmail()));
        walletDto.setBalance(wallet.getBalance());
        return walletDto;
    }
}
