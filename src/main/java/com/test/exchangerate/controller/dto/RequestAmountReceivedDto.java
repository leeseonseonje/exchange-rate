package com.test.exchangerate.controller.dto;

import com.test.exchangerate.domain.RecipientCountry;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;
import java.math.BigDecimal;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RequestAmountReceivedDto {

    @NotNull(message = "수취국가를 선택해 주세요.")
    private RecipientCountry recipientCountry;

    @NotNull(message = "송금액을 입력해 주세요.")
    @DecimalMax(value = "10000", message = "10000달러 보다 큰 금액은 송금할수 없습니다.")
    @DecimalMin(value = "0", message = "0달러 보다 작은 금액은 송금할 수 없습니다.")
    private BigDecimal remittance;
}
