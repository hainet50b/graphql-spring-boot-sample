package com.hainet.graphql.spring.boot.sample.web.scalar.validatedcreditcardpayload;

import graphql.language.StringValue;
import graphql.schema.Coercing;
import graphql.schema.CoercingParseValueException;
import graphql.schema.CoercingSerializeException;
import graphql.schema.GraphQLScalarType;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;

@Component
public class GoodThru extends GraphQLScalarType {

    public GoodThru() {
        super("GoodThru", "ValidatedCreditCardPayload.GoodThru", new Coercing() {
            private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM");

            @Override
            public String serialize(final Object dataFetcherResult) {
                return this.serializeGoodThru(dataFetcherResult);
            }

            @Override
            public LocalDate parseValue(final Object input) {
                return this.parseGoodThruFromVariable(input);
            }

            @Override
            public LocalDate parseLiteral(final Object input) {
                return this.parseGoodThruFromAstLiteral(input);
            }

            private String serializeGoodThru(final Object dataFetcherResult) {
                if (dataFetcherResult instanceof LocalDate) {
                    return ((LocalDate) dataFetcherResult).format(formatter);
                }
                throw new CoercingSerializeException("Unable to serialize!");
            }

            private LocalDate parseGoodThru(final String goodThru) {
                try {
                    return YearMonth.parse(goodThru).atDay(1);
                } catch (Exception e) {
                    throw new CoercingParseValueException("Unable to parse value!", e);
                }
            }

            private LocalDate parseGoodThruFromVariable(final Object input) {
                if (input instanceof String) {
                    return this.parseGoodThru(input.toString());
                }
                throw new CoercingParseValueException("Unable to parse value!");
            }

            private LocalDate parseGoodThruFromAstLiteral(final Object input) {
                if (input instanceof StringValue) {
                    return this.parseGoodThru(((StringValue) input).getValue());
                }
                throw new CoercingParseValueException("Unable to parse value!");
            }
        });
    }
}
