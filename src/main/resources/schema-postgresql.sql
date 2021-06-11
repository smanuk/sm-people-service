CREATE SCHEMA IF NOT EXISTS app AUTHORIZATION admin;

CREATE TABLE IF NOT EXISTS person(
    id bigserial PRIMARY KEY,
    first_name varchar(100),
    last_name varchar(100),
    date_of_birth date,
    country_code char(2)
);
