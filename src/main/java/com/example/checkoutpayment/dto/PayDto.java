package com.example.checkoutpayment.dto;

import com.example.checkoutpayment.model.PaymentStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PayDto {
    private String name;
    private PaymentStatus status;
}
