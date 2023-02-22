CREATE TABLE person (
    id INTEGER NOT NULL PRIMARY KEY,
    name VARCHAR NOT NULL,
    age INTEGER NOT NULL,
    birth_date DATE NOT NULL,
    include_date DATE NOT NULL,
    update_date DATE NOT NULL,
    active BOOLEAN NOT NULL
);

CREATE SEQUENCE person_seq INCREMENT 1 START 1 OWNED BY person.id;

-------------------------------------------------------------------------------------------------------------------

CREATE TABLE email (
    id INTEGER NOT NULL PRIMARY KEY,
    description VARCHAR NOT NULL,
    is_main_email BOOLEAN NOT NULL,
    person_id INTEGER NOT NULL,
    include_date DATE NOT NULL,
    update_date DATE NOT NULL,
    active BOOLEAN NOT NULL
);

CREATE SEQUENCE email_seq INCREMENT 1 START 1 OWNED BY email.id;

ALTER TABLE email
    ADD CONSTRAINT fk_email_to_person
    FOREIGN KEY(person_id) REFERENCES person(id);

-------------------------------------------------------------------------------------------------------------------

CREATE TABLE phone (
    id INTEGER NOT NULL PRIMARY KEY,
    phone_number VARCHAR NOT NULL,
    is_main_phone_number BOOLEAN NOT NULL,
    person_id INTEGER NOT NULL,
    include_date DATE NOT NULL,
    update_date DATE NOT NULL,
    active BOOLEAN NOT NULL
);

CREATE SEQUENCE phone_seq INCREMENT 1 START 1 OWNED BY phone.id;

ALTER TABLE phone
    ADD CONSTRAINT fk_phone_to_person
    FOREIGN KEY(person_id) REFERENCES person(id);

-------------------------------------------------------------------------------------------------------------------

CREATE TABLE bills (
    id INTEGER NOT NULL PRIMARY KEY,
    description VARCHAR NOT NULL,
    large_description VARCHAR,
    start_date DATE NOT NULL,
    end_date DATE NOT NULL,
    total_value REAL NOT NULL,
    is_single_payment BOOLEAN NOT NULL,
    number_installments INTEGER NOT NULL,
    category INTEGER NOT NULL,
    is_payed BOOLEAN NOT NULL,
    person_id INTEGER NOT NULL,
    include_date DATE NOT NULL,
    update_date DATE NOT NULL,
    active BOOLEAN NOT NULL
);

CREATE SEQUENCE bills_seq INCREMENT 1 START 1 OWNED BY bills.id;

ALTER TABLE bills
    ADD CONSTRAINT fk_bills_to_person
    FOREIGN KEY(person_id) REFERENCES person(id);


-------------------------------------------------------------------------------------------------------------------

CREATE TABLE installment (
    id INTEGER NOT NULL PRIMARY KEY,
    value REAL NOT NULL,
    payment_date DATE NOT NULL,
    is_payed BOOLEAN NOT NULL,
    bills_id INTEGER NOT NULL,
    include_date DATE NOT NULL,
    update_date DATE NOT NULL,
    active BOOLEAN NOT NULL
);

CREATE SEQUENCE installment_seq INCREMENT 1 START 1 OWNED BY installment.id;

ALTER TABLE installment
    ADD CONSTRAINT fk_installment_to_bills
    FOREIGN KEY(bills_id) REFERENCES bills(id);

-------------------------------------------------------------------------------------------------------------------

CREATE TABLE role (
    id INTEGER NOT NULL PRIMARY KEY,
    role INTEGER NOT NULL,
    include_date DATE NOT NULL,
    update_date DATE NOT NULL,
    active BOOLEAN NOT NULL
);

CREATE SEQUENCE role_seq INCREMENT 1 START 1 OWNED BY role.id;

-------------------------------------------------------------------------------------------------------------------

CREATE TABLE users (
    id INTEGER NOT NULL PRIMARY KEY,
    username VARCHAR NOT NULL,
    password VARCHAR NOT NULL,
    role_id INTEGER NOT NULL,
    include_date DATE NOT NULL,
    update_date DATE NOT NULL,
    active BOOLEAN NOT NULL
);

CREATE SEQUENCE users_seq INCREMENT 1 START 1 OWNED BY users.id;

ALTER TABLE users
    ADD CONSTRAINT fk_users_to_role
    FOREIGN KEY(role_id) REFERENCES role(id);

-------------------------------------------------------------------------------------------------------------------