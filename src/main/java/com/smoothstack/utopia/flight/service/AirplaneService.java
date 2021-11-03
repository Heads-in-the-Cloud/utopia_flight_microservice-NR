package com.smoothstack.utopia.flight.service;

import com.smoothstack.utopia.flight.entity.Airplane;
import com.smoothstack.utopia.flight.repository.AirplaneRepository;
import com.smoothstack.utopia.flight.repository.AirplaneTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AirplaneService {

    @Autowired
    private AirplaneRepository airplaneRepository;
    @Autowired
    AirplaneTypeRepository airplaneTypeRepository;

    public List<Airplane> getAllAirplanes() {
        return airplaneRepository.findAll();
    }

    public Optional<Airplane> getAirplane(int id) {
        return airplaneRepository.findById(id);
    }

    public Airplane addAirplane(Airplane airplane) {
        return airplaneRepository.save(airplane);
    }

    public void deleteAirplane(int id) {
        airplaneRepository.deleteById(id);
    }

}
