package com.smoothstack.utopia.flight.controller;

import com.smoothstack.utopia.flight.entity.Route;
import com.smoothstack.utopia.flight.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/flights/route")
public class RouteController {

    @Autowired
    private RouteService routeService;

    @GetMapping(path = "/all")
    @PreAuthorize("hasAuthority('Administrator')")
    public List<Route> getRoutes() {
        return routeService.getAllRoutes();
    }

    @GetMapping(path = "/{id}")
    @PreAuthorize("hasAuthority('Administrator')")
    public Route getRouteById(@PathVariable int id) {
        Optional<Route> route = routeService.getRouteById(id);
        return route.orElse(null);
    }

    @PostMapping(path = "/add")
    @PreAuthorize("hasAuthority('Administrator')")
    public ResponseEntity<Route> addRoute(@RequestBody Route route) {
        return ResponseEntity.status(201).body(routeService.addRoute(route));
    }

    @DeleteMapping(path = "/delete/{id}")
    @PreAuthorize("hasAuthority('Administrator')")
    public void deleteRoute(@PathVariable int id) {
        routeService.deleteRouteById(id);
    }

}
