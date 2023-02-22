CREATE TABLE phone (
    id INTEGER NOT NULL PRIMARY KEY,
    phone_number VARCHAR NOT NULL,
    is_main_phone_number BOOLEAN NOT NULL,
    person_id INTEGER NOT NULL
);

CREATE SEQUENCE phone_sequence INCREMENT 1 START 1 OWNED BY phone.id;

ALTER TABLE phone
    ADD CONSTRAINT fk_phone_to_person
    FOREIGN KEY(person_id) REFERENCES person(id);