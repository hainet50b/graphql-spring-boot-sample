package com.hainet.graphql.spring.boot.sample.config;

import com.hainet.graphql.spring.boot.sample.web.exception.GraphQLErrorAdapter;
import graphql.GraphQLError;
import graphql.servlet.DefaultGraphQLErrorHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@Slf4j
public class GraphQLErrorHandlerConfig extends DefaultGraphQLErrorHandler {

    @Override
    public List<GraphQLError> processErrors(final List<GraphQLError> errors) {
        return errors.stream()
                .map(GraphQLErrorAdapter::new)
                .collect(Collectors.toList());
    }
}
