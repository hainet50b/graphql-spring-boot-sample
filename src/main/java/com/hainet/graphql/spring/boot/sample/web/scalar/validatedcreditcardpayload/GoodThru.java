package com.hainet.graphql.spring.boot.sample.web.scalar.validatedcreditcardpayload;

import graphql.language.StringValue;
import graphql.schema.Coercing;
import graphql.schema.CoercingParseValueException;
import graphql.schema.CoercingSerializeException;
import graphql.schema.GraphQLScalarType;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Component
public class GoodThru extends GraphQLScalarType {

    public GoodThru() {
        super("GoodThru", "ValidatedCreditCardPayload.SecurityCode", new Coercing() {
            @Override
            public String serialize(final Object dataFetcherResult) {
                return GoodThru.serializeGoodThru(dataFetcherResult);
            }

            @Override
            public LocalDate parseValue(final Object input) {
                return GoodThru.parseGoodThruFromVariable(input);
            }

            @Override
            public LocalDate parseLiteral(final Object input) {
                return GoodThru.parseGoodThruFromAstLiteral(input);
            }
        });
    }

    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM");

    private static String serializeGoodThru(final Object dataFetcherResult) {
        if (dataFetcherResult instanceof LocalDate) {
            return ((LocalDate) dataFetcherResult).format(formatter);
        }
        throw new CoercingSerializeException("Unable to serialize!");
    }

    private static LocalDate parseGoodThru(final String goodThru) {
        try {
            return LocalDate.parse(goodThru, formatter);
        } catch (Exception e) {
            throw new CoercingParseValueException("Unable to parse value!");
        }
    }

    private static LocalDate parseGoodThruFromVariable(final Object input) {
        if (input instanceof String) {
            return parseGoodThru(input.toString());
        }
        throw new CoercingParseValueException("Unable to parse value!");
    }

    private static LocalDate parseGoodThruFromAstLiteral(final Object input) {
        if (input instanceof StringValue) {
            return parseGoodThru(((StringValue) input).getValue());
        }
        throw new CoercingParseValueException("Unable to parse value!");
    }
}
