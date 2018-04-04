package com.hainet.graphql.spring.boot.sample.web.mutation;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.hainet.graphql.spring.boot.sample.domain.dao.CreditCardDao;
import com.hainet.graphql.spring.boot.sample.domain.entity.CreditCard;
import com.hainet.graphql.spring.boot.sample.web.form.CreditCardForm;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CreditCardMutation implements GraphQLMutationResolver {

    private final CreditCardDao dao;

    public CreditCard createCreditCard(final CreditCardForm form) {
        final CreditCard creditCard = new CreditCard();
        creditCard.setNumber(form.getNumber());
        creditCard.setGoodThru(form.getGoodThru());
        creditCard.setBrandId(form.getBrandId());
        creditCard.setSecurityCode(form.getSecurityCode());

        dao.insert(creditCard);

        return creditCard;
    }
}
