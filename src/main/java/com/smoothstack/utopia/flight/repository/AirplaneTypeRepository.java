package com.smoothstack.utopia.flight.repository;

import com.smoothstack.utopia.flight.entity.AirplaneType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AirplaneTypeRepository extends JpaRepository<AirplaneType, Integer> {
}
