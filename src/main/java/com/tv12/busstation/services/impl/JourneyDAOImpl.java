package com.tv12.busstation.services.impl;

import com.tv12.busstation.entities.Bus;
import com.tv12.busstation.entities.Driver;
import com.tv12.busstation.entities.Journey;
import com.tv12.busstation.entities.Route;
import com.tv12.busstation.repositories.BusesRepository;
import com.tv12.busstation.repositories.DriversRepository;
import com.tv12.busstation.repositories.JourneysRepository;
import com.tv12.busstation.repositories.RoutesRepository;
import com.tv12.busstation.services.JourneyDAO;
import org.springframework.stereotype.Service;

import java.sql.Date;

@Service
public class JourneyDAOImpl implements JourneyDAO {

    private final JourneysRepository journeysRepository;
    private final RoutesRepository routesRepository;
    private final BusesRepository busesRepository;
    private final DriversRepository driversRepository;

    public JourneyDAOImpl(JourneysRepository journeysRepository,
                          RoutesRepository routesRepository,
                          BusesRepository busesRepository,
                          DriversRepository driversRepository) {
        this.journeysRepository = journeysRepository;
        this.routesRepository = routesRepository;
        this.busesRepository = busesRepository;
        this.driversRepository = driversRepository;
    }

    @Override
    public void create(int routeId, int busId, int driverId, Date startDate) {
        Route route = routesRepository.findById(routeId).get();
        Bus bus = busesRepository.findById(busId).get();
        Driver driver = driversRepository.findById(driverId).get();
        journeysRepository.save(new Journey(null, route, bus, driver, startDate));
    }

    @Override
    public Iterable<Journey> readAll() {
        return journeysRepository.findAll();
    }

    @Override
    public Journey readById(int id) {
        return journeysRepository.findById(id).get();
    }

    @Override
    public void update(int id, int routeId, int busId, int driverId, Date startDate) {
        Journey journey = journeysRepository.findById(id).get();
        journey.setRoute(routesRepository.findById(routeId).get());
        journey.setBus(busesRepository.findById(busId).get());
        journey.setDriver(driversRepository.findById(driverId).get());
        journey.setStartDate(startDate);
        journeysRepository.save(journey);
    }

    @Override
    public void delete(int id) {
        journeysRepository.deleteById(id);
    }
}
