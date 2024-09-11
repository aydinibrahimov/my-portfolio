package com.hibernate.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

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
    @JsonProperty("metadata")
    Metadata metadata;
}
