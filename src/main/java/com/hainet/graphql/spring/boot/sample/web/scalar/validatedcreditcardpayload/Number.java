package com.hainet.graphql.spring.boot.sample.web.scalar.validatedcreditcardpayload;

import graphql.language.StringValue;
import graphql.schema.Coercing;
import graphql.schema.CoercingParseValueException;
import graphql.schema.CoercingSerializeException;
import graphql.schema.GraphQLScalarType;
import org.springframework.stereotype.Component;

@Component
public class Number extends GraphQLScalarType {

    public Number() {
        super("Number", "ValidatedCreditCardPayload.Number", new Coercing() {
            @Override
            public String serialize(final Object dataFetcherResult) {
                return Number.serializeNumber(dataFetcherResult);
            }

            @Override
            public String parseValue(final Object input) {
                return Number.parseNumberFromVariable(input);
            }

            @Override
            public String parseLiteral(final Object input) {
                return Number.parseNumberFromAstLiteral(input);
            }
        });
    }

    private static String serializeNumber(final Object dataFetcherResult) {
        if (dataFetcherResult instanceof String) {
            return dataFetcherResult.toString();
        }
        throw new CoercingSerializeException("Unable to serialize!");
    }

    private static boolean looksLikeAnNumber(final String number) {
        return number.matches("[0-9]{14,16}");
    }

    private static String parseNumberFromVariable(final Object input) {
        if (input instanceof String) {
            final String possibleNumberValue = input.toString();
            if (looksLikeAnNumber(possibleNumberValue)) {
                return possibleNumberValue;
            }
        }
        throw new CoercingParseValueException("Unable to parse value!");
    }

    private static String parseNumberFromAstLiteral(final Object input) {
        if (input instanceof StringValue) {
            final String possibleNumberValue = ((StringValue) input).getValue();
            if (looksLikeAnNumber(possibleNumberValue)) {
                return possibleNumberValue;
            }
        }
        throw new CoercingParseValueException("Unable to parse value!");
    }
}
