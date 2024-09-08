package com.hibernate.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import static jakarta.persistence.GenerationType.IDENTITY;

@Table
@Entity
@Setter
@Getter
public class Product {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
}
