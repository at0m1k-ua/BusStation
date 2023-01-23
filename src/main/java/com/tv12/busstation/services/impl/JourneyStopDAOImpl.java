package com.tv12.busstation.services.impl;

import com.tv12.busstation.entities.JourneyStop;
import com.tv12.busstation.repositories.JourneyStopsRepository;
import com.tv12.busstation.services.JourneyStopDAO;
import org.springframework.stereotype.Service;

@Service
public class JourneyStopDAOImpl implements JourneyStopDAO {
    private final JourneyStopsRepository journeyStopsRepository;

    public JourneyStopDAOImpl(JourneyStopsRepository journeyStopsRepository) {
        this.journeyStopsRepository = journeyStopsRepository;
    }

    @Override
    public JourneyStop getByIds(int journeyId, int stopId) {
        return journeyStopsRepository.getJourneyStop(journeyId, stopId);
    }
}
