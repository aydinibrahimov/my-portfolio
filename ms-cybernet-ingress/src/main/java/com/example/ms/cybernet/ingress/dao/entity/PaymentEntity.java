package com.example.ms.cybernet.ingress.dao.entity;

import com.example.ms.cybernet.ingress.model.enums.PaymentStatus;
import jakarta.persistence.*;
import static jakarta.persistence.GenerationType.IDENTITY;

import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "payments")
@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class PaymentEntity {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private BigDecimal paymentAmount;
    @Enumerated(EnumType.STRING)
    private PaymentStatus paymentStatus;
    private String description;
}
