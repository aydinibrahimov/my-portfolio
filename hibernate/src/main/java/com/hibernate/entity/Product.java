package com.hibernate.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Builder
@Getter
@Setter
@EqualsAndHashCode(of = "id")

public class Product {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String title;
    @Embedded
    Metadata metadata;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    Customer customer;

}
