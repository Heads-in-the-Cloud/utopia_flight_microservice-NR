package com.smoothstack.utopia.flight.service;

import com.smoothstack.utopia.flight.entity.Route;
import com.smoothstack.utopia.flight.repository.RouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RouteService {

    @Autowired
    private RouteRepository routeRepository;

    public List<Route> getAllRoutes() {
        return routeRepository.findAll();
    }

    public Optional<Route> getRouteById(int id) {
        return routeRepository.findById(id);
    }

    public Route addRoute(Route route) {
        return routeRepository.save(route);
    }

    public void deleteRouteById(int id) {
        routeRepository.deleteById(id);
    }
}
