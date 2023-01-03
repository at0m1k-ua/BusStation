package com.tv12.busstation.repositories;

import com.tv12.busstation.entities.projections.SourceJourneyStopProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.tv12.busstation.entities.JourneyStop;

import java.util.List;

public interface JourneyStopsRepository extends JpaRepository<JourneyStop, Integer> {
    @Query(value = """
                   SELECT
                        journey_id,
                        stop_id,
                        city_name,
                        timestamp
                    FROM
                        journey_stops AS stops_from
                    WHERE
                        city_name = ? AND
                        DATE(timestamp) = ? AND
                        EXISTS(
                            SELECT
                                journey_id,
                                city_name,
                                timestamp
                            FROM
                                journey_stops AS stops_to
                            WHERE
                                stops_from.journey_id = stops_to.journey_id AND
                                stops_to.city_name = ? AND
                                stops_from.timestamp < stops_to.timestamp
                        );
                   """, nativeQuery = true)
    List<SourceJourneyStopProjection> getSourceJourneyStops(String from, String date, String to);
}
