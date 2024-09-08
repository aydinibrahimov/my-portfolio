package com.hibernate.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import static jakarta.persistence.GenerationType.IDENTITY;

@Table
@Entity
@Setter
@Getter
public class Customer {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
}
