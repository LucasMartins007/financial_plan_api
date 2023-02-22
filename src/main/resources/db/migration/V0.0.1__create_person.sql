CREATE TABLE person (
    id INTEGER NOT NULL PRIMARY KEY,
    name VARCHAR NOT NULL,
    age INTEGER NOT NULL,
    birth_date DATE NOT NULL,
    include_date DATE NOT NULL,
    update_date DATE NOT NULL,
    active BOOLEAN NOT NULL
);

CREATE SEQUENCE person_sequence INCREMENT 1 START 1 OWNED BY person.id;