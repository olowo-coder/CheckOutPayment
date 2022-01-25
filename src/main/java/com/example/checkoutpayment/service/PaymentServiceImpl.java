package com.example.checkoutpayment.service;

import com.example.checkoutpayment.dto.PayDto;
import com.example.checkoutpayment.dto.PaymentRequest;
import com.example.checkoutpayment.model.*;
import com.example.checkoutpayment.repository.PaymentRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import java.util.*;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
public class PaymentServiceImpl implements PaymentService {

    private final WebClient webClient;
    private final PaymentRepository paymentRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<PaymentRequest> getAllPayments() {
        List<Payment> list = paymentRepository.findAll();
        return list.stream()
                .map(payment -> modelMapper.map(payment, PaymentRequest.class)).collect(Collectors.toList());
    }

    @Override
    public String savePayment(PayDto payDto) {
        Payment payment = new Payment();
        Object object = webClient.get().uri(uriBuilder -> uriBuilder.path("/item/info")
                        .queryParam("name", payDto.getName())
                        .build()).retrieve().bodyToFlux(Object.class).blockFirst();
        modelMapper.map(payDto, payment);
        modelMapper.map(object, payment);
        paymentRepository.save(payment);
        return "Saved";
    }

    @Override
    public List<?> allItemsAvailable() {
        ObjectMapper mapper = new ObjectMapper();
        Object[] object = webClient.get().uri("/item").retrieve().bodyToMono(Object[].class).block();
        return Arrays.stream(object)
                .map(objects -> mapper.convertValue(objects, PaymentRequest.class))
                .map((item) -> "{ name: " + item.getName() + ", description: "+ item.getDescription() + " }")
                .collect(Collectors.toList());
//        return object.stream()
//                .map(payment -> modelMapper.map(payment, PaymentRequest.class)).collect(Collectors.toList());
    }

}
