package com.hainet.graphql.spring.boot.sample.web.payload;

import lombok.Data;

import java.time.LocalDate;

@Data
public class CreditCardPayload {

    private String number;

    private LocalDate goodThru;

    private int brandId;

    private String securityCode;
}
