package com.hainet.graphql.spring.boot.sample.domain.entity;

import lombok.Data;

import java.time.LocalDate;

@Data
public class CreditCard {

    private int id;

    private String number;

    private LocalDate goodThru;

    private int brandId;

    private String securityCode;
}
