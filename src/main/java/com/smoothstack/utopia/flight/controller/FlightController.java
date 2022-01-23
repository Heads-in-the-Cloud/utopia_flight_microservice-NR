package com.smoothstack.utopia.flight.controller;

import com.smoothstack.utopia.flight.entity.Flight;
import com.smoothstack.utopia.flight.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/flights")
public class FlightController {

    @Autowired
    private FlightService flightService;

    @GetMapping(path = "/all")
    @PreAuthorize("hasAuthority('Administrator')")
    public List<Flight> getFlights() {
        return flightService.getAllFlights();
    }

    @GetMapping(path = "/{id}")
    @PreAuthorize("hasAuthority('Administrator')")
    public Flight getFlightById(@PathVariable int id) {
        return flightService.getFlightById(id);
    }

    @PostMapping(path = "/add")
    @PreAuthorize("hasAuthority('Administrator')")
    public ResponseEntity<Flight> addFlight(@RequestBody Flight flight) {
        Flight f = flightService.addFlight(flight);
        if (f.isComplete()) {
            return ResponseEntity.status(201).body(flightService.addFlight(flight));
        } else return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(flight);
    }

    @PutMapping(path = "/{id}/update")
    @PreAuthorize("hasAuthority('Administrator')")
    public ResponseEntity<Flight> updateFlight(@PathVariable int id, @RequestBody Flight flight) {
        Flight f = flightService.updateFlight(id, flight);
        if (f.isComplete()) {
            return ResponseEntity.ok(flightService.updateFlight(id, flight));
        } else return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(flight);
    }

    @DeleteMapping(path = "/delete/{id}")
    @PreAuthorize("hasAuthority('Administrator')")
    public ResponseEntity<Flight> deleteFlight(@PathVariable int id) {
        flightService.deleteFlight(id);
        return ResponseEntity.ok(null);
    }

    @GetMapping(path = "/health")
    public ResponseEntity<String> health() {
        return ResponseEntity.ok("OK");
    }
}
