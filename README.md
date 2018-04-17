# GraphQL Spring Boot Sample
2018年4月18日に行われる「JSUG勉強会 2018年その3 LT大会」で発表してきます。  
イベント詳細：https://jsug.doorkeeper.jp/events/72113  
スライド：後日アップロード

## How to GraphiQL
1. Launch this APP.
1. Access to http://localhost:8080/graphiql.
1. Enter queries below and hit Ctrl+Return.
```
# Queries
query {
  findCreditCards {
    id,
    number,
    goodThru,
    securityCode
  },
  findCreditCardById(id: 1) {
    id,
    number,
    goodThru,
    securityCode
  }
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

query {
  rabbit,
  turtle
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
