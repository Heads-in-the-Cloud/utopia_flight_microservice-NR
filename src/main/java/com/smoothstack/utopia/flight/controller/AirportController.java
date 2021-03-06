package com.smoothstack.utopia.flight.controller;

import com.smoothstack.utopia.flight.entity.Airport;
import com.smoothstack.utopia.flight.service.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/flights/airport")
public class AirportController {
    @Autowired
    private AirportService airportService;

    @GetMapping(path = "/all")
    @PreAuthorize("hasAuthority('Administrator')")
    public List<Airport> getAirports() {
        return airportService.getAllAirports();
    }

    @GetMapping(path = "/{id}")
    @PreAuthorize("hasAuthority('Administrator')")
    public Airport getAirportById(@PathVariable String id) {
        Optional<Airport> airport = airportService.getAirportById(id);
        return airport.orElse(null);
    }

    @PostMapping(path = "/add")
    @PreAuthorize("hasAuthority('Administrator')")
    public ResponseEntity<Airport> addAirport(@RequestBody Airport airport) {
        return ResponseEntity.status(201).body(airportService.addAirport(airport));
    }

    @DeleteMapping(path = "/{iataId}")
    @PreAuthorize("hasAuthority('Administrator')")
    public void deleteAirport(@PathVariable String iataId) {
        airportService.deleteAirport(iataId);
    }
}
