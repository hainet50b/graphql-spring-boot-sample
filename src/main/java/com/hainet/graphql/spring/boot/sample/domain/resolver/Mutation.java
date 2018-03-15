package com.hainet.graphql.spring.boot.sample.domain.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.hainet.graphql.spring.boot.sample.domain.dao.PersonDao;
import com.hainet.graphql.spring.boot.sample.domain.model.Person;
import org.springframework.stereotype.Component;

@Component
public class Mutation implements GraphQLMutationResolver {

    private final PersonDao dao;

    public Mutation(final PersonDao dao) {
        this.dao = dao;
    }

    public Person createPerson(final String name) {
        final Person person = new Person();
        person.setName(name);

        return person;
    }
}
