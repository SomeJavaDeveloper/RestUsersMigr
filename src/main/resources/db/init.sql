
CREATE TABLE users (
    id    SERIAL PRIMARY KEY,
    name VARCHAR (255) NOT NULL,
    surname VARCHAR (255) NOT NULL,
    birth_date TIMESTAMP NOT NULL,
    login VARCHAR (255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    description VARCHAR(300) NOT NULL,
    address VARCHAR(255) NOT NULL
);
