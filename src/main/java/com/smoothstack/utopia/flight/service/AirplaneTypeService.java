package com.smoothstack.utopia.flight.service;

import com.smoothstack.utopia.flight.entity.AirplaneType;
import com.smoothstack.utopia.flight.repository.AirplaneTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AirplaneTypeService {

    @Autowired
    private AirplaneTypeRepository airplaneTypeRepository;

    public List<AirplaneType> getAllAirplaneTypes() {
        return airplaneTypeRepository.findAll();
    }

    public AirplaneType addAirplaneType(AirplaneType airplaneType) {
        return airplaneTypeRepository.saveAndFlush(airplaneType);
    }

    public Optional<AirplaneType> getAirplaneTypeById(int id) {
        return airplaneTypeRepository.findById(id);
    }
}
