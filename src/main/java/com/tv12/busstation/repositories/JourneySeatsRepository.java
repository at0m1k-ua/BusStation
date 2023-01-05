package com.tv12.busstation.repositories;

import com.tv12.busstation.entities.JourneySeat;
import com.tv12.busstation.entities.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.sql.Timestamp;

public interface JourneySeatsRepository extends JpaRepository<Ticket, JourneySeat> {

    @Query(value = """
                   SELECT EXISTS(
                        SELECT ticket_id
                        FROM journey_seats
                        WHERE
                            journey_id = ?1 AND
                            seat_number = ?2 AND
                            timestamp_from < ?4 AND
                            timestamp_to > ?3
                    )
                   """, nativeQuery = true)
    int seatIsBusy(int journeyId, int seatNumber, Timestamp timestamp_from, Timestamp timestamp_to);
}
