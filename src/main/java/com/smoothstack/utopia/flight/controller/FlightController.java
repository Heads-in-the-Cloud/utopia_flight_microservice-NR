package com.smoothstack.utopia.flight.controller;

import com.smoothstack.utopia.flight.entity.Flight;
import com.smoothstack.utopia.flight.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@RestController
@RequestMapping(path = "/api/flights")
public class FlightController {

    @Autowired
    private FlightService flightService;

    @GetMapping(path = "/all")
    @RolesAllowed({"ROLE_ADMIN", "ROLE_AGENT", "ROLE_EMPLOYEE", "ROLE_TRAVELER"})
    public List<Flight> getFlights() {
        return flightService.getAllFlights();
    }

    @GetMapping(path = "/{id}")
    @RolesAllowed({"ROLE_AGENT", "ROLE_ADMIN"})
    public Flight getFlightById(@PathVariable int id) {
        return flightService.getFlightById(id);
    }

    @PostMapping(path = "/add")
    @RolesAllowed("ROLE_ADMIN")
    public ResponseEntity<Flight> addFlight(@RequestBody Flight flight) {
        Flight f = flightService.addFlight(flight);
        if (f.isComplete()) {
            return ResponseEntity.status(201).body(flightService.addFlight(flight));
        } else return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(flight);
    }

    @PutMapping(path = "/{id}/update")
    public ResponseEntity<Flight> updateFlight(@PathVariable int id, @RequestBody Flight flight) {
        Flight f = flightService.updateFlight(id, flight);
        if (f.isComplete()) {
            return ResponseEntity.ok(flightService.updateFlight(id, flight));
        } else return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(flight);
    }

    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<Flight> deleteFlight(@PathVariable int id) {
        flightService.deleteFlight(id);
        return ResponseEntity.ok(null);
    }
}
