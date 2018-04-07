# GraphQL Spring Boot Sample
## How to GraphiQL
1. Launch this APP.
1. Access to http://localhost:8080/graphiql.
1. Enter queries below and hit Ctrl+Return.
```
# Queries
query {
  findCreditCards {
    id
    number,
    goodThru,
    securityCode
  },
  findValidatedCreditCards {
    id,
    number,
    goodThru,
    securityCode
  }
  findBrands {
    id
    name
  }
}

mutation CreditCard($payload: CreditCardPayload!) {
  createCreditCard(payload: $payload) {
    id,
    number,
    goodThru,
    brand {
      id,
      name
    },
    securityCode
  }
}

mutation ValidatedCreditCard($validatedPayload: ValidatedCreditCardPayload!) {
    createValidatedCreditCard(payload: $validatedPayload) {
    id,
    number,
    goodThru,
    brand {
      id,
      name
    },
    securityCode
  }
}

mutation {
  createBrand(name: "MASTER") {
    id,
    name
  }
}

# Variables
{
  "payload": {
    "number": "2234567890123456",
    "goodThru": "2018-04-18",
    "brandId": 1,
    "securityCode": "1234"
  },
  "validatedPayload": {
    "number": "3234567890123456",
    "goodThru": "2018-04",
    "brandId": 1,
    "securityCode": "1234"
  }
}
```
