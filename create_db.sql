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
    phone varchar(32) NOT NULL,
    email varchar(64) NOT NULL,
    journey_id INT NOT NULL,
    seat_number INT NOT NULL,
    stop_number_from INT NOT NULL,
    CHECK(stop_number_from > 0),
    stop_number_to INT NOT NULL,
    price INT NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT now(),
    CHECK(price > 0),
    CHECK(stop_number_to > 0),
    PRIMARY KEY (id),
    FOREIGN KEY (journey_id) REFERENCES journeys(id),
    FOREIGN KEY (stop_number_from) REFERENCES stops(id),
    FOREIGN KEY (stop_number_to) REFERENCES stops(id)
);

CREATE VIEW journey_stops AS
SELECT
    journeys.id AS journey_id,
    stops.id AS stop_id,
    stops.price AS price,
    cities.name AS city_name,
    TIMESTAMP(start_date + INTERVAL day_shift DAY, time) AS timestamp
FROM journeys
    JOIN routes ON journeys.route_id = routes.id
    JOIN stops ON routes.id = stops.route_id
    JOIN cities ON city_id = cities.id
ORDER BY journey_id, timestamp;

CREATE VIEW trips AS
SELECT * FROM (
    SELECT
        journey_stops_from.journey_id AS journey_id,
        from_stop_id,
        to_stop_id,
        from_city_name,
        to_city_name,
        from_timestamp,
        to_timestamp
    FROM (
        SELECT
            journey_id,
            stop_id as from_stop_id,
            city_name AS from_city_name,
            timestamp AS from_timestamp
        FROM
            journey_stops
    ) AS journey_stops_from JOIN (
        SELECT
            journey_id,
            stop_id AS to_stop_id,
            city_name AS to_city_name,
            timestamp AS to_timestamp
        FROM
            journey_stops
    )
    AS journey_stops_to
    ON journey_stops_from.journey_id = journey_stops_to.journey_id
) AS unfiltered WHERE from_timestamp < to_timestamp;

CREATE VIEW journey_seats AS
SELECT
    tickets.id AS ticket_id,
    journey_stops_from.journey_id,
    journey_stops_from.timestamp AS timestamp_from,
    journey_stops_to.timestamp AS timestamp_to,
    seat_number
FROM tickets
   JOIN journey_stops
   AS journey_stops_from
   ON tickets.journey_id = journey_stops_from.journey_id AND
      tickets.stop_number_from = journey_stops_from.stop_id
   JOIN journey_stops
   AS journey_stops_to
   ON tickets.journey_id = journey_stops_from.journey_id AND
      tickets.stop_number_to = journey_stops_to.stop_id;
