# GraphQL Spring Boot Sample
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
    brand {
      id,
      name
    }
  },
  findBrands {
    id,
    name
  }
}

mutation CreditCard($form: CreditCardForm!) {
  createCreditCard(form: $form) {
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
  "form": {
    "number": "2234567890123456",
    "goodThru": "2018-04-18",
    "brandId": 1,
    "securityCode": "1234"
  }
}
```
