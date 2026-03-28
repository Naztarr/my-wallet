package com.naz.walletSystemApi.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatusCode;

@Data
@Schema(
        name = "response",
        description = "Schema to hold  successful response information")
public class ResponseDto {
    @Schema(
            description = "Status code in the response"
    )
    private HttpStatusCode statusCode;

    @Schema(
            description = "Status message in the response"
    )
    private String statusMsg;

    public ResponseDto(HttpStatusCode statusCode, String statusMsg) {
        this.statusCode = statusCode;
        this.statusMsg = statusMsg;
    }
}
