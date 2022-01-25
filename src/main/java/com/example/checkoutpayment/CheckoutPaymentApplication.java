package com.example.checkoutpayment;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class CheckoutPaymentApplication {


    public static void main(String[] args) {
        SpringApplication.run(CheckoutPaymentApplication.class, args);
    }

}
