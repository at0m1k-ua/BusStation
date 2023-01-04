DROP DATABASE IF EXISTS bus_station;
CREATE DATABASE bus_station;
USE bus_station;

CREATE TABLE drivers (
    id INT NOT NULL AUTO_INCREMENT,
    surname varchar(64) NOT NULL,
    name varchar(64) NOT NULL,
    patronymic varchar(64) NOT NULL,
    phone varchar(16) NOT NULL,
    email varchar(64) NOT NULL,
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
    seats_number SMALLINT NOT NULL,
    CHECK(seats_number > 0),
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

CREATE TABLE routes (
    id INT NOT NULL AUTO_INCREMENT,
    PRIMARY KEY (id)
);

CREATE TABLE journeys (
    id INT NOT NULL AUTO_INCREMENT,
    route_id INT NOT NULL,
    bus_id INT NOT NULL,
    driver_id INT NOT NULL,
    start_date DATE NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (route_id) REFERENCES routes(id),
    FOREIGN KEY (bus_id) REFERENCES buses(id),
    FOREIGN KEY (driver_id) REFERENCES drivers(id)
);

CREATE TABLE stops (
    id INT NOT NULL AUTO_INCREMENT,
    route_id INT NOT NULL,
    city_id INT NOT NULL,
    day_shift INT NOT NULL,
    time TIME NOT NULL,
    price INT NOT NULL,
    CHECK(price >= 0),
    PRIMARY KEY (id, route_id),
    FOREIGN KEY (route_id) REFERENCES routes(id) ON DELETE CASCADE,
    FOREIGN KEY (city_id) REFERENCES cities(id)
);

CREATE TABLE tickets (
    id INT NOT NULL AUTO_INCREMENT,
    surname varchar(64) NOT NULL,
    name varchar(64) NOT NULL,
    phone varchar(16) NOT NULL,
    email varchar(64) NOT NULL,
    journey_id INT NOT NULL,
    seat_number INT NOT NULL,
    stop_number_from INT NOT NULL,
    CHECK(stop_number_from > 0),
    stop_number_to INT NOT NULL,
    price INT NOT NULL,
    CHECK(price > 0),
    CHECK(stop_number_to > 0),
    PRIMARY KEY (id),
    FOREIGN KEY (journey_id) REFERENCES journeys(id)
);

CREATE VIEW journey_stops AS
SELECT
    journeys.id AS journey_id,
    cities.name AS city_name,
    TIMESTAMP(start_date + INTERVAL day_shift DAY, time) AS timestamp
FROM journeys
         JOIN routes ON journeys.route_id = routes.id
         JOIN stops ON routes.id = stops.route_id
         JOIN cities ON city_id = cities.id
ORDER BY journey_id, timestamp;
