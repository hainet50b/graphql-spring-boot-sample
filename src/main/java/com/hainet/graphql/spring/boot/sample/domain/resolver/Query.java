package com.hainet.graphql.spring.boot.sample.domain.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.hainet.graphql.spring.boot.sample.domain.dao.PersonDao;
import com.hainet.graphql.spring.boot.sample.domain.model.Person;
import org.springframework.stereotype.Component;

@Component

public class Query implements GraphQLQueryResolver {

    private final PersonDao dao;

    public Query(final PersonDao dao) {
        this.dao = dao;
    }

    public Iterable<Person> findAll() {
        return dao.findAll();
    }
}
