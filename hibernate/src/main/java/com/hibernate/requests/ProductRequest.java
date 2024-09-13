package com.hibernate.requests;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ProductRequest {
    private String title;
    private  CustomerRequest customerRequest;
}
