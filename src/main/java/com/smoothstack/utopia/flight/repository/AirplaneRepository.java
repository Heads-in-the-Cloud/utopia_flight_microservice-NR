package com.smoothstack.utopia.flight.repository;

import com.smoothstack.utopia.flight.entity.Airplane;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AirplaneRepository extends JpaRepository<Airplane, Integer> {
}
