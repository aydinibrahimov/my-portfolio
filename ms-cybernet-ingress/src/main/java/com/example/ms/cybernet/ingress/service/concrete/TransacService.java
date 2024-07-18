package com.example.ms.cybernet.ingress.service.concrete;

import com.example.ms.cybernet.ingress.dao.repository.PaymentRepository;
import com.example.ms.cybernet.ingress.model.request.PaymentRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

import static com.example.ms.cybernet.ingress.mapper.PaymentMapper.PAYMENT_MAPPER;

@Component
@RequiredArgsConstructor
public class TransacService {
    private  final PaymentRepository repository;

    @Transactional(propagation = )
    public void save(){
        repository.save(
                PAYMENT_MAPPER.generatePayment(
                        new PaymentRequest(BigDecimal.TEN,"desc-222"
                        )));
        throw new RuntimeException();

    }
}
