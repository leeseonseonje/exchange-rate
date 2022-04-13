package com.test.exchangerate.controller.dto;

import com.test.exchangerate.domain.RecipientCountry;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
public class ResponseAmountReceivedDto {

    private String amountReceived;

    private RecipientCountry recipientCountry;

    private ResponseAmountReceivedDto(String amountReceived, RecipientCountry recipientCountry) {
        this.amountReceived = amountReceived;
        this.recipientCountry = recipientCountry;
    }

    @Builder
    public static ResponseAmountReceivedDto of(String amountReceived, RecipientCountry recipientCountry) {
        return ResponseAmountReceivedDto.builder()
                .amountReceived(amountReceived)
                .recipientCountry(recipientCountry)
                .build();
    }
}
