package com.example.ms.cybernet.ingress.service.concrete;

import com.example.ms.cybernet.ingress.dao.entity.PaymentEntity;
import com.example.ms.cybernet.ingress.dao.repository.PaymentRepository;
import com.example.ms.cybernet.ingress.exception.NotFoundException;
import com.example.ms.cybernet.ingress.mapper.PaymentMapper;
import com.example.ms.cybernet.ingress.model.request.PaymentRequest;
import com.example.ms.cybernet.ingress.model.response.PaymentResponse;
import com.example.ms.cybernet.ingress.service.abstraction.PaymentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import static com.example.ms.cybernet.ingress.mapper.PaymentMapper.PAYMENT_MAPPER;


import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository repository;

    private PaymentResponse findPaymentById(Long id) {
        log.info("ServiceLog.findPaymentById.start id:{}", id);
        return repository.findById(id)
                .map(PAYMENT_MAPPER::generatePaymentResponse)
                .orElseThrow(() -> {
                    log.info("ServiceLog.findPaymentById.error id:{}", id);
                    throw new NotFoundException("PAYMENT_NOT_FOUND");
                });
    }

    @Override
    public void createPayment(PaymentRequest request) {
        log.info("ServiceLog.createPayment.start request:{}", request);
        repository.save(PAYMENT_MAPPER.generatePayment(request));
        log.info("ServiceLog.createPayment.success request:{}", request);

    }

    @Override
    public PaymentResponse getPaymentById(Long id) {
        return null;
    }

    @Override
    public void updatePaymentDescription(Long id, String description) {

    }
}
