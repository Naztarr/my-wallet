package com.naz.walletSystemApi.controller;

import com.naz.walletSystemApi.dto.*;
import com.naz.walletSystemApi.service.WalletService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Tag(
        name = "REST APIs for Wallet Operations",
        description = "REST APIs to Create, Fund, Debit and Fetch wallet details"
)
@RestController
@RequestMapping(path ="/wallets",produces = (MediaType.APPLICATION_JSON_VALUE))
@Validated
public class WalletController {
    @Autowired
    private WalletService walletService;

    @Operation(
            summary = "Create Wallet REST API",
            description = "REST API to create a new wallet for a user with zero balance"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "201",
                    description = "HTTP Status CREATED"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "HTTP Status Internal Server Error",
                    content = @Content(schema = @Schema(implementation = ErrorResponseDto.class))
            )
    })
    @PostMapping
    public ResponseEntity<ResponseDto> create(@Valid @RequestBody CreateWalletRequestDto request) {
        String res = walletService.createWallet(request.getUserId());
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDto(HttpStatus.CREATED, res));
    }

    @Operation(
            summary = "Fund Wallet REST API",
            description = "REST API to add money to an existing wallet"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "HTTP Status OK"
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "HTTP Status Bad Request (e.g. Invalid Amount)",
                    content = @Content(schema = @Schema(implementation = ErrorResponseDto.class))
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "HTTP Status Not Found",
                    content = @Content(schema = @Schema(implementation = ErrorResponseDto.class))
            )
    })
    @PostMapping("/{id}/fund")
    public ResponseEntity<ResponseDto> fund(@PathVariable UUID id,
                                       @Valid @RequestBody AmountRequestDto request) {
        String res = walletService.fundWallet(id, request.getAmount());
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new ResponseDto(HttpStatus.OK, res));
    }

    @Operation(
            summary = "Debit Wallet REST API",
            description = "REST API to spend money from an existing wallet"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "HTTP Status OK"
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "HTTP Status Bad Request (e.g. Insufficient Balance)",
                    content = @Content(schema = @Schema(implementation = ErrorResponseDto.class))
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "HTTP Status Not Found",
                    content = @Content(schema = @Schema(implementation = ErrorResponseDto.class))
            )
    })
    @PostMapping("/{id}/debit")
    public ResponseEntity<ResponseDto> debit(@PathVariable UUID id,
                                        @Valid @RequestBody AmountRequestDto request) {
        String res = walletService.debitWallet(id, request.getAmount());
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new ResponseDto(HttpStatus.OK, res));
    }

    @Operation(
            summary = "Fetch Wallet Details REST API",
            description = "REST API to fetch wallet balance and details based on wallet ID"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "HTTP Status OK"
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "HTTP Status Not Found",
                    content = @Content(schema = @Schema(implementation = ErrorResponseDto.class))
            )
    })
    @GetMapping("/{id}")
    public ResponseEntity<WalletResponseDto> get(@PathVariable UUID id) {
        WalletResponseDto walletDto = walletService.getWallet(id);
        return ResponseEntity.status(HttpStatus.OK).body(walletDto);
    }
}
