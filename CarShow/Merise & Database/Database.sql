DROP DATABASE IF EXISTS car_show;

CREATE DATABASE car_show;

\c car_show

CREATE TABLE IF NOT EXISTS car (
    id SERIAL PRIMARY KEY,
    name VARCHAR(250) NOT NULL,
    description TEXT,
    brand VARCHAR(250),
    model VARCHAR(250),
    price DOUBLE PRECISION,
    color VARCHAR(50),
    motor_type VARCHAR(250),
    power VARCHAR(500),
    place_number INT,
    status VARCHAR(100),
    type VARCHAR(250)
);

CREATE TABLE IF NOT EXISTS images (
    product_id SERIAL PRIMARY KEY NOT NULL,
    urL VARCHAR(500) NOT NULL
);

CREATE TABLE IF NOT EXISTS appointment (
    car_id INT PRIMARY KEY,
    name VARCHAR(250),
    firstname VARCHAR(250),
    email VARCHAR(250),
    message TEXT,
    contact CHAR(200),
    appointment_date TIMESTAMP,
    status VARCHAR(250) CHECK (status IN 
    (
        'pending',
        'validated',
        'rejected',
        'archived'
    ))
);

CREATE TABLE IF NOT EXISTS users (
    id SERIAL PRIMARY KEY,
    name VARCHAR(250) NOT NULL,
    email VARCHAR(250) NOT NULL,
    phone VARCHAR(250),
    password CHAR(30) NOT NULL
);

CREATE TABLE IF NOT EXISTS message (
    id SERIAL PRIMARY KEY,
    firstname VARCHAR(250),
    lastname VARCHAR(250),
    email VARCHAR(250),
    message TEXT
);

