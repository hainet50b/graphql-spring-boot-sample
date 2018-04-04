package com.hainet.graphql.spring.boot.sample.web.scalar;

import graphql.language.StringValue;
import graphql.schema.Coercing;
import graphql.schema.CoercingParseValueException;
import graphql.schema.CoercingSerializeException;
import graphql.schema.GraphQLScalarType;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Component
public class GraphQLLocalDate extends GraphQLScalarType {

    public GraphQLLocalDate() {
        super("LocalDate", "Java 8 Date & Time API LocalDate", new Coercing() {
            @Override
            public String serialize(final Object dataFetcherResult) {
                if (dataFetcherResult instanceof LocalDate) {
                    return ((LocalDate) dataFetcherResult).format(DateTimeFormatter.ISO_DATE);
                }
                throw new CoercingSerializeException("Unable to serialize!");
            }

            @Override
            public LocalDate parseValue(final Object input) {
                if (input instanceof String) {
                    return LocalDate.parse(
                            input.toString(),
                            DateTimeFormatter.ISO_DATE
                    );
                }
                throw new CoercingParseValueException("Unable to parse value!");
            }

            @Override
            public LocalDate parseLiteral(final Object input) {
                if (input instanceof StringValue) {
                    return LocalDate.parse(
                            ((StringValue) input).getValue(),
                            DateTimeFormatter.ISO_DATE
                    );
                }
                throw new CoercingParseValueException("Unable to parse value!");
            }
        });
    }
}
