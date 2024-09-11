package com.hibernate.entity;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Setter
@Getter
@EqualsAndHashCode(of ="id" )
public class Product {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String product;
    @Embedded
    Metadata metadata;

}
