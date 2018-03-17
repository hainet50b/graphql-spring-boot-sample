package com.hainet.graphql.spring.boot.sample.domain.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Author {

    public Author(final int id) {
        this.id = id;
    }

    private int id;

    private String name;
}
