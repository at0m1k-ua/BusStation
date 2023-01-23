package com.tv12.busstation.repositories;

import com.tv12.busstation.entities.JourneyStop;
import com.tv12.busstation.entities.JourneyStopPrimaryKey;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
@Repository
public interface JourneyStopsRepository extends CrudRepository<JourneyStop, JourneyStopPrimaryKey> {
    @Query(value = """
                   SELECT sum(price) AS price
                    FROM journey_stops
                    WHERE
                        journey_id = ? AND
                        timestamp > ? AND
                        timestamp <= ?
                    GROUP BY journey_id
                   """)
    int getTripPrice(Integer journeyId, Timestamp from, Timestamp to);

    @Query(value = "SELECT * FROM journey_stops WHERE journey_id = ? AND stop_id = ?")
    JourneyStop getJourneyStop(int journeyId, int stopId);
}
