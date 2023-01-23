package com.tv12.busstation.services.impl;

import com.tv12.busstation.entities.City;
import com.tv12.busstation.entities.Route;
import com.tv12.busstation.entities.Stop;
import com.tv12.busstation.repositories.CitiesRepository;
import com.tv12.busstation.repositories.RoutesRepository;
import com.tv12.busstation.repositories.StopsRepository;
import com.tv12.busstation.services.StopDAO;
import org.springframework.stereotype.Service;

import java.sql.Time;

@Service
public class StopDAOImpl implements StopDAO {

    private final RoutesRepository routesRepository;
    private final StopsRepository stopsRepository;
    private final CitiesRepository citiesRepository;

    public StopDAOImpl(RoutesRepository routesRepository,
                       StopsRepository stopsRepository,
                       CitiesRepository citiesRepository) {
        this.routesRepository = routesRepository;
        this.stopsRepository = stopsRepository;
        this.citiesRepository = citiesRepository;
    }

    @Override
    public void create(int routeId, int cityId, int dayShift, Time time, int price) {
        save(null, routeId, cityId, dayShift, time, price);
    }

    @Override
    public void update(int id, int routeId, int cityId, int dayShift, Time time, int price) {
        save(id, routeId, cityId, dayShift, time, price);
    }

    public void save(Integer id, int routeId, int cityId, int dayShift, Time time, int price) {
        Route route = routesRepository.findById(routeId).get();
        City city = citiesRepository.findById(cityId).get();
        Stop stop = id == null ? new Stop() : stopsRepository.findById(id).get();

        stop.setRoute(route);
        stop.setCity(city);
        stop.setDayShift(dayShift);
        stop.setTime(time);
        stop.setPrice(price);
        stopsRepository.save(stop);
    }

    @Override
    public void delete(int id) {
        stopsRepository.deleteById(id);
    }
}
