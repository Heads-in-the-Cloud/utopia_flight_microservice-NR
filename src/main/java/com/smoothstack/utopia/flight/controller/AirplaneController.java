package com.smoothstack.utopia.flight.controller;

import com.smoothstack.utopia.flight.entity.Airplane;
import com.smoothstack.utopia.flight.service.AirplaneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/flights/airplane")
public class AirplaneController {

    @Autowired
    private AirplaneService airplaneService;

    @GetMapping(path = "/all")
    @PreAuthorize("hasAuthority('Administrator')")
    public List<Airplane> getAllAirplanes() {
        return airplaneService.getAllAirplanes();
    }

    @GetMapping(path = "/{id}")
    @PreAuthorize("hasAuthority('Administrator')")
    public ResponseEntity<Airplane> getAirplaneById(@PathVariable int id) {
        Optional<Airplane> a = airplaneService.getAirplane(id);
        return a.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping(path = "/add")
    @PreAuthorize("hasAuthority('Administrator')")
    public ResponseEntity<Airplane> addAirplane(@RequestBody Airplane airplane) {
        Airplane a = airplaneService.addAirplane(airplane);
        return ResponseEntity.status(201).body(a);
    }

    @DeleteMapping(path = "/delete/{id}")
    @PreAuthorize("hasAuthority('Administrator')")
    public ResponseEntity<Airplane> deleteAirPlane(int id) {
        airplaneService.deleteAirplane(id);
        return ResponseEntity.ok().build();
    }
}
