package com.tv12.busstation.repositories;

import com.tv12.busstation.entities.JourneyStop;
import com.tv12.busstation.entities.JourneyStopPrimaryKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.sql.Timestamp;

public interface JourneyStopsRepository extends JpaRepository<JourneyStop, JourneyStopPrimaryKey> {
    @Query(value = """
                   SELECT sum(price) AS price
                    FROM journey_stops
                    WHERE
                        journey_id = ? AND
                        timestamp > ? AND
                        timestamp <= ?
                    GROUP BY journey_id
                   """, nativeQuery = true)
    int getTripPrice(Integer journeyId, Timestamp from, Timestamp to);

    @Query(value = "SELECT * FROM journey_stops WHERE journey_id = ? AND stop_id = ?", nativeQuery = true)
    JourneyStop getJourneyStop(int journeyId, int stopId);
}
