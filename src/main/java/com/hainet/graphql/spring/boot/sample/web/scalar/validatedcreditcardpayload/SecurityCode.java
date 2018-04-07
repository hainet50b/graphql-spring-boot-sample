package com.hainet.graphql.spring.boot.sample.web.scalar.validatedcreditcardpayload;

import graphql.language.StringValue;
import graphql.schema.Coercing;
import graphql.schema.CoercingParseValueException;
import graphql.schema.CoercingSerializeException;
import graphql.schema.GraphQLScalarType;
import org.springframework.stereotype.Component;

@Component
public class SecurityCode extends GraphQLScalarType {

    public SecurityCode() {
        super("SecurityCode", "ValidatedCreditCardPayload.SecurityCode", new Coercing() {
            @Override
            public String serialize(final Object dataFetcherResult) {
                return this.serializeSecurityCode(dataFetcherResult);
            }

            @Override
            public String parseValue(final Object input) {
                return this.parseSecurityCodeFromVariable(input);
            }

            @Override
            public String parseLiteral(final Object input) {
                return this.parseSecurityCodeFromAstLiteral(input);
            }

            private String serializeSecurityCode(final Object dataFetcherResult) {
                if (dataFetcherResult instanceof String) {
                    return dataFetcherResult.toString();
                }
                throw new CoercingSerializeException("Unable to serialize!");
            }

            private boolean looksLikeAnSecurityCode(final String securityCode) {
                return securityCode.matches("[0-9]{3,4}");
            }

            private String parseSecurityCodeFromVariable(final Object input) {
                if (input instanceof String) {
                    final String possibleSecurityCodeValue = input.toString();
                    if (this.looksLikeAnSecurityCode(possibleSecurityCodeValue)) {
                        return possibleSecurityCodeValue;
                    }
                }
                throw new CoercingParseValueException("Unable to parse value!");
            }

            private String parseSecurityCodeFromAstLiteral(final Object input) {
                if (input instanceof StringValue) {
                    final String possibleSecurityCodeValue = ((StringValue) input).getValue();
                    if (this.looksLikeAnSecurityCode(possibleSecurityCodeValue)) {
                        return possibleSecurityCodeValue;
                    }
                }
                throw new CoercingParseValueException("Unable to parse value!");
            }
        });
    }

}
