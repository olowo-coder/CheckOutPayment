package com.example.checkoutpayment.service;

import com.example.checkoutpayment.dto.PayDto;
import com.example.checkoutpayment.dto.PaymentRequest;
import com.example.checkoutpayment.model.Payment;
import org.springframework.http.ResponseEntity;
import reactor.core.publisher.Flux;

import java.util.List;

public interface PaymentService {
    List<PaymentRequest> getAllPayments();

    String savePayment(PayDto payment);

    List<?> allItemsAvailable();
}
