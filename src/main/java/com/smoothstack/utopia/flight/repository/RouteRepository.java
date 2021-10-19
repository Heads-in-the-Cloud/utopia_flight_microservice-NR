package com.smoothstack.utopia.flight.repository;

import com.smoothstack.utopia.flight.entity.Route;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RouteRepository extends JpaRepository<Route, Integer> {
}
