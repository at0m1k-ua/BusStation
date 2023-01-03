package com.tv12.busstation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.tv12.busstation.entities.JourneyStop;

import java.sql.Timestamp;
import java.util.List;

public interface JourneyStopsRepository extends JpaRepository<JourneyStop, Integer> {
    @Query(value = """
                   SELECT *
                    FROM
                        journey_stops AS stops_from
                    WHERE
                        city_name = ?1 AND
                        DATE(timestamp) = ?3 AND
                        EXISTS(
                            SELECT
                                journey_id,
                                city_name,
                                timestamp
                            FROM
                                journey_stops AS stops_to
                            WHERE
                                stops_from.journey_id = stops_to.journey_id AND
                                stops_to.city_name = ?2 AND
                                stops_from.timestamp < stops_to.timestamp
                        );
                   """, nativeQuery = true)
    List<JourneyStop> getFromJourneyStops(String from, String to, String date);

    @Query(value = """
                   SELECT *
                    FROM
                        journey_stops
                    WHERE
                        journey_id = ? AND
                        city_name = ? AND
                        timestamp > ?
                    LIMIT 1;
                   """, nativeQuery = true)
    JourneyStop getToJourneyStop(Integer journeyId, String cityName, Timestamp timestamp);
}
