package com.hainet.graphql.spring.boot.sample.web.mutation;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.hainet.graphql.spring.boot.sample.domain.dao.BrandDao;
import com.hainet.graphql.spring.boot.sample.domain.entity.Brand;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BrandMutation implements GraphQLMutationResolver {

    private final BrandDao dao;

    public Brand createBrand(final String name) {
        final Brand brand = new Brand();
        brand.setName(name);

        this.dao.insert(brand);

        return brand;
    }
}
