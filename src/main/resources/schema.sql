CREATE TABLE brand (
  id   INT AUTO_INCREMENT,
  name VARCHAR(10) NOT NULL UNIQUE,
  PRIMARY KEY (id)
);

CREATE TABLE credit_card (
  id            INT AUTO_INCREMENT,
  number        VARCHAR(16) NOT NULL UNIQUE,
  good_thru     DATE        NOT NULL,
  brand_id      INT         NOT NULL,
  security_code VARCHAR(4)  NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (brand_id) REFERENCES brand (id)
);
