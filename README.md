# Sample requests
```
query {
  findBooks(filter: {
    ids: [1]
    titles: ["GraphQL"]
    publisherIds: [1]
    authorIds: [1]
  }) {
    id,
    title,
    publisher{
      id,
      name
    },
    authors {
      id,
      name
    }
  }
}

mutation {
  createBook(title: "Buch der Lieder", publisherId: 2, authorId: 2) {
    id,
    title,
    publisher {
      id,
      name
    }
    authors {
      id,
      name
    }
  }
}

mutation {
  relateAuthorToBook(bookId: 2, authorId: 2)
}

query {
  findPublishers {
    id,
    name
  }
}

mutation {
  createPublisher(name: "Iwanami") {
    id,
    name
  }
}

query {
  findAuthors {
    id,
    name
  }
}

mutation {
  createAuthor(name: "Heinrich Heine") {
    id,
    name
  }
}
```
