CREATE DATABASE bus_station;
USE bus_station;

CREATE TABLE passengers (
    id INT NOT NULL AUTO_INCREMENT,
    surname varchar(64) NOT NULL ,
    name varchar(64) NOT NULL,
    patronymic varchar(64) NOT NULL,
    phone varchar(16) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE cities (
    id INT NOT NULL AUTO_INCREMENT,
    name varchar(64) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE bus_models (
    id INT NOT NULL AUTO_INCREMENT,
    name varchar(256) NOT NULL,
    seats_number SMALLINT NOT NULL CHECK(seats_number > 0),
    PRIMARY KEY (id)
);

CREATE TABLE buses (
    id INT NOT NULL AUTO_INCREMENT,
    model_id INT NOT NULL,
    color varchar(16),
    licence_plate_number varchar(16),
    PRIMARY KEY (id),
    FOREIGN KEY (model_id) REFERENCES bus_models(id)
);

CREATE TABLE journeys (
    id INT NOT NULL AUTO_INCREMENT,
    bus_id INT NOT NULL,
    platform_number INT NOT NULL CHECK(platform_number > 0),
    PRIMARY KEY (id),
    FOREIGN KEY (bus_id) REFERENCES buses(id)
);

CREATE TABLE stops (
    id INT NOT NULL,
    journey_id INT NOT NULL,
    city_id INT NOT NULL,
    time TIMESTAMP NOT NULL,
    price INT NOT NULL CHECK(price > 0),
    PRIMARY KEY (id, journey_id),
    FOREIGN KEY (journey_id) REFERENCES journeys(id),
    FOREIGN KEY (city_id) REFERENCES cities(id)
);

CREATE TABLE orders (
    id INT NOT NULL,
    passenger_id INT NOT NULL,
    journey_id INT NOT NULL,
    seat_number INT NOT NULL,
    stop_number_from INT NOT NULL CHECK(stop_number_from > 0),
    stop_number_to INT NOT NULL CHECK(stop_number_from > 0),
    PRIMARY KEY (id),
    FOREIGN KEY (passenger_id) REFERENCES passengers(id),
    FOREIGN KEY (journey_id) REFERENCES journeys(id)
);
