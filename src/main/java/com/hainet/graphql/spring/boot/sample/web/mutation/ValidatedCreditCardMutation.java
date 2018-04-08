package com.hainet.graphql.spring.boot.sample.web.mutation;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.hainet.graphql.spring.boot.sample.domain.dao.ValidatedCreditCardDao;
import com.hainet.graphql.spring.boot.sample.domain.entity.ValidatedCreditCard;
import com.hainet.graphql.spring.boot.sample.web.payload.CreditCardPayload;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ValidatedCreditCardMutation implements GraphQLMutationResolver {

    private final ValidatedCreditCardDao dao;

    public ValidatedCreditCard createValidatedCreditCard(final CreditCardPayload payload) {
        final ValidatedCreditCard creditCard = new ValidatedCreditCard();
        creditCard.setNumber(payload.getNumber());
        creditCard.setGoodThru(payload.getGoodThru());
        creditCard.setBrandId(payload.getBrandId());
        creditCard.setSecurityCode(payload.getSecurityCode());

        this.dao.insert(creditCard);

        return creditCard;
    }
}
