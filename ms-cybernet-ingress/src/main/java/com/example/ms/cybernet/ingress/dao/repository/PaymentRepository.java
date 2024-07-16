package com.example.ms.cybernet.ingress.dao.repository;

import com.example.ms.cybernet.ingress.dao.entity.PaymentEntity;
import com.example.ms.cybernet.ingress.model.enums.PaymentStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PaymentRepository extends JpaRepository<PaymentEntity,Long> {
    Optional<PaymentEntity> findByIdAndPaymentStatusNot(Long id, PaymentStatus status);
    List<PaymentEntity> findAllAndPaymentStatusNot(PaymentStatus status);
}
