package com.naz.walletSystemApi.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public class AmountRequestDto {
    @NotNull(message = "Amount is required")
    @Positive(message = "Amount must be greater than zero")
    @Schema(description = "Amount to be funded or debited", example = "100.00")
    private BigDecimal amount;

    public BigDecimal getAmount() {
        return amount;
    }
}
