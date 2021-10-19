package com.smoothstack.utopia.flight.controller;

import com.smoothstack.utopia.flight.entity.Flight;
import com.smoothstack.utopia.flight.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/flight")
public class FlightController {

    @Autowired
    private FlightService flightService;

    @GetMapping(path = "/all")
    public List<Flight> getFlights() {
        return flightService.getAllFlights();
    }

    @GetMapping(path = "/{id}")
    public Flight getFlightById(@PathVariable int id) {
        return flightService.getFlightById(id);
    }

    @PostMapping(path = "/add")
    public ResponseEntity<Flight> addFlight(@RequestBody Flight flight) {
        Flight f = flightService.addFlight(flight);
        if (f.isComplete()) {
            return ResponseEntity.ok(flightService.addFlight(flight));
        } else return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(flight);
    }
}
