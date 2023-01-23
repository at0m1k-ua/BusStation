package com.tv12.busstation.repositories;

import com.tv12.busstation.entities.Trip;
import com.tv12.busstation.entities.TripPrimaryKey;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import java.sql.Date;
import java.util.List;

public interface TripsRepository extends CrudRepository<Trip, TripPrimaryKey> {
    @Query(value = """
                   SELECT *
                    FROM trips
                    WHERE
                        from_city_name = ? AND
                        to_city_name = ? AND
                        DATE(from_timestamp) = ?
                   """)
    List<Trip> findByCitiesAndDepartureDate(String from, String to, Date departureDate);
}
