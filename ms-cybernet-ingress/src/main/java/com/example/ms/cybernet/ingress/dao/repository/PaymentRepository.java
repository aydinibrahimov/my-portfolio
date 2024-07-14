package com.example.ms.cybernet.ingress.dao.repository;

import com.example.ms.cybernet.ingress.dao.entity.PaymentEntity;
import com.example.ms.cybernet.ingress.model.enums.PaymentStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PaymentRepository extends JpaRepository<PaymentEntity,Long> {
    Optional<PaymentEntity> findByIdAntStatusNot(Long id, PaymentStatus status);
}
