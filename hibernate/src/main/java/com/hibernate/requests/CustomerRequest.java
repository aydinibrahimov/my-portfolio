package com.hibernate.requests;

import lombok.Builder;

import java.sql.Timestamp;


@Builder
public class CustomerRequest {

    public String name;
    public Timestamp createDate;
    public Timestamp updateDate;
}
