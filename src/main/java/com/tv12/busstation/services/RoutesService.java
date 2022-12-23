package com.tv12.busstation.services;

import com.tv12.busstation.entities.Route;
import com.tv12.busstation.entities.Stop;

public interface RoutesService {
    int create();
    Iterable<Route> readAll();
    Iterable<Stop> getRouteStops(int routeId);
    void delete(int id);
}
