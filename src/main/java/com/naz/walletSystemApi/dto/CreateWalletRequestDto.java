package com.naz.walletSystemApi.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

public class CreateWalletRequestDto {
    @NotBlank(message = "User ID cannot be blank")
    @Schema(description = "Unique ID of the user")
    public String userId;
}
