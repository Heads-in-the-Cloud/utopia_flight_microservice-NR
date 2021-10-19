package com.smoothstack.utopia.flight.repository;

import com.smoothstack.utopia.flight.entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightRepository extends JpaRepository<Flight, Integer> {
}
