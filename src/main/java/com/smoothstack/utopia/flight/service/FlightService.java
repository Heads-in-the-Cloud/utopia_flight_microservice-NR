package com.smoothstack.utopia.flight.service;

import com.smoothstack.utopia.flight.entity.Flight;
import com.smoothstack.utopia.flight.repository.AirplaneRepository;
import com.smoothstack.utopia.flight.repository.FlightRepository;
import com.smoothstack.utopia.flight.repository.RouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightService {

    @Autowired
    private FlightRepository flightRepository;
    @Autowired
    private AirplaneRepository airplaneRepository;
    @Autowired
    private RouteRepository routeRepository;

    public List<Flight> getAllFlights() {
        return flightRepository.findAll();
    }

    public Flight getFlightById(int id) {
        return flightRepository.getById(id);
    }

    public Flight addFlight(Flight flight) {
        if (flight.getRoute() != null && routeRepository.existsById(flight.getRoute().getId())) {
            flight.setRoute(routeRepository.getById(flight.getRoute().getId()));
        } else return flight;
        if (flight.getAirplane() != null && airplaneRepository.existsById(flight.getAirplane().getId())) {
            flight.setAirplane(airplaneRepository.getById(flight.getAirplane().getId()));
        } else return flight;
        //if(flight.isComplete()) return flightRepository.save(flight);
        System.out.println(flight);
        return flight;
    }
}
