CREATE TABLE package (
    id SERIAL PRIMARY KEY,
    type TEXT
);

CREATE TABLE carrier (
    id SERIAL PRIMARY KEY,
    name TEXT
);

CREATE TABLE car (
    id SERIAL PRIMARY KEY,
    model TEXT,
    type TEXT
);

CREATE TABLE paymentType (
    id SERIAL PRIMARY KEY,
    type TEXT
);

CREATE TABLE freight (
    id SERIAL PRIMARY KEY,
    dateFreight TEXT,
    status TEXT,
    carrier_id BIGINT,
    driver_id BIGINT,
    package_id BIGINT,
    paymentType_id BIGINT,
    CONSTRAINT fk_driver FOREIGN KEY (driver_id) REFERENCES driver(id),
    CONSTRAINT fk_carrier FOREIGN KEY (carrier_id) REFERENCES carrier(id),
    CONSTRAINT fk_package FOREIGN KEY (package_id) REFERENCES package(id),
    CONSTRAINT fk_paymentType FOREIGN KEY (paymentType_id) REFERENCES paymentType(id)
);

