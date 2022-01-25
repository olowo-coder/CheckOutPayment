package com.example.checkoutpayment.controller;

import com.example.checkoutpayment.dto.PayDto;
import com.example.checkoutpayment.dto.PaymentRequest;
import com.example.checkoutpayment.service.PaymentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("payment")
@AllArgsConstructor
public class PaymentController {
    private final PaymentService paymentService;

    @GetMapping
    public ResponseEntity<?> getAllPayments(){
        return ResponseEntity.ok(paymentService.getAllPayments());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> savePayment(@RequestBody PayDto payment){
        return ResponseEntity.ok(paymentService.savePayment(payment));
    }

    @GetMapping("/stock")
    public ResponseEntity<?> allItemsInStock(){
        return ResponseEntity.ok(paymentService.allItemsAvailable());
    }

}
