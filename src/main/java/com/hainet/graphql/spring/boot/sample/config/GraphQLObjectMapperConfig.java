package com.hainet.graphql.spring.boot.sample.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import graphql.servlet.ObjectMapperConfigurer;
import org.springframework.stereotype.Component;

@Component
public class GraphQLObjectMapperConfig implements ObjectMapperConfigurer {

    @Override
    public void configure(final ObjectMapper mapper) {
        mapper.registerModule(new JavaTimeModule());
    }
}
