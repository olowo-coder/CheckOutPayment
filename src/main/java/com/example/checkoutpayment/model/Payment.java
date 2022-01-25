package com.example.checkoutpayment.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Document(collection = "payment")
public class Payment {
    @Id
    private String id;
    private String name;
    private String description;
    private BigDecimal price;
    private String receiptID = UUID.randomUUID().toString().toUpperCase().substring(0, 8);
    private PaymentStatus status;
    private LocalDateTime paidAt = LocalDateTime.now();
}
