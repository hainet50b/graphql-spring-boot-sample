package com.hainet.graphql.spring.boot.sample.config;

import com.hainet.graphql.spring.boot.sample.web.exception.GraphQLErrorHolder;
import graphql.ExceptionWhileDataFetching;
import graphql.GraphQLError;
import graphql.servlet.GraphQLErrorHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@Slf4j
public class GraphQLErrorHandlerConfig implements GraphQLErrorHandler {

    @Override
    public List<GraphQLError> processErrors(final List<GraphQLError> errors) {
        errors.stream()
                .filter(this::isServerError)
                .forEach(error -> {
                    if (error instanceof Throwable) {
                        log.error("Error executing query!", (Throwable) error);
                    } else {
                        log.error(
                                "Error executing query ({}): {}",
                                error.getClass().getSimpleName(),
                                error.getMessage()
                        );
                    }
                });

        return errors.stream()
                .map(GraphQLErrorHolder::new)
                .collect(Collectors.toList());
    }

    private boolean isServerError(final GraphQLError error) {
        return error instanceof ExceptionWhileDataFetching || error instanceof Throwable;
    }
}
