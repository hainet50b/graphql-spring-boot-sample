CREATE TABLE book (
  id           INT AUTO_INCREMENT,
  title        VARCHAR NOT NULL UNIQUE,
  publisher_id INT     NOT NULL,
  author_id    INT     NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE publisher (
  id   INT AUTO_INCREMENT,
  name VARCHAR NOT NULL UNIQUE,
  PRIMARY KEY (id)
);

CREATE TABLE author (
  id   INT AUTO_INCREMENT,
  name VARCHAR NOT NULL UNIQUE,
  PRIMARY KEY (id)
);

CREATE TABLE book_author (
  id        INT AUTO_INCREMENT,
  book_id   INT NOT NULL,
  author_id INT NOT NULL,
  PRIMARY KEY (id)
);
