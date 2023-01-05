package com.tv12.busstation.services.impl;

import com.tv12.busstation.entities.JourneyStop;
import com.tv12.busstation.repositories.JourneyStopsRepository;
import com.tv12.busstation.services.JourneyStopsService;
import org.springframework.stereotype.Service;

@Service
public class JourneyStopsServiceImpl implements JourneyStopsService {
    private final JourneyStopsRepository journeyStopsRepository;

    public JourneyStopsServiceImpl(JourneyStopsRepository journeyStopsRepository) {
        this.journeyStopsRepository = journeyStopsRepository;
    }

    @Override
    public JourneyStop getByIds(int journeyId, int stopId) {
        return journeyStopsRepository.getJourneyStop(journeyId, stopId);
    }
}
