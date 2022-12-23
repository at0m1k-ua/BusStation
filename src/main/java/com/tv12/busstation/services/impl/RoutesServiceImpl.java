package com.tv12.busstation.services.impl;

import com.tv12.busstation.entities.Route;
import com.tv12.busstation.entities.Stop;
import com.tv12.busstation.repositories.RoutesRepository;
import com.tv12.busstation.services.RoutesService;
import org.springframework.stereotype.Controller;

@Controller
public class RoutesServiceImpl implements RoutesService {

    private final RoutesRepository routesRepository;

    public RoutesServiceImpl(RoutesRepository routesRepository) {
        this.routesRepository = routesRepository;
    }

    @Override
    public int create() {
        return routesRepository.saveAndFlush(new Route()).getId();
    }

    @Override
    public Iterable<Route> readAll() {
        return routesRepository.findAll();
    }

    @Override
    public Iterable<Stop> getRouteStops(int routeId) {
        Route route = routesRepository.findById(routeId).get();
        return route.getStops();
    }

    @Override
    public void delete(int id) {
        routesRepository.deleteById(id);
    }
}
