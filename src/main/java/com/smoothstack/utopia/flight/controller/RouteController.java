package com.smoothstack.utopia.flight.controller;

import com.smoothstack.utopia.flight.entity.Route;
import com.smoothstack.utopia.flight.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/route")
public class RouteController {

    @Autowired
    private RouteService routeService;

    @GetMapping(path = "/all")
    public List<Route> getRoutes() {
        return routeService.getAllRoutes();
    }

    @GetMapping(path = "/{id}")
    public Route getRouteById(@PathVariable int id) {
        Optional<Route> route = routeService.getRouteById(id);
        return route.orElse(null);
    }

    @PostMapping(path = "/add")
    public Route addRoute(@RequestBody Route route) {
        return routeService.addRoute(route);
    }

    @DeleteMapping(path = "/delete/{id}")
    public void deleteRoute(@PathVariable int id) {
        routeService.deleteRouteById(id);
    }

}
