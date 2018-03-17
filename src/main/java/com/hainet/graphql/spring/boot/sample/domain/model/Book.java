package com.hainet.graphql.spring.boot.sample.domain.model;

import lombok.Data;

@Data
public class Book {

    private int id;

    private String title;

    private int authorId;
}
