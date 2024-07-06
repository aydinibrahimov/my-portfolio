package com.example.ms.cybernet.ingress.dao.entity;

import com.example.ms.cybernet.ingress.model.enums.PaymentStatus;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Table(name = "Payment")
@Data
public class PaymentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BigDecimal paymentAmount;
    private PaymentStatus paymentStatus;
    private String description;
}
