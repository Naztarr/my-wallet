package com.naz.walletSystemApi.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public class CreateWalletRequestDto {
    @NotNull(message = "User ID is required")
    @Schema(description = "Unique ID of the user")
    private UUID userId;

    public UUID getUserId() {
        return userId;
    }
}
