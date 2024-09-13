package com.hibernate.entity;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

import static jakarta.persistence.CascadeType.ALL;
import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Setter
@Getter
@EqualsAndHashCode(of = "id")
public class Customer {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String name;
    @Enumerated(value =EnumType.STRING)
    CustomerType customerType;
    @Embedded
    Metadata metadata;

    @OneToMany(mappedBy = "customer", cascade = ALL)
    List<Product> products;
}
