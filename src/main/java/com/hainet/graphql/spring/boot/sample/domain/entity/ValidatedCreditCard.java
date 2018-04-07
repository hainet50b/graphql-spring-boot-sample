package com.hainet.graphql.spring.boot.sample.domain.entity;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ValidatedCreditCard {

    private int id;

    private String number;

    private LocalDate goodThru;

    private int brandId;

    private String securityCode;
}
