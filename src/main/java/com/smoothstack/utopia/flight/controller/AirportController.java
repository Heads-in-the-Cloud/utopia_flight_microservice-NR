package com.smoothstack.utopia.flight.controller;

import com.smoothstack.utopia.flight.entity.Airport;
import com.smoothstack.utopia.flight.service.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/airport")
public class AirportController {
    @Autowired
    private AirportService airportService;

    @GetMapping(path = "/all")
    public List<Airport> getAirports() {
        return airportService.getAllAirports();
    }

    @GetMapping(path = "/{id}")
    public Airport getAirportById(@PathVariable String id) {
        Optional<Airport> airport = airportService.getAirportById(id);
        return airport.orElse(null);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteAirport(@PathVariable int id) {
        airportService.deleteAirport(id);
    }
}
