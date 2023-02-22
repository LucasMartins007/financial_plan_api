CREATE TABLE email (
    id INTEGER NOT NULL PRIMARY KEY,
    description VARCHAR NOT NULL,
    is_main_email BOOLEAN NOT NULL,
    person_id INTEGER NOT NULL
);

CREATE SEQUENCE email_sequence INCREMENT 1 START 1 OWNED BY email.id;

ALTER TABLE email
    ADD CONSTRAINT fk_email_to_person
    FOREIGN KEY(person_id) REFERENCES person(id);