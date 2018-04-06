package com.hainet.graphql.spring.boot.sample.web.mutation;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.hainet.graphql.spring.boot.sample.domain.dao.CreditCardDao;
import com.hainet.graphql.spring.boot.sample.domain.entity.CreditCard;
import com.hainet.graphql.spring.boot.sample.web.payload.CreditCardPayload;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CreditCardMutation implements GraphQLMutationResolver {

    private final CreditCardDao dao;

    public CreditCard createCreditCard(final CreditCardPayload payload) {
        final CreditCard creditCard = new CreditCard();
        creditCard.setNumber(payload.getNumber());
        creditCard.setGoodThru(payload.getGoodThru());
        creditCard.setBrandId(payload.getBrandId());
        creditCard.setSecurityCode(payload.getSecurityCode());

        dao.insert(creditCard);

        return creditCard;
    }
}
