package com.hainet.graphql.spring.boot.sample.web.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.hainet.graphql.spring.boot.sample.domain.dao.BrandDao;
import com.hainet.graphql.spring.boot.sample.domain.entity.Brand;
import com.hainet.graphql.spring.boot.sample.domain.entity.ValidatedCreditCard;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ValidatedCreditCardResolver implements GraphQLResolver<ValidatedCreditCard> {

    private final BrandDao brandDao;

    public Brand brand(final ValidatedCreditCard creditCard) {
        return this.brandDao.findById(creditCard.getBrandId());
    }
}
