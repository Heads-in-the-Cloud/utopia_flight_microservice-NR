package com.smoothstack.utopia.flight.controller;

import com.smoothstack.utopia.flight.entity.Airport;
import com.smoothstack.utopia.flight.repository.AirportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/airport")
public class AirportController {
    @Autowired
    private AirportRepository airportRepository;

    @GetMapping(path = "/all")
    public List<Airport> getAirports() {
        return airportRepository.findAll();
    }
}
