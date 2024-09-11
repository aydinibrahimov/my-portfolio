package com.hibernate.entity;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Embeddable
@Setter
@Getter
public class Metadata {

    private Timestamp createDate;
    private Timestamp updateDate;
}
