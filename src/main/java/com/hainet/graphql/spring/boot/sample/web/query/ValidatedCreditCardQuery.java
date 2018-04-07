package com.hainet.graphql.spring.boot.sample.web.query;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.hainet.graphql.spring.boot.sample.domain.dao.ValidatedCreditCardDao;
import com.hainet.graphql.spring.boot.sample.domain.entity.ValidatedCreditCard;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ValidatedCreditCardQuery implements GraphQLQueryResolver {

    private final ValidatedCreditCardDao dao;

    public List<ValidatedCreditCard> findValidatedCreditCards() {
        return dao.findAll();
    }
}
