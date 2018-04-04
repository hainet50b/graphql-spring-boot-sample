package com.hainet.graphql.spring.boot.sample.web.query;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.hainet.graphql.spring.boot.sample.domain.dao.CreditCardDao;
import com.hainet.graphql.spring.boot.sample.domain.entity.CreditCard;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class CreditCardQuery implements GraphQLQueryResolver {

    private final CreditCardDao dao;

    public List<CreditCard> findCreditCards() {
        return dao.findAll();
    }
}
