package com.smoothstack.utopia.flight.controller;

import com.smoothstack.utopia.flight.entity.Route;
import com.smoothstack.utopia.flight.repository.RouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/route")
public class RouteController {

    @Autowired
    private RouteRepository routeRepository;

    @GetMapping(path = "/all")
    public List<Route> getRoutes() {
        return routeRepository.findAll();
    }

    @GetMapping(path = "/{id}")
    public Route getRouteById(@PathVariable int id) {
        return routeRepository.getById(id);
    }

}
