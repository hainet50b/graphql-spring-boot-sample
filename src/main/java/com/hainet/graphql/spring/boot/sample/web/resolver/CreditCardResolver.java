package com.hainet.graphql.spring.boot.sample.web.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.hainet.graphql.spring.boot.sample.domain.dao.BrandDao;
import com.hainet.graphql.spring.boot.sample.domain.entity.Brand;
import com.hainet.graphql.spring.boot.sample.domain.entity.CreditCard;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CreditCardResolver implements GraphQLResolver<CreditCard> {

    private final BrandDao brandDao;

    public Brand getBrand(final CreditCard creditCard) {
        return this.brandDao.findById(creditCard.getBrandId());
    }
}
