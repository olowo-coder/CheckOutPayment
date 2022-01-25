package com.example.checkoutpayment.dto;

import com.example.checkoutpayment.model.PaymentStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class PaymentRequest {
    private String name;
    private String description;
    private BigDecimal price;
    private String receiptID;
    private PaymentStatus status;
    private LocalDateTime paidAt;
}
