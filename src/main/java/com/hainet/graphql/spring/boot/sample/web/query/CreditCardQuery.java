package com.hainet.graphql.spring.boot.sample.web.query;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.hainet.graphql.spring.boot.sample.domain.dao.CreditCardDao;
import com.hainet.graphql.spring.boot.sample.domain.entity.CreditCard;
import com.hainet.graphql.spring.boot.sample.web.exception.GraphQLValidationError;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class CreditCardQuery implements GraphQLQueryResolver {

    private final CreditCardDao dao;

    public List<CreditCard> findCreditCards() {
        return this.dao.findAll();
    }

    public CreditCard findCreditCardById(final int id) {
        final CreditCard creditCard = this.dao.findById(id);
        if (creditCard == null) {
            final Map<String, Object> extensions = new HashMap<>();
            extensions.put("Target", id);

            throw new GraphQLValidationError("The credit card was not found!", extensions);
        }

        return creditCard;
    }
}
