package com.smoothstack.utopia.flight.repository;

import com.smoothstack.utopia.flight.entity.Airport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AirportRepository extends JpaRepository<Airport, String> {
}
