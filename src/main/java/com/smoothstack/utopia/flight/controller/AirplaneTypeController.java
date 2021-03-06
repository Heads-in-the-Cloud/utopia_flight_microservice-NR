package com.smoothstack.utopia.flight.controller;

import com.smoothstack.utopia.flight.entity.AirplaneType;
import com.smoothstack.utopia.flight.service.AirplaneTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/flights/airplanetype")
public class AirplaneTypeController {

    @Autowired
    private AirplaneTypeService airplaneTypeService;

    @GetMapping("/all")
    @PreAuthorize("hasAuthority('Administrator')")
    public ResponseEntity<List<AirplaneType>> getAirplaneTypes() {
        return ResponseEntity.ok(airplaneTypeService.getAllAirplaneTypes());
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('Administrator')")
    public ResponseEntity<AirplaneType> getAirplaneType(@PathVariable int id) {
        Optional<AirplaneType> at = airplaneTypeService.getAirplaneTypeById(id);
        return at.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/add")
    @PreAuthorize("hasAuthority('Administrator')")
    public ResponseEntity<AirplaneType> addAirplaneType(@RequestBody AirplaneType airplaneType) {
        return ResponseEntity.status(201).body(airplaneTypeService.addAirplaneType(airplaneType));
    }
}
