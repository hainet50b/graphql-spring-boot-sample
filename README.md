# Sample requests
```
query {
  findBooks {
    id,
    title,
    author {
      id,
      name
    }
  }
}

mutation {
  createBook(title: "Buch der Lieder", authorId: 2) {
    id,
    title,
    author {
      id,
      name
    }
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
