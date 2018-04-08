package com.hainet.graphql.spring.boot.sample.web.exception;

import graphql.ErrorType;
import graphql.GraphQLError;
import graphql.language.SourceLocation;

import java.util.List;
import java.util.Map;

public class GraphQLValidationError extends RuntimeException implements GraphQLError {

    private Map<String, Object> extensions;

    public GraphQLValidationError(final String message) {
        super(message);
        this.extensions = null;
    }

    public GraphQLValidationError(final String message, final Map<String, Object> extensions) {
        super(message);
        this.extensions = extensions;
    }

    @Override
    public List<SourceLocation> getLocations() {
        return null;
    }

    @Override
    public ErrorType getErrorType() {
        return ErrorType.ValidationError;
    }

    @Override
    public Map<String, Object> getExtensions() {
        return this.extensions;
    }
}
