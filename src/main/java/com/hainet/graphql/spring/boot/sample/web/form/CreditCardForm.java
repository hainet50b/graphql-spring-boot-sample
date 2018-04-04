package com.hainet.graphql.spring.boot.sample.web.form;

import lombok.Data;

import java.time.LocalDate;

@Data
public class CreditCardForm {

    private String number;

    private LocalDate goodThru;

    private int brandId;

    private String securityCode;
}
