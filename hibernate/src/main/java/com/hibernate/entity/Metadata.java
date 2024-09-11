package com.hibernate.entity;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Embeddable
@Setter
@Getter
public class Metadata {
    private String createDate;
    private String updateDate;
}
