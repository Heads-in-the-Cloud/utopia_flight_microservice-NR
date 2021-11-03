package com.smoothstack.utopia.flight.service;

import com.smoothstack.utopia.flight.entity.Airport;
import com.smoothstack.utopia.flight.repository.AirportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AirportService {

    @Autowired
    private AirportRepository airportRepository;

    public List<Airport> getAllAirports() {
        return airportRepository.findAll();
    }

    public Optional<Airport> getAirportById(String id) {
        return airportRepository.findById(id);
    }

    public void deleteAirport(String iataId) {
        airportRepository.deleteById(iataId);
    }

    public Airport addAirport(Airport airport) {
        return airportRepository.save(airport);
    }
}
