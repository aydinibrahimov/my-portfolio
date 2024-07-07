package com.example.ms.cybernet.ingress.model.response;

import com.example.ms.cybernet.ingress.model.enums.PaymentStatus;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Builder
@Data
public class PaymentResponse {
  private  Long id;
  private  PaymentStatus paymentStatus;
  private  String description;
  private  BigDecimal paymentAmount;

}
