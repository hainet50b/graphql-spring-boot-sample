package com.hainet.graphql.spring.boot.sample.domain.model;

import lombok.Data;

import java.util.List;

@Data
public class BookFilter {

    private List<Integer> ids;

    private List<String> titles;

    private List<Integer> publisherIds;

    private List<Integer> authorIds;
}
