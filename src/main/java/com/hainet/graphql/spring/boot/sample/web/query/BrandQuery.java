package com.hainet.graphql.spring.boot.sample.web.query;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.hainet.graphql.spring.boot.sample.domain.dao.BrandDao;
import com.hainet.graphql.spring.boot.sample.domain.entity.Brand;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class BrandQuery implements GraphQLQueryResolver {

    private final BrandDao dao;

    public List<Brand> findBrands() {
        return dao.findAll();
    }

}
